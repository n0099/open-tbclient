package com.baidu.tieba;

import android.os.MessageQueue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class in7 implements MessageQueue.IdleHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<FrsModelController> a;
    public MvcSocketResponsedMessage<c3a, ?> b;
    public MvcSocketMessage<FrsRequestData, c3a> c;
    public MvcNetMessage<FrsRequestData, c3a> d;
    public j3a e;

    public in7() {
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
            FrsModelController frsModelController = this.a.get();
            if (frsModelController == null) {
                return false;
            }
            frsModelController.a1(this.b, this.c, this.d);
            j3a j3aVar = this.e;
            if (j3aVar != null) {
                j3aVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a(FrsModelController frsModelController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, frsModelController) == null) {
            this.a = new WeakReference<>(frsModelController);
        }
    }

    public void b(j3a j3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j3aVar) == null) {
            this.e = j3aVar;
        }
    }

    public void c(MvcSocketMessage<FrsRequestData, c3a> mvcSocketMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mvcSocketMessage) == null) {
            this.c = mvcSocketMessage;
        }
    }

    public void d(MvcNetMessage<FrsRequestData, c3a> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mvcNetMessage) == null) {
            this.d = mvcNetMessage;
        }
    }

    public void e(MvcSocketResponsedMessage<c3a, ?> mvcSocketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mvcSocketResponsedMessage) == null) {
            this.b = mvcSocketResponsedMessage;
        }
    }
}
