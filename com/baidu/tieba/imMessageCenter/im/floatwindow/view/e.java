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
    private com.baidu.adp.lib.h.d crF;
    private LinearLayout ddO;
    private ImageView ddP;
    private ScaleAnimation ddQ;
    private ScaleAnimation ddR;
    private boolean ddS;
    private boolean ddT;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e ddU;
    private Animation ddV;
    private Animation ddW;
    private Runnable ddX;

    public e(Context context) {
        super(LayoutInflater.from(context).inflate(u.h.im_chat_tip_view, (ViewGroup) null));
        this.ddS = false;
        this.ddT = false;
        this.ddX = new f(this);
        this.crF = new g(this);
        this.ddP = (ImageView) this.ddg.findViewById(u.g.im_chat_tip_view_delete);
        this.ddO = (LinearLayout) this.ddg.findViewById(u.g.im_chat_tip_holder);
        this.ddU = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e atc() {
        if (this.ddU.isEmpty()) {
            int[] iArr = new int[2];
            this.ddP.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.ddP.getMeasuredHeight() / 2) + 15;
                this.ddU.G(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.ddU;
    }

    public void b(Handler handler) {
        if (!asN()) {
            asO();
            if (handler != null) {
                handler.removeCallbacks(this.ddX);
                handler.post(this.ddX);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.ddX);
        this.ddP.clearAnimation();
        this.ddT = false;
        this.ddS = false;
        if (this.ddO.getWindowToken() != null) {
            this.ddO.clearAnimation();
            this.ddO.startAnimation(ath());
            return;
        }
        asP();
    }

    public void atd() {
        if (!this.ddT && !this.ddS) {
            this.ddS = true;
            this.ddP.startAnimation(atf());
        }
    }

    public void ate() {
        if (!this.ddT && this.ddS) {
            this.ddS = false;
            this.ddP.startAnimation(atg());
        }
    }

    private ScaleAnimation atf() {
        if (this.ddQ == null) {
            this.ddQ = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.ddQ.setDuration(150L);
            this.ddQ.setFillAfter(true);
            this.ddQ.setAnimationListener(this.crF);
        }
        return this.ddQ;
    }

    private ScaleAnimation atg() {
        if (this.ddR == null) {
            this.ddR = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.ddR.setDuration(150L);
            this.ddR.setFillAfter(true);
            this.ddR.setAnimationListener(this.crF);
        }
        return this.ddR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation atb() {
        if (this.ddV == null) {
            this.ddV = AnimationUtils.loadAnimation(TbadkCoreApplication.m10getInst(), u.a.float_window_tip_in_anim);
        }
        return this.ddV;
    }

    private Animation ath() {
        if (this.ddW == null) {
            this.ddW = AnimationUtils.loadAnimation(TbadkCoreApplication.m10getInst(), u.a.float_window_tip_out_anim);
            this.ddW.setAnimationListener(this.crF);
        }
        return this.ddW;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams asM() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
