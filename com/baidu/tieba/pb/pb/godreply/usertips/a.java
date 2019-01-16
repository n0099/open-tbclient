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
    private View.OnClickListener aTI;
    private ViewGroup amV;
    private GodReplyLeaderboardTipView fWd;
    private int aMj = 3;
    private final int[] fWc = new int[2];
    private int fWe = Integer.MIN_VALUE;
    private int fWf = Integer.MIN_VALUE;
    private boolean fWg = false;

    public void J(View.OnClickListener onClickListener) {
        this.aTI = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.amV == null) {
                this.amV = (RelativeLayout) ((Activity) context).findViewById(e.g.pb_layout);
            }
            if (this.amV != null) {
                view.getLocationOnScreen(this.fWc);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fWd == null) {
                    this.fWd = new GodReplyLeaderboardTipView(context);
                }
                this.fWd.animate().cancel();
                this.fWd.setAlpha(0.0f);
                this.fWd.animate().alpha(1.0f).setListener(null).start();
                this.fWd.setOnClickListener(this.aTI);
                this.fWd.onChangeSkinType(this.aMj);
                if (this.fWd.getParent() != null && this.fWd.getParent() != this.amV) {
                    ((ViewGroup) this.fWd.getParent()).removeView(this.fWd);
                }
                if (this.fWd.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = cR(context);
                    layoutParams.topMargin = this.fWc[1] + view.getHeight() + cQ(context);
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
                        this.amV.addView(this.fWd, i, layoutParams);
                    }
                }
                this.fWd.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fWd != null) {
            this.fWd.animate().cancel();
            this.fWd.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
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
        if (this.fWd != null && this.fWd.getParent() != null && this.fWd.getParent() == this.amV) {
            this.fWd.setVisibility(4);
        }
    }

    public void bu(View view) {
        if (biN()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fWc);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fWd.getLayoutParams();
            layoutParams.rightMargin = cR(context);
            layoutParams.topMargin = this.fWc[1] + view.getHeight() + cQ(context);
            layoutParams.addRule(11);
            this.fWd.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fWd.getHeight() < l.aS(context)[1] && !this.fWg) {
                b.l(context, true);
                this.fWg = true;
                this.fWd.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean biN() {
        return this.fWd != null && this.fWd.getParent() != null && this.fWd.getParent() == this.amV && this.fWd.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.aMj = i;
        if (this.fWd != null) {
            this.fWd.onChangeSkinType(i);
        }
    }

    private int cQ(Context context) {
        if (this.fWe == Integer.MIN_VALUE) {
            this.fWe = -l.dip2px(context, 5.0f);
        }
        return this.fWe;
    }

    private int cR(Context context) {
        if (this.fWf == Integer.MIN_VALUE) {
            this.fWf = l.dip2px(context, 17.0f);
        }
        return this.fWf;
    }
}
