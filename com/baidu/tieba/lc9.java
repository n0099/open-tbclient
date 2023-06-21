package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lc9 extends kc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d89 m;
    public u79 n;
    public v79 o;
    public y89 p;
    public PbReplyLoadMoreAdapter q;
    public nc9 r;
    public mc9 s;
    public w79 t;

    @Override // com.baidu.tieba.kc9
    public void C(j49 j49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j49Var) == null) {
        }
    }

    @Override // com.baidu.tieba.kc9
    public i89 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (i89) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kc9
    public e79 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (e79) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kc9
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kc9
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.tieba.kc9
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lc9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        super(detailInfoAndReplyFragment, bdTypeRecyclerView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DetailInfoAndReplyFragment) objArr2[0], (BdTypeRecyclerView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        H();
    }

    @Override // com.baidu.tieba.kc9
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.n.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.kc9
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.kc9
    public void D(q59 q59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, q59Var) == null) {
            super.D(q59Var);
            this.p.q0(q59Var);
        }
    }

    @Override // com.baidu.tieba.kc9
    public void E(j49 j49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, j49Var) == null) {
            this.r.R(j49Var);
        }
    }

    @Override // com.baidu.tieba.kc9
    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.r.o(str);
        }
    }

    @Override // com.baidu.tieba.kc9
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            super.u(onClickListener);
            this.p.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.kc9
    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            y89 y89Var = this.p;
            if (y89Var != null) {
                y89Var.p0(z);
            }
            mc9 mc9Var = this.s;
            if (mc9Var != null) {
                mc9Var.x(z);
            }
            nc9 nc9Var = this.r;
            if (nc9Var != null) {
                nc9Var.Q(z);
            }
        }
    }

    @Override // com.baidu.tieba.kc9
    public void w(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, zVar) == null) {
            super.w(zVar);
            this.p.n(zVar);
        }
    }

    @Override // com.baidu.tieba.kc9
    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onLongClickListener) == null) {
            super.x(onLongClickListener);
            this.p.d(onLongClickListener);
        }
    }

    @Override // com.baidu.tieba.kc9
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            super.z(onClickListener);
            this.p.e(onClickListener);
            this.q.y(onClickListener);
            this.t.e(onClickListener);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.r = new nc9(this.a.N(), b0a.W0);
            this.n = new u79(this.a.N(), r49.c, this.a.getUniqueId());
            this.o = new v79(this.a.N(), s49.a);
            this.m = new d89(this.a.N(), v49.k1);
            y89 y89Var = new y89(this.a.N(), b0a.X0);
            this.p = y89Var;
            y89Var.r0(this.a.N());
            this.p.m0(this.a.N().r3());
            this.q = new PbReplyLoadMoreAdapter(this.a.N(), b0a.e1);
            this.s = new mc9(this.a.getContext(), e59.b, this.a.N());
            this.t = new w79(this.a.N(), t49.c);
            this.d.add(this.r);
            this.d.add(this.s);
            this.d.add(this.m);
            this.d.add(this.n);
            this.d.add(this.o);
            this.d.add(this.p);
            this.d.add(this.q);
            this.d.add(this.t);
            this.b.addAdapters(this.d);
        }
    }

    @Override // com.baidu.tieba.kc9
    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.kc9
    public void m() {
        nc9 nc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (nc9Var = this.r) != null) {
            nc9Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.kc9
    public void q(j49 j49Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{j49Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.p.r(j49Var);
            this.p.setFromCDN(z);
            this.p.o(str);
            this.p.c(z2);
            this.p.o0(0.5f);
        }
    }
}
