package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.tencent.connect.common.Constants;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.r.f0.m.a;
import d.a.i0.r.q.a2;
import d.a.j0.d2.k.e.q0;
/* loaded from: classes3.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f20290e;

    /* renamed from: f  reason: collision with root package name */
    public PbVideoFullscreenLikeBtn f20291f;

    /* renamed from: g  reason: collision with root package name */
    public q0 f20292g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f20293h;

    public PbVideoFullscreenAttentionLayout(Context context) {
        super(context);
        c(context);
    }

    public int a(a2 a2Var) {
        if (a2Var == null) {
            return 0;
        }
        if (a2Var.l2()) {
            return !k.isEmpty(a2Var.i0()) ? 2 : 0;
        }
        return 1;
    }

    public boolean b() {
        q0 q0Var = this.f20292g;
        return (q0Var == null || q0Var.j() == null || !this.f20292g.j().getIsLike()) ? false : true;
    }

    public final void c(Context context) {
        FrameLayout.inflate(context, R.layout.pb_video_attention, this);
        this.f20290e = (HeadImageView) findViewById(R.id.attention_img);
        this.f20291f = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.f20290e.setIsRound(true);
        this.f20290e.setBorderWidth(l.g(context, R.dimen.tbds3));
        this.f20290e.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.f20290e.setAutoChangeStyle(false);
        this.f20291f.setConfig(new a());
    }

    public void d(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        String str = a2Var.A;
        int a2 = a(a2Var);
        if (this.f20292g == null) {
            if (!(getContext() instanceof PbActivity)) {
                return;
            }
            q0 q0Var = new q0(((PbActivity) getContext()).getPageContext(), this.f20291f, -1);
            this.f20292g = q0Var;
            q0Var.m(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            this.f20292g.l(this.f20293h);
        }
        this.f20292g.n(a2Var.T());
        this.f20292g.w(str);
        this.f20292g.u(a2Var);
        q0 q0Var2 = this.f20292g;
        q0Var2.r = true;
        q0Var2.v(a2);
    }

    public void setData(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(a2Var.T().getAvater());
        if (headPortraitFilter.startsWith("http")) {
            this.f20290e.V(headPortraitFilter, 10, false);
        } else {
            this.f20290e.V(headPortraitFilter, 25, false);
        }
        if (a2Var.T().getBaijiahaoInfo() != null && a2Var.T().getBaijiahaoInfo().auth_id.intValue() > 0) {
            this.f20290e.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(a2Var.T().getBaijiahaoInfo().auth_id.intValue(), 1));
            this.f20290e.setShowV(true);
            this.f20290e.setGodIconWidth(R.dimen.tbds31);
        } else {
            this.f20290e.setBjhAuthIconRes(0);
            this.f20290e.setIsBigV(a2Var.T().isBigV());
            this.f20290e.setShowV(a2Var.T().isBigV());
        }
        d(a2Var);
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.f20291f.setOnclickEvent(onClickListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.f20293h = bdUniqueId;
    }

    public PbVideoFullscreenAttentionLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public PbVideoFullscreenAttentionLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context);
    }
}
