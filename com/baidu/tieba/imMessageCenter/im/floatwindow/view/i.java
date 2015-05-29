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
/* loaded from: classes.dex */
public class i {
    private HeadImageView aBk;
    private TextView btw;
    private int buA;
    private ao buD;
    private RelativeLayout buw;
    private ImageView bux;
    private TranslateAnimation buy;
    private TranslateAnimation buz;
    private final int index;
    private boolean buB = false;
    private m buC = new j(this);
    private Point btx = new Point();

    public i(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.buw = relativeLayout;
        this.aBk = (HeadImageView) relativeLayout.findViewById(com.baidu.tieba.q.im_floating_head_view);
        this.btw = (TextView) relativeLayout.findViewById(com.baidu.tieba.q.im_floating_unread_view);
        this.bux = (ImageView) relativeLayout.findViewById(com.baidu.tieba.q.im_floating_arrow);
        this.aBk.setAutoChangeStyle(false);
        this.aBk.setIsRound(true);
        this.aBk.setTag(Integer.valueOf(i));
        this.aBk.setOnLongClickListener(new k(this));
        this.aBk.setOnTouchListener(new l(this));
    }

    public void a(ao aoVar) {
        this.buD = aoVar;
    }

    public boolean d(Animation animation) {
        return this.buz == animation;
    }

    public void a(com.baidu.adp.lib.g.e eVar) {
        if (this.buw.getVisibility() == 0) {
            this.buy = new TranslateAnimation(Wz(), 0.0f, 0.0f, 0.0f);
            this.buy.setDuration(300L);
            if (eVar != null) {
                this.buy.setAnimationListener(eVar);
            }
            this.buw.startAnimation(this.buy);
        }
    }

    private int Wz() {
        int[] iArr = new int[2];
        this.buw.getLocationInWindow(iArr);
        int M = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst());
        return ((M - iArr[0]) - this.buw.getMeasuredWidth()) - com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.g.e eVar) {
        if (this.buw.getVisibility() == 0) {
            this.buz = new TranslateAnimation(0.0f, Wz(), 0.0f, 0.0f);
            this.buz.setDuration(300L);
            if (eVar != null) {
                this.buz.setAnimationListener(eVar);
            }
            this.buw.startAnimation(this.buz);
        }
    }

    public void WA() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.buw.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.buw.startAnimation(translateAnimation);
    }

    public void WB() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.buw.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.buw.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.buA = userData.getConcern_num();
            gO(userData.getConcern_num());
            this.aBk.c(userData.getPortrait(), 12, false);
            this.aBk.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.bux.setVisibility(0);
            } else {
                this.bux.setVisibility(8);
            }
            this.buw.setVisibility(0);
            return;
        }
        this.buw.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aBk.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(int i) {
        int i2;
        if (!this.buB) {
            if (i <= 0) {
                this.btw.setVisibility(8);
                return;
            }
            this.btw.setVisibility(0);
            if (i < 10) {
                this.btw.setText(String.valueOf(i));
                i2 = com.baidu.tieba.p.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.btw.setText(String.valueOf(i));
                i2 = com.baidu.tieba.p.icon_news_head_prompt_two;
            } else {
                this.btw.setText("   ");
                i2 = com.baidu.tieba.p.icon_news_head_prompt_more;
            }
            this.btw.setBackgroundResource(i2);
        }
    }
}
