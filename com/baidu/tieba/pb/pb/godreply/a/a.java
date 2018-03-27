package com.baidu.tieba.pb.pb.godreply.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private ViewGroup aHI;
    private View.OnClickListener blT;
    private b fKC;
    private int bfC = 3;
    private final int[] fKB = new int[2];
    private int fKD = Integer.MIN_VALUE;
    private int fKE = Integer.MIN_VALUE;
    private boolean fKF = false;

    public void F(View.OnClickListener onClickListener) {
        this.blT = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.aHI == null) {
                this.aHI = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.aHI != null) {
                view.getLocationOnScreen(this.fKB);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fKC == null) {
                    this.fKC = new b(context);
                }
                this.fKC.animate().cancel();
                this.fKC.setAlpha(0.0f);
                this.fKC.animate().alpha(1.0f).setListener(null).start();
                this.fKC.setOnClickListener(this.blT);
                this.fKC.onChangeSkinType(this.bfC);
                if (this.fKC.getParent() != null && this.fKC.getParent() != this.aHI) {
                    ((ViewGroup) this.fKC.getParent()).removeView(this.fKC);
                }
                if (this.fKC.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = ca(context);
                    layoutParams.topMargin = this.fKB[1] + view.getHeight() + bZ(context);
                    layoutParams.addRule(11);
                    int childCount = this.aHI.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.aHI.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.aHI.getChildCount()) {
                        this.aHI.addView(this.fKC, i, layoutParams);
                    }
                }
                this.fKC.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fKC != null) {
            this.fKC.animate().cancel();
            this.fKC.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bbJ();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bbJ();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbJ() {
        if (this.fKC != null && this.fKC.getParent() != null && this.fKC.getParent() == this.aHI) {
            this.fKC.setVisibility(4);
        }
    }

    public void co(View view) {
        if (bbK()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fKB);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKC.getLayoutParams();
            layoutParams.rightMargin = ca(context);
            layoutParams.topMargin = this.fKB[1] + view.getHeight() + bZ(context);
            layoutParams.addRule(11);
            this.fKC.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fKC.getHeight() < l.as(context)[1] && !this.fKF) {
                c.v(context, true);
                this.fKF = true;
                this.fKC.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean bbK() {
        return this.fKC != null && this.fKC.getParent() != null && this.fKC.getParent() == this.aHI && this.fKC.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.bfC = i;
        if (this.fKC != null) {
            this.fKC.onChangeSkinType(i);
        }
    }

    private int bZ(Context context) {
        if (this.fKD == Integer.MIN_VALUE) {
            this.fKD = -l.dip2px(context, 5.0f);
        }
        return this.fKD;
    }

    private int ca(Context context) {
        if (this.fKE == Integer.MIN_VALUE) {
            this.fKE = l.dip2px(context, 17.0f);
        }
        return this.fKE;
    }
}
