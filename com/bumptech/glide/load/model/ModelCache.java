package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;
/* loaded from: classes2.dex */
public class ModelCache<A, B> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SIZE = 250;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<ModelKey<A>, B> cache;

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class ModelKey<A> {
        public static /* synthetic */ Interceptable $ic;
        public static final Queue<ModelKey<?>> KEY_QUEUE;
        public transient /* synthetic */ FieldHolder $fh;
        public int height;
        public A model;
        public int width;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1861703786, "Lcom/bumptech/glide/load/model/ModelCache$ModelKey;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1861703786, "Lcom/bumptech/glide/load/model/ModelCache$ModelKey;");
                    return;
                }
            }
            KEY_QUEUE = Util.createQueue(0);
        }

        public ModelKey() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static <A> ModelKey<A> get(A a, int i2, int i3) {
            InterceptResult invokeLII;
            ModelKey<A> modelKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, a, i2, i3)) == null) {
                synchronized (KEY_QUEUE) {
                    modelKey = (ModelKey<A>) KEY_QUEUE.poll();
                }
                if (modelKey == null) {
                    modelKey = new ModelKey<>();
                }
                modelKey.init(a, i2, i3);
                return modelKey;
            }
            return (ModelKey) invokeLII.objValue;
        }

        private void init(A a, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(65539, this, a, i2, i3) == null) {
                this.model = a;
                this.width = i2;
                this.height = i3;
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof ModelKey) {
                    ModelKey modelKey = (ModelKey) obj;
                    return this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (((this.height * 31) + this.width) * 31) + this.model.hashCode() : invokeV.intValue;
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (KEY_QUEUE) {
                    KEY_QUEUE.offer(this);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelCache() {
        this(250L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.cache.clearMemory();
        }
    }

    @Nullable
    public B get(A a, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a, i2, i3)) == null) {
            ModelKey<A> modelKey = ModelKey.get(a, i2, i3);
            B b2 = this.cache.get(modelKey);
            modelKey.release();
            return b2;
        }
        return (B) invokeLII.objValue;
    }

    public void put(A a, int i2, int i3, B b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{a, Integer.valueOf(i2), Integer.valueOf(i3), b2}) == null) {
            this.cache.put(ModelKey.get(a, i2, i3), b2);
        }
    }

    public ModelCache(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cache = new LruCache<ModelKey<A>, B>(this, j2) { // from class: com.bumptech.glide.load.model.ModelCache.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ModelCache this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j2);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Long.valueOf(j2)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Long) newInitContext2.callArgs[0]).longValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.bumptech.glide.util.LruCache
            public /* bridge */ /* synthetic */ void onItemEvicted(@NonNull Object obj, @Nullable Object obj2) {
                onItemEvicted((ModelKey) ((ModelKey) obj), (ModelKey<A>) obj2);
            }

            public void onItemEvicted(@NonNull ModelKey<A> modelKey, @Nullable B b2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, modelKey, b2) == null) {
                    modelKey.release();
                }
            }
        };
    }
}
