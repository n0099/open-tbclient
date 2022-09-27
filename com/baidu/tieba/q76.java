package com.baidu.tieba;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
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
/* loaded from: classes5.dex */
public class q76 extends m76 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DownloadManagerNetModel b;
    public s76 c;
    public t76 d;
    public List<String> e;
    public p76 f;
    public final List<k76> g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q76(BaseFragment baseFragment, int i) {
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
        this.d = new t76();
        this.e = new ArrayList();
        this.g = new ArrayList();
        this.h = 0;
        this.c = new s76(1, i);
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), this.c);
        this.b = downloadManagerNetModel;
        downloadManagerNetModel.b0(this);
        this.b.setUniqueId(baseFragment.getUniqueId());
    }

    @Override // com.baidu.tieba.m76
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            this.c.c();
            this.b.loadData();
        }
    }

    @Override // com.baidu.tieba.m76
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e();
            this.d.a.clear();
            this.e.clear();
            this.c.b();
            this.b.loadData();
        }
    }

    @Override // com.baidu.tieba.m76
    public void d(p76 p76Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p76Var) == null) {
            this.f = p76Var;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.clear();
            this.h = 0;
        }
    }

    public final void f(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || i == 0) {
            return;
        }
        this.f.b(i, str);
    }

    public void g(List<k76> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (k76 k76Var : list) {
                PackageInfo a = ws6.a(k76Var.a.pkgName);
                if (a != null) {
                    if (a.versionCode < k76Var.a.apkDetail.version_code.intValue()) {
                        List<k76> list2 = this.g;
                        int i = this.h;
                        this.h = i + 1;
                        list2.add(i, k76Var);
                    } else {
                        this.g.add(k76Var);
                    }
                    this.e.add(k76Var.a.pkgName);
                }
            }
            if (ListUtils.getCount(this.g) < 15 && this.d.c.intValue() != 0) {
                this.c.c();
                this.b.loadData();
                return;
            }
            this.d.a.addAll(this.g);
            if (ListUtils.getCount(this.d.a) <= 4) {
                this.f.a(this.d.a, h(), this.d.c.intValue());
                return;
            }
            p76 p76Var = this.f;
            t76 t76Var = this.d;
            p76Var.a(t76Var.a, null, t76Var.c.intValue());
        }
    }

    public List<k76> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (k76 k76Var : this.d.b) {
                if (!this.e.contains(k76Var.a.pkgName)) {
                    arrayList.add(k76Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean i(t76 t76Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t76Var)) == null) {
            if (t76Var == null) {
                return false;
            }
            t76 t76Var2 = this.d;
            t76Var2.c = t76Var.c;
            t76Var2.b = t76Var.b;
            g(t76Var.a);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        t76 t76Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
            t76Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (t76Var == null || !i(t76Var)) {
            f(mvcSocketResponsedMessage.getError(), mvcSocketResponsedMessage.getErrorString());
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        t76 t76Var = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            t76Var = (t76) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (t76Var == null || !i(t76Var)) {
            f(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
        }
    }
}
