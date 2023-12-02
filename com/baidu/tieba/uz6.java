package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.p05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class uz6 extends n05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext l;
    public Context m;
    public ViewEventCenter n;
    public final p05 o;
    public rx6 p;
    public final List<l05> q;
    public final p05.f r;

    /* loaded from: classes8.dex */
    public class a implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz6 a;

        public a(uz6 uz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz6Var;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                this.a.dismiss();
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(this.a.m, (int) R.string.network_not_available);
                } else if (i == 2) {
                    this.a.n.dispatchMvcEvent(new eo5(4, this.a.p, null, null));
                } else if (i == 1) {
                    this.a.n.dispatchMvcEvent(new eo5(13, this.a.p, null, null));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uz6(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.l = tbPageContext;
        this.m = tbPageContext.getPageActivity();
        this.n = viewEventCenter;
        this.q = new ArrayList();
        p05 p05Var = new p05(this.m);
        this.o = p05Var;
        p05Var.r(this.r);
        h(this.o);
    }

    public void s(rx6 rx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rx6Var) == null) {
            this.p = rx6Var;
            p();
        }
    }

    public final void p() {
        List<l05> list;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.p != null && (list = this.q) != null && this.o != null) {
            list.clear();
            if (this.p.g() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i = R.string.cancel_top;
            } else {
                i = R.string.obfuscated_res_0x7f0f1719;
            }
            this.q.add(new l05(1, q(i, new Object[0]), this.o));
            this.q.add(new l05(2, q(R.string.obfuscated_res_0x7f0f055b, new Object[0]), this.o));
            this.o.m(this.q);
        }
    }

    public final String q(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, objArr)) == null) {
            Context context = this.m;
            if (context == null) {
                return null;
            }
            return context.getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public void r() {
        p05 p05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (p05Var = this.o) != null) {
            p05Var.k();
        }
    }
}
