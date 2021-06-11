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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.f0.m.a;
import d.a.m0.r.q.a2;
import d.a.n0.e2.k.e.q0;
/* loaded from: classes5.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f19577e;

    /* renamed from: f  reason: collision with root package name */
    public PbVideoFullscreenLikeBtn f19578f;

    /* renamed from: g  reason: collision with root package name */
    public q0 f19579g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f19580h;

    public PbVideoFullscreenAttentionLayout(Context context) {
        super(context);
        c(context);
    }

    public int a(a2 a2Var) {
        if (a2Var == null) {
            return 0;
        }
        if (a2Var.o2()) {
            return !k.isEmpty(a2Var.i0()) ? 2 : 0;
        }
        return 1;
    }

    public boolean b() {
        q0 q0Var = this.f19579g;
        return (q0Var == null || q0Var.j() == null || !this.f19579g.j().getIsLike()) ? false : true;
    }

    public final void c(Context context) {
        FrameLayout.inflate(context, R.layout.pb_video_attention, this);
        this.f19577e = (HeadImageView) findViewById(R.id.attention_img);
        this.f19578f = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.f19577e.setIsRound(true);
        this.f19577e.setBorderWidth(l.g(context, R.dimen.tbds3));
        this.f19577e.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.f19577e.setAutoChangeStyle(false);
        this.f19578f.setConfig(new a());
    }

    public void d(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        String str = a2Var.A;
        int a2 = a(a2Var);
        if (this.f19579g == null) {
            if (!(getContext() instanceof PbActivity)) {
                return;
            }
            q0 q0Var = new q0(((PbActivity) getContext()).getPageContext(), this.f19578f, -1);
            this.f19579g = q0Var;
            q0Var.m("11");
            this.f19579g.l(this.f19580h);
        }
        this.f19579g.n(a2Var.T());
        this.f19579g.w(str);
        this.f19579g.u(a2Var);
        q0 q0Var2 = this.f19579g;
        q0Var2.s = true;
        q0Var2.v(a2);
    }

    public void setData(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(a2Var.T().getAvater());
        if (headPortraitFilter.startsWith("http")) {
            this.f19577e.U(headPortraitFilter, 10, false);
        } else {
            this.f19577e.U(headPortraitFilter, 25, false);
        }
        if (a2Var.T().getBaijiahaoInfo() != null && a2Var.T().getBaijiahaoInfo().auth_id.intValue() > 0) {
            this.f19577e.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(a2Var.T().getBaijiahaoInfo().auth_id.intValue(), 1));
            this.f19577e.setShowV(true);
            this.f19577e.setGodIconWidth(R.dimen.tbds31);
        } else {
            this.f19577e.setBjhAuthIconRes(0);
            this.f19577e.setIsBigV(a2Var.T().isBigV());
            this.f19577e.setShowV(a2Var.T().isBigV());
        }
        d(a2Var);
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.f19578f.setOnclickEvent(onClickListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.f19580h = bdUniqueId;
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
