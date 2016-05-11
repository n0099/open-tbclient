package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h {
    private HeadImageView aLx;
    private TextView cuN;
    private RelativeLayout cvM;
    private ImageView cvN;
    private TranslateAnimation cvO;
    private TranslateAnimation cvP;
    private int cvQ;
    private FloatingPersonalChatView.a cvT;
    private final int index;
    private boolean cvR = false;
    private a cvS = new i(this);
    private Point cuO = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void akj();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.cvM = relativeLayout;
        this.aLx = (HeadImageView) relativeLayout.findViewById(t.g.im_floating_head_view);
        this.cuN = (TextView) relativeLayout.findViewById(t.g.im_floating_unread_view);
        this.cvN = (ImageView) relativeLayout.findViewById(t.g.im_floating_arrow);
        this.aLx.setAutoChangeStyle(false);
        this.aLx.setIsRound(true);
        this.aLx.setTag(Integer.valueOf(i));
        this.aLx.setOnLongClickListener(new j(this));
        this.aLx.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.cvT = aVar;
    }

    public boolean d(Animation animation) {
        return this.cvP == animation;
    }

    public void a(com.baidu.adp.lib.h.d dVar) {
        if (this.cvM.getVisibility() == 0) {
            this.cvO = new TranslateAnimation(akg(), 0.0f, 0.0f, 0.0f);
            this.cvO.setDuration(300L);
            if (dVar != null) {
                this.cvO.setAnimationListener(dVar);
            }
            this.cvM.startAnimation(this.cvO);
        }
    }

    private int akg() {
        int[] iArr = new int[2];
        this.cvM.getLocationInWindow(iArr);
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m11getInst());
        return ((B - iArr[0]) - this.cvM.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m11getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.h.d dVar) {
        if (this.cvM.getVisibility() == 0) {
            this.cvP = new TranslateAnimation(0.0f, akg(), 0.0f, 0.0f);
            this.cvP.setDuration(300L);
            if (dVar != null) {
                this.cvP.setAnimationListener(dVar);
            }
            this.cvM.startAnimation(this.cvP);
        }
    }

    public void akh() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.cvM.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.cvM.startAnimation(translateAnimation);
    }

    public void aki() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.cvM.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.cvM.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.cvQ = userData.getConcern_num();
            jR(userData.getConcern_num());
            this.aLx.c(userData.getPortrait(), 12, false);
            this.aLx.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.cvN.setVisibility(0);
            } else {
                this.cvN.setVisibility(8);
            }
            this.cvM.setVisibility(0);
            return;
        }
        this.cvM.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aLx.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jR(int i) {
        int i2;
        if (!this.cvR) {
            if (i <= 0) {
                this.cuN.setVisibility(8);
                return;
            }
            this.cuN.setVisibility(0);
            if (i < 10) {
                this.cuN.setText(String.valueOf(i));
                i2 = t.f.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.cuN.setText(String.valueOf(i));
                i2 = t.f.icon_news_head_prompt_two;
            } else {
                this.cuN.setText("   ");
                i2 = t.f.icon_news_head_prompt_more;
            }
            this.cuN.setBackgroundResource(i2);
        }
    }
}
