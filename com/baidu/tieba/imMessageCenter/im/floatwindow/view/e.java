package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.imMessageCenter.im.floatwindow.j {
    private com.baidu.adp.lib.h.d cDs;
    private LinearLayout dqT;
    private ImageView dqU;
    private ScaleAnimation dqV;
    private ScaleAnimation dqW;
    private boolean dqX;
    private boolean dqY;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e dqZ;
    private Animation dra;
    private Animation drb;
    private Runnable drc;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(r.h.im_chat_tip_view, (ViewGroup) null));
        this.dqX = false;
        this.dqY = false;
        this.drc = new f(this);
        this.cDs = new g(this);
        this.dqU = (ImageView) this.dqm.findViewById(r.g.im_chat_tip_view_delete);
        this.dqT = (LinearLayout) this.dqm.findViewById(r.g.im_chat_tip_holder);
        this.dqZ = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e ayo() {
        if (this.dqZ.isEmpty()) {
            int[] iArr = new int[2];
            this.dqU.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.dqU.getMeasuredHeight() / 2) + 15;
                this.dqZ.J(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.dqZ;
    }

    public void b(Handler handler) {
        if (!aya()) {
            ayb();
            if (handler != null) {
                handler.removeCallbacks(this.drc);
                handler.post(this.drc);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.drc);
        this.dqU.clearAnimation();
        this.dqY = false;
        this.dqX = false;
        if (this.dqT.getWindowToken() != null) {
            this.dqT.clearAnimation();
            this.dqT.startAnimation(ayt());
            return;
        }
        ayc();
    }

    public void ayp() {
        if (!this.dqY && !this.dqX) {
            this.dqX = true;
            this.dqU.startAnimation(ayr());
        }
    }

    public void ayq() {
        if (!this.dqY && this.dqX) {
            this.dqX = false;
            this.dqU.startAnimation(ays());
        }
    }

    private ScaleAnimation ayr() {
        if (this.dqV == null) {
            this.dqV = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.dqV.setDuration(150L);
            this.dqV.setFillAfter(true);
            this.dqV.setAnimationListener(this.cDs);
        }
        return this.dqV;
    }

    private ScaleAnimation ays() {
        if (this.dqW == null) {
            this.dqW = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.dqW.setDuration(150L);
            this.dqW.setFillAfter(true);
            this.dqW.setAnimationListener(this.cDs);
        }
        return this.dqW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ayn() {
        if (this.dra == null) {
            this.dra = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), r.a.float_window_tip_in_anim);
        }
        return this.dra;
    }

    private Animation ayt() {
        if (this.drb == null) {
            this.drb = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), r.a.float_window_tip_out_anim);
            this.drb.setAnimationListener(this.cDs);
        }
        return this.drb;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams axZ() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
