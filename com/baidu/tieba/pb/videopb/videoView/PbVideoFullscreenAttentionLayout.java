package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.r.f0.n.a;
import d.a.o0.r.q.b2;
import d.a.p0.h2.k.e.q0;
/* loaded from: classes4.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f19849e;

    /* renamed from: f  reason: collision with root package name */
    public PbVideoFullscreenLikeBtn f19850f;

    /* renamed from: g  reason: collision with root package name */
    public q0 f19851g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f19852h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoFullscreenAttentionLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c(context);
    }

    public int a(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b2Var)) == null) {
            if (b2Var == null) {
                return 0;
            }
            if (b2Var.b2()) {
                return !k.isEmpty(b2Var.W()) ? 2 : 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q0 q0Var = this.f19851g;
            return (q0Var == null || q0Var.j() == null || !this.f19851g.j().getIsLike()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            FrameLayout.inflate(context, R.layout.pb_video_attention, this);
            this.f19849e = (HeadImageView) findViewById(R.id.attention_img);
            this.f19850f = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
            this.f19849e.setIsRound(true);
            this.f19849e.setBorderWidth(l.g(context, R.dimen.tbds3));
            this.f19849e.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
            this.f19849e.setAutoChangeStyle(false);
            this.f19850f.setConfig(new a());
        }
    }

    public void d(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, b2Var) == null) || b2Var == null || b2Var.H() == null) {
            return;
        }
        String str = b2Var.A;
        int a2 = a(b2Var);
        if (this.f19851g == null) {
            if (!(getContext() instanceof PbActivity)) {
                return;
            }
            q0 q0Var = new q0(((PbActivity) getContext()).getPageContext(), this.f19850f, -1);
            this.f19851g = q0Var;
            q0Var.m("11");
            this.f19851g.l(this.f19852h);
        }
        this.f19851g.n(b2Var.H());
        this.f19851g.w(str);
        this.f19851g.u(b2Var);
        q0 q0Var2 = this.f19851g;
        q0Var2.s = true;
        q0Var2.v(a2);
    }

    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, b2Var) == null) || b2Var == null || b2Var.H() == null) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(b2Var.H().getAvater());
        if (headPortraitFilter.startsWith("http")) {
            this.f19849e.M(headPortraitFilter, 10, false);
        } else {
            this.f19849e.M(headPortraitFilter, 25, false);
        }
        if (b2Var.H().getBaijiahaoInfo() != null && b2Var.H().getBaijiahaoInfo().auth_id.intValue() > 0) {
            this.f19849e.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(b2Var.H().getBaijiahaoInfo().auth_id.intValue(), 1));
            this.f19849e.setShowV(true);
            this.f19849e.setGodIconWidth(R.dimen.tbds31);
        } else {
            this.f19849e.setBjhAuthIconRes(0);
            this.f19849e.setIsBigV(b2Var.H().isBigV());
            this.f19849e.setShowV(b2Var.H().isBigV());
        }
        d(b2Var);
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f19850f.setOnclickEvent(onClickListener);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.f19852h = bdUniqueId;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoFullscreenAttentionLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoFullscreenAttentionLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        c(context);
    }
}
