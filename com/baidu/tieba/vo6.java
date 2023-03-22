package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.k05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class vo6 extends i05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext k;
    public Context l;
    public ViewEventCenter m;
    public final k05 n;
    public qm6 o;
    public final List<g05> p;
    public final k05.f q;

    /* loaded from: classes6.dex */
    public class a implements k05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vo6 a;

        public a(vo6 vo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vo6Var;
        }

        @Override // com.baidu.tieba.k05.f
        public void M0(k05 k05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, k05Var, i, view2) == null) {
                this.a.dismiss();
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    hi.P(this.a.l, R.string.network_not_available);
                } else if (i == 2) {
                    this.a.m.dispatchMvcEvent(new hj5(4, this.a.o, null, null));
                } else if (i == 1) {
                    this.a.m.dispatchMvcEvent(new hj5(13, this.a.o, null, null));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vo6(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
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
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new a(this);
        this.k = tbPageContext;
        this.l = tbPageContext.getPageActivity();
        this.m = viewEventCenter;
        this.p = new ArrayList();
        k05 k05Var = new k05(this.l);
        this.n = k05Var;
        k05Var.p(this.q);
        h(this.n);
    }

    public void r(qm6 qm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qm6Var) == null) {
            this.o = qm6Var;
            o();
        }
    }

    public final void o() {
        List<g05> list;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.o != null && (list = this.p) != null && this.n != null) {
            list.clear();
            if (this.o.i() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i = R.string.cancel_top;
            } else {
                i = R.string.obfuscated_res_0x7f0f1538;
            }
            this.p.add(new g05(1, p(i, new Object[0]), this.n));
            this.p.add(new g05(2, p(R.string.obfuscated_res_0x7f0f04db, new Object[0]), this.n));
            this.n.k(this.p);
        }
    }

    public final String p(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, objArr)) == null) {
            Context context = this.l;
            if (context == null) {
                return null;
            }
            return context.getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public void q() {
        k05 k05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (k05Var = this.n) != null) {
            k05Var.j();
        }
    }
}
