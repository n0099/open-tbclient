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
    private GodReplyLeaderboardTipView hmq;
    private int bUJ = 3;
    private final int[] hmp = new int[2];
    private int hmr = Integer.MIN_VALUE;
    private int hms = Integer.MIN_VALUE;
    private boolean hmt = false;

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
                view.getLocationOnScreen(this.hmp);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hmq == null) {
                    this.hmq = new GodReplyLeaderboardTipView(context);
                }
                this.hmq.animate().cancel();
                this.hmq.setAlpha(0.0f);
                this.hmq.animate().alpha(1.0f).setListener(null).start();
                this.hmq.setOnClickListener(this.ccA);
                this.hmq.onChangeSkinType(this.bUJ);
                if (this.hmq.getParent() != null && this.hmq.getParent() != this.btB) {
                    ((ViewGroup) this.hmq.getParent()).removeView(this.hmq);
                }
                if (this.hmq.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = en(context);
                    layoutParams.topMargin = this.hmp[1] + view.getHeight() + em(context);
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
                        this.btB.addView(this.hmq, i, layoutParams);
                    }
                }
                this.hmq.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hmq != null) {
            this.hmq.animate().cancel();
            this.hmq.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bJk();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bJk();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJk() {
        if (this.hmq != null && this.hmq.getParent() != null && this.hmq.getParent() == this.btB) {
            this.hmq.setVisibility(4);
        }
    }

    public void cj(View view) {
        if (bJl()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hmp);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hmq.getLayoutParams();
            layoutParams.rightMargin = en(context);
            layoutParams.topMargin = this.hmp[1] + view.getHeight() + em(context);
            layoutParams.addRule(11);
            this.hmq.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hmq.getHeight() < l.aS(context)[1] && !this.hmt) {
                b.l(context, true);
                this.hmt = true;
                this.hmq.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean bJl() {
        return this.hmq != null && this.hmq.getParent() != null && this.hmq.getParent() == this.btB && this.hmq.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.bUJ = i;
        if (this.hmq != null) {
            this.hmq.onChangeSkinType(i);
        }
    }

    private int em(Context context) {
        if (this.hmr == Integer.MIN_VALUE) {
            this.hmr = -l.dip2px(context, 5.0f);
        }
        return this.hmr;
    }

    private int en(Context context) {
        if (this.hms == Integer.MIN_VALUE) {
            this.hms = l.dip2px(context, 17.0f);
        }
        return this.hms;
    }
}
