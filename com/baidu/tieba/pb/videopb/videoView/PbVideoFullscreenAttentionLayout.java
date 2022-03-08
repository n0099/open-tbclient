package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.q0.r.l0.n.a;
import c.a.q0.r.r.e2;
import c.a.r0.u2.k.f.r0;
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
/* loaded from: classes6.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f45492e;

    /* renamed from: f  reason: collision with root package name */
    public PbVideoFullscreenLikeBtn f45493f;

    /* renamed from: g  reason: collision with root package name */
    public r0 f45494g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f45495h;

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
            this.f45492e = (HeadImageView) findViewById(R.id.attention_img);
            this.f45493f = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
            this.f45492e.setIsRound(true);
            this.f45492e.setBorderWidth(n.f(context, R.dimen.tbds3));
            this.f45492e.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
            this.f45492e.setAutoChangeStyle(false);
            this.f45493f.setConfig(new a());
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
            r0 r0Var = this.f45494g;
            return (r0Var == null || r0Var.j() == null || !this.f45494g.j().getIsLike()) ? false : true;
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
        if (this.f45494g == null) {
            if (!(getContext() instanceof AbsPbActivity)) {
                return;
            }
            r0 r0Var = new r0(((AbsPbActivity) getContext()).getPageContext(), this.f45493f, -1);
            this.f45494g = r0Var;
            r0Var.m("11");
            this.f45494g.l(this.f45495h);
        }
        this.f45494g.n(e2Var.J());
        this.f45494g.x(str);
        this.f45494g.v(e2Var);
        r0 r0Var2 = this.f45494g;
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
            this.f45492e.startLoad(headPortraitFilter, 10, false);
        } else {
            this.f45492e.startLoad(headPortraitFilter, 25, false);
        }
        this.f45492e.setBjhAuthIconRes(0);
        this.f45492e.setIsBigV(e2Var.J().isBigV());
        this.f45492e.setShowV(e2Var.J().isBigV());
        processUserLikePresenter(e2Var);
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f45493f.setOnclickEvent(onClickListener);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.f45495h = bdUniqueId;
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
