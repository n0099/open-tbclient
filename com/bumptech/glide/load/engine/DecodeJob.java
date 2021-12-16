package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DecodeJob";
    public transient /* synthetic */ FieldHolder $fh;
    public Callback<R> callback;
    public Key currentAttemptingKey;
    public Object currentData;
    public DataSource currentDataSource;
    public DataFetcher<?> currentFetcher;
    public volatile DataFetcherGenerator currentGenerator;
    public Key currentSourceKey;
    public Thread currentThread;
    public final DecodeHelper<R> decodeHelper;
    public final DeferredEncodeManager<?> deferredEncodeManager;
    public final DiskCacheProvider diskCacheProvider;
    public DiskCacheStrategy diskCacheStrategy;
    public GlideContext glideContext;
    public int height;
    public volatile boolean isCallbackNotified;
    public volatile boolean isCancelled;
    public EngineKey loadKey;
    public Object model;
    public boolean onlyRetrieveFromCache;
    public Options options;
    public int order;
    public final Pools.Pool<DecodeJob<?>> pool;
    public Priority priority;
    public final ReleaseManager releaseManager;
    public RunReason runReason;
    public Key signature;
    public Stage stage;
    public long startFetchTime;
    public final StateVerifier stateVerifier;
    public final List<Throwable> throwables;
    public int width;

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$EncodeStrategy;
        public static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason;
        public static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(722504342, "Lcom/bumptech/glide/load/engine/DecodeJob$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(722504342, "Lcom/bumptech/glide/load/engine/DecodeJob$1;");
                    return;
                }
            }
            int[] iArr = new int[EncodeStrategy.values().length];
            $SwitchMap$com$bumptech$glide$load$EncodeStrategy = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$EncodeStrategy[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface Callback<R> {
        void onLoadFailed(GlideException glideException);

        void onResourceReady(Resource<R> resource, DataSource dataSource);

        void reschedule(DecodeJob<?> decodeJob);
    }

    /* loaded from: classes2.dex */
    public final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DataSource dataSource;
        public final /* synthetic */ DecodeJob this$0;

        public DecodeCallback(DecodeJob decodeJob, DataSource dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {decodeJob, dataSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = decodeJob;
            this.dataSource = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.DecodePath.DecodeCallback
        @NonNull
        public Resource<Z> onResourceDecoded(@NonNull Resource<Z> resource) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, resource)) == null) ? this.this$0.onResourceDecoded(this.dataSource, resource) : (Resource) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class DeferredEncodeManager<Z> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ResourceEncoder<Z> encoder;
        public Key key;
        public LockedResource<Z> toEncode;

        public DeferredEncodeManager() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.key = null;
                this.encoder = null;
                this.toEncode = null;
            }
        }

        public void encode(DiskCacheProvider diskCacheProvider, Options options) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, diskCacheProvider, options) == null) {
                GlideTrace.beginSection("DecodeJob.encode");
                try {
                    diskCacheProvider.getDiskCache().put(this.key, new DataCacheWriter(this.encoder, this.toEncode, options));
                } finally {
                    this.toEncode.unlock();
                    GlideTrace.endSection();
                }
            }
        }

        public boolean hasResourceToEncode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.toEncode != null : invokeV.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.bumptech.glide.load.ResourceEncoder<X> */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.bumptech.glide.load.engine.LockedResource<X> */
        /* JADX WARN: Multi-variable type inference failed */
        public <X> void init(Key key, ResourceEncoder<X> resourceEncoder, LockedResource<X> lockedResource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, key, resourceEncoder, lockedResource) == null) {
                this.key = key;
                this.encoder = resourceEncoder;
                this.toEncode = lockedResource;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface DiskCacheProvider {
        DiskCache getDiskCache();
    }

    /* loaded from: classes2.dex */
    public static class ReleaseManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isEncodeComplete;
        public boolean isFailed;
        public boolean isReleased;

        public ReleaseManager() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        private boolean isComplete(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) ? (this.isFailed || z || this.isEncodeComplete) && this.isReleased : invokeZ.booleanValue;
        }

        public synchronized boolean onEncodeComplete() {
            InterceptResult invokeV;
            boolean isComplete;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    this.isEncodeComplete = true;
                    isComplete = isComplete(false);
                }
                return isComplete;
            }
            return invokeV.booleanValue;
        }

        public synchronized boolean onFailed() {
            InterceptResult invokeV;
            boolean isComplete;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this) {
                    this.isFailed = true;
                    isComplete = isComplete(false);
                }
                return isComplete;
            }
            return invokeV.booleanValue;
        }

        public synchronized boolean release(boolean z) {
            InterceptResult invokeZ;
            boolean isComplete;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                synchronized (this) {
                    this.isReleased = true;
                    isComplete = isComplete(z);
                }
                return isComplete;
            }
            return invokeZ.booleanValue;
        }

        public synchronized void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    this.isEncodeComplete = false;
                    this.isReleased = false;
                    this.isFailed = false;
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class RunReason {
        public static final /* synthetic */ RunReason[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RunReason DECODE_DATA;
        public static final RunReason INITIALIZE;
        public static final RunReason SWITCH_TO_SOURCE_SERVICE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(979297784, "Lcom/bumptech/glide/load/engine/DecodeJob$RunReason;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(979297784, "Lcom/bumptech/glide/load/engine/DecodeJob$RunReason;");
                    return;
                }
            }
            INITIALIZE = new RunReason("INITIALIZE", 0);
            SWITCH_TO_SOURCE_SERVICE = new RunReason("SWITCH_TO_SOURCE_SERVICE", 1);
            RunReason runReason = new RunReason("DECODE_DATA", 2);
            DECODE_DATA = runReason;
            $VALUES = new RunReason[]{INITIALIZE, SWITCH_TO_SOURCE_SERVICE, runReason};
        }

        public RunReason(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RunReason valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RunReason) Enum.valueOf(RunReason.class, str) : (RunReason) invokeL.objValue;
        }

        public static RunReason[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RunReason[]) $VALUES.clone() : (RunReason[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class Stage {
        public static final /* synthetic */ Stage[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Stage DATA_CACHE;
        public static final Stage ENCODE;
        public static final Stage FINISHED;
        public static final Stage INITIALIZE;
        public static final Stage RESOURCE_CACHE;
        public static final Stage SOURCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(22214537, "Lcom/bumptech/glide/load/engine/DecodeJob$Stage;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(22214537, "Lcom/bumptech/glide/load/engine/DecodeJob$Stage;");
                    return;
                }
            }
            INITIALIZE = new Stage("INITIALIZE", 0);
            RESOURCE_CACHE = new Stage("RESOURCE_CACHE", 1);
            DATA_CACHE = new Stage("DATA_CACHE", 2);
            SOURCE = new Stage("SOURCE", 3);
            ENCODE = new Stage("ENCODE", 4);
            Stage stage = new Stage("FINISHED", 5);
            FINISHED = stage;
            $VALUES = new Stage[]{INITIALIZE, RESOURCE_CACHE, DATA_CACHE, SOURCE, ENCODE, stage};
        }

        public Stage(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Stage valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Stage) Enum.valueOf(Stage.class, str) : (Stage) invokeL.objValue;
        }

        public static Stage[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Stage[]) $VALUES.clone() : (Stage[]) invokeV.objValue;
        }
    }

    public DecodeJob(DiskCacheProvider diskCacheProvider, Pools.Pool<DecodeJob<?>> pool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {diskCacheProvider, pool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.decodeHelper = new DecodeHelper<>();
        this.throwables = new ArrayList();
        this.stateVerifier = StateVerifier.newInstance();
        this.deferredEncodeManager = new DeferredEncodeManager<>();
        this.releaseManager = new ReleaseManager();
        this.diskCacheProvider = diskCacheProvider;
        this.pool = pool;
    }

    private <Data> Resource<R> decodeFromData(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, dataFetcher, data, dataSource)) == null) {
            if (data == null) {
                return null;
            }
            try {
                long logTime = LogTime.getLogTime();
                Resource<R> decodeFromFetcher = decodeFromFetcher(data, dataSource);
                if (Log.isLoggable(TAG, 2)) {
                    logWithTimeAndKey("Decoded result " + decodeFromFetcher, logTime);
                }
                return decodeFromFetcher;
            } finally {
                dataFetcher.cleanup();
            }
        }
        return (Resource) invokeLLL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.bumptech.glide.load.engine.LoadPath<Data, ?, R>, com.bumptech.glide.load.engine.LoadPath<Data, ResourceType, R> */
    private <Data> Resource<R> decodeFromFetcher(Data data, DataSource dataSource) throws GlideException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, data, dataSource)) == null) ? runLoadPath(data, dataSource, (LoadPath<Data, ?, R>) this.decodeHelper.getLoadPath(data.getClass())) : (Resource) invokeLL.objValue;
    }

    private void decodeFromRetrievedData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (Log.isLoggable(TAG, 2)) {
                long j2 = this.startFetchTime;
                logWithTimeAndKey("Retrieved data", j2, "data: " + this.currentData + ", cache key: " + this.currentSourceKey + ", fetcher: " + this.currentFetcher);
            }
            Resource<R> resource = null;
            try {
                resource = decodeFromData(this.currentFetcher, this.currentData, this.currentDataSource);
            } catch (GlideException e2) {
                e2.setLoggingDetails(this.currentAttemptingKey, this.currentDataSource);
                this.throwables.add(e2);
            }
            if (resource != null) {
                notifyEncodeAndRelease(resource, this.currentDataSource);
            } else {
                runGenerators();
            }
        }
    }

    private DataFetcherGenerator getNextGenerator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[this.stage.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return null;
                        }
                        throw new IllegalStateException("Unrecognized stage: " + this.stage);
                    }
                    return new SourceGenerator(this.decodeHelper, this);
                }
                return new DataCacheGenerator(this.decodeHelper, this);
            }
            return new ResourceCacheGenerator(this.decodeHelper, this);
        }
        return (DataFetcherGenerator) invokeV.objValue;
    }

    private Stage getNextStage(Stage stage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, stage)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[stage.ordinal()];
            if (i2 == 1) {
                return this.diskCacheStrategy.decodeCachedData() ? Stage.DATA_CACHE : getNextStage(Stage.DATA_CACHE);
            } else if (i2 == 2) {
                return this.onlyRetrieveFromCache ? Stage.FINISHED : Stage.SOURCE;
            } else if (i2 == 3 || i2 == 4) {
                return Stage.FINISHED;
            } else {
                if (i2 == 5) {
                    return this.diskCacheStrategy.decodeCachedResource() ? Stage.RESOURCE_CACHE : getNextStage(Stage.RESOURCE_CACHE);
                }
                throw new IllegalArgumentException("Unrecognized stage: " + stage);
            }
        }
        return (Stage) invokeL.objValue;
    }

    @NonNull
    private Options getOptionsWithHardwareConfig(DataSource dataSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, dataSource)) == null) {
            Options options = this.options;
            if (Build.VERSION.SDK_INT < 26) {
                return options;
            }
            boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.decodeHelper.isScaleOnlyOrNoTransform();
            Boolean bool = (Boolean) options.get(Downsampler.ALLOW_HARDWARE_CONFIG);
            if (bool == null || (bool.booleanValue() && !z)) {
                Options options2 = new Options();
                options2.putAll(this.options);
                options2.set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.valueOf(z));
                return options2;
            }
            return options;
        }
        return (Options) invokeL.objValue;
    }

    private int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.priority.ordinal() : invokeV.intValue;
    }

    private void logWithTimeAndKey(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65544, this, str, j2) == null) {
            logWithTimeAndKey(str, j2, null);
        }
    }

    private void notifyComplete(Resource<R> resource, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, resource, dataSource) == null) {
            setNotifiedOrThrow();
            this.callback.onResourceReady(resource, dataSource);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.bumptech.glide.load.engine.LockedResource */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.bumptech.glide.load.engine.LockedResource */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.bumptech.glide.load.engine.LockedResource */
    /* JADX WARN: Multi-variable type inference failed */
    private void notifyEncodeAndRelease(Resource<R> resource, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, resource, dataSource) == null) {
            if (resource instanceof Initializable) {
                ((Initializable) resource).initialize();
            }
            LockedResource lockedResource = 0;
            if (this.deferredEncodeManager.hasResourceToEncode()) {
                resource = LockedResource.obtain(resource);
                lockedResource = resource;
            }
            notifyComplete(resource, dataSource);
            this.stage = Stage.ENCODE;
            try {
                if (this.deferredEncodeManager.hasResourceToEncode()) {
                    this.deferredEncodeManager.encode(this.diskCacheProvider, this.options);
                }
                onEncodeComplete();
            } finally {
                if (lockedResource != 0) {
                    lockedResource.unlock();
                }
            }
        }
    }

    private void notifyFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            setNotifiedOrThrow();
            this.callback.onLoadFailed(new GlideException("Failed to load resource", new ArrayList(this.throwables)));
            onLoadFailed();
        }
    }

    private void onEncodeComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && this.releaseManager.onEncodeComplete()) {
            releaseInternal();
        }
    }

    private void onLoadFailed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, this) == null) && this.releaseManager.onFailed()) {
            releaseInternal();
        }
    }

    private void releaseInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.releaseManager.reset();
            this.deferredEncodeManager.clear();
            this.decodeHelper.clear();
            this.isCallbackNotified = false;
            this.glideContext = null;
            this.signature = null;
            this.options = null;
            this.priority = null;
            this.loadKey = null;
            this.callback = null;
            this.stage = null;
            this.currentGenerator = null;
            this.currentThread = null;
            this.currentSourceKey = null;
            this.currentData = null;
            this.currentDataSource = null;
            this.currentFetcher = null;
            this.startFetchTime = 0L;
            this.isCancelled = false;
            this.model = null;
            this.throwables.clear();
            this.pool.release(this);
        }
    }

    private void runGenerators() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.currentThread = Thread.currentThread();
            this.startFetchTime = LogTime.getLogTime();
            boolean z = false;
            while (!this.isCancelled && this.currentGenerator != null && !(z = this.currentGenerator.startNext())) {
                this.stage = getNextStage(this.stage);
                this.currentGenerator = getNextGenerator();
                if (this.stage == Stage.SOURCE) {
                    reschedule();
                    return;
                }
            }
            if ((this.stage == Stage.FINISHED || this.isCancelled) && !z) {
                notifyFailed();
            }
        }
    }

    private <Data, ResourceType> Resource<R> runLoadPath(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, this, data, dataSource, loadPath)) == null) {
            Options optionsWithHardwareConfig = getOptionsWithHardwareConfig(dataSource);
            DataRewinder<Data> rewinder = this.glideContext.getRegistry().getRewinder(data);
            try {
                return loadPath.load(rewinder, optionsWithHardwareConfig, this.width, this.height, new DecodeCallback(this, dataSource));
            } finally {
                rewinder.cleanup();
            }
        }
        return (Resource) invokeLLL.objValue;
    }

    private void runWrapped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[this.runReason.ordinal()];
            if (i2 == 1) {
                this.stage = getNextStage(Stage.INITIALIZE);
                this.currentGenerator = getNextGenerator();
                runGenerators();
            } else if (i2 == 2) {
                runGenerators();
            } else if (i2 == 3) {
                decodeFromRetrievedData();
            } else {
                throw new IllegalStateException("Unrecognized run reason: " + this.runReason);
            }
        }
    }

    private void setNotifiedOrThrow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.stateVerifier.throwIfRecycled();
            if (!this.isCallbackNotified) {
                this.isCallbackNotified = true;
                return;
            }
            throw new IllegalStateException("Already notified");
        }
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.isCancelled = true;
            DataFetcherGenerator dataFetcherGenerator = this.currentGenerator;
            if (dataFetcherGenerator != null) {
                dataFetcherGenerator.cancel();
            }
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.stateVerifier : (StateVerifier) invokeV.objValue;
    }

    public DecodeJob<R> init(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, Callback<R> callback, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{glideContext, obj, engineKey, key, Integer.valueOf(i2), Integer.valueOf(i3), cls, cls2, priority, diskCacheStrategy, map, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), options, callback, Integer.valueOf(i4)})) == null) {
            this.decodeHelper.init(glideContext, obj, key, i2, i3, diskCacheStrategy, cls, cls2, priority, options, map, z, z2, this.diskCacheProvider);
            this.glideContext = glideContext;
            this.signature = key;
            this.priority = priority;
            this.loadKey = engineKey;
            this.width = i2;
            this.height = i3;
            this.diskCacheStrategy = diskCacheStrategy;
            this.onlyRetrieveFromCache = z3;
            this.options = options;
            this.callback = callback;
            this.order = i4;
            this.runReason = RunReason.INITIALIZE;
            this.model = obj;
            return this;
        }
        return (DecodeJob) invokeCommon.objValue;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, key, exc, dataFetcher, dataSource) == null) {
            dataFetcher.cleanup();
            GlideException glideException = new GlideException("Fetching data failed", exc);
            glideException.setLoggingDetails(key, dataSource, dataFetcher.getDataClass());
            this.throwables.add(glideException);
            if (Thread.currentThread() != this.currentThread) {
                this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
                this.callback.reschedule(this);
                return;
            }
            runGenerators();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, key, obj, dataFetcher, dataSource, key2) == null) {
            this.currentSourceKey = key;
            this.currentData = obj;
            this.currentFetcher = dataFetcher;
            this.currentDataSource = dataSource;
            this.currentAttemptingKey = key2;
            if (Thread.currentThread() != this.currentThread) {
                this.runReason = RunReason.DECODE_DATA;
                this.callback.reschedule(this);
                return;
            }
            GlideTrace.beginSection("DecodeJob.decodeFromRetrievedData");
            try {
                decodeFromRetrievedData();
            } finally {
                GlideTrace.endSection();
            }
        }
    }

    @NonNull
    public <Z> Resource<Z> onResourceDecoded(DataSource dataSource, @NonNull Resource<Z> resource) {
        InterceptResult invokeLL;
        Resource<Z> resource2;
        Transformation<Z> transformation;
        EncodeStrategy encodeStrategy;
        Key dataCacheKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, dataSource, resource)) == null) {
            Class<?> cls = resource.get().getClass();
            ResourceEncoder<Z> resourceEncoder = null;
            if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
                Transformation<Z> transformation2 = this.decodeHelper.getTransformation(cls);
                transformation = transformation2;
                resource2 = transformation2.transform(this.glideContext, resource, this.width, this.height);
            } else {
                resource2 = resource;
                transformation = null;
            }
            if (!resource.equals(resource2)) {
                resource.recycle();
            }
            if (this.decodeHelper.isResourceEncoderAvailable(resource2)) {
                resourceEncoder = this.decodeHelper.getResultEncoder(resource2);
                encodeStrategy = resourceEncoder.getEncodeStrategy(this.options);
            } else {
                encodeStrategy = EncodeStrategy.NONE;
            }
            ResourceEncoder resourceEncoder2 = resourceEncoder;
            if (this.diskCacheStrategy.isResourceCacheable(!this.decodeHelper.isSourceKey(this.currentSourceKey), dataSource, encodeStrategy)) {
                if (resourceEncoder2 != null) {
                    int i2 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$EncodeStrategy[encodeStrategy.ordinal()];
                    if (i2 == 1) {
                        dataCacheKey = new DataCacheKey(this.currentSourceKey, this.signature);
                    } else if (i2 == 2) {
                        dataCacheKey = new ResourceCacheKey(this.decodeHelper.getArrayPool(), this.currentSourceKey, this.signature, this.width, this.height, transformation, cls, this.options);
                    } else {
                        throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                    }
                    LockedResource obtain = LockedResource.obtain(resource2);
                    this.deferredEncodeManager.init(dataCacheKey, resourceEncoder2, obtain);
                    return obtain;
                }
                throw new Registry.NoResultEncoderAvailableException(resource2.get().getClass());
            }
            return resource2;
        }
        return (Resource) invokeLL.objValue;
    }

    public void release(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && this.releaseManager.release(z)) {
            releaseInternal();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.callback.reschedule(this);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r0 != null) goto L15;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048586, this) != null) {
            return;
        }
        GlideTrace.beginSectionFormat("DecodeJob#run(model=%s)", this.model);
        DataFetcher<?> dataFetcher = this.currentFetcher;
        try {
            if (this.isCancelled) {
                notifyFailed();
                return;
            }
            runWrapped();
        } catch (Throwable th) {
            try {
                if (Log.isLoggable(TAG, 3)) {
                    String str = "DecodeJob threw unexpectedly, isCancelled: " + this.isCancelled + ", stage: " + this.stage;
                }
                if (this.stage != Stage.ENCODE) {
                    this.throwables.add(th);
                    notifyFailed();
                }
                if (this.isCancelled) {
                    if (dataFetcher != null) {
                        dataFetcher.cleanup();
                    }
                    GlideTrace.endSection();
                    return;
                }
                throw th;
            } finally {
                if (dataFetcher != null) {
                    dataFetcher.cleanup();
                }
                GlideTrace.endSection();
            }
        }
    }

    public boolean willDecodeFromCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Stage nextStage = getNextStage(Stage.INITIALIZE);
            return nextStage == Stage.RESOURCE_CACHE || nextStage == Stage.DATA_CACHE;
        }
        return invokeV.booleanValue;
    }

    private void logWithTimeAndKey(String str, long j2, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{str, Long.valueOf(j2), str2}) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" in ");
            sb.append(LogTime.getElapsedMillis(j2));
            sb.append(", load key: ");
            sb.append(this.loadKey);
            if (str2 != null) {
                str3 = StringUtil.ARRAY_ELEMENT_SEPARATOR + str2;
            } else {
                str3 = "";
            }
            sb.append(str3);
            sb.append(", thread: ");
            sb.append(Thread.currentThread().getName());
            sb.toString();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, decodeJob)) == null) {
            int priority = getPriority() - decodeJob.getPriority();
            return priority == 0 ? this.order - decodeJob.order : priority;
        }
        return invokeL.intValue;
    }
}
