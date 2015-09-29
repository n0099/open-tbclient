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
    private LinearLayout bLO;
    private ScaleAnimation bLP;
    private ScaleAnimation bLQ;
    private boolean bLR;
    private boolean bLS;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e bLT;
    private Animation bLU;
    private Animation bLV;
    private Runnable bLW;
    private com.baidu.adp.lib.g.d bLX;
    private ImageView deleteView;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(i.g.im_chat_tip_view, (ViewGroup) null));
        this.bLR = false;
        this.bLS = false;
        this.bLW = new f(this);
        this.bLX = new g(this);
        this.deleteView = (ImageView) this.bLg.findViewById(i.f.im_chat_tip_view_delete);
        this.bLO = (LinearLayout) this.bLg.findViewById(i.f.im_chat_tip_holder);
        this.bLT = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e YL() {
        if (this.bLT.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.bLT.t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.bLT;
    }

    public void b(Handler handler) {
        if (!Yw()) {
            Yx();
            if (handler != null) {
                handler.removeCallbacks(this.bLW);
                handler.post(this.bLW);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.bLW);
        this.deleteView.clearAnimation();
        this.bLS = false;
        this.bLR = false;
        if (this.bLO.getWindowToken() != null) {
            this.bLO.clearAnimation();
            this.bLO.startAnimation(YQ());
            return;
        }
        Yy();
    }

    public void YM() {
        if (!this.bLS && !this.bLR) {
            this.bLR = true;
            this.deleteView.startAnimation(YO());
        }
    }

    public void YN() {
        if (!this.bLS && this.bLR) {
            this.bLR = false;
            this.deleteView.startAnimation(YP());
        }
    }

    private ScaleAnimation YO() {
        if (this.bLP == null) {
            this.bLP = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.bLP.setDuration(150L);
            this.bLP.setFillAfter(true);
            this.bLP.setAnimationListener(this.bLX);
        }
        return this.bLP;
    }

    private ScaleAnimation YP() {
        if (this.bLQ == null) {
            this.bLQ = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.bLQ.setDuration(150L);
            this.bLQ.setFillAfter(true);
            this.bLQ.setAnimationListener(this.bLX);
        }
        return this.bLQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation YK() {
        if (this.bLU == null) {
            this.bLU = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_tip_in_anim);
        }
        return this.bLU;
    }

    private Animation YQ() {
        if (this.bLV == null) {
            this.bLV = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_tip_out_anim);
            this.bLV.setAnimationListener(this.bLX);
        }
        return this.bLV;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams Yv() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
