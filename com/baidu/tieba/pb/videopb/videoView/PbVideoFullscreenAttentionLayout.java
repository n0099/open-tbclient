package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.t0.s.l0.n.a;
import c.a.t0.s.r.e2;
import c.a.u0.u2.f;
import c.a.u0.u2.g;
import c.a.u0.u2.i;
import c.a.u0.u2.j;
import c.a.u0.u2.u.f.r0;
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
/* loaded from: classes13.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f47084e;

    /* renamed from: f  reason: collision with root package name */
    public PbVideoFullscreenLikeBtn f47085f;

    /* renamed from: g  reason: collision with root package name */
    public r0 f47086g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f47087h;

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
            this.f47084e = (HeadImageView) findViewById(i.attention_img);
            this.f47085f = (PbVideoFullscreenLikeBtn) findViewById(i.concern_video_info_item);
            this.f47084e.setIsRound(true);
            this.f47084e.setBorderWidth(n.f(context, g.tbds3));
            this.f47084e.setBorderColor(context.getResources().getColor(f.CAM_X0402));
            this.f47084e.setAutoChangeStyle(false);
            this.f47085f.setConfig(new a());
        }
    }

    public int getThreadForumType(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var)) == null) {
            if (e2Var == null) {
                return 0;
            }
            if (e2Var.p2()) {
                return !m.isEmpty(e2Var.b0()) ? 2 : 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public boolean hasConcerned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            r0 r0Var = this.f47086g;
            return (r0Var == null || r0Var.j() == null || !this.f47086g.j().getIsLike()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void processUserLikePresenter(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, e2Var) == null) || e2Var == null || e2Var.J() == null) {
            return;
        }
        String str = e2Var.E;
        int threadForumType = getThreadForumType(e2Var);
        if (this.f47086g == null) {
            if (!(getContext() instanceof AbsPbActivity)) {
                return;
            }
            r0 r0Var = new r0(((AbsPbActivity) getContext()).getPageContext(), this.f47085f, -1);
            this.f47086g = r0Var;
            r0Var.m("11");
            this.f47086g.l(this.f47087h);
        }
        this.f47086g.n(e2Var.J());
        this.f47086g.x(str);
        this.f47086g.v(e2Var);
        r0 r0Var2 = this.f47086g;
        r0Var2.t = true;
        r0Var2.w(threadForumType);
    }

    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, e2Var) == null) || e2Var == null || e2Var.J() == null) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(e2Var.J().getAvater());
        if (headPortraitFilter.startsWith("http")) {
            this.f47084e.startLoad(headPortraitFilter, 10, false);
        } else {
            this.f47084e.startLoad(headPortraitFilter, 25, false);
        }
        this.f47084e.setBjhAuthIconRes(0);
        this.f47084e.setIsBigV(e2Var.J().isBigV());
        this.f47084e.setShowV(e2Var.J().isBigV());
        processUserLikePresenter(e2Var);
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f47085f.setOnclickEvent(onClickListener);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.f47087h = bdUniqueId;
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
