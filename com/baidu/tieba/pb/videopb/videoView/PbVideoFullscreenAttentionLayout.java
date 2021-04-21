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
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.f0.m.a;
import d.b.i0.r.q.a2;
import d.b.j0.d2.k.e.q0;
/* loaded from: classes3.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f19801e;

    /* renamed from: f  reason: collision with root package name */
    public PbVideoFullscreenLikeBtn f19802f;

    /* renamed from: g  reason: collision with root package name */
    public q0 f19803g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f19804h;

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
        q0 q0Var = this.f19803g;
        return (q0Var == null || q0Var.j() == null || !this.f19803g.j().getIsLike()) ? false : true;
    }

    public final void c(Context context) {
        FrameLayout.inflate(context, R.layout.pb_video_attention, this);
        this.f19801e = (HeadImageView) findViewById(R.id.attention_img);
        this.f19802f = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.f19801e.setIsRound(true);
        this.f19801e.setBorderWidth(l.g(context, R.dimen.tbds3));
        this.f19801e.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.f19801e.setAutoChangeStyle(false);
        this.f19802f.setConfig(new a());
    }

    public void d(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        String str = a2Var.A;
        int a2 = a(a2Var);
        if (this.f19803g == null) {
            if (!(getContext() instanceof PbActivity)) {
                return;
            }
            q0 q0Var = new q0(((PbActivity) getContext()).getPageContext(), this.f19802f, -1);
            this.f19803g = q0Var;
            q0Var.m(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            this.f19803g.l(this.f19804h);
        }
        this.f19803g.n(a2Var.T());
        this.f19803g.x(str);
        this.f19803g.v(a2Var);
        q0 q0Var2 = this.f19803g;
        q0Var2.r = true;
        q0Var2.w(a2);
    }

    public void setData(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(a2Var.T().getAvater());
        if (headPortraitFilter.startsWith("http")) {
            this.f19801e.W(headPortraitFilter, 10, false);
        } else {
            this.f19801e.W(headPortraitFilter, 25, false);
        }
        if (a2Var.T().getBaijiahaoInfo() != null && a2Var.T().getBaijiahaoInfo().auth_id.intValue() > 0) {
            this.f19801e.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(a2Var.T().getBaijiahaoInfo().auth_id.intValue(), 1));
            this.f19801e.setShowV(true);
            this.f19801e.setGodIconWidth(R.dimen.tbds31);
        } else {
            this.f19801e.setBjhAuthIconRes(0);
            this.f19801e.setIsBigV(a2Var.T().isBigV());
            this.f19801e.setShowV(a2Var.T().isBigV());
        }
        d(a2Var);
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.f19802f.setOnclickEvent(onClickListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.f19804h = bdUniqueId;
    }

    public PbVideoFullscreenAttentionLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public PbVideoFullscreenAttentionLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
