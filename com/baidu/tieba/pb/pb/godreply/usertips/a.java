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
    private ViewGroup bTI;
    private View.OnClickListener cze;
    private GodReplyLeaderboardTipView hKt;
    private int csg = 3;
    private final int[] hKs = new int[2];
    private int hKu = Integer.MIN_VALUE;
    private int hKv = Integer.MIN_VALUE;
    private boolean hKw = false;

    public void P(View.OnClickListener onClickListener) {
        this.cze = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.bTI == null) {
                this.bTI = (RelativeLayout) ((Activity) context).findViewById(R.id.pb_layout);
            }
            if (this.bTI != null) {
                view.getLocationOnScreen(this.hKs);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hKt == null) {
                    this.hKt = new GodReplyLeaderboardTipView(context);
                }
                this.hKt.animate().cancel();
                this.hKt.setAlpha(0.0f);
                this.hKt.animate().alpha(1.0f).setListener(null).start();
                this.hKt.setOnClickListener(this.cze);
                this.hKt.onChangeSkinType(this.csg);
                if (this.hKt.getParent() != null && this.hKt.getParent() != this.bTI) {
                    ((ViewGroup) this.hKt.getParent()).removeView(this.hKt);
                }
                if (this.hKt.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = dR(context);
                    layoutParams.topMargin = this.hKs[1] + view.getHeight() + dQ(context);
                    layoutParams.addRule(11);
                    int childCount = this.bTI.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.bTI.getChildAt(i2);
                        if (childAt != null && childAt.getId() == R.id.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.bTI.getChildCount()) {
                        this.bTI.addView(this.hKt, i, layoutParams);
                    }
                }
                this.hKt.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hKt != null) {
            this.hKt.animate().cancel();
            this.hKt.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bRN();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bRN();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRN() {
        if (this.hKt != null && this.hKt.getParent() != null && this.hKt.getParent() == this.bTI) {
            this.hKt.setVisibility(4);
        }
    }

    public void cr(View view) {
        if (bRO()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hKs);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hKt.getLayoutParams();
            layoutParams.rightMargin = dR(context);
            layoutParams.topMargin = this.hKs[1] + view.getHeight() + dQ(context);
            layoutParams.addRule(11);
            this.hKt.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hKt.getHeight() < l.getScreenDimensions(context)[1] && !this.hKw) {
                b.j(context, true);
                this.hKw = true;
                this.hKt.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bRO() {
        return this.hKt != null && this.hKt.getParent() != null && this.hKt.getParent() == this.bTI && this.hKt.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.csg = i;
        if (this.hKt != null) {
            this.hKt.onChangeSkinType(i);
        }
    }

    private int dQ(Context context) {
        if (this.hKu == Integer.MIN_VALUE) {
            this.hKu = -l.dip2px(context, 5.0f);
        }
        return this.hKu;
    }

    private int dR(Context context) {
        if (this.hKv == Integer.MIN_VALUE) {
            this.hKv = l.dip2px(context, 17.0f);
        }
        return this.hKv;
    }
}
