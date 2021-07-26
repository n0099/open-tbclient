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
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.s.f0.n.a;
import d.a.p0.s.q.b2;
import d.a.q0.h2.k.e.q0;
/* loaded from: classes4.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f19952e;

    /* renamed from: f  reason: collision with root package name */
    public PbVideoFullscreenLikeBtn f19953f;

    /* renamed from: g  reason: collision with root package name */
    public q0 f19954g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f19955h;

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
            if (b2Var.c2()) {
                return !k.isEmpty(b2Var.X()) ? 2 : 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q0 q0Var = this.f19954g;
            return (q0Var == null || q0Var.j() == null || !this.f19954g.j().getIsLike()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            FrameLayout.inflate(context, R.layout.pb_video_attention, this);
            this.f19952e = (HeadImageView) findViewById(R.id.attention_img);
            this.f19953f = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
            this.f19952e.setIsRound(true);
            this.f19952e.setBorderWidth(l.g(context, R.dimen.tbds3));
            this.f19952e.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
            this.f19952e.setAutoChangeStyle(false);
            this.f19953f.setConfig(new a());
        }
    }

    public void d(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, b2Var) == null) || b2Var == null || b2Var.H() == null) {
            return;
        }
        String str = b2Var.A;
        int a2 = a(b2Var);
        if (this.f19954g == null) {
            if (!(getContext() instanceof AbsPbActivity)) {
                return;
            }
            q0 q0Var = new q0(((AbsPbActivity) getContext()).getPageContext(), this.f19953f, -1);
            this.f19954g = q0Var;
            q0Var.m("11");
            this.f19954g.l(this.f19955h);
        }
        this.f19954g.n(b2Var.H());
        this.f19954g.w(str);
        this.f19954g.u(b2Var);
        q0 q0Var2 = this.f19954g;
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
            this.f19952e.M(headPortraitFilter, 10, false);
        } else {
            this.f19952e.M(headPortraitFilter, 25, false);
        }
        if (b2Var.H().getBaijiahaoInfo() != null && b2Var.H().getBaijiahaoInfo().auth_id.intValue() > 0) {
            this.f19952e.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(b2Var.H().getBaijiahaoInfo().auth_id.intValue(), 1));
            this.f19952e.setShowV(true);
            this.f19952e.setGodIconWidth(R.dimen.tbds31);
        } else {
            this.f19952e.setBjhAuthIconRes(0);
            this.f19952e.setIsBigV(b2Var.H().isBigV());
            this.f19952e.setShowV(b2Var.H().isBigV());
        }
        d(b2Var);
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f19953f.setOnclickEvent(onClickListener);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.f19955h = bdUniqueId;
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
