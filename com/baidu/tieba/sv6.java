package com.baidu.tieba;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class sv6 extends ov6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DownloadManagerNetModel b;
    public uv6 c;
    public vv6 d;
    public List<String> e;
    public rv6 f;
    public final List<mv6> g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sv6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
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
        this.d = new vv6();
        this.e = new ArrayList();
        this.g = new ArrayList();
        this.h = 0;
        uv6 uv6Var = new uv6(1, i);
        this.c = uv6Var;
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(tbPageContext, uv6Var);
        this.b = downloadManagerNetModel;
        downloadManagerNetModel.q0(this);
        this.b.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void I(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        vv6 vv6Var = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            vv6Var = (vv6) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (vv6Var != null && i(vv6Var)) {
            return;
        }
        f(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void u(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048585, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        vv6 vv6Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
            vv6Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (vv6Var != null && i(vv6Var)) {
            return;
        }
        f(mvcSocketResponsedMessage.getError(), mvcSocketResponsedMessage.getErrorString());
    }

    @Override // com.baidu.tieba.ov6
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e();
            this.c.c();
            this.b.loadData();
        }
    }

    @Override // com.baidu.tieba.ov6
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e();
            this.d.a.clear();
            this.e.clear();
            this.c.b();
            this.b.loadData();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.g.clear();
            this.h = 0;
        }
    }

    @Override // com.baidu.tieba.ov6
    public void d(rv6 rv6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rv6Var) == null) {
            this.f = rv6Var;
        }
    }

    public final boolean i(vv6 vv6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vv6Var)) == null) {
            if (vv6Var == null) {
                return false;
            }
            vv6 vv6Var2 = this.d;
            vv6Var2.c = vv6Var.c;
            vv6Var2.b = vv6Var.b;
            g(vv6Var.a);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void f(int i, String str) {
        rv6 rv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && i != 0 && (rv6Var = this.f) != null) {
            rv6Var.b(i, str);
        }
    }

    public void g(List<mv6> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            for (mv6 mv6Var : list) {
                PackageInfo a = b68.a(mv6Var.a.pkgName);
                if (a != null) {
                    mv6Var.f = true;
                    if (a.versionCode < mv6Var.a.apkDetail.version_code.intValue()) {
                        List<mv6> list2 = this.g;
                        int i = this.h;
                        this.h = i + 1;
                        list2.add(i, mv6Var);
                    } else {
                        this.g.add(mv6Var);
                    }
                    this.e.add(mv6Var.a.pkgName);
                }
            }
            if (ListUtils.getCount(this.g) < 15 && this.d.c.intValue() != 0) {
                this.c.c();
                this.b.loadData();
                return;
            }
            this.d.a.addAll(this.g);
            if (this.f != null) {
                if (ListUtils.getCount(this.d.a) <= 4) {
                    this.f.a(this.d.a, h(), this.d.c.intValue());
                    return;
                }
                rv6 rv6Var = this.f;
                vv6 vv6Var = this.d;
                rv6Var.a(vv6Var.a, null, vv6Var.c.intValue());
            }
        }
    }

    public List<mv6> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (mv6 mv6Var : this.d.b) {
                if (!this.e.contains(mv6Var.a.pkgName)) {
                    arrayList.add(mv6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
