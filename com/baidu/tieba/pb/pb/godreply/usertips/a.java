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
    private View.OnClickListener aGU;
    private ViewGroup aaK;
    private GodReplyLeaderboardTipView fuM;
    private int azI = 3;
    private final int[] fuL = new int[2];
    private int fuN = Integer.MIN_VALUE;
    private int fuO = Integer.MIN_VALUE;
    private boolean fuP = false;

    public void H(View.OnClickListener onClickListener) {
        this.aGU = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.aaK == null) {
                this.aaK = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.aaK != null) {
                view.getLocationOnScreen(this.fuL);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fuM == null) {
                    this.fuM = new GodReplyLeaderboardTipView(context);
                }
                this.fuM.animate().cancel();
                this.fuM.setAlpha(0.0f);
                this.fuM.animate().alpha(1.0f).setListener(null).start();
                this.fuM.setOnClickListener(this.aGU);
                this.fuM.onChangeSkinType(this.azI);
                if (this.fuM.getParent() != null && this.fuM.getParent() != this.aaK) {
                    ((ViewGroup) this.fuM.getParent()).removeView(this.fuM);
                }
                if (this.fuM.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = bZ(context);
                    layoutParams.topMargin = this.fuL[1] + view.getHeight() + bY(context);
                    layoutParams.addRule(11);
                    int childCount = this.aaK.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.aaK.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.aaK.getChildCount()) {
                        this.aaK.addView(this.fuM, i, layoutParams);
                    }
                }
                this.fuM.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fuM != null) {
            this.fuM.animate().cancel();
            this.fuM.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.baC();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.baC();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baC() {
        if (this.fuM != null && this.fuM.getParent() != null && this.fuM.getParent() == this.aaK) {
            this.fuM.setVisibility(4);
        }
    }

    public void bb(View view) {
        if (baD()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fuL);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fuM.getLayoutParams();
            layoutParams.rightMargin = bZ(context);
            layoutParams.topMargin = this.fuL[1] + view.getHeight() + bY(context);
            layoutParams.addRule(11);
            this.fuM.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fuM.getHeight() < l.al(context)[1] && !this.fuP) {
                b.u(context, true);
                this.fuP = true;
                this.fuM.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean baD() {
        return this.fuM != null && this.fuM.getParent() != null && this.fuM.getParent() == this.aaK && this.fuM.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.azI = i;
        if (this.fuM != null) {
            this.fuM.onChangeSkinType(i);
        }
    }

    private int bY(Context context) {
        if (this.fuN == Integer.MIN_VALUE) {
            this.fuN = -l.dip2px(context, 5.0f);
        }
        return this.fuN;
    }

    private int bZ(Context context) {
        if (this.fuO == Integer.MIN_VALUE) {
            this.fuO = l.dip2px(context, 17.0f);
        }
        return this.fuO;
    }
}
