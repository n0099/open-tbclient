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
public class k6a extends j6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a1a o;
    public r0a p;
    public s0a q;
    public v1a r;
    public PbReplyLoadMoreAdapter s;
    public m6a t;
    public l6a u;
    public t0a v;

    @Override // com.baidu.tieba.j6a
    public void D(aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aw9Var) == null) {
        }
    }

    @Override // com.baidu.tieba.j6a
    public g1a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (g1a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j6a
    public yz9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (yz9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j6a
    public PbFirstFloorCommentAndPraiseAdapter h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j6a
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tieba.j6a
    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k6a(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        I();
    }

    @Override // com.baidu.tieba.j6a
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            super.A(onClickListener);
            this.r.e(onClickListener);
            this.s.z(onClickListener);
            this.v.e(onClickListener);
        }
    }

    @Override // com.baidu.tieba.j6a
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.p.z(onClickListener);
        }
    }

    @Override // com.baidu.tieba.j6a
    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.q.z(onClickListener);
        }
    }

    @Override // com.baidu.tieba.j6a
    public void E(ux9 ux9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ux9Var) == null) {
            super.E(ux9Var);
            this.r.k0(ux9Var);
        }
    }

    @Override // com.baidu.tieba.j6a
    public void F(aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aw9Var) == null) {
            this.t.Q(aw9Var);
        }
    }

    @Override // com.baidu.tieba.j6a
    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.t.p(str);
        }
    }

    @Override // com.baidu.tieba.j6a
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.v(onClickListener);
            this.r.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.j6a
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            v1a v1aVar = this.r;
            if (v1aVar != null) {
                v1aVar.j0(z);
            }
            l6a l6aVar = this.u;
            if (l6aVar != null) {
                l6aVar.y(z);
            }
            m6a m6aVar = this.t;
            if (m6aVar != null) {
                m6aVar.P(z);
            }
        }
    }

    @Override // com.baidu.tieba.j6a
    public void x(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, zVar) == null) {
            super.x(zVar);
            this.r.o(zVar);
        }
    }

    @Override // com.baidu.tieba.j6a
    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onLongClickListener) == null) {
            super.y(onLongClickListener);
            this.r.d(onLongClickListener);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t = new m6a(this.a.h0(), nwa.X0);
            this.p = new r0a(this.a.h0(), iw9.c, this.a.getUniqueId());
            this.q = new s0a(this.a.h0(), jw9.a);
            this.o = new a1a(this.a.h0(), mw9.m1);
            v1a v1aVar = new v1a(this.a.h0(), nwa.Y0);
            this.r = v1aVar;
            v1aVar.l0(this.a.h0());
            this.r.g0(this.a.h0().p4());
            this.s = new PbReplyLoadMoreAdapter(this.a.h0(), nwa.g1);
            this.u = new l6a(this.a.getContext(), uw9.b, this.a.h0());
            this.v = new t0a(this.a.h0(), kw9.c);
            this.d.add(this.t);
            this.d.add(this.u);
            this.d.add(this.o);
            this.d.add(this.p);
            this.d.add(this.q);
            this.d.add(this.r);
            this.d.add(this.s);
            this.d.add(this.v);
            this.b.addAdapters(this.d);
        }
    }

    @Override // com.baidu.tieba.j6a
    public void m() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.j6a
    public void n() {
        m6a m6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (m6aVar = this.t) != null) {
            m6aVar.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.j6a
    public void r(aw9 aw9Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{aw9Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.r.s(aw9Var);
            this.r.setFromCDN(z);
            this.r.p(str);
            this.r.c(z2);
            this.r.i0(0.5f);
        }
    }
}
