package com.baidu.tieba;

import android.os.MessageQueue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ms6 implements MessageQueue.IdleHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsModelController a;
    public MvcHttpResponsedMessage<ao8> b;
    public MvcHttpMessage<FrsRequestData, ao8> c;
    public MvcNetMessage<FrsRequestData, ao8> d;
    public ho8 e;

    public ms6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.a;
            if (frsModelController == null) {
                return false;
            }
            frsModelController.D0(this.b, this.c, this.d);
            ho8 ho8Var = this.e;
            if (ho8Var != null) {
                ho8Var.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a(FrsModelController frsModelController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, frsModelController) == null) {
            this.a = frsModelController;
        }
    }

    public void b(ho8 ho8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ho8Var) == null) {
            this.e = ho8Var;
        }
    }

    public void c(MvcHttpMessage<FrsRequestData, ao8> mvcHttpMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mvcHttpMessage) == null) {
            this.c = mvcHttpMessage;
        }
    }

    public void d(MvcNetMessage<FrsRequestData, ao8> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mvcNetMessage) == null) {
            this.d = mvcNetMessage;
        }
    }

    public void e(MvcHttpResponsedMessage<ao8> mvcHttpResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mvcHttpResponsedMessage) == null) {
            this.b = mvcHttpResponsedMessage;
        }
    }
}
