package com.baidu.tieba.pb.pb.godreply.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    private ViewGroup RT;
    private View.OnClickListener avn;
    private b eSz;
    private int apD = 3;
    private final int[] eSy = new int[2];
    private int eSA = ExploreByTouchHelper.INVALID_ID;
    private int eSB = ExploreByTouchHelper.INVALID_ID;
    private boolean eSC = false;

    public void E(View.OnClickListener onClickListener) {
        this.avn = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.RT == null) {
                this.RT = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.RT != null) {
                view.getLocationOnScreen(this.eSy);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.eSz == null) {
                    this.eSz = new b(context);
                }
                this.eSz.animate().cancel();
                this.eSz.setAlpha(0.0f);
                this.eSz.animate().alpha(1.0f).setListener(null).start();
                this.eSz.setOnClickListener(this.avn);
                this.eSz.onChangeSkinType(this.apD);
                if (this.eSz.getParent() != null && this.eSz.getParent() != this.RT) {
                    ((ViewGroup) this.eSz.getParent()).removeView(this.eSz);
                }
                if (this.eSz.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = bO(context);
                    layoutParams.topMargin = this.eSy[1] + view.getHeight() + bN(context);
                    layoutParams.addRule(11);
                    int childCount = this.RT.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.RT.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.RT.getChildCount()) {
                        this.RT.addView(this.eSz, i, layoutParams);
                    }
                }
                this.eSz.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.eSz != null) {
            this.eSz.animate().cancel();
            this.eSz.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.aSH();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.aSH();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSH() {
        if (this.eSz != null && this.eSz.getParent() != null && this.eSz.getParent() == this.RT) {
            this.eSz.setVisibility(4);
        }
    }

    public void bb(View view) {
        if (aSI()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.eSy);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSz.getLayoutParams();
            layoutParams.rightMargin = bO(context);
            layoutParams.topMargin = this.eSy[1] + view.getHeight() + bN(context);
            layoutParams.addRule(11);
            this.eSz.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.eSz.getHeight() < l.ag(context)[1] && !this.eSC) {
                c.t(context, true);
                this.eSC = true;
                this.eSz.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean aSI() {
        return this.eSz != null && this.eSz.getParent() != null && this.eSz.getParent() == this.RT && this.eSz.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.apD = i;
        if (this.eSz != null) {
            this.eSz.onChangeSkinType(i);
        }
    }

    private int bN(Context context) {
        if (this.eSA == Integer.MIN_VALUE) {
            this.eSA = -l.dip2px(context, 5.0f);
        }
        return this.eSA;
    }

    private int bO(Context context) {
        if (this.eSB == Integer.MIN_VALUE) {
            this.eSB = l.dip2px(context, 17.0f);
        }
        return this.eSB;
    }
}
