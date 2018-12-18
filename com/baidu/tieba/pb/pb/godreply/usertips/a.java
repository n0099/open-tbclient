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
    private View.OnClickListener aSY;
    private ViewGroup amB;
    private GodReplyLeaderboardTipView fSo;
    private int aLF = 3;
    private final int[] fSn = new int[2];
    private int fSp = Integer.MIN_VALUE;
    private int fSq = Integer.MIN_VALUE;
    private boolean fSr = false;

    public void J(View.OnClickListener onClickListener) {
        this.aSY = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.amB == null) {
                this.amB = (RelativeLayout) ((Activity) context).findViewById(e.g.pb_layout);
            }
            if (this.amB != null) {
                view.getLocationOnScreen(this.fSn);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fSo == null) {
                    this.fSo = new GodReplyLeaderboardTipView(context);
                }
                this.fSo.animate().cancel();
                this.fSo.setAlpha(0.0f);
                this.fSo.animate().alpha(1.0f).setListener(null).start();
                this.fSo.setOnClickListener(this.aSY);
                this.fSo.onChangeSkinType(this.aLF);
                if (this.fSo.getParent() != null && this.fSo.getParent() != this.amB) {
                    ((ViewGroup) this.fSo.getParent()).removeView(this.fSo);
                }
                if (this.fSo.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = cR(context);
                    layoutParams.topMargin = this.fSn[1] + view.getHeight() + cQ(context);
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
                        this.amB.addView(this.fSo, i, layoutParams);
                    }
                }
                this.fSo.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fSo != null) {
            this.fSo.animate().cancel();
            this.fSo.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bhw();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bhw();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhw() {
        if (this.fSo != null && this.fSo.getParent() != null && this.fSo.getParent() == this.amB) {
            this.fSo.setVisibility(4);
        }
    }

    public void br(View view) {
        if (bhx()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fSn);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fSo.getLayoutParams();
            layoutParams.rightMargin = cR(context);
            layoutParams.topMargin = this.fSn[1] + view.getHeight() + cQ(context);
            layoutParams.addRule(11);
            this.fSo.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fSo.getHeight() < l.aS(context)[1] && !this.fSr) {
                b.l(context, true);
                this.fSr = true;
                this.fSo.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bhx() {
        return this.fSo != null && this.fSo.getParent() != null && this.fSo.getParent() == this.amB && this.fSo.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.aLF = i;
        if (this.fSo != null) {
            this.fSo.onChangeSkinType(i);
        }
    }

    private int cQ(Context context) {
        if (this.fSp == Integer.MIN_VALUE) {
            this.fSp = -l.dip2px(context, 5.0f);
        }
        return this.fSp;
    }

    private int cR(Context context) {
        if (this.fSq == Integer.MIN_VALUE) {
            this.fSq = l.dip2px(context, 17.0f);
        }
        return this.fSq;
    }
}
