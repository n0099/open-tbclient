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
    private ViewGroup aHH;
    private View.OnClickListener blQ;
    private b fKm;
    private int bfz = 3;
    private final int[] fKl = new int[2];
    private int fKn = Integer.MIN_VALUE;
    private int fKo = Integer.MIN_VALUE;
    private boolean fKp = false;

    public void F(View.OnClickListener onClickListener) {
        this.blQ = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.aHH == null) {
                this.aHH = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.aHH != null) {
                view.getLocationOnScreen(this.fKl);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fKm == null) {
                    this.fKm = new b(context);
                }
                this.fKm.animate().cancel();
                this.fKm.setAlpha(0.0f);
                this.fKm.animate().alpha(1.0f).setListener(null).start();
                this.fKm.setOnClickListener(this.blQ);
                this.fKm.onChangeSkinType(this.bfz);
                if (this.fKm.getParent() != null && this.fKm.getParent() != this.aHH) {
                    ((ViewGroup) this.fKm.getParent()).removeView(this.fKm);
                }
                if (this.fKm.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = ca(context);
                    layoutParams.topMargin = this.fKl[1] + view.getHeight() + bZ(context);
                    layoutParams.addRule(11);
                    int childCount = this.aHH.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.aHH.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.aHH.getChildCount()) {
                        this.aHH.addView(this.fKm, i, layoutParams);
                    }
                }
                this.fKm.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fKm != null) {
            this.fKm.animate().cancel();
            this.fKm.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bbI();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bbI();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbI() {
        if (this.fKm != null && this.fKm.getParent() != null && this.fKm.getParent() == this.aHH) {
            this.fKm.setVisibility(4);
        }
    }

    public void co(View view) {
        if (bbJ()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fKl);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKm.getLayoutParams();
            layoutParams.rightMargin = ca(context);
            layoutParams.topMargin = this.fKl[1] + view.getHeight() + bZ(context);
            layoutParams.addRule(11);
            this.fKm.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fKm.getHeight() < l.as(context)[1] && !this.fKp) {
                c.v(context, true);
                this.fKp = true;
                this.fKm.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean bbJ() {
        return this.fKm != null && this.fKm.getParent() != null && this.fKm.getParent() == this.aHH && this.fKm.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.bfz = i;
        if (this.fKm != null) {
            this.fKm.onChangeSkinType(i);
        }
    }

    private int bZ(Context context) {
        if (this.fKn == Integer.MIN_VALUE) {
            this.fKn = -l.dip2px(context, 5.0f);
        }
        return this.fKn;
    }

    private int ca(Context context) {
        if (this.fKo == Integer.MIN_VALUE) {
            this.fKo = l.dip2px(context, 17.0f);
        }
        return this.fKo;
    }
}
