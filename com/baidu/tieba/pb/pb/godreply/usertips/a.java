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
    private GodReplyLeaderboardTipView hDz;
    private int ccI = 3;
    private final int[] hDy = new int[2];
    private int hDA = Integer.MIN_VALUE;
    private int hDB = Integer.MIN_VALUE;
    private boolean hDC = false;

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
                view.getLocationOnScreen(this.hDy);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hDz == null) {
                    this.hDz = new GodReplyLeaderboardTipView(context);
                }
                this.hDz.animate().cancel();
                this.hDz.setAlpha(0.0f);
                this.hDz.animate().alpha(1.0f).setListener(null).start();
                this.hDz.setOnClickListener(this.ckH);
                this.hDz.onChangeSkinType(this.ccI);
                if (this.hDz.getParent() != null && this.hDz.getParent() != this.bAJ) {
                    ((ViewGroup) this.hDz.getParent()).removeView(this.hDz);
                }
                if (this.hDz.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = ec(context);
                    layoutParams.topMargin = this.hDy[1] + view.getHeight() + eb(context);
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
                        this.bAJ.addView(this.hDz, i, layoutParams);
                    }
                }
                this.hDz.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hDz != null) {
            this.hDz.animate().cancel();
            this.hDz.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bQX();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bQX();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQX() {
        if (this.hDz != null && this.hDz.getParent() != null && this.hDz.getParent() == this.bAJ) {
            this.hDz.setVisibility(4);
        }
    }

    public void cr(View view) {
        if (bQY()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hDy);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hDz.getLayoutParams();
            layoutParams.rightMargin = ec(context);
            layoutParams.topMargin = this.hDy[1] + view.getHeight() + eb(context);
            layoutParams.addRule(11);
            this.hDz.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hDz.getHeight() < l.aj(context)[1] && !this.hDC) {
                b.j(context, true);
                this.hDC = true;
                this.hDz.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bQY() {
        return this.hDz != null && this.hDz.getParent() != null && this.hDz.getParent() == this.bAJ && this.hDz.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.ccI = i;
        if (this.hDz != null) {
            this.hDz.onChangeSkinType(i);
        }
    }

    private int eb(Context context) {
        if (this.hDA == Integer.MIN_VALUE) {
            this.hDA = -l.dip2px(context, 5.0f);
        }
        return this.hDA;
    }

    private int ec(Context context) {
        if (this.hDB == Integer.MIN_VALUE) {
            this.hDB = l.dip2px(context, 17.0f);
        }
        return this.hDB;
    }
}
