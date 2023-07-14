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
public class zy6 extends uy6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadManagerNetModel b;
    public az6 c;
    public bz6 d;
    public xy6 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zy6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
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
        az6 az6Var = new az6(1, i);
        this.c = az6Var;
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(tbPageContext, az6Var);
        this.b = downloadManagerNetModel;
        downloadManagerNetModel.x0(this);
        this.b.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void A(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        bz6 bz6Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
            bz6Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (bz6Var != null && f(bz6Var)) {
            return;
        }
        e(mvcSocketResponsedMessage.getError(), mvcSocketResponsedMessage.getErrorString());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void M(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        bz6 bz6Var = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            bz6Var = (bz6) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (bz6Var != null && f(bz6Var)) {
            return;
        }
        e(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
    }

    @Override // com.baidu.tieba.uy6
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.c();
            this.b.loadData();
        }
    }

    @Override // com.baidu.tieba.uy6
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c.b();
            this.b.loadData();
        }
    }

    @Override // com.baidu.tieba.uy6
    public void d(xy6 xy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xy6Var) == null) {
            this.e = xy6Var;
        }
    }

    public final void e(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && i != 0) {
            this.e.b(i, str);
        }
    }

    public final boolean f(bz6 bz6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bz6Var)) == null) {
            if (bz6Var == null) {
                return false;
            }
            if (this.c.a() != 1) {
                this.d.a(bz6Var);
            } else {
                this.d = bz6Var;
            }
            xy6 xy6Var = this.e;
            bz6 bz6Var2 = this.d;
            xy6Var.a(bz6Var2.a, bz6Var2.b, bz6Var2.c.intValue());
            return true;
        }
        return invokeL.booleanValue;
    }
}
