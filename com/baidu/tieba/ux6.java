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
public class ux6 extends qx6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DownloadManagerNetModel b;
    public wx6 c;
    public xx6 d;
    public List<String> e;
    public tx6 f;
    public final List<ox6> g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ux6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
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
        this.d = new xx6();
        this.e = new ArrayList();
        this.g = new ArrayList();
        this.h = 0;
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
        if (xx6Var != null && i(xx6Var)) {
            return;
        }
        f(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void v(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048585, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        xx6 xx6Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
            xx6Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (xx6Var != null && i(xx6Var)) {
            return;
        }
        f(mvcSocketResponsedMessage.getError(), mvcSocketResponsedMessage.getErrorString());
    }

    @Override // com.baidu.tieba.qx6
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e();
            this.c.c();
            this.b.loadData();
        }
    }

    @Override // com.baidu.tieba.qx6
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

    @Override // com.baidu.tieba.qx6
    public void d(tx6 tx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tx6Var) == null) {
            this.f = tx6Var;
        }
    }

    public final boolean i(xx6 xx6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xx6Var)) == null) {
            if (xx6Var == null) {
                return false;
            }
            xx6 xx6Var2 = this.d;
            xx6Var2.c = xx6Var.c;
            xx6Var2.b = xx6Var.b;
            g(xx6Var.a);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void f(int i, String str) {
        tx6 tx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && i != 0 && (tx6Var = this.f) != null) {
            tx6Var.b(i, str);
        }
    }

    public void g(List<ox6> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            for (ox6 ox6Var : list) {
                PackageInfo a = ou7.a(ox6Var.a.pkgName);
                if (a != null) {
                    if (a.versionCode < ox6Var.a.apkDetail.version_code.intValue()) {
                        List<ox6> list2 = this.g;
                        int i = this.h;
                        this.h = i + 1;
                        list2.add(i, ox6Var);
                    } else {
                        this.g.add(ox6Var);
                    }
                    this.e.add(ox6Var.a.pkgName);
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
                tx6 tx6Var = this.f;
                xx6 xx6Var = this.d;
                tx6Var.a(xx6Var.a, null, xx6Var.c.intValue());
            }
        }
    }

    public List<ox6> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (ox6 ox6Var : this.d.b) {
                if (!this.e.contains(ox6Var.a.pkgName)) {
                    arrayList.add(ox6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
