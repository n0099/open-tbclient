package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.s.g0.n.a;
import b.a.q0.s.q.d2;
import b.a.r0.k2.f;
import b.a.r0.k2.g;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.k2.u.f.p0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f52833e;

    /* renamed from: f  reason: collision with root package name */
    public PbVideoFullscreenLikeBtn f52834f;

    /* renamed from: g  reason: collision with root package name */
    public p0 f52835g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f52836h;

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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            FrameLayout.inflate(context, j.pb_video_attention, this);
            this.f52833e = (HeadImageView) findViewById(i.attention_img);
            this.f52834f = (PbVideoFullscreenLikeBtn) findViewById(i.concern_video_info_item);
            this.f52833e.setIsRound(true);
            this.f52833e.setBorderWidth(l.g(context, g.tbds3));
            this.f52833e.setBorderColor(context.getResources().getColor(f.CAM_X0402));
            this.f52833e.setAutoChangeStyle(false);
            this.f52834f.setConfig(new a());
        }
    }

    public int getThreadForumType(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var)) == null) {
            if (d2Var == null) {
                return 0;
            }
            if (d2Var.l2()) {
                return !k.isEmpty(d2Var.Z()) ? 2 : 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public boolean hasConcerned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            p0 p0Var = this.f52835g;
            return (p0Var == null || p0Var.j() == null || !this.f52835g.j().getIsLike()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void processUserLikePresenter(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) || d2Var == null || d2Var.J() == null) {
            return;
        }
        String str = d2Var.E;
        int threadForumType = getThreadForumType(d2Var);
        if (this.f52835g == null) {
            if (!(getContext() instanceof AbsPbActivity)) {
                return;
            }
            p0 p0Var = new p0(((AbsPbActivity) getContext()).getPageContext(), this.f52834f, -1);
            this.f52835g = p0Var;
            p0Var.m("11");
            this.f52835g.l(this.f52836h);
        }
        this.f52835g.n(d2Var.J());
        this.f52835g.w(str);
        this.f52835g.u(d2Var);
        p0 p0Var2 = this.f52835g;
        p0Var2.s = true;
        p0Var2.v(threadForumType);
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) || d2Var == null || d2Var.J() == null) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(d2Var.J().getAvater());
        if (headPortraitFilter.startsWith("http")) {
            this.f52833e.startLoad(headPortraitFilter, 10, false);
        } else {
            this.f52833e.startLoad(headPortraitFilter, 25, false);
        }
        this.f52833e.setBjhAuthIconRes(0);
        this.f52833e.setIsBigV(d2Var.J().isBigV());
        this.f52833e.setShowV(d2Var.J().isBigV());
        processUserLikePresenter(d2Var);
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f52834f.setOnclickEvent(onClickListener);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.f52836h = bdUniqueId;
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
        a(context);
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
        a(context);
    }
}
