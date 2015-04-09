package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.imMessageCenter.im.floatwindow.o {
    private ScaleAnimation brA;
    private ScaleAnimation brB;
    private boolean brC;
    private boolean brD;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.j brE;
    private Animation brF;
    private Animation brG;
    private Runnable brH;
    private com.baidu.adp.lib.g.e brI;
    private LinearLayout brz;
    private ImageView deleteView;

    public f(Context context) {
        super(com.baidu.adp.lib.g.b.hH().inflate(context, com.baidu.tieba.w.im_chat_tip_view, null));
        this.brC = false;
        this.brD = false;
        this.brH = new g(this);
        this.brI = new h(this);
        this.deleteView = (ImageView) this.bqS.findViewById(com.baidu.tieba.v.im_chat_tip_view_delete);
        this.brz = (LinearLayout) this.bqS.findViewById(com.baidu.tieba.v.im_chat_tip_holder);
        this.brE = new com.baidu.tieba.imMessageCenter.im.floatwindow.j();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.j Vc() {
        if (this.brE.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.brE.u(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.brE;
    }

    public void b(Handler handler) {
        if (!UN()) {
            UO();
            if (handler != null) {
                handler.removeCallbacks(this.brH);
                handler.post(this.brH);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.brH);
        this.deleteView.clearAnimation();
        this.brD = false;
        this.brC = false;
        if (this.brz.getWindowToken() != null) {
            this.brz.clearAnimation();
            this.brz.startAnimation(Vh());
            return;
        }
        UP();
    }

    public void Vd() {
        if (!this.brD && !this.brC) {
            this.brC = true;
            this.deleteView.startAnimation(Vf());
        }
    }

    public void Ve() {
        if (!this.brD && this.brC) {
            this.brC = false;
            this.deleteView.startAnimation(Vg());
        }
    }

    private ScaleAnimation Vf() {
        if (this.brA == null) {
            this.brA = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.brA.setDuration(150L);
            this.brA.setFillAfter(true);
            this.brA.setAnimationListener(this.brI);
        }
        return this.brA;
    }

    private ScaleAnimation Vg() {
        if (this.brB == null) {
            this.brB = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.brB.setDuration(150L);
            this.brB.setFillAfter(true);
            this.brB.setAnimationListener(this.brI);
        }
        return this.brB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Vb() {
        if (this.brF == null) {
            this.brF = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), com.baidu.tieba.p.float_window_tip_in_anim);
        }
        return this.brF;
    }

    private Animation Vh() {
        if (this.brG == null) {
            this.brG = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), com.baidu.tieba.p.float_window_tip_out_anim);
            this.brG.setAnimationListener(this.brI);
        }
        return this.brG;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.o
    public WindowManager.LayoutParams UM() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
