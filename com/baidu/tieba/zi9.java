package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zi9 extends wh9<of9, PbReplyTitleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;
    public SortSwitchButton.f h;
    public BdUniqueId i;
    public BdUniqueId j;
    public boolean k;
    public ze9 l;
    public View m;
    public boolean n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zi9(bn9 bn9Var, BdUniqueId bdUniqueId) {
        super(bn9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bn9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bn9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.i = BdUniqueId.gen();
        this.j = BdUniqueId.gen();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.n = z;
        }
    }

    public void B(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            this.h = fVar;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public void r(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ze9Var) == null) {
            this.l = ze9Var;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.k = false;
            MessageManager.getInstance().unRegisterListener(this.i);
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wh9, com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        z(i, view2, viewGroup, (of9) obj, (PbReplyTitleViewHolder) viewHolder);
        return view2;
    }

    public final void u() {
        ze9 ze9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (ze9Var = this.l) != null && ze9Var.N() != null && this.l.g() != null) {
            ze9 ze9Var2 = this.l;
            if (ze9Var2.i && !this.k) {
                this.k = true;
                boolean f = ze9Var2.g().f();
                TiebaStatic.log(new StatisticItem("common_exp").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_id", this.l.g().b()).param("thread_type", this.l.N().getThreadType()).param("tid", this.l.N().getId()));
                if (!f) {
                    TiebaStatic.log(new StatisticItem("common_exp").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_id", this.l.g().b()).param("thread_type", this.l.N().getThreadType()).param("tid", this.l.N().getId()));
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public PbReplyTitleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07a9, viewGroup, false);
            this.m = inflate;
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.a.getPageContext(), inflate);
            PbFragment pbFragment = this.b;
            if (pbFragment != null) {
                pbReplyTitleViewHolder.t(pbFragment.d0);
            }
            pbReplyTitleViewHolder.v = false;
            pbReplyTitleViewHolder.s(this.g);
            pbReplyTitleViewHolder.r(this.h);
            pbReplyTitleViewHolder.q(this.n);
            if (getType() == of9.g) {
                pbReplyTitleViewHolder.p(this.i);
            } else if (getType() == of9.h) {
                pbReplyTitleViewHolder.o(this.j);
            }
            return pbReplyTitleViewHolder;
        }
        return (PbReplyTitleViewHolder) invokeL.objValue;
    }

    public View z(int i, View view2, ViewGroup viewGroup, of9 of9Var, PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view2, viewGroup, of9Var, pbReplyTitleViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) of9Var, (of9) pbReplyTitleViewHolder);
            if (pbReplyTitleViewHolder != null) {
                u();
                of9Var.e = this.l.f;
                pbReplyTitleViewHolder.j(of9Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
