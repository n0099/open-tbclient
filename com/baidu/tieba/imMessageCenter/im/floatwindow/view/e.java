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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.imMessageCenter.im.floatwindow.j {
    private LinearLayout bIJ;
    private ScaleAnimation bIK;
    private ScaleAnimation bIL;
    private boolean bIM;
    private boolean bIN;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e bIO;
    private Animation bIP;
    private Animation bIQ;
    private Runnable bIR;
    private com.baidu.adp.lib.g.d bIS;
    private ImageView deleteView;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(i.g.im_chat_tip_view, (ViewGroup) null));
        this.bIM = false;
        this.bIN = false;
        this.bIR = new f(this);
        this.bIS = new g(this);
        this.deleteView = (ImageView) this.bIb.findViewById(i.f.im_chat_tip_view_delete);
        this.bIJ = (LinearLayout) this.bIb.findViewById(i.f.im_chat_tip_holder);
        this.bIO = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e Yd() {
        if (this.bIO.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.bIO.s(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.bIO;
    }

    public void b(Handler handler) {
        if (!XO()) {
            XP();
            if (handler != null) {
                handler.removeCallbacks(this.bIR);
                handler.post(this.bIR);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.bIR);
        this.deleteView.clearAnimation();
        this.bIN = false;
        this.bIM = false;
        if (this.bIJ.getWindowToken() != null) {
            this.bIJ.clearAnimation();
            this.bIJ.startAnimation(Yi());
            return;
        }
        XQ();
    }

    public void Ye() {
        if (!this.bIN && !this.bIM) {
            this.bIM = true;
            this.deleteView.startAnimation(Yg());
        }
    }

    public void Yf() {
        if (!this.bIN && this.bIM) {
            this.bIM = false;
            this.deleteView.startAnimation(Yh());
        }
    }

    private ScaleAnimation Yg() {
        if (this.bIK == null) {
            this.bIK = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.bIK.setDuration(150L);
            this.bIK.setFillAfter(true);
            this.bIK.setAnimationListener(this.bIS);
        }
        return this.bIK;
    }

    private ScaleAnimation Yh() {
        if (this.bIL == null) {
            this.bIL = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.bIL.setDuration(150L);
            this.bIL.setFillAfter(true);
            this.bIL.setAnimationListener(this.bIS);
        }
        return this.bIL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Yc() {
        if (this.bIP == null) {
            this.bIP = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_tip_in_anim);
        }
        return this.bIP;
    }

    private Animation Yi() {
        if (this.bIQ == null) {
            this.bIQ = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_tip_out_anim);
            this.bIQ.setAnimationListener(this.bIS);
        }
        return this.bIQ;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams XN() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
