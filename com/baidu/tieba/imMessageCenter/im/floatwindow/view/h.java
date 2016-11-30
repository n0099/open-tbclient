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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h {
    private HeadImageView aYe;
    private TextView dvN;
    private RelativeLayout dwL;
    private ImageView dwM;
    private TranslateAnimation dwN;
    private TranslateAnimation dwO;
    private int dwP;
    private FloatingPersonalChatView.a dwS;
    private final int index;
    private boolean dwQ = false;
    private a dwR = new i(this);
    private Point dvO = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void aAu();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.dwL = relativeLayout;
        this.aYe = (HeadImageView) relativeLayout.findViewById(r.g.im_floating_head_view);
        this.dvN = (TextView) relativeLayout.findViewById(r.g.im_floating_unread_view);
        this.dwM = (ImageView) relativeLayout.findViewById(r.g.im_floating_arrow);
        this.aYe.setAutoChangeStyle(false);
        this.aYe.setIsRound(true);
        this.aYe.setTag(Integer.valueOf(i));
        this.aYe.setOnLongClickListener(new j(this));
        this.aYe.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.dwS = aVar;
    }

    public boolean d(Animation animation) {
        return this.dwO == animation;
    }

    public void a(com.baidu.adp.lib.h.d dVar) {
        if (this.dwL.getVisibility() == 0) {
            this.dwN = new TranslateAnimation(aAr(), 0.0f, 0.0f, 0.0f);
            this.dwN.setDuration(300L);
            if (dVar != null) {
                this.dwN.setAnimationListener(dVar);
            }
            this.dwL.startAnimation(this.dwN);
        }
    }

    private int aAr() {
        int[] iArr = new int[2];
        this.dwL.getLocationInWindow(iArr);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst());
        return ((K - iArr[0]) - this.dwL.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.h.d dVar) {
        if (this.dwL.getVisibility() == 0) {
            this.dwO = new TranslateAnimation(0.0f, aAr(), 0.0f, 0.0f);
            this.dwO.setDuration(300L);
            if (dVar != null) {
                this.dwO.setAnimationListener(dVar);
            }
            this.dwL.startAnimation(this.dwO);
        }
    }

    public void aAs() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.dwL.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.dwL.startAnimation(translateAnimation);
    }

    public void aAt() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.dwL.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.dwL.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.dwP = userData.getConcern_num();
            mr(userData.getConcern_num());
            this.aYe.c(userData.getPortrait(), 12, false);
            this.aYe.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.dwM.setVisibility(0);
            } else {
                this.dwM.setVisibility(8);
            }
            this.dwL.setVisibility(0);
            return;
        }
        this.dwL.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYe.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(int i) {
        int i2;
        if (!this.dwQ) {
            if (i <= 0) {
                this.dvN.setVisibility(8);
                return;
            }
            this.dvN.setVisibility(0);
            if (i < 10) {
                this.dvN.setText(String.valueOf(i));
                i2 = r.f.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.dvN.setText(String.valueOf(i));
                i2 = r.f.icon_news_head_prompt_two;
            } else {
                this.dvN.setText("   ");
                i2 = r.f.icon_news_head_prompt_more;
            }
            this.dvN.setBackgroundResource(i2);
        }
    }
}
