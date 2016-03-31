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
    private LinearLayout cuD;
    private ImageView cuE;
    private ScaleAnimation cuF;
    private ScaleAnimation cuG;
    private boolean cuH;
    private boolean cuI;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e cuJ;
    private Animation cuK;
    private Animation cuL;
    private Runnable cuM;
    private com.baidu.adp.lib.h.d cuN;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(t.h.im_chat_tip_view, (ViewGroup) null));
        this.cuH = false;
        this.cuI = false;
        this.cuM = new f(this);
        this.cuN = new g(this);
        this.cuE = (ImageView) this.ctV.findViewById(t.g.im_chat_tip_view_delete);
        this.cuD = (LinearLayout) this.ctV.findViewById(t.g.im_chat_tip_holder);
        this.cuJ = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e ajU() {
        if (this.cuJ.isEmpty()) {
            int[] iArr = new int[2];
            this.cuE.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.cuE.getMeasuredHeight() / 2) + 15;
                this.cuJ.E(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.cuJ;
    }

    public void b(Handler handler) {
        if (!ajF()) {
            ajG();
            if (handler != null) {
                handler.removeCallbacks(this.cuM);
                handler.post(this.cuM);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.cuM);
        this.cuE.clearAnimation();
        this.cuI = false;
        this.cuH = false;
        if (this.cuD.getWindowToken() != null) {
            this.cuD.clearAnimation();
            this.cuD.startAnimation(ajZ());
            return;
        }
        ajH();
    }

    public void ajV() {
        if (!this.cuI && !this.cuH) {
            this.cuH = true;
            this.cuE.startAnimation(ajX());
        }
    }

    public void ajW() {
        if (!this.cuI && this.cuH) {
            this.cuH = false;
            this.cuE.startAnimation(ajY());
        }
    }

    private ScaleAnimation ajX() {
        if (this.cuF == null) {
            this.cuF = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.cuF.setDuration(150L);
            this.cuF.setFillAfter(true);
            this.cuF.setAnimationListener(this.cuN);
        }
        return this.cuF;
    }

    private ScaleAnimation ajY() {
        if (this.cuG == null) {
            this.cuG = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.cuG.setDuration(150L);
            this.cuG.setFillAfter(true);
            this.cuG.setAnimationListener(this.cuN);
        }
        return this.cuG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ajT() {
        if (this.cuK == null) {
            this.cuK = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), t.a.float_window_tip_in_anim);
        }
        return this.cuK;
    }

    private Animation ajZ() {
        if (this.cuL == null) {
            this.cuL = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), t.a.float_window_tip_out_anim);
            this.cuL.setAnimationListener(this.cuN);
        }
        return this.cuL;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams ajE() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
