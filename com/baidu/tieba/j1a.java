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
public class j1a extends i1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vw9 n;
    public mw9 o;
    public nw9 p;
    public qx9 q;
    public PbReplyLoadMoreAdapter r;
    public l1a s;
    public k1a t;
    public ow9 u;

    @Override // com.baidu.tieba.i1a
    public void D(es9 es9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, es9Var) == null) {
        }
    }

    @Override // com.baidu.tieba.i1a
    public bx9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (bx9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i1a
    public uv9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (uv9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i1a
    public PbFirstFloorCommentAndPraiseAdapter h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i1a
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tieba.i1a
    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1a(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.i1a
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            super.A(onClickListener);
            this.q.e(onClickListener);
            this.r.z(onClickListener);
            this.u.e(onClickListener);
        }
    }

    @Override // com.baidu.tieba.i1a
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.z(onClickListener);
        }
    }

    @Override // com.baidu.tieba.i1a
    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.p.z(onClickListener);
        }
    }

    @Override // com.baidu.tieba.i1a
    public void E(zt9 zt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zt9Var) == null) {
            super.E(zt9Var);
            this.q.k0(zt9Var);
        }
    }

    @Override // com.baidu.tieba.i1a
    public void F(es9 es9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, es9Var) == null) {
            this.s.Q(es9Var);
        }
    }

    @Override // com.baidu.tieba.i1a
    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.s.p(str);
        }
    }

    @Override // com.baidu.tieba.i1a
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.v(onClickListener);
            this.q.l(onClickListener);
        }
    }

    @Override // com.baidu.tieba.i1a
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            qx9 qx9Var = this.q;
            if (qx9Var != null) {
                qx9Var.j0(z);
            }
            k1a k1aVar = this.t;
            if (k1aVar != null) {
                k1aVar.y(z);
            }
            l1a l1aVar = this.s;
            if (l1aVar != null) {
                l1aVar.P(z);
            }
        }
    }

    @Override // com.baidu.tieba.i1a
    public void x(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, zVar) == null) {
            super.x(zVar);
            this.q.o(zVar);
        }
    }

    @Override // com.baidu.tieba.i1a
    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onLongClickListener) == null) {
            super.y(onLongClickListener);
            this.q.d(onLongClickListener);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.s = new l1a(this.a.e0(), vra.W0);
            this.o = new mw9(this.a.e0(), ms9.c, this.a.getUniqueId());
            this.p = new nw9(this.a.e0(), ns9.a);
            this.n = new vw9(this.a.e0(), qs9.k1);
            qx9 qx9Var = new qx9(this.a.e0(), vra.X0);
            this.q = qx9Var;
            qx9Var.l0(this.a.e0());
            this.q.g0(this.a.e0().d4());
            this.r = new PbReplyLoadMoreAdapter(this.a.e0(), vra.e1);
            this.t = new k1a(this.a.getContext(), zs9.b, this.a.e0());
            this.u = new ow9(this.a.e0(), os9.c);
            this.d.add(this.s);
            this.d.add(this.t);
            this.d.add(this.n);
            this.d.add(this.o);
            this.d.add(this.p);
            this.d.add(this.q);
            this.d.add(this.r);
            this.d.add(this.u);
            this.b.addAdapters(this.d);
        }
    }

    @Override // com.baidu.tieba.i1a
    public void m() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.i1a
    public void n() {
        l1a l1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (l1aVar = this.s) != null) {
            l1aVar.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.i1a
    public void r(es9 es9Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{es9Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q.s(es9Var);
            this.q.setFromCDN(z);
            this.q.p(str);
            this.q.c(z2);
            this.q.i0(0.5f);
        }
    }
}
