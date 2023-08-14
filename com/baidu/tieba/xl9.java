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
public class xl9 extends wl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ph9 n;
    public gh9 o;
    public hh9 p;
    public ji9 q;
    public PbReplyLoadMoreAdapter r;
    public zl9 s;
    public yl9 t;
    public ih9 u;

    @Override // com.baidu.tieba.wl9
    public void D(td9 td9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, td9Var) == null) {
        }
    }

    @Override // com.baidu.tieba.wl9
    public uh9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (uh9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wl9
    public og9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (og9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wl9
    public PbFirstFloorCommentAndPraiseAdapter h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wl9
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tieba.wl9
    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xl9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.wl9
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            super.A(onClickListener);
            this.q.e(onClickListener);
            this.r.y(onClickListener);
            this.u.e(onClickListener);
        }
    }

    @Override // com.baidu.tieba.wl9
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.wl9
    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.p.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.wl9
    public void E(af9 af9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, af9Var) == null) {
            super.E(af9Var);
            this.q.q0(af9Var);
        }
    }

    @Override // com.baidu.tieba.wl9
    public void F(td9 td9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, td9Var) == null) {
            this.s.R(td9Var);
        }
    }

    @Override // com.baidu.tieba.wl9
    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.s.o(str);
        }
    }

    @Override // com.baidu.tieba.wl9
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.v(onClickListener);
            this.q.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.wl9
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            ji9 ji9Var = this.q;
            if (ji9Var != null) {
                ji9Var.p0(z);
            }
            yl9 yl9Var = this.t;
            if (yl9Var != null) {
                yl9Var.x(z);
            }
            zl9 zl9Var = this.s;
            if (zl9Var != null) {
                zl9Var.Q(z);
            }
        }
    }

    @Override // com.baidu.tieba.wl9
    public void x(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, zVar) == null) {
            super.x(zVar);
            this.q.n(zVar);
        }
    }

    @Override // com.baidu.tieba.wl9
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
            this.s = new zl9(this.a.O(), rba.V0);
            this.o = new gh9(this.a.O(), be9.c, this.a.getUniqueId());
            this.p = new hh9(this.a.O(), ce9.a);
            this.n = new ph9(this.a.O(), fe9.j1);
            ji9 ji9Var = new ji9(this.a.O(), rba.W0);
            this.q = ji9Var;
            ji9Var.r0(this.a.O());
            this.q.m0(this.a.O().s3());
            this.r = new PbReplyLoadMoreAdapter(this.a.O(), rba.d1);
            this.t = new yl9(this.a.getContext(), oe9.b, this.a.O());
            this.u = new ih9(this.a.O(), de9.c);
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

    @Override // com.baidu.tieba.wl9
    public void m() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.wl9
    public void n() {
        zl9 zl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (zl9Var = this.s) != null) {
            zl9Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.wl9
    public void r(td9 td9Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{td9Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q.r(td9Var);
            this.q.setFromCDN(z);
            this.q.o(str);
            this.q.c(z2);
            this.q.o0(0.5f);
        }
    }
}
