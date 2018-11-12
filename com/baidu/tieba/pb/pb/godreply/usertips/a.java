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
    private View.OnClickListener aPz;
    private ViewGroup aiZ;
    private GodReplyLeaderboardTipView fLy;
    private int aIf = 3;
    private final int[] fLx = new int[2];
    private int fLz = Integer.MIN_VALUE;
    private int fLA = Integer.MIN_VALUE;
    private boolean fLB = false;

    public void J(View.OnClickListener onClickListener) {
        this.aPz = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.aiZ == null) {
                this.aiZ = (RelativeLayout) ((Activity) context).findViewById(e.g.pb_layout);
            }
            if (this.aiZ != null) {
                view.getLocationOnScreen(this.fLx);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fLy == null) {
                    this.fLy = new GodReplyLeaderboardTipView(context);
                }
                this.fLy.animate().cancel();
                this.fLy.setAlpha(0.0f);
                this.fLy.animate().alpha(1.0f).setListener(null).start();
                this.fLy.setOnClickListener(this.aPz);
                this.fLy.onChangeSkinType(this.aIf);
                if (this.fLy.getParent() != null && this.fLy.getParent() != this.aiZ) {
                    ((ViewGroup) this.fLy.getParent()).removeView(this.fLy);
                }
                if (this.fLy.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = cN(context);
                    layoutParams.topMargin = this.fLx[1] + view.getHeight() + cM(context);
                    layoutParams.addRule(11);
                    int childCount = this.aiZ.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.aiZ.getChildAt(i2);
                        if (childAt != null && childAt.getId() == e.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.aiZ.getChildCount()) {
                        this.aiZ.addView(this.fLy, i, layoutParams);
                    }
                }
                this.fLy.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fLy != null) {
            this.fLy.animate().cancel();
            this.fLy.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bfG();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bfG();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfG() {
        if (this.fLy != null && this.fLy.getParent() != null && this.fLy.getParent() == this.aiZ) {
            this.fLy.setVisibility(4);
        }
    }

    public void br(View view) {
        if (bfH()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fLx);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLy.getLayoutParams();
            layoutParams.rightMargin = cN(context);
            layoutParams.topMargin = this.fLx[1] + view.getHeight() + cM(context);
            layoutParams.addRule(11);
            this.fLy.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fLy.getHeight() < l.aS(context)[1] && !this.fLB) {
                b.l(context, true);
                this.fLB = true;
                this.fLy.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bfH() {
        return this.fLy != null && this.fLy.getParent() != null && this.fLy.getParent() == this.aiZ && this.fLy.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.aIf = i;
        if (this.fLy != null) {
            this.fLy.onChangeSkinType(i);
        }
    }

    private int cM(Context context) {
        if (this.fLz == Integer.MIN_VALUE) {
            this.fLz = -l.dip2px(context, 5.0f);
        }
        return this.fLz;
    }

    private int cN(Context context) {
        if (this.fLA == Integer.MIN_VALUE) {
            this.fLA = l.dip2px(context, 17.0f);
        }
        return this.fLA;
    }
}
