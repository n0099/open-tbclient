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
    private ViewGroup bBG;
    private View.OnClickListener cmb;
    private GodReplyLeaderboardTipView hKJ;
    private int cdS = 3;
    private final int[] hKI = new int[2];
    private int hKK = Integer.MIN_VALUE;
    private int hKL = Integer.MIN_VALUE;
    private boolean hKM = false;

    public void O(View.OnClickListener onClickListener) {
        this.cmb = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.bBG == null) {
                this.bBG = (RelativeLayout) ((Activity) context).findViewById(R.id.pb_layout);
            }
            if (this.bBG != null) {
                view.getLocationOnScreen(this.hKI);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hKJ == null) {
                    this.hKJ = new GodReplyLeaderboardTipView(context);
                }
                this.hKJ.animate().cancel();
                this.hKJ.setAlpha(0.0f);
                this.hKJ.animate().alpha(1.0f).setListener(null).start();
                this.hKJ.setOnClickListener(this.cmb);
                this.hKJ.onChangeSkinType(this.cdS);
                if (this.hKJ.getParent() != null && this.hKJ.getParent() != this.bBG) {
                    ((ViewGroup) this.hKJ.getParent()).removeView(this.hKJ);
                }
                if (this.hKJ.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = ee(context);
                    layoutParams.topMargin = this.hKI[1] + view.getHeight() + ed(context);
                    layoutParams.addRule(11);
                    int childCount = this.bBG.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.bBG.getChildAt(i2);
                        if (childAt != null && childAt.getId() == R.id.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.bBG.getChildCount()) {
                        this.bBG.addView(this.hKJ, i, layoutParams);
                    }
                }
                this.hKJ.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hKJ != null) {
            this.hKJ.animate().cancel();
            this.hKJ.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bUb();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bUb();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUb() {
        if (this.hKJ != null && this.hKJ.getParent() != null && this.hKJ.getParent() == this.bBG) {
            this.hKJ.setVisibility(4);
        }
    }

    public void cv(View view) {
        if (bUc()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hKI);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hKJ.getLayoutParams();
            layoutParams.rightMargin = ee(context);
            layoutParams.topMargin = this.hKI[1] + view.getHeight() + ed(context);
            layoutParams.addRule(11);
            this.hKJ.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hKJ.getHeight() < l.aj(context)[1] && !this.hKM) {
                b.j(context, true);
                this.hKM = true;
                this.hKJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bUc() {
        return this.hKJ != null && this.hKJ.getParent() != null && this.hKJ.getParent() == this.bBG && this.hKJ.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.cdS = i;
        if (this.hKJ != null) {
            this.hKJ.onChangeSkinType(i);
        }
    }

    private int ed(Context context) {
        if (this.hKK == Integer.MIN_VALUE) {
            this.hKK = -l.dip2px(context, 5.0f);
        }
        return this.hKK;
    }

    private int ee(Context context) {
        if (this.hKL == Integer.MIN_VALUE) {
            this.hKL = l.dip2px(context, 17.0f);
        }
        return this.hKL;
    }
}
