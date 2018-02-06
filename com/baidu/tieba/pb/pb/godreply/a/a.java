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
    private ViewGroup aHS;
    private View.OnClickListener bmd;
    private b fKx;
    private int bfL = 3;
    private final int[] fKw = new int[2];
    private int fKy = Integer.MIN_VALUE;
    private int fKz = Integer.MIN_VALUE;
    private boolean fKA = false;

    public void F(View.OnClickListener onClickListener) {
        this.bmd = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.aHS == null) {
                this.aHS = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.aHS != null) {
                view.getLocationOnScreen(this.fKw);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fKx == null) {
                    this.fKx = new b(context);
                }
                this.fKx.animate().cancel();
                this.fKx.setAlpha(0.0f);
                this.fKx.animate().alpha(1.0f).setListener(null).start();
                this.fKx.setOnClickListener(this.bmd);
                this.fKx.onChangeSkinType(this.bfL);
                if (this.fKx.getParent() != null && this.fKx.getParent() != this.aHS) {
                    ((ViewGroup) this.fKx.getParent()).removeView(this.fKx);
                }
                if (this.fKx.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = ca(context);
                    layoutParams.topMargin = this.fKw[1] + view.getHeight() + bZ(context);
                    layoutParams.addRule(11);
                    int childCount = this.aHS.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.aHS.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.aHS.getChildCount()) {
                        this.aHS.addView(this.fKx, i, layoutParams);
                    }
                }
                this.fKx.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fKx != null) {
            this.fKx.animate().cancel();
            this.fKx.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.1
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
        if (this.fKx != null && this.fKx.getParent() != null && this.fKx.getParent() == this.aHS) {
            this.fKx.setVisibility(4);
        }
    }

    public void co(View view) {
        if (bbK()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fKw);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKx.getLayoutParams();
            layoutParams.rightMargin = ca(context);
            layoutParams.topMargin = this.fKw[1] + view.getHeight() + bZ(context);
            layoutParams.addRule(11);
            this.fKx.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fKx.getHeight() < l.as(context)[1] && !this.fKA) {
                c.v(context, true);
                this.fKA = true;
                this.fKx.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean bbK() {
        return this.fKx != null && this.fKx.getParent() != null && this.fKx.getParent() == this.aHS && this.fKx.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.bfL = i;
        if (this.fKx != null) {
            this.fKx.onChangeSkinType(i);
        }
    }

    private int bZ(Context context) {
        if (this.fKy == Integer.MIN_VALUE) {
            this.fKy = -l.dip2px(context, 5.0f);
        }
        return this.fKy;
    }

    private int ca(Context context) {
        if (this.fKz == Integer.MIN_VALUE) {
            this.fKz = l.dip2px(context, 17.0f);
        }
        return this.fKz;
    }
}
