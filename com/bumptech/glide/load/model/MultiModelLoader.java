package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes7.dex */
public class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Pools.Pool<List<Throwable>> exceptionListPool;
    public final List<ModelLoader<Model, Data>> modelLoaders;

    /* loaded from: classes7.dex */
    public static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DataFetcher.DataCallback<? super Data> callback;
        public int currentIndex;
        @Nullable
        public List<Throwable> exceptions;
        public final List<DataFetcher<Data>> fetchers;
        public Priority priority;
        public final Pools.Pool<List<Throwable>> throwableListPool;

        public MultiFetcher(@NonNull List<DataFetcher<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, pool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.throwableListPool = pool;
            Preconditions.checkNotEmpty(list);
            this.fetchers = list;
            this.currentIndex = 0;
        }

        private void startNextOrFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                if (this.currentIndex < this.fetchers.size() - 1) {
                    this.currentIndex++;
                    loadData(this.priority, this.callback);
                    return;
                }
                Preconditions.checkNotNull(this.exceptions);
                this.callback.onLoadFailed(new GlideException("Fetch failed", new ArrayList(this.exceptions)));
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (DataFetcher<Data> dataFetcher : this.fetchers) {
                    dataFetcher.cancel();
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                List<Throwable> list = this.exceptions;
                if (list != null) {
                    this.throwableListPool.release(list);
                }
                this.exceptions = null;
                for (DataFetcher<Data> dataFetcher : this.fetchers) {
                    dataFetcher.cleanup();
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<Data> getDataClass() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fetchers.get(0).getDataClass() : (Class) invokeV.objValue;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.fetchers.get(0).getDataSource() : (DataSource) invokeV.objValue;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, priority, dataCallback) == null) {
                this.priority = priority;
                this.callback = dataCallback;
                this.exceptions = this.throwableListPool.acquire();
                this.fetchers.get(this.currentIndex).loadData(priority, this);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onDataReady(@Nullable Data data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, data) == null) {
                if (data != null) {
                    this.callback.onDataReady(data);
                } else {
                    startNextOrFail();
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onLoadFailed(@NonNull Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                ((List) Preconditions.checkNotNull(this.exceptions)).add(exc);
                startNextOrFail();
            }
        }
    }

    public MultiModelLoader(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, pool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.modelLoaders = list;
        this.exceptionListPool = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Model model, int i2, int i3, @NonNull Options options) {
        InterceptResult invokeCommon;
        ModelLoader.LoadData<Data> buildLoadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{model, Integer.valueOf(i2), Integer.valueOf(i3), options})) == null) {
            int size = this.modelLoaders.size();
            ArrayList arrayList = new ArrayList(size);
            Key key = null;
            for (int i4 = 0; i4 < size; i4++) {
                ModelLoader<Model, Data> modelLoader = this.modelLoaders.get(i4);
                if (modelLoader.handles(model) && (buildLoadData = modelLoader.buildLoadData(model, i2, i3, options)) != null) {
                    key = buildLoadData.sourceKey;
                    arrayList.add(buildLoadData.fetcher);
                }
            }
            if (arrayList.isEmpty() || key == null) {
                return null;
            }
            return new ModelLoader.LoadData<>(key, new MultiFetcher(arrayList, this.exceptionListPool));
        }
        return (ModelLoader.LoadData) invokeCommon.objValue;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Model model) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, model)) == null) {
            for (ModelLoader<Model, Data> modelLoader : this.modelLoaders) {
                if (modelLoader.handles(model)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.modelLoaders.toArray()) + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
