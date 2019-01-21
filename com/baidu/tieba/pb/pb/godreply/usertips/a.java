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
    private View.OnClickListener aTJ;
    private ViewGroup amV;
    private GodReplyLeaderboardTipView fWe;
    private int aMk = 3;
    private final int[] fWd = new int[2];
    private int fWf = Integer.MIN_VALUE;
    private int fWg = Integer.MIN_VALUE;
    private boolean fWh = false;

    public void J(View.OnClickListener onClickListener) {
        this.aTJ = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.amV == null) {
                this.amV = (RelativeLayout) ((Activity) context).findViewById(e.g.pb_layout);
            }
            if (this.amV != null) {
                view.getLocationOnScreen(this.fWd);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fWe == null) {
                    this.fWe = new GodReplyLeaderboardTipView(context);
                }
                this.fWe.animate().cancel();
                this.fWe.setAlpha(0.0f);
                this.fWe.animate().alpha(1.0f).setListener(null).start();
                this.fWe.setOnClickListener(this.aTJ);
                this.fWe.onChangeSkinType(this.aMk);
                if (this.fWe.getParent() != null && this.fWe.getParent() != this.amV) {
                    ((ViewGroup) this.fWe.getParent()).removeView(this.fWe);
                }
                if (this.fWe.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = cR(context);
                    layoutParams.topMargin = this.fWd[1] + view.getHeight() + cQ(context);
                    layoutParams.addRule(11);
                    int childCount = this.amV.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.amV.getChildAt(i2);
                        if (childAt != null && childAt.getId() == e.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.amV.getChildCount()) {
                        this.amV.addView(this.fWe, i, layoutParams);
                    }
                }
                this.fWe.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fWe != null) {
            this.fWe.animate().cancel();
            this.fWe.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.biM();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.biM();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biM() {
        if (this.fWe != null && this.fWe.getParent() != null && this.fWe.getParent() == this.amV) {
            this.fWe.setVisibility(4);
        }
    }

    public void bu(View view) {
        if (biN()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fWd);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fWe.getLayoutParams();
            layoutParams.rightMargin = cR(context);
            layoutParams.topMargin = this.fWd[1] + view.getHeight() + cQ(context);
            layoutParams.addRule(11);
            this.fWe.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fWe.getHeight() < l.aS(context)[1] && !this.fWh) {
                b.l(context, true);
                this.fWh = true;
                this.fWe.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean biN() {
        return this.fWe != null && this.fWe.getParent() != null && this.fWe.getParent() == this.amV && this.fWe.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.aMk = i;
        if (this.fWe != null) {
            this.fWe.onChangeSkinType(i);
        }
    }

    private int cQ(Context context) {
        if (this.fWf == Integer.MIN_VALUE) {
            this.fWf = -l.dip2px(context, 5.0f);
        }
        return this.fWf;
    }

    private int cR(Context context) {
        if (this.fWg == Integer.MIN_VALUE) {
            this.fWg = l.dip2px(context, 17.0f);
        }
        return this.fWg;
    }
}
