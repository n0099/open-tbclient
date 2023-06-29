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
/* loaded from: classes8.dex */
public class xg9 extends wg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pc9 m;
    public gc9 n;
    public hc9 o;
    public kd9 p;
    public PbReplyLoadMoreAdapter q;
    public zg9 r;
    public yg9 s;
    public ic9 t;

    @Override // com.baidu.tieba.wg9
    public void C(u89 u89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u89Var) == null) {
        }
    }

    @Override // com.baidu.tieba.wg9
    public uc9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (uc9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wg9
    public pb9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (pb9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wg9
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wg9
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.tieba.wg9
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xg9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.wg9
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.n.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.wg9
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.wg9
    public void D(ba9 ba9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ba9Var) == null) {
            super.D(ba9Var);
            this.p.q0(ba9Var);
        }
    }

    @Override // com.baidu.tieba.wg9
    public void E(u89 u89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, u89Var) == null) {
            this.r.R(u89Var);
        }
    }

    @Override // com.baidu.tieba.wg9
    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.r.o(str);
        }
    }

    @Override // com.baidu.tieba.wg9
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            super.u(onClickListener);
            this.p.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.wg9
    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            kd9 kd9Var = this.p;
            if (kd9Var != null) {
                kd9Var.p0(z);
            }
            yg9 yg9Var = this.s;
            if (yg9Var != null) {
                yg9Var.x(z);
            }
            zg9 zg9Var = this.r;
            if (zg9Var != null) {
                zg9Var.Q(z);
            }
        }
    }

    @Override // com.baidu.tieba.wg9
    public void w(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, zVar) == null) {
            super.w(zVar);
            this.p.n(zVar);
        }
    }

    @Override // com.baidu.tieba.wg9
    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onLongClickListener) == null) {
            super.x(onLongClickListener);
            this.p.d(onLongClickListener);
        }
    }

    @Override // com.baidu.tieba.wg9
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
            this.r = new zg9(this.a.N(), n4a.W0);
            this.n = new gc9(this.a.N(), c99.c, this.a.getUniqueId());
            this.o = new hc9(this.a.N(), d99.a);
            this.m = new pc9(this.a.N(), g99.k1);
            kd9 kd9Var = new kd9(this.a.N(), n4a.X0);
            this.p = kd9Var;
            kd9Var.r0(this.a.N());
            this.p.m0(this.a.N().r3());
            this.q = new PbReplyLoadMoreAdapter(this.a.N(), n4a.e1);
            this.s = new yg9(this.a.getContext(), p99.b, this.a.N());
            this.t = new ic9(this.a.N(), e99.c);
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

    @Override // com.baidu.tieba.wg9
    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.wg9
    public void m() {
        zg9 zg9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (zg9Var = this.r) != null) {
            zg9Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.wg9
    public void q(u89 u89Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{u89Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.p.r(u89Var);
            this.p.setFromCDN(z);
            this.p.o(str);
            this.p.c(z2);
            this.p.o0(0.5f);
        }
    }
}
