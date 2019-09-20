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
    private ViewGroup bCe;
    private View.OnClickListener cmX;
    private GodReplyLeaderboardTipView hMG;
    private int ceL = 3;
    private final int[] hMF = new int[2];
    private int hMH = Integer.MIN_VALUE;
    private int hMI = Integer.MIN_VALUE;
    private boolean hMJ = false;

    public void O(View.OnClickListener onClickListener) {
        this.cmX = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.bCe == null) {
                this.bCe = (RelativeLayout) ((Activity) context).findViewById(R.id.pb_layout);
            }
            if (this.bCe != null) {
                view.getLocationOnScreen(this.hMF);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hMG == null) {
                    this.hMG = new GodReplyLeaderboardTipView(context);
                }
                this.hMG.animate().cancel();
                this.hMG.setAlpha(0.0f);
                this.hMG.animate().alpha(1.0f).setListener(null).start();
                this.hMG.setOnClickListener(this.cmX);
                this.hMG.onChangeSkinType(this.ceL);
                if (this.hMG.getParent() != null && this.hMG.getParent() != this.bCe) {
                    ((ViewGroup) this.hMG.getParent()).removeView(this.hMG);
                }
                if (this.hMG.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = ef(context);
                    layoutParams.topMargin = this.hMF[1] + view.getHeight() + ee(context);
                    layoutParams.addRule(11);
                    int childCount = this.bCe.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.bCe.getChildAt(i2);
                        if (childAt != null && childAt.getId() == R.id.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.bCe.getChildCount()) {
                        this.bCe.addView(this.hMG, i, layoutParams);
                    }
                }
                this.hMG.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hMG != null) {
            this.hMG.animate().cancel();
            this.hMG.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bUO();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bUO();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUO() {
        if (this.hMG != null && this.hMG.getParent() != null && this.hMG.getParent() == this.bCe) {
            this.hMG.setVisibility(4);
        }
    }

    public void cv(View view) {
        if (bUP()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hMF);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hMG.getLayoutParams();
            layoutParams.rightMargin = ef(context);
            layoutParams.topMargin = this.hMF[1] + view.getHeight() + ee(context);
            layoutParams.addRule(11);
            this.hMG.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hMG.getHeight() < l.aj(context)[1] && !this.hMJ) {
                b.j(context, true);
                this.hMJ = true;
                this.hMG.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bUP() {
        return this.hMG != null && this.hMG.getParent() != null && this.hMG.getParent() == this.bCe && this.hMG.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.ceL = i;
        if (this.hMG != null) {
            this.hMG.onChangeSkinType(i);
        }
    }

    private int ee(Context context) {
        if (this.hMH == Integer.MIN_VALUE) {
            this.hMH = -l.dip2px(context, 5.0f);
        }
        return this.hMH;
    }

    private int ef(Context context) {
        if (this.hMI == Integer.MIN_VALUE) {
            this.hMI = l.dip2px(context, 17.0f);
        }
        return this.hMI;
    }
}
