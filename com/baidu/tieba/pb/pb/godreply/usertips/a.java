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
    private View.OnClickListener ckH;
    private GodReplyLeaderboardTipView hDC;
    private int ccI = 3;
    private final int[] hDB = new int[2];
    private int hDD = Integer.MIN_VALUE;
    private int hDE = Integer.MIN_VALUE;
    private boolean hDF = false;

    public void M(View.OnClickListener onClickListener) {
        this.ckH = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.bAJ == null) {
                this.bAJ = (RelativeLayout) ((Activity) context).findViewById(R.id.pb_layout);
            }
            if (this.bAJ != null) {
                view.getLocationOnScreen(this.hDB);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hDC == null) {
                    this.hDC = new GodReplyLeaderboardTipView(context);
                }
                this.hDC.animate().cancel();
                this.hDC.setAlpha(0.0f);
                this.hDC.animate().alpha(1.0f).setListener(null).start();
                this.hDC.setOnClickListener(this.ckH);
                this.hDC.onChangeSkinType(this.ccI);
                if (this.hDC.getParent() != null && this.hDC.getParent() != this.bAJ) {
                    ((ViewGroup) this.hDC.getParent()).removeView(this.hDC);
                }
                if (this.hDC.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = ec(context);
                    layoutParams.topMargin = this.hDB[1] + view.getHeight() + eb(context);
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
                        this.bAJ.addView(this.hDC, i, layoutParams);
                    }
                }
                this.hDC.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hDC != null) {
            this.hDC.animate().cancel();
            this.hDC.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bRa();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bRa();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRa() {
        if (this.hDC != null && this.hDC.getParent() != null && this.hDC.getParent() == this.bAJ) {
            this.hDC.setVisibility(4);
        }
    }

    public void cr(View view) {
        if (bRb()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hDB);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hDC.getLayoutParams();
            layoutParams.rightMargin = ec(context);
            layoutParams.topMargin = this.hDB[1] + view.getHeight() + eb(context);
            layoutParams.addRule(11);
            this.hDC.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hDC.getHeight() < l.aj(context)[1] && !this.hDF) {
                b.j(context, true);
                this.hDF = true;
                this.hDC.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bRb() {
        return this.hDC != null && this.hDC.getParent() != null && this.hDC.getParent() == this.bAJ && this.hDC.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.ccI = i;
        if (this.hDC != null) {
            this.hDC.onChangeSkinType(i);
        }
    }

    private int eb(Context context) {
        if (this.hDD == Integer.MIN_VALUE) {
            this.hDD = -l.dip2px(context, 5.0f);
        }
        return this.hDD;
    }

    private int ec(Context context) {
        if (this.hDE == Integer.MIN_VALUE) {
            this.hDE = l.dip2px(context, 17.0f);
        }
        return this.hDE;
    }
}
