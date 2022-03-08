package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
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
    public static final DataRewinder.Factory<?> DEFAULT_FACTORY;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Class<?>, DataRewinder.Factory<?>> rewinders;

    /* loaded from: classes7.dex */
    public static final class DefaultRewinder implements DataRewinder<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object data;

        public DefaultRewinder(@NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.data = obj;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public void cleanup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        @NonNull
        public Object rewindAndGet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.data : invokeV.objValue;
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
        DEFAULT_FACTORY = new DataRewinder.Factory<Object>() { // from class: com.bumptech.glide.load.data.DataRewinderRegistry.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bumptech.glide.load.data.DataRewinder.Factory
            @NonNull
            public DataRewinder<Object> build(@NonNull Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? new DefaultRewinder(obj) : (DataRewinder) invokeL.objValue;
            }

            @Override // com.bumptech.glide.load.data.DataRewinder.Factory
            @NonNull
            public Class<Object> getDataClass() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    throw new UnsupportedOperationException("Not implemented");
                }
                return (Class) invokeV.objValue;
            }
        };
    }

    public DataRewinderRegistry() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.rewinders = new HashMap();
    }

    @NonNull
    public synchronized <T> DataRewinder<T> build(@NonNull T t) {
        InterceptResult invokeL;
        DataRewinder<T> dataRewinder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(t);
                DataRewinder.Factory<?> factory = this.rewinders.get(t.getClass());
                if (factory == null) {
                    Iterator<DataRewinder.Factory<?>> it = this.rewinders.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        DataRewinder.Factory<?> next = it.next();
                        if (next.getDataClass().isAssignableFrom(t.getClass())) {
                            factory = next;
                            break;
                        }
                    }
                }
                if (factory == null) {
                    factory = DEFAULT_FACTORY;
                }
                dataRewinder = (DataRewinder<T>) factory.build(t);
            }
            return dataRewinder;
        }
        return (DataRewinder) invokeL.objValue;
    }

    public synchronized void register(@NonNull DataRewinder.Factory<?> factory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, factory) == null) {
            synchronized (this) {
                this.rewinders.put(factory.getDataClass(), factory);
            }
        }
    }
}
