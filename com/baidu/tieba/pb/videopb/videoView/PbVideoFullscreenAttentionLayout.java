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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.f0.m.a;
import d.b.h0.r.q.a2;
import d.b.i0.c2.k.e.o0;
/* loaded from: classes5.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f20105e;

    /* renamed from: f  reason: collision with root package name */
    public PbVideoFullscreenLikeBtn f20106f;

    /* renamed from: g  reason: collision with root package name */
    public o0 f20107g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f20108h;

    public PbVideoFullscreenAttentionLayout(Context context) {
        super(context);
        c(context);
    }

    public int a(a2 a2Var) {
        if (a2Var == null) {
            return 0;
        }
        if (a2Var.k2()) {
            return !k.isEmpty(a2Var.i0()) ? 2 : 0;
        }
        return 1;
    }

    public boolean b() {
        o0 o0Var = this.f20107g;
        return (o0Var == null || o0Var.j() == null || !this.f20107g.j().getIsLike()) ? false : true;
    }

    public final void c(Context context) {
        FrameLayout.inflate(context, R.layout.pb_video_attention, this);
        this.f20105e = (HeadImageView) findViewById(R.id.attention_img);
        this.f20106f = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.f20105e.setIsRound(true);
        this.f20105e.setBorderWidth(l.g(context, R.dimen.tbds3));
        this.f20105e.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.f20105e.setAutoChangeStyle(false);
        this.f20106f.setConfig(new a());
    }

    public void d(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        String str = a2Var.A;
        int a2 = a(a2Var);
        if (this.f20107g == null) {
            if (!(getContext() instanceof PbActivity)) {
                return;
            }
            o0 o0Var = new o0(((PbActivity) getContext()).getPageContext(), this.f20106f, -1);
            this.f20107g = o0Var;
            o0Var.m(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            this.f20107g.l(this.f20108h);
        }
        this.f20107g.n(a2Var.T());
        this.f20107g.x(str);
        this.f20107g.v(a2Var);
        o0 o0Var2 = this.f20107g;
        o0Var2.r = true;
        o0Var2.w(a2);
    }

    public void setData(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(a2Var.T().getAvater());
        if (headPortraitFilter.startsWith("http")) {
            this.f20105e.W(headPortraitFilter, 10, false);
        } else {
            this.f20105e.W(headPortraitFilter, 25, false);
        }
        if (a2Var.T().getBaijiahaoInfo() != null && a2Var.T().getBaijiahaoInfo().auth_id.intValue() > 0) {
            this.f20105e.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(a2Var.T().getBaijiahaoInfo().auth_id.intValue(), 1));
            this.f20105e.setShowV(true);
            this.f20105e.setGodIconWidth(R.dimen.tbds31);
        } else {
            this.f20105e.setBjhAuthIconRes(0);
            this.f20105e.setIsBigV(a2Var.T().isBigV());
            this.f20105e.setShowV(a2Var.T().isBigV());
        }
        d(a2Var);
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.f20106f.setOnclickEvent(onClickListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.f20108h = bdUniqueId;
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
