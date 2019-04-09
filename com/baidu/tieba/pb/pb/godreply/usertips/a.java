package com.baidu.tieba.pb.pb.godreply.usertips;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a {
    private ViewGroup btH;
    private View.OnClickListener ccD;
    private GodReplyLeaderboardTipView hlZ;
    private int bUN = 3;
    private final int[] hlY = new int[2];
    private int hma = Integer.MIN_VALUE;
    private int hmb = Integer.MIN_VALUE;
    private boolean hmc = false;

    public void K(View.OnClickListener onClickListener) {
        this.ccD = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.btH == null) {
                this.btH = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.btH != null) {
                view.getLocationOnScreen(this.hlY);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hlZ == null) {
                    this.hlZ = new GodReplyLeaderboardTipView(context);
                }
                this.hlZ.animate().cancel();
                this.hlZ.setAlpha(0.0f);
                this.hlZ.animate().alpha(1.0f).setListener(null).start();
                this.hlZ.setOnClickListener(this.ccD);
                this.hlZ.onChangeSkinType(this.bUN);
                if (this.hlZ.getParent() != null && this.hlZ.getParent() != this.btH) {
                    ((ViewGroup) this.hlZ.getParent()).removeView(this.hlZ);
                }
                if (this.hlZ.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = em(context);
                    layoutParams.topMargin = this.hlY[1] + view.getHeight() + el(context);
                    layoutParams.addRule(11);
                    int childCount = this.btH.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.btH.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.btH.getChildCount()) {
                        this.btH.addView(this.hlZ, i, layoutParams);
                    }
                }
                this.hlZ.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hlZ != null) {
            this.hlZ.animate().cancel();
            this.hlZ.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bJg();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bJg();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJg() {
        if (this.hlZ != null && this.hlZ.getParent() != null && this.hlZ.getParent() == this.btH) {
            this.hlZ.setVisibility(4);
        }
    }

    public void cj(View view) {
        if (bJh()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hlY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlZ.getLayoutParams();
            layoutParams.rightMargin = em(context);
            layoutParams.topMargin = this.hlY[1] + view.getHeight() + el(context);
            layoutParams.addRule(11);
            this.hlZ.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hlZ.getHeight() < l.aS(context)[1] && !this.hmc) {
                b.l(context, true);
                this.hmc = true;
                this.hlZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bJh() {
        return this.hlZ != null && this.hlZ.getParent() != null && this.hlZ.getParent() == this.btH && this.hlZ.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.bUN = i;
        if (this.hlZ != null) {
            this.hlZ.onChangeSkinType(i);
        }
    }

    private int el(Context context) {
        if (this.hma == Integer.MIN_VALUE) {
            this.hma = -l.dip2px(context, 5.0f);
        }
        return this.hma;
    }

    private int em(Context context) {
        if (this.hmb == Integer.MIN_VALUE) {
            this.hmb = l.dip2px(context, 17.0f);
        }
        return this.hmb;
    }
}
