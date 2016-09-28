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
    private HeadImageView aVS;
    private TextView dqg;
    private RelativeLayout dre;
    private ImageView drf;
    private TranslateAnimation drg;
    private TranslateAnimation drh;
    private int dri;
    private FloatingPersonalChatView.a drl;
    private final int index;
    private boolean drj = false;
    private a drk = new i(this);
    private Point dqh = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void ayx();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.dre = relativeLayout;
        this.aVS = (HeadImageView) relativeLayout.findViewById(r.g.im_floating_head_view);
        this.dqg = (TextView) relativeLayout.findViewById(r.g.im_floating_unread_view);
        this.drf = (ImageView) relativeLayout.findViewById(r.g.im_floating_arrow);
        this.aVS.setAutoChangeStyle(false);
        this.aVS.setIsRound(true);
        this.aVS.setTag(Integer.valueOf(i));
        this.aVS.setOnLongClickListener(new j(this));
        this.aVS.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.drl = aVar;
    }

    public boolean d(Animation animation) {
        return this.drh == animation;
    }

    public void a(com.baidu.adp.lib.h.d dVar) {
        if (this.dre.getVisibility() == 0) {
            this.drg = new TranslateAnimation(ayu(), 0.0f, 0.0f, 0.0f);
            this.drg.setDuration(300L);
            if (dVar != null) {
                this.drg.setAnimationListener(dVar);
            }
            this.dre.startAnimation(this.drg);
        }
    }

    private int ayu() {
        int[] iArr = new int[2];
        this.dre.getLocationInWindow(iArr);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst());
        return ((K - iArr[0]) - this.dre.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.h.d dVar) {
        if (this.dre.getVisibility() == 0) {
            this.drh = new TranslateAnimation(0.0f, ayu(), 0.0f, 0.0f);
            this.drh.setDuration(300L);
            if (dVar != null) {
                this.drh.setAnimationListener(dVar);
            }
            this.dre.startAnimation(this.drh);
        }
    }

    public void ayv() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.dre.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.dre.startAnimation(translateAnimation);
    }

    public void ayw() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.dre.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.dre.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.dri = userData.getConcern_num();
            mj(userData.getConcern_num());
            this.aVS.c(userData.getPortrait(), 12, false);
            this.aVS.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.drf.setVisibility(0);
            } else {
                this.drf.setVisibility(8);
            }
            this.dre.setVisibility(0);
            return;
        }
        this.dre.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aVS.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(int i) {
        int i2;
        if (!this.drj) {
            if (i <= 0) {
                this.dqg.setVisibility(8);
                return;
            }
            this.dqg.setVisibility(0);
            if (i < 10) {
                this.dqg.setText(String.valueOf(i));
                i2 = r.f.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.dqg.setText(String.valueOf(i));
                i2 = r.f.icon_news_head_prompt_two;
            } else {
                this.dqg.setText("   ");
                i2 = r.f.icon_news_head_prompt_more;
            }
            this.dqg.setBackgroundResource(i2);
        }
    }
}
