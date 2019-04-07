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
    private ViewGroup btG;
    private View.OnClickListener ccC;
    private GodReplyLeaderboardTipView hlY;
    private int bUM = 3;
    private final int[] hlX = new int[2];
    private int hlZ = Integer.MIN_VALUE;
    private int hma = Integer.MIN_VALUE;
    private boolean hmb = false;

    public void K(View.OnClickListener onClickListener) {
        this.ccC = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.btG == null) {
                this.btG = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.btG != null) {
                view.getLocationOnScreen(this.hlX);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hlY == null) {
                    this.hlY = new GodReplyLeaderboardTipView(context);
                }
                this.hlY.animate().cancel();
                this.hlY.setAlpha(0.0f);
                this.hlY.animate().alpha(1.0f).setListener(null).start();
                this.hlY.setOnClickListener(this.ccC);
                this.hlY.onChangeSkinType(this.bUM);
                if (this.hlY.getParent() != null && this.hlY.getParent() != this.btG) {
                    ((ViewGroup) this.hlY.getParent()).removeView(this.hlY);
                }
                if (this.hlY.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = em(context);
                    layoutParams.topMargin = this.hlX[1] + view.getHeight() + el(context);
                    layoutParams.addRule(11);
                    int childCount = this.btG.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.btG.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.btG.getChildCount()) {
                        this.btG.addView(this.hlY, i, layoutParams);
                    }
                }
                this.hlY.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hlY != null) {
            this.hlY.animate().cancel();
            this.hlY.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
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
        if (this.hlY != null && this.hlY.getParent() != null && this.hlY.getParent() == this.btG) {
            this.hlY.setVisibility(4);
        }
    }

    public void cj(View view) {
        if (bJh()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hlX);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlY.getLayoutParams();
            layoutParams.rightMargin = em(context);
            layoutParams.topMargin = this.hlX[1] + view.getHeight() + el(context);
            layoutParams.addRule(11);
            this.hlY.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hlY.getHeight() < l.aS(context)[1] && !this.hmb) {
                b.l(context, true);
                this.hmb = true;
                this.hlY.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bJh() {
        return this.hlY != null && this.hlY.getParent() != null && this.hlY.getParent() == this.btG && this.hlY.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.bUM = i;
        if (this.hlY != null) {
            this.hlY.onChangeSkinType(i);
        }
    }

    private int el(Context context) {
        if (this.hlZ == Integer.MIN_VALUE) {
            this.hlZ = -l.dip2px(context, 5.0f);
        }
        return this.hlZ;
    }

    private int em(Context context) {
        if (this.hma == Integer.MIN_VALUE) {
            this.hma = l.dip2px(context, 17.0f);
        }
        return this.hma;
    }
}
