package com.bumptech.glide.load.engine.bitmap_recycle;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.Util;
import java.util.Queue;
/* loaded from: classes7.dex */
public abstract class BaseKeyPool {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SIZE = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public final Queue keyPool;

    public abstract Poolable create();

    public BaseKeyPool() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.keyPool = Util.createQueue(20);
    }

    public Poolable get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Poolable poolable = (Poolable) this.keyPool.poll();
            if (poolable == null) {
                return create();
            }
            return poolable;
        }
        return (Poolable) invokeV.objValue;
    }

    public void offer(Poolable poolable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, poolable) == null) && this.keyPool.size() < 20) {
            this.keyPool.offer(poolable);
        }
    }
}
