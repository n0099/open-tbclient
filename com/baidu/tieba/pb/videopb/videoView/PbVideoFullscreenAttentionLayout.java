package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.o0.s.f0.n.a;
import c.a.o0.s.q.c2;
import c.a.p0.i2.k.e.p0;
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
/* loaded from: classes7.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f55314e;

    /* renamed from: f  reason: collision with root package name */
    public PbVideoFullscreenLikeBtn f55315f;

    /* renamed from: g  reason: collision with root package name */
    public p0 f55316g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f55317h;

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
            this.f55314e = (HeadImageView) findViewById(R.id.attention_img);
            this.f55315f = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
            this.f55314e.setIsRound(true);
            this.f55314e.setBorderWidth(l.g(context, R.dimen.tbds3));
            this.f55314e.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
            this.f55314e.setAutoChangeStyle(false);
            this.f55315f.setConfig(new a());
        }
    }

    public int getThreadForumType(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var)) == null) {
            if (c2Var == null) {
                return 0;
            }
            if (c2Var.h2()) {
                return !k.isEmpty(c2Var.Z()) ? 2 : 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public boolean hasConcerned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            p0 p0Var = this.f55316g;
            return (p0Var == null || p0Var.j() == null || !this.f55316g.j().getIsLike()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void processUserLikePresenter(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, c2Var) == null) || c2Var == null || c2Var.J() == null) {
            return;
        }
        String str = c2Var.B;
        int threadForumType = getThreadForumType(c2Var);
        if (this.f55316g == null) {
            if (!(getContext() instanceof AbsPbActivity)) {
                return;
            }
            p0 p0Var = new p0(((AbsPbActivity) getContext()).getPageContext(), this.f55315f, -1);
            this.f55316g = p0Var;
            p0Var.m("11");
            this.f55316g.l(this.f55317h);
        }
        this.f55316g.n(c2Var.J());
        this.f55316g.w(str);
        this.f55316g.u(c2Var);
        p0 p0Var2 = this.f55316g;
        p0Var2.s = true;
        p0Var2.v(threadForumType);
    }

    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, c2Var) == null) || c2Var == null || c2Var.J() == null) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(c2Var.J().getAvater());
        if (headPortraitFilter.startsWith("http")) {
            this.f55314e.startLoad(headPortraitFilter, 10, false);
        } else {
            this.f55314e.startLoad(headPortraitFilter, 25, false);
        }
        if (c2Var.J().getBaijiahaoInfo() != null && c2Var.J().getBaijiahaoInfo().auth_id.intValue() > 0) {
            this.f55314e.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(c2Var.J().getBaijiahaoInfo().auth_id.intValue(), 1));
            this.f55314e.setShowV(true);
            this.f55314e.setGodIconWidth(R.dimen.tbds31);
        } else {
            this.f55314e.setBjhAuthIconRes(0);
            this.f55314e.setIsBigV(c2Var.J().isBigV());
            this.f55314e.setShowV(c2Var.J().isBigV());
        }
        processUserLikePresenter(c2Var);
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f55315f.setOnclickEvent(onClickListener);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.f55317h = bdUniqueId;
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
