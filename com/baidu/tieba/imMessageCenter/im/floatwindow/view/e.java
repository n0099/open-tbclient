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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.imMessageCenter.im.floatwindow.j {
    private LinearLayout cvA;
    private ImageView cvB;
    private ScaleAnimation cvC;
    private ScaleAnimation cvD;
    private boolean cvE;
    private boolean cvF;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e cvG;
    private Animation cvH;
    private Animation cvI;
    private Runnable cvJ;
    private com.baidu.adp.lib.h.d cvK;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(t.h.im_chat_tip_view, (ViewGroup) null));
        this.cvE = false;
        this.cvF = false;
        this.cvJ = new f(this);
        this.cvK = new g(this);
        this.cvB = (ImageView) this.cuT.findViewById(t.g.im_chat_tip_view_delete);
        this.cvA = (LinearLayout) this.cuT.findViewById(t.g.im_chat_tip_holder);
        this.cvG = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e aka() {
        if (this.cvG.isEmpty()) {
            int[] iArr = new int[2];
            this.cvB.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.cvB.getMeasuredHeight() / 2) + 15;
                this.cvG.D(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.cvG;
    }

    public void b(Handler handler) {
        if (!ajL()) {
            ajM();
            if (handler != null) {
                handler.removeCallbacks(this.cvJ);
                handler.post(this.cvJ);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.cvJ);
        this.cvB.clearAnimation();
        this.cvF = false;
        this.cvE = false;
        if (this.cvA.getWindowToken() != null) {
            this.cvA.clearAnimation();
            this.cvA.startAnimation(akf());
            return;
        }
        ajN();
    }

    public void akb() {
        if (!this.cvF && !this.cvE) {
            this.cvE = true;
            this.cvB.startAnimation(akd());
        }
    }

    public void akc() {
        if (!this.cvF && this.cvE) {
            this.cvE = false;
            this.cvB.startAnimation(ake());
        }
    }

    private ScaleAnimation akd() {
        if (this.cvC == null) {
            this.cvC = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.cvC.setDuration(150L);
            this.cvC.setFillAfter(true);
            this.cvC.setAnimationListener(this.cvK);
        }
        return this.cvC;
    }

    private ScaleAnimation ake() {
        if (this.cvD == null) {
            this.cvD = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.cvD.setDuration(150L);
            this.cvD.setFillAfter(true);
            this.cvD.setAnimationListener(this.cvK);
        }
        return this.cvD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ajZ() {
        if (this.cvH == null) {
            this.cvH = AnimationUtils.loadAnimation(TbadkCoreApplication.m11getInst(), t.a.float_window_tip_in_anim);
        }
        return this.cvH;
    }

    private Animation akf() {
        if (this.cvI == null) {
            this.cvI = AnimationUtils.loadAnimation(TbadkCoreApplication.m11getInst(), t.a.float_window_tip_out_anim);
            this.cvI.setAnimationListener(this.cvK);
        }
        return this.cvI;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams ajK() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
