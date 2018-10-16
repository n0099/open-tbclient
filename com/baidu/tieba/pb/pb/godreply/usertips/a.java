package com.baidu.tieba.pb.pb.godreply.usertips;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class a {
    private View.OnClickListener aOJ;
    private ViewGroup aim;
    private GodReplyLeaderboardTipView fJY;
    private int aHp = 3;
    private final int[] fJX = new int[2];
    private int fJZ = Integer.MIN_VALUE;
    private int fKa = Integer.MIN_VALUE;
    private boolean fKb = false;

    public void H(View.OnClickListener onClickListener) {
        this.aOJ = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.aim == null) {
                this.aim = (RelativeLayout) ((Activity) context).findViewById(e.g.pb_layout);
            }
            if (this.aim != null) {
                view.getLocationOnScreen(this.fJX);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fJY == null) {
                    this.fJY = new GodReplyLeaderboardTipView(context);
                }
                this.fJY.animate().cancel();
                this.fJY.setAlpha(0.0f);
                this.fJY.animate().alpha(1.0f).setListener(null).start();
                this.fJY.setOnClickListener(this.aOJ);
                this.fJY.onChangeSkinType(this.aHp);
                if (this.fJY.getParent() != null && this.fJY.getParent() != this.aim) {
                    ((ViewGroup) this.fJY.getParent()).removeView(this.fJY);
                }
                if (this.fJY.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = cS(context);
                    layoutParams.topMargin = this.fJX[1] + view.getHeight() + cR(context);
                    layoutParams.addRule(11);
                    int childCount = this.aim.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.aim.getChildAt(i2);
                        if (childAt != null && childAt.getId() == e.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.aim.getChildCount()) {
                        this.aim.addView(this.fJY, i, layoutParams);
                    }
                }
                this.fJY.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fJY != null) {
            this.fJY.animate().cancel();
            this.fJY.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bgj();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bgj();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgj() {
        if (this.fJY != null && this.fJY.getParent() != null && this.fJY.getParent() == this.aim) {
            this.fJY.setVisibility(4);
        }
    }

    public void bp(View view) {
        if (bgk()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fJX);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fJY.getLayoutParams();
            layoutParams.rightMargin = cS(context);
            layoutParams.topMargin = this.fJX[1] + view.getHeight() + cR(context);
            layoutParams.addRule(11);
            this.fJY.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fJY.getHeight() < l.aS(context)[1] && !this.fKb) {
                b.l(context, true);
                this.fKb = true;
                this.fJY.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bgk() {
        return this.fJY != null && this.fJY.getParent() != null && this.fJY.getParent() == this.aim && this.fJY.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.aHp = i;
        if (this.fJY != null) {
            this.fJY.onChangeSkinType(i);
        }
    }

    private int cR(Context context) {
        if (this.fJZ == Integer.MIN_VALUE) {
            this.fJZ = -l.dip2px(context, 5.0f);
        }
        return this.fJZ;
    }

    private int cS(Context context) {
        if (this.fKa == Integer.MIN_VALUE) {
            this.fKa = l.dip2px(context, 17.0f);
        }
        return this.fKa;
    }
}
