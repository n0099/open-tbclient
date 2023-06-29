package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class p07 extends p55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext l;
    public Context m;
    public ViewEventCenter n;
    public final r55 o;
    public my6 p;
    public final List<n55> q;
    public final r55.f r;

    /* loaded from: classes7.dex */
    public class a implements r55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p07 a;

        public a(p07 p07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p07Var;
        }

        @Override // com.baidu.tieba.r55.f
        public void M0(r55 r55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, r55Var, i, view2) == null) {
                this.a.dismiss();
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    xi.P(this.a.m, R.string.network_not_available);
                } else if (i == 2) {
                    this.a.n.dispatchMvcEvent(new er5(4, this.a.p, null, null));
                } else if (i == 1) {
                    this.a.n.dispatchMvcEvent(new er5(13, this.a.p, null, null));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p07(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
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
                super((l9) newInitContext.callArgs[0]);
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
        r55 r55Var = new r55(this.m);
        this.o = r55Var;
        r55Var.q(this.r);
        h(this.o);
    }

    public void s(my6 my6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, my6Var) == null) {
            this.p = my6Var;
            p();
        }
    }

    public final void p() {
        List<n55> list;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.p != null && (list = this.q) != null && this.o != null) {
            list.clear();
            if (this.p.h() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i = R.string.cancel_top;
            } else {
                i = R.string.obfuscated_res_0x7f0f169a;
            }
            this.q.add(new n55(1, q(i, new Object[0]), this.o));
            this.q.add(new n55(2, q(R.string.obfuscated_res_0x7f0f0543, new Object[0]), this.o));
            this.o.l(this.q);
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
        r55 r55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (r55Var = this.o) != null) {
            r55Var.j();
        }
    }
}
