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
/* loaded from: classes2.dex */
public class a {
    private View.OnClickListener aKh;
    private ViewGroup ado;
    private GodReplyLeaderboardTipView fCx;
    private int aCJ = 3;
    private final int[] fCw = new int[2];
    private int fCy = Integer.MIN_VALUE;
    private int fCz = Integer.MIN_VALUE;
    private boolean fCA = false;

    public void H(View.OnClickListener onClickListener) {
        this.aKh = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.ado == null) {
                this.ado = (RelativeLayout) ((Activity) context).findViewById(e.g.pb_layout);
            }
            if (this.ado != null) {
                view.getLocationOnScreen(this.fCw);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fCx == null) {
                    this.fCx = new GodReplyLeaderboardTipView(context);
                }
                this.fCx.animate().cancel();
                this.fCx.setAlpha(0.0f);
                this.fCx.animate().alpha(1.0f).setListener(null).start();
                this.fCx.setOnClickListener(this.aKh);
                this.fCx.onChangeSkinType(this.aCJ);
                if (this.fCx.getParent() != null && this.fCx.getParent() != this.ado) {
                    ((ViewGroup) this.fCx.getParent()).removeView(this.fCx);
                }
                if (this.fCx.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = cF(context);
                    layoutParams.topMargin = this.fCw[1] + view.getHeight() + cE(context);
                    layoutParams.addRule(11);
                    int childCount = this.ado.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.ado.getChildAt(i2);
                        if (childAt != null && childAt.getId() == e.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.ado.getChildCount()) {
                        this.ado.addView(this.fCx, i, layoutParams);
                    }
                }
                this.fCx.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fCx != null) {
            this.fCx.animate().cancel();
            this.fCx.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bcX();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bcX();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcX() {
        if (this.fCx != null && this.fCx.getParent() != null && this.fCx.getParent() == this.ado) {
            this.fCx.setVisibility(4);
        }
    }

    public void bp(View view) {
        if (bcY()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fCw);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fCx.getLayoutParams();
            layoutParams.rightMargin = cF(context);
            layoutParams.topMargin = this.fCw[1] + view.getHeight() + cE(context);
            layoutParams.addRule(11);
            this.fCx.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fCx.getHeight() < l.aS(context)[1] && !this.fCA) {
                b.k(context, true);
                this.fCA = true;
                this.fCx.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bcY() {
        return this.fCx != null && this.fCx.getParent() != null && this.fCx.getParent() == this.ado && this.fCx.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.aCJ = i;
        if (this.fCx != null) {
            this.fCx.onChangeSkinType(i);
        }
    }

    private int cE(Context context) {
        if (this.fCy == Integer.MIN_VALUE) {
            this.fCy = -l.dip2px(context, 5.0f);
        }
        return this.fCy;
    }

    private int cF(Context context) {
        if (this.fCz == Integer.MIN_VALUE) {
            this.fCz = l.dip2px(context, 17.0f);
        }
        return this.fCz;
    }
}
