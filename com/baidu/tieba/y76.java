package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerHttpResponseMessage;
import com.baidu.tieba.downloadmanager.net.DownloadManagerNetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class y76 extends t76 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadManagerNetModel b;
    public z76 c;
    public a86 d;
    public w76 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y76(BaseFragment baseFragment, int i) {
        super(baseFragment, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragment) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new z76(1, i);
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), this.c);
        this.b = downloadManagerNetModel;
        downloadManagerNetModel.b0(this);
        this.b.setUniqueId(baseFragment.getUniqueId());
    }

    @Override // com.baidu.tieba.t76
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.c();
            this.b.loadData();
        }
    }

    @Override // com.baidu.tieba.t76
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.b();
            this.b.loadData();
        }
    }

    @Override // com.baidu.tieba.t76
    public void d(w76 w76Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w76Var) == null) {
            this.e = w76Var;
        }
    }

    public final void e(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && i != 0) {
            this.e.b(i, str);
        }
    }

    public final boolean f(a86 a86Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, a86Var)) == null) {
            if (a86Var == null) {
                return false;
            }
            if (this.c.a() != 1) {
                this.d.a(a86Var);
            } else {
                this.d = a86Var;
            }
            w76 w76Var = this.e;
            a86 a86Var2 = this.d;
            w76Var.a(a86Var2.a, a86Var2.b, a86Var2.c.intValue());
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048581, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        a86 a86Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
            a86Var = (a86) ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (a86Var != null && f(a86Var)) {
            return;
        }
        e(mvcSocketResponsedMessage.getError(), mvcSocketResponsedMessage.getErrorString());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        a86 a86Var = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            a86Var = (a86) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (a86Var != null && f(a86Var)) {
            return;
        }
        e(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
    }
}
