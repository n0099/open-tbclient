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
    private ViewGroup btD;
    private View.OnClickListener ccA;
    private GodReplyLeaderboardTipView hml;
    private int bUK = 3;
    private final int[] hmk = new int[2];
    private int hmm = Integer.MIN_VALUE;
    private int hmn = Integer.MIN_VALUE;
    private boolean hmo = false;

    public void K(View.OnClickListener onClickListener) {
        this.ccA = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.btD == null) {
                this.btD = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.btD != null) {
                view.getLocationOnScreen(this.hmk);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hml == null) {
                    this.hml = new GodReplyLeaderboardTipView(context);
                }
                this.hml.animate().cancel();
                this.hml.setAlpha(0.0f);
                this.hml.animate().alpha(1.0f).setListener(null).start();
                this.hml.setOnClickListener(this.ccA);
                this.hml.onChangeSkinType(this.bUK);
                if (this.hml.getParent() != null && this.hml.getParent() != this.btD) {
                    ((ViewGroup) this.hml.getParent()).removeView(this.hml);
                }
                if (this.hml.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = em(context);
                    layoutParams.topMargin = this.hmk[1] + view.getHeight() + el(context);
                    layoutParams.addRule(11);
                    int childCount = this.btD.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.btD.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.btD.getChildCount()) {
                        this.btD.addView(this.hml, i, layoutParams);
                    }
                }
                this.hml.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hml != null) {
            this.hml.animate().cancel();
            this.hml.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
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
        if (this.hml != null && this.hml.getParent() != null && this.hml.getParent() == this.btD) {
            this.hml.setVisibility(4);
        }
    }

    public void cj(View view) {
        if (bJk()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hmk);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hml.getLayoutParams();
            layoutParams.rightMargin = em(context);
            layoutParams.topMargin = this.hmk[1] + view.getHeight() + el(context);
            layoutParams.addRule(11);
            this.hml.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hml.getHeight() < l.aS(context)[1] && !this.hmo) {
                b.l(context, true);
                this.hmo = true;
                this.hml.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bJk() {
        return this.hml != null && this.hml.getParent() != null && this.hml.getParent() == this.btD && this.hml.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.bUK = i;
        if (this.hml != null) {
            this.hml.onChangeSkinType(i);
        }
    }

    private int el(Context context) {
        if (this.hmm == Integer.MIN_VALUE) {
            this.hmm = -l.dip2px(context, 5.0f);
        }
        return this.hmm;
    }

    private int em(Context context) {
        if (this.hmn == Integer.MIN_VALUE) {
            this.hmn = l.dip2px(context, 17.0f);
        }
        return this.hmn;
    }
}
