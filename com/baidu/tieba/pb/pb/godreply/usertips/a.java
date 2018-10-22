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
    private GodReplyLeaderboardTipView fJZ;
    private int aHp = 3;
    private final int[] fJY = new int[2];
    private int fKa = Integer.MIN_VALUE;
    private int fKb = Integer.MIN_VALUE;
    private boolean fKc = false;

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
                view.getLocationOnScreen(this.fJY);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fJZ == null) {
                    this.fJZ = new GodReplyLeaderboardTipView(context);
                }
                this.fJZ.animate().cancel();
                this.fJZ.setAlpha(0.0f);
                this.fJZ.animate().alpha(1.0f).setListener(null).start();
                this.fJZ.setOnClickListener(this.aOJ);
                this.fJZ.onChangeSkinType(this.aHp);
                if (this.fJZ.getParent() != null && this.fJZ.getParent() != this.aim) {
                    ((ViewGroup) this.fJZ.getParent()).removeView(this.fJZ);
                }
                if (this.fJZ.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = cS(context);
                    layoutParams.topMargin = this.fJY[1] + view.getHeight() + cR(context);
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
                        this.aim.addView(this.fJZ, i, layoutParams);
                    }
                }
                this.fJZ.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fJZ != null) {
            this.fJZ.animate().cancel();
            this.fJZ.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
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
        if (this.fJZ != null && this.fJZ.getParent() != null && this.fJZ.getParent() == this.aim) {
            this.fJZ.setVisibility(4);
        }
    }

    public void bp(View view) {
        if (bgk()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fJY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fJZ.getLayoutParams();
            layoutParams.rightMargin = cS(context);
            layoutParams.topMargin = this.fJY[1] + view.getHeight() + cR(context);
            layoutParams.addRule(11);
            this.fJZ.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fJZ.getHeight() < l.aS(context)[1] && !this.fKc) {
                b.l(context, true);
                this.fKc = true;
                this.fJZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bgk() {
        return this.fJZ != null && this.fJZ.getParent() != null && this.fJZ.getParent() == this.aim && this.fJZ.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.aHp = i;
        if (this.fJZ != null) {
            this.fJZ.onChangeSkinType(i);
        }
    }

    private int cR(Context context) {
        if (this.fKa == Integer.MIN_VALUE) {
            this.fKa = -l.dip2px(context, 5.0f);
        }
        return this.fKa;
    }

    private int cS(Context context) {
        if (this.fKb == Integer.MIN_VALUE) {
            this.fKb = l.dip2px(context, 17.0f);
        }
        return this.fKb;
    }
}
