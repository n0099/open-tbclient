package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.f0.n.a;
import c.a.q0.s.q.d2;
import c.a.r0.j2.k.e.p0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f55735e;

    /* renamed from: f  reason: collision with root package name */
    public PbVideoFullscreenLikeBtn f55736f;

    /* renamed from: g  reason: collision with root package name */
    public p0 f55737g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f55738h;

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
            FrameLayout.inflate(context, R.layout.pb_video_attention, this);
            this.f55735e = (HeadImageView) findViewById(R.id.attention_img);
            this.f55736f = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
            this.f55735e.setIsRound(true);
            this.f55735e.setBorderWidth(l.g(context, R.dimen.tbds3));
            this.f55735e.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
            this.f55735e.setAutoChangeStyle(false);
            this.f55736f.setConfig(new a());
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
            p0 p0Var = this.f55737g;
            return (p0Var == null || p0Var.j() == null || !this.f55737g.j().getIsLike()) ? false : true;
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
        if (this.f55737g == null) {
            if (!(getContext() instanceof AbsPbActivity)) {
                return;
            }
            p0 p0Var = new p0(((AbsPbActivity) getContext()).getPageContext(), this.f55736f, -1);
            this.f55737g = p0Var;
            p0Var.m("11");
            this.f55737g.l(this.f55738h);
        }
        this.f55737g.n(d2Var.J());
        this.f55737g.w(str);
        this.f55737g.u(d2Var);
        p0 p0Var2 = this.f55737g;
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
            this.f55735e.startLoad(headPortraitFilter, 10, false);
        } else {
            this.f55735e.startLoad(headPortraitFilter, 25, false);
        }
        this.f55735e.setBjhAuthIconRes(0);
        this.f55735e.setIsBigV(d2Var.J().isBigV());
        this.f55735e.setShowV(d2Var.J().isBigV());
        processUserLikePresenter(d2Var);
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f55736f.setOnclickEvent(onClickListener);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.f55738h = bdUniqueId;
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
