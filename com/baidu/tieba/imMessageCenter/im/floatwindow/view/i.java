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
    private HeadImageView aBl;
    private TextView btx;
    private TranslateAnimation buA;
    private int buB;
    private ao buE;
    private RelativeLayout bux;
    private ImageView buy;
    private TranslateAnimation buz;
    private final int index;
    private boolean buC = false;
    private m buD = new j(this);
    private Point bty = new Point();

    public i(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.bux = relativeLayout;
        this.aBl = (HeadImageView) relativeLayout.findViewById(com.baidu.tieba.q.im_floating_head_view);
        this.btx = (TextView) relativeLayout.findViewById(com.baidu.tieba.q.im_floating_unread_view);
        this.buy = (ImageView) relativeLayout.findViewById(com.baidu.tieba.q.im_floating_arrow);
        this.aBl.setAutoChangeStyle(false);
        this.aBl.setIsRound(true);
        this.aBl.setTag(Integer.valueOf(i));
        this.aBl.setOnLongClickListener(new k(this));
        this.aBl.setOnTouchListener(new l(this));
    }

    public void a(ao aoVar) {
        this.buE = aoVar;
    }

    public boolean d(Animation animation) {
        return this.buA == animation;
    }

    public void a(com.baidu.adp.lib.g.e eVar) {
        if (this.bux.getVisibility() == 0) {
            this.buz = new TranslateAnimation(WA(), 0.0f, 0.0f, 0.0f);
            this.buz.setDuration(300L);
            if (eVar != null) {
                this.buz.setAnimationListener(eVar);
            }
            this.bux.startAnimation(this.buz);
        }
    }

    private int WA() {
        int[] iArr = new int[2];
        this.bux.getLocationInWindow(iArr);
        int M = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst());
        return ((M - iArr[0]) - this.bux.getMeasuredWidth()) - com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.g.e eVar) {
        if (this.bux.getVisibility() == 0) {
            this.buA = new TranslateAnimation(0.0f, WA(), 0.0f, 0.0f);
            this.buA.setDuration(300L);
            if (eVar != null) {
                this.buA.setAnimationListener(eVar);
            }
            this.bux.startAnimation(this.buA);
        }
    }

    public void WB() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.bux.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bux.startAnimation(translateAnimation);
    }

    public void WC() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.bux.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bux.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.buB = userData.getConcern_num();
            gO(userData.getConcern_num());
            this.aBl.c(userData.getPortrait(), 12, false);
            this.aBl.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.buy.setVisibility(0);
            } else {
                this.buy.setVisibility(8);
            }
            this.bux.setVisibility(0);
            return;
        }
        this.bux.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aBl.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(int i) {
        int i2;
        if (!this.buC) {
            if (i <= 0) {
                this.btx.setVisibility(8);
                return;
            }
            this.btx.setVisibility(0);
            if (i < 10) {
                this.btx.setText(String.valueOf(i));
                i2 = com.baidu.tieba.p.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.btx.setText(String.valueOf(i));
                i2 = com.baidu.tieba.p.icon_news_head_prompt_two;
            } else {
                this.btx.setText("   ");
                i2 = com.baidu.tieba.p.icon_news_head_prompt_more;
            }
            this.btx.setBackgroundResource(i2);
        }
    }
}
