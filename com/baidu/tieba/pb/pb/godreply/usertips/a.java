package com.baidu.tieba.pb.pb.godreply.usertips;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {
    private ViewGroup bAJ;
    private View.OnClickListener ckI;
    private GodReplyLeaderboardTipView hDD;
    private int ccJ = 3;
    private final int[] hDC = new int[2];
    private int hDE = Integer.MIN_VALUE;
    private int hDF = Integer.MIN_VALUE;
    private boolean hDG = false;

    public void M(View.OnClickListener onClickListener) {
        this.ckI = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.bAJ == null) {
                this.bAJ = (RelativeLayout) ((Activity) context).findViewById(R.id.pb_layout);
            }
            if (this.bAJ != null) {
                view.getLocationOnScreen(this.hDC);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hDD == null) {
                    this.hDD = new GodReplyLeaderboardTipView(context);
                }
                this.hDD.animate().cancel();
                this.hDD.setAlpha(0.0f);
                this.hDD.animate().alpha(1.0f).setListener(null).start();
                this.hDD.setOnClickListener(this.ckI);
                this.hDD.onChangeSkinType(this.ccJ);
                if (this.hDD.getParent() != null && this.hDD.getParent() != this.bAJ) {
                    ((ViewGroup) this.hDD.getParent()).removeView(this.hDD);
                }
                if (this.hDD.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = ec(context);
                    layoutParams.topMargin = this.hDC[1] + view.getHeight() + eb(context);
                    layoutParams.addRule(11);
                    int childCount = this.bAJ.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.bAJ.getChildAt(i2);
                        if (childAt != null && childAt.getId() == R.id.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.bAJ.getChildCount()) {
                        this.bAJ.addView(this.hDD, i, layoutParams);
                    }
                }
                this.hDD.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hDD != null) {
            this.hDD.animate().cancel();
            this.hDD.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bRb();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bRb();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRb() {
        if (this.hDD != null && this.hDD.getParent() != null && this.hDD.getParent() == this.bAJ) {
            this.hDD.setVisibility(4);
        }
    }

    public void cr(View view) {
        if (bRc()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hDC);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hDD.getLayoutParams();
            layoutParams.rightMargin = ec(context);
            layoutParams.topMargin = this.hDC[1] + view.getHeight() + eb(context);
            layoutParams.addRule(11);
            this.hDD.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hDD.getHeight() < l.aj(context)[1] && !this.hDG) {
                b.j(context, true);
                this.hDG = true;
                this.hDD.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bRc() {
        return this.hDD != null && this.hDD.getParent() != null && this.hDD.getParent() == this.bAJ && this.hDD.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.ccJ = i;
        if (this.hDD != null) {
            this.hDD.onChangeSkinType(i);
        }
    }

    private int eb(Context context) {
        if (this.hDE == Integer.MIN_VALUE) {
            this.hDE = -l.dip2px(context, 5.0f);
        }
        return this.hDE;
    }

    private int ec(Context context) {
        if (this.hDF == Integer.MIN_VALUE) {
            this.hDF = l.dip2px(context, 17.0f);
        }
        return this.hDF;
    }
}
