package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class FactoryPools {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_POOL_SIZE = 20;
    public static final Resetter EMPTY_RESETTER;
    public static final String TAG = "FactoryPools";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface Factory {
        Object create();
    }

    /* loaded from: classes7.dex */
    public interface Poolable {
        StateVerifier getVerifier();
    }

    /* loaded from: classes7.dex */
    public interface Resetter {
        void reset(Object obj);
    }

    /* loaded from: classes7.dex */
    public final class FactoryPool implements Pools.Pool {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Factory factory;
        public final Pools.Pool pool;
        public final Resetter resetter;

        public FactoryPool(Pools.Pool pool, Factory factory, Resetter resetter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pool, factory, resetter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pool = pool;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // androidx.core.util.Pools.Pool
        public Object acquire() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Object acquire = this.pool.acquire();
                if (acquire == null) {
                    acquire = this.factory.create();
                    if (Log.isLoggable(FactoryPools.TAG, 2)) {
                        Log.v(FactoryPools.TAG, "Created new " + acquire.getClass());
                    }
                }
                if (acquire instanceof Poolable) {
                    ((Poolable) acquire).getVerifier().setRecycled(false);
                }
                return acquire;
            }
            return invokeV.objValue;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof Poolable) {
                    ((Poolable) obj).getVerifier().setRecycled(true);
                }
                this.resetter.reset(obj);
                return this.pool.release(obj);
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1279720053, "Lcom/bumptech/glide/util/pool/FactoryPools;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1279720053, "Lcom/bumptech/glide/util/pool/FactoryPools;");
                return;
            }
        }
        EMPTY_RESETTER = new Resetter() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public void reset(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                }
            }

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
        };
    }

    public FactoryPools() {
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

    public static Resetter emptyResetter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return EMPTY_RESETTER;
        }
        return (Resetter) invokeV.objValue;
    }

    public static Pools.Pool threadSafeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return threadSafeList(20);
        }
        return (Pools.Pool) invokeV.objValue;
    }

    public static Pools.Pool build(Pools.Pool pool, Factory factory) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pool, factory)) == null) {
            return build(pool, factory, emptyResetter());
        }
        return (Pools.Pool) invokeLL.objValue;
    }

    public static Pools.Pool simple(int i, Factory factory) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, null, i, factory)) == null) {
            return build(new Pools.SimplePool(i), factory);
        }
        return (Pools.Pool) invokeIL.objValue;
    }

    public static Pools.Pool threadSafe(int i, Factory factory) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65542, null, i, factory)) == null) {
            return build(new Pools.SynchronizedPool(i), factory);
        }
        return (Pools.Pool) invokeIL.objValue;
    }

    public static Pools.Pool build(Pools.Pool pool, Factory factory, Resetter resetter) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, pool, factory, resetter)) == null) {
            return new FactoryPool(pool, factory, resetter);
        }
        return (Pools.Pool) invokeLLL.objValue;
    }

    public static Pools.Pool threadSafeList(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            return build(new Pools.SynchronizedPool(i), new Factory() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
                public List create() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return new ArrayList();
                    }
                    return (List) invokeV.objValue;
                }
            }, new Resetter() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
                public void reset(List list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        list.clear();
                    }
                }
            });
        }
        return (Pools.Pool) invokeI.objValue;
    }
}
