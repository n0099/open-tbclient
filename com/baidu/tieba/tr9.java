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
public class tr9 extends sr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kn9 n;
    public bn9 o;
    public cn9 p;
    public eo9 q;
    public PbReplyLoadMoreAdapter r;
    public vr9 s;
    public ur9 t;
    public dn9 u;

    @Override // com.baidu.tieba.sr9
    public void D(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aj9Var) == null) {
        }
    }

    @Override // com.baidu.tieba.sr9
    public pn9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (pn9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sr9
    public jm9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (jm9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sr9
    public PbFirstFloorCommentAndPraiseAdapter h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sr9
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tieba.sr9
    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tr9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.sr9
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            super.A(onClickListener);
            this.q.e(onClickListener);
            this.r.y(onClickListener);
            this.u.e(onClickListener);
        }
    }

    @Override // com.baidu.tieba.sr9
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.sr9
    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.p.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.sr9
    public void E(vk9 vk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vk9Var) == null) {
            super.E(vk9Var);
            this.q.o0(vk9Var);
        }
    }

    @Override // com.baidu.tieba.sr9
    public void F(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aj9Var) == null) {
            this.s.P(aj9Var);
        }
    }

    @Override // com.baidu.tieba.sr9
    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.s.o(str);
        }
    }

    @Override // com.baidu.tieba.sr9
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.v(onClickListener);
            this.q.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.sr9
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            eo9 eo9Var = this.q;
            if (eo9Var != null) {
                eo9Var.n0(z);
            }
            ur9 ur9Var = this.t;
            if (ur9Var != null) {
                ur9Var.x(z);
            }
            vr9 vr9Var = this.s;
            if (vr9Var != null) {
                vr9Var.O(z);
            }
        }
    }

    @Override // com.baidu.tieba.sr9
    public void x(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, zVar) == null) {
            super.x(zVar);
            this.q.n(zVar);
        }
    }

    @Override // com.baidu.tieba.sr9
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
            this.s = new vr9(this.a.S(), tha.W0);
            this.o = new bn9(this.a.S(), ij9.c, this.a.getUniqueId());
            this.p = new cn9(this.a.S(), jj9.a);
            this.n = new kn9(this.a.S(), mj9.k1);
            eo9 eo9Var = new eo9(this.a.S(), tha.X0);
            this.q = eo9Var;
            eo9Var.p0(this.a.S());
            this.q.k0(this.a.S().G3());
            this.r = new PbReplyLoadMoreAdapter(this.a.S(), tha.e1);
            this.t = new ur9(this.a.getContext(), vj9.b, this.a.S());
            this.u = new dn9(this.a.S(), kj9.c);
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

    @Override // com.baidu.tieba.sr9
    public void m() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.sr9
    public void n() {
        vr9 vr9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (vr9Var = this.s) != null) {
            vr9Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.sr9
    public void r(aj9 aj9Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{aj9Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q.r(aj9Var);
            this.q.setFromCDN(z);
            this.q.o(str);
            this.q.c(z2);
            this.q.m0(0.5f);
        }
    }
}
