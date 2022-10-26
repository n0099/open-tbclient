package com.bumptech.glide.load.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes7.dex */
public class DataRewinderRegistry {
    public static /* synthetic */ Interceptable $ic;
    public static final DataRewinder.Factory DEFAULT_FACTORY;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map rewinders;

    /* loaded from: classes7.dex */
    public final class DefaultRewinder implements DataRewinder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object data;

        @Override // com.bumptech.glide.load.data.DataRewinder
        public void cleanup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public DefaultRewinder(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.data = obj;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public Object rewindAndGet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.data;
            }
            return invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-626183299, "Lcom/bumptech/glide/load/data/DataRewinderRegistry;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-626183299, "Lcom/bumptech/glide/load/data/DataRewinderRegistry;");
                return;
            }
        }
        DEFAULT_FACTORY = new DataRewinder.Factory() { // from class: com.bumptech.glide.load.data.DataRewinderRegistry.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bumptech.glide.load.data.DataRewinder.Factory
            public Class getDataClass() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    throw new UnsupportedOperationException("Not implemented");
                }
                return (Class) invokeV.objValue;
            }

            @Override // com.bumptech.glide.load.data.DataRewinder.Factory
            public DataRewinder build(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                    return new DefaultRewinder(obj);
                }
                return (DataRewinder) invokeL.objValue;
            }
        };
    }

    public DataRewinderRegistry() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.rewinders = new HashMap();
    }

    public synchronized DataRewinder build(Object obj) {
        InterceptResult invokeL;
        DataRewinder build;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(obj);
                DataRewinder.Factory factory = (DataRewinder.Factory) this.rewinders.get(obj.getClass());
                if (factory == null) {
                    Iterator it = this.rewinders.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        DataRewinder.Factory factory2 = (DataRewinder.Factory) it.next();
                        if (factory2.getDataClass().isAssignableFrom(obj.getClass())) {
                            factory = factory2;
                            break;
                        }
                    }
                }
                if (factory == null) {
                    factory = DEFAULT_FACTORY;
                }
                build = factory.build(obj);
            }
            return build;
        }
        return (DataRewinder) invokeL.objValue;
    }

    public synchronized void register(DataRewinder.Factory factory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, factory) == null) {
            synchronized (this) {
                this.rewinders.put(factory.getDataClass(), factory);
            }
        }
    }
}
