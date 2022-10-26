package com.bumptech.glide.load.model;

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
/* loaded from: classes7.dex */
public class ModelCache {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SIZE = 250;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache cache;

    /* loaded from: classes7.dex */
    public final class ModelKey {
        public static /* synthetic */ Interceptable $ic;
        public static final Queue KEY_QUEUE;
        public transient /* synthetic */ FieldHolder $fh;
        public int height;
        public Object model;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (((this.height * 31) + this.width) * 31) + this.model.hashCode();
            }
            return invokeV.intValue;
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (KEY_QUEUE) {
                    KEY_QUEUE.offer(this);
                }
            }
        }

        public static ModelKey get(Object obj, int i, int i2) {
            InterceptResult invokeLII;
            ModelKey modelKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, obj, i, i2)) == null) {
                synchronized (KEY_QUEUE) {
                    modelKey = (ModelKey) KEY_QUEUE.poll();
                }
                if (modelKey == null) {
                    modelKey = new ModelKey();
                }
                modelKey.init(obj, i, i2);
                return modelKey;
            }
            return (ModelKey) invokeLII.objValue;
        }

        private void init(Object obj, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(65539, this, obj, i, i2) == null) {
                this.model = obj;
                this.width = i;
                this.height = i2;
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (!(obj instanceof ModelKey)) {
                    return false;
                }
                ModelKey modelKey = (ModelKey) obj;
                if (this.width != modelKey.width || this.height != modelKey.height || !this.model.equals(modelKey.model)) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelCache() {
        this(250L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public ModelCache(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cache = new LruCache(this, j) { // from class: com.bumptech.glide.load.model.ModelCache.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ModelCache this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Long.valueOf(j)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Long) newInitContext2.callArgs[0]).longValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bumptech.glide.util.LruCache
            public void onItemEvicted(ModelKey modelKey, Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, modelKey, obj) == null) {
                    modelKey.release();
                }
            }
        };
    }

    public Object get(Object obj, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i, i2)) == null) {
            ModelKey modelKey = ModelKey.get(obj, i, i2);
            Object obj2 = this.cache.get(modelKey);
            modelKey.release();
            return obj2;
        }
        return invokeLII.objValue;
    }

    public void put(Object obj, int i, int i2, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{obj, Integer.valueOf(i), Integer.valueOf(i2), obj2}) == null) {
            this.cache.put(ModelKey.get(obj, i, i2), obj2);
        }
    }
}
