package com.baidu.tieba.pb.pb.godreply.usertips;

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
    private ViewGroup SW;
    private View.OnClickListener axH;
    private GodReplyLeaderboardTipView ffl;
    private int aqQ = 3;
    private final int[] ffk = new int[2];
    private int ffm = Integer.MIN_VALUE;
    private int ffn = Integer.MIN_VALUE;
    private boolean ffo = false;

    public void G(View.OnClickListener onClickListener) {
        this.axH = onClickListener;
    }

    public void showTip(View view2) {
        Context context;
        if (view2 != null && (context = view2.getContext()) != null && (context instanceof Activity)) {
            if (this.SW == null) {
                this.SW = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.SW != null) {
                view2.getLocationOnScreen(this.ffk);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.ffl == null) {
                    this.ffl = new GodReplyLeaderboardTipView(context);
                }
                this.ffl.animate().cancel();
                this.ffl.setAlpha(0.0f);
                this.ffl.animate().alpha(1.0f).setListener(null).start();
                this.ffl.setOnClickListener(this.axH);
                this.ffl.onChangeSkinType(this.aqQ);
                if (this.ffl.getParent() != null && this.ffl.getParent() != this.SW) {
                    ((ViewGroup) this.ffl.getParent()).removeView(this.ffl);
                }
                if (this.ffl.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = bO(context);
                    layoutParams.topMargin = this.ffk[1] + view2.getHeight() + bN(context);
                    layoutParams.addRule(11);
                    int childCount = this.SW.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.SW.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.SW.getChildCount()) {
                        this.SW.addView(this.ffl, i, layoutParams);
                    }
                }
                this.ffl.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.ffl != null) {
            this.ffl.animate().cancel();
            this.ffl.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.aWG();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.aWG();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWG() {
        if (this.ffl != null && this.ffl.getParent() != null && this.ffl.getParent() == this.SW) {
            this.ffl.setVisibility(4);
        }
    }

    public void aU(View view2) {
        if (aWH()) {
            Context context = view2.getContext();
            view2.getLocationOnScreen(this.ffk);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ffl.getLayoutParams();
            layoutParams.rightMargin = bO(context);
            layoutParams.topMargin = this.ffk[1] + view2.getHeight() + bN(context);
            layoutParams.addRule(11);
            this.ffl.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.ffl.getHeight() < l.aj(context)[1] && !this.ffo) {
                b.u(context, true);
                this.ffo = true;
                this.ffl.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean aWH() {
        return this.ffl != null && this.ffl.getParent() != null && this.ffl.getParent() == this.SW && this.ffl.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.aqQ = i;
        if (this.ffl != null) {
            this.ffl.onChangeSkinType(i);
        }
    }

    private int bN(Context context) {
        if (this.ffm == Integer.MIN_VALUE) {
            this.ffm = -l.dip2px(context, 5.0f);
        }
        return this.ffm;
    }

    private int bO(Context context) {
        if (this.ffn == Integer.MIN_VALUE) {
            this.ffn = l.dip2px(context, 17.0f);
        }
        return this.ffn;
    }
}
