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
    private View.OnClickListener aTa;
    private ViewGroup amB;
    private GodReplyLeaderboardTipView fVg;
    private int aLH = 3;
    private final int[] fVf = new int[2];
    private int fVh = Integer.MIN_VALUE;
    private int fVi = Integer.MIN_VALUE;
    private boolean fVj = false;

    public void J(View.OnClickListener onClickListener) {
        this.aTa = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.amB == null) {
                this.amB = (RelativeLayout) ((Activity) context).findViewById(e.g.pb_layout);
            }
            if (this.amB != null) {
                view.getLocationOnScreen(this.fVf);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fVg == null) {
                    this.fVg = new GodReplyLeaderboardTipView(context);
                }
                this.fVg.animate().cancel();
                this.fVg.setAlpha(0.0f);
                this.fVg.animate().alpha(1.0f).setListener(null).start();
                this.fVg.setOnClickListener(this.aTa);
                this.fVg.onChangeSkinType(this.aLH);
                if (this.fVg.getParent() != null && this.fVg.getParent() != this.amB) {
                    ((ViewGroup) this.fVg.getParent()).removeView(this.fVg);
                }
                if (this.fVg.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = cR(context);
                    layoutParams.topMargin = this.fVf[1] + view.getHeight() + cQ(context);
                    layoutParams.addRule(11);
                    int childCount = this.amB.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.amB.getChildAt(i2);
                        if (childAt != null && childAt.getId() == e.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.amB.getChildCount()) {
                        this.amB.addView(this.fVg, i, layoutParams);
                    }
                }
                this.fVg.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fVg != null) {
            this.fVg.animate().cancel();
            this.fVg.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bii();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bii();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bii() {
        if (this.fVg != null && this.fVg.getParent() != null && this.fVg.getParent() == this.amB) {
            this.fVg.setVisibility(4);
        }
    }

    public void bu(View view) {
        if (bij()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fVf);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fVg.getLayoutParams();
            layoutParams.rightMargin = cR(context);
            layoutParams.topMargin = this.fVf[1] + view.getHeight() + cQ(context);
            layoutParams.addRule(11);
            this.fVg.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fVg.getHeight() < l.aS(context)[1] && !this.fVj) {
                b.l(context, true);
                this.fVj = true;
                this.fVg.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bij() {
        return this.fVg != null && this.fVg.getParent() != null && this.fVg.getParent() == this.amB && this.fVg.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.aLH = i;
        if (this.fVg != null) {
            this.fVg.onChangeSkinType(i);
        }
    }

    private int cQ(Context context) {
        if (this.fVh == Integer.MIN_VALUE) {
            this.fVh = -l.dip2px(context, 5.0f);
        }
        return this.fVh;
    }

    private int cR(Context context) {
        if (this.fVi == Integer.MIN_VALUE) {
            this.fVi = l.dip2px(context, 17.0f);
        }
        return this.fVi;
    }
}
