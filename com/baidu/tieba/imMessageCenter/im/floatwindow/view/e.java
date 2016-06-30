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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.imMessageCenter.im.floatwindow.j {
    private com.baidu.adp.lib.h.d cpk;
    private LinearLayout daR;
    private ImageView daS;
    private ScaleAnimation daT;
    private ScaleAnimation daU;
    private boolean daV;
    private boolean daW;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e daX;
    private Animation daY;
    private Animation daZ;
    private Runnable dba;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(u.h.im_chat_tip_view, (ViewGroup) null));
        this.daV = false;
        this.daW = false;
        this.dba = new f(this);
        this.cpk = new g(this);
        this.daS = (ImageView) this.dai.findViewById(u.g.im_chat_tip_view_delete);
        this.daR = (LinearLayout) this.dai.findViewById(u.g.im_chat_tip_holder);
        this.daX = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e asq() {
        if (this.daX.isEmpty()) {
            int[] iArr = new int[2];
            this.daS.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.daS.getMeasuredHeight() / 2) + 15;
                this.daX.F(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.daX;
    }

    public void b(Handler handler) {
        if (!asb()) {
            asc();
            if (handler != null) {
                handler.removeCallbacks(this.dba);
                handler.post(this.dba);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.dba);
        this.daS.clearAnimation();
        this.daW = false;
        this.daV = false;
        if (this.daR.getWindowToken() != null) {
            this.daR.clearAnimation();
            this.daR.startAnimation(asv());
            return;
        }
        asd();
    }

    public void asr() {
        if (!this.daW && !this.daV) {
            this.daV = true;
            this.daS.startAnimation(ast());
        }
    }

    public void ass() {
        if (!this.daW && this.daV) {
            this.daV = false;
            this.daS.startAnimation(asu());
        }
    }

    private ScaleAnimation ast() {
        if (this.daT == null) {
            this.daT = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.daT.setDuration(150L);
            this.daT.setFillAfter(true);
            this.daT.setAnimationListener(this.cpk);
        }
        return this.daT;
    }

    private ScaleAnimation asu() {
        if (this.daU == null) {
            this.daU = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.daU.setDuration(150L);
            this.daU.setFillAfter(true);
            this.daU.setAnimationListener(this.cpk);
        }
        return this.daU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation asp() {
        if (this.daY == null) {
            this.daY = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), u.a.float_window_tip_in_anim);
        }
        return this.daY;
    }

    private Animation asv() {
        if (this.daZ == null) {
            this.daZ = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), u.a.float_window_tip_out_anim);
            this.daZ.setAnimationListener(this.cpk);
        }
        return this.daZ;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams asa() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
