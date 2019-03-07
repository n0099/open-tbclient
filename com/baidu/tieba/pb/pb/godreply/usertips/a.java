package com.baidu.tieba.pb.pb.godreply.usertips;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a {
    private ViewGroup btB;
    private View.OnClickListener ccA;
    private GodReplyLeaderboardTipView hmp;
    private int bUJ = 3;
    private final int[] hmo = new int[2];
    private int hmq = Integer.MIN_VALUE;
    private int hmr = Integer.MIN_VALUE;
    private boolean hms = false;

    public void K(View.OnClickListener onClickListener) {
        this.ccA = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.btB == null) {
                this.btB = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.btB != null) {
                view.getLocationOnScreen(this.hmo);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hmp == null) {
                    this.hmp = new GodReplyLeaderboardTipView(context);
                }
                this.hmp.animate().cancel();
                this.hmp.setAlpha(0.0f);
                this.hmp.animate().alpha(1.0f).setListener(null).start();
                this.hmp.setOnClickListener(this.ccA);
                this.hmp.onChangeSkinType(this.bUJ);
                if (this.hmp.getParent() != null && this.hmp.getParent() != this.btB) {
                    ((ViewGroup) this.hmp.getParent()).removeView(this.hmp);
                }
                if (this.hmp.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = en(context);
                    layoutParams.topMargin = this.hmo[1] + view.getHeight() + em(context);
                    layoutParams.addRule(11);
                    int childCount = this.btB.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.btB.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.btB.getChildCount()) {
                        this.btB.addView(this.hmp, i, layoutParams);
                    }
                }
                this.hmp.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hmp != null) {
            this.hmp.animate().cancel();
            this.hmp.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bJj();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bJj();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJj() {
        if (this.hmp != null && this.hmp.getParent() != null && this.hmp.getParent() == this.btB) {
            this.hmp.setVisibility(4);
        }
    }

    public void cj(View view) {
        if (bJk()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hmo);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hmp.getLayoutParams();
            layoutParams.rightMargin = en(context);
            layoutParams.topMargin = this.hmo[1] + view.getHeight() + em(context);
            layoutParams.addRule(11);
            this.hmp.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hmp.getHeight() < l.aS(context)[1] && !this.hms) {
                b.l(context, true);
                this.hms = true;
                this.hmp.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean bJk() {
        return this.hmp != null && this.hmp.getParent() != null && this.hmp.getParent() == this.btB && this.hmp.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.bUJ = i;
        if (this.hmp != null) {
            this.hmp.onChangeSkinType(i);
        }
    }

    private int em(Context context) {
        if (this.hmq == Integer.MIN_VALUE) {
            this.hmq = -l.dip2px(context, 5.0f);
        }
        return this.hmq;
    }

    private int en(Context context) {
        if (this.hmr == Integer.MIN_VALUE) {
            this.hmr = l.dip2px(context, 17.0f);
        }
        return this.hmr;
    }
}
