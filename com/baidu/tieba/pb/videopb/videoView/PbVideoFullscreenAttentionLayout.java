package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.s.i0.n.a;
import c.a.s0.s.q.d2;
import c.a.t0.s2.f;
import c.a.t0.s2.g;
import c.a.t0.s2.i;
import c.a.t0.s2.j;
import c.a.t0.s2.u.f.q0;
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
/* loaded from: classes12.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f48735e;

    /* renamed from: f  reason: collision with root package name */
    public PbVideoFullscreenLikeBtn f48736f;

    /* renamed from: g  reason: collision with root package name */
    public q0 f48737g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f48738h;

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
            this.f48735e = (HeadImageView) findViewById(i.attention_img);
            this.f48736f = (PbVideoFullscreenLikeBtn) findViewById(i.concern_video_info_item);
            this.f48735e.setIsRound(true);
            this.f48735e.setBorderWidth(n.f(context, g.tbds3));
            this.f48735e.setBorderColor(context.getResources().getColor(f.CAM_X0402));
            this.f48735e.setAutoChangeStyle(false);
            this.f48736f.setConfig(new a());
        }
    }

    public int getThreadForumType(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var)) == null) {
            if (d2Var == null) {
                return 0;
            }
            if (d2Var.o2()) {
                return !m.isEmpty(d2Var.a0()) ? 2 : 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public boolean hasConcerned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q0 q0Var = this.f48737g;
            return (q0Var == null || q0Var.j() == null || !this.f48737g.j().getIsLike()) ? false : true;
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
        if (this.f48737g == null) {
            if (!(getContext() instanceof AbsPbActivity)) {
                return;
            }
            q0 q0Var = new q0(((AbsPbActivity) getContext()).getPageContext(), this.f48736f, -1);
            this.f48737g = q0Var;
            q0Var.m("11");
            this.f48737g.l(this.f48738h);
        }
        this.f48737g.n(d2Var.J());
        this.f48737g.x(str);
        this.f48737g.v(d2Var);
        q0 q0Var2 = this.f48737g;
        q0Var2.t = true;
        q0Var2.w(threadForumType);
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) || d2Var == null || d2Var.J() == null) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(d2Var.J().getAvater());
        if (headPortraitFilter.startsWith("http")) {
            this.f48735e.startLoad(headPortraitFilter, 10, false);
        } else {
            this.f48735e.startLoad(headPortraitFilter, 25, false);
        }
        this.f48735e.setBjhAuthIconRes(0);
        this.f48735e.setIsBigV(d2Var.J().isBigV());
        this.f48735e.setShowV(d2Var.J().isBigV());
        processUserLikePresenter(d2Var);
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f48736f.setOnclickEvent(onClickListener);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.f48738h = bdUniqueId;
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
