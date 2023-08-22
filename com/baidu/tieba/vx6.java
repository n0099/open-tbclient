package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
/* loaded from: classes8.dex */
public class vx6 extends qx6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadManagerNetModel b;
    public wx6 c;
    public xx6 d;
    public tx6 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vx6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        super(tbPageContext, bdUniqueId, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        wx6 wx6Var = new wx6(1, i);
        this.c = wx6Var;
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(tbPageContext, wx6Var);
        this.b = downloadManagerNetModel;
        downloadManagerNetModel.p0(this);
        this.b.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void G(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        xx6 xx6Var = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            xx6Var = (xx6) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (xx6Var != null && f(xx6Var)) {
            return;
        }
        e(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void v(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        xx6 xx6Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
            xx6Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (xx6Var != null && f(xx6Var)) {
            return;
        }
        e(mvcSocketResponsedMessage.getError(), mvcSocketResponsedMessage.getErrorString());
    }

    @Override // com.baidu.tieba.qx6
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.c();
            this.b.loadData();
        }
    }

    @Override // com.baidu.tieba.qx6
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.b();
            this.b.loadData();
        }
    }

    @Override // com.baidu.tieba.qx6
    public void d(tx6 tx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tx6Var) == null) {
            this.e = tx6Var;
        }
    }

    public final void e(int i, String str) {
        tx6 tx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && i != 0 && (tx6Var = this.e) != null) {
            tx6Var.b(i, str);
        }
    }

    public final boolean f(xx6 xx6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xx6Var)) == null) {
            if (xx6Var == null) {
                return false;
            }
            if (this.c.a() != 1) {
                this.d.a(xx6Var);
            } else {
                this.d = xx6Var;
            }
            tx6 tx6Var = this.e;
            if (tx6Var != null) {
                xx6 xx6Var2 = this.d;
                tx6Var.a(xx6Var2.a, xx6Var2.b, xx6Var2.c.intValue());
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
