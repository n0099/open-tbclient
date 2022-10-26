package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes5.dex */
public final class n0a extends k0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n0a() {
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
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        f(linkedQueueNode);
        e(linkedQueueNode);
        linkedQueueNode.soNext(null);
    }

    @Override // java.util.Queue
    public Object peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinkedQueueNode lvNext = a().lvNext();
            if (lvNext != null) {
                return lvNext.lpValue();
            }
            return null;
        }
        return invokeV.objValue;
    }

    @Override // java.util.Queue
    public Object poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LinkedQueueNode lvNext = a().lvNext();
            if (lvNext != null) {
                Object andNullValue = lvNext.getAndNullValue();
                e(lvNext);
                return andNullValue;
            }
            return null;
        }
        return invokeV.objValue;
    }

    @Override // java.util.Queue
    public boolean offer(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj != null) {
                LinkedQueueNode linkedQueueNode = new LinkedQueueNode(obj);
                b().soNext(linkedQueueNode);
                f(linkedQueueNode);
                return true;
            }
            throw new NullPointerException("null elements not allowed");
        }
        return invokeL.booleanValue;
    }
}
