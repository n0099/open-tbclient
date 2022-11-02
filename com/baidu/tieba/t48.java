package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class t48 extends s48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s08 n;
    public j08 o;
    public k08 p;
    public o18 q;
    public PbReplyLoadMoreAdapter r;
    public b58 s;
    public a58 t;
    public l08 u;

    @Override // com.baidu.tieba.s48
    public void D(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dx7Var) == null) {
        }
    }

    @Override // com.baidu.tieba.s48
    public x08 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (x08) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s48
    public sz7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (sz7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s48
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s48
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tieba.s48
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t48(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.s48
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            super.A(onClickListener);
            this.q.e(onClickListener);
            this.r.w(onClickListener);
            this.u.e(onClickListener);
        }
    }

    @Override // com.baidu.tieba.s48
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.w(onClickListener);
        }
    }

    @Override // com.baidu.tieba.s48
    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.p.w(onClickListener);
        }
    }

    @Override // com.baidu.tieba.s48
    public void E(fy7 fy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fy7Var) == null) {
            super.E(fy7Var);
            this.q.n0(fy7Var);
        }
    }

    @Override // com.baidu.tieba.s48
    public void F(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dx7Var) == null) {
            this.s.M(dx7Var);
        }
    }

    @Override // com.baidu.tieba.s48
    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.s.o(str);
        }
    }

    @Override // com.baidu.tieba.s48
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.v(onClickListener);
            this.q.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.s48
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            o18 o18Var = this.q;
            if (o18Var != null) {
                o18Var.m0(z);
            }
            a58 a58Var = this.t;
            if (a58Var != null) {
                a58Var.v(z);
            }
            b58 b58Var = this.s;
            if (b58Var != null) {
                b58Var.L(z);
            }
        }
    }

    @Override // com.baidu.tieba.s48
    public void x(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, yVar) == null) {
            super.x(yVar);
            this.q.n(yVar);
        }
    }

    @Override // com.baidu.tieba.s48
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
            this.s = new b58(this.b.B(), PostData.L0);
            this.o = new j08(this.b.B(), jx7.c, this.b.getUniqueId());
            this.p = new k08(this.b.B(), kx7.a);
            this.n = new s08(this.b.B(), nx7.b1);
            o18 o18Var = new o18(this.b.B(), PostData.M0);
            this.q = o18Var;
            o18Var.o0(this.b.B());
            this.q.j0(this.b.B().K3());
            this.r = new PbReplyLoadMoreAdapter(this.b.B(), PostData.T0);
            this.t = new a58(this.b.getContext(), xx7.b, this.b.B());
            this.u = new l08(this.b.B(), lx7.c);
            this.e.add(this.s);
            this.e.add(this.t);
            this.e.add(this.n);
            this.e.add(this.o);
            this.e.add(this.p);
            this.e.add(this.q);
            this.e.add(this.r);
            this.e.add(this.u);
            this.c.a(this.e);
        }
    }

    @Override // com.baidu.tieba.s48
    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (bdTypeRecyclerView = this.c) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.s48
    public void m() {
        b58 b58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (b58Var = this.s) != null) {
            b58Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.s48
    public void q(dx7 dx7Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{dx7Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q.r(dx7Var);
            this.q.setFromCDN(z);
            this.q.o(str);
            this.q.c(z2);
            this.q.l0(0.5f);
        }
    }
}
