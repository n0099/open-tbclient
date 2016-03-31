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
    private HeadImageView aPn;
    private TextView ctP;
    private RelativeLayout cuP;
    private ImageView cuQ;
    private TranslateAnimation cuR;
    private TranslateAnimation cuS;
    private int cuT;
    private FloatingPersonalChatView.a cuW;
    private final int index;
    private boolean cuU = false;
    private a cuV = new i(this);
    private Point ctQ = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void akd();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.cuP = relativeLayout;
        this.aPn = (HeadImageView) relativeLayout.findViewById(t.g.im_floating_head_view);
        this.ctP = (TextView) relativeLayout.findViewById(t.g.im_floating_unread_view);
        this.cuQ = (ImageView) relativeLayout.findViewById(t.g.im_floating_arrow);
        this.aPn.setAutoChangeStyle(false);
        this.aPn.setIsRound(true);
        this.aPn.setTag(Integer.valueOf(i));
        this.aPn.setOnLongClickListener(new j(this));
        this.aPn.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.cuW = aVar;
    }

    public boolean d(Animation animation) {
        return this.cuS == animation;
    }

    public void a(com.baidu.adp.lib.h.d dVar) {
        if (this.cuP.getVisibility() == 0) {
            this.cuR = new TranslateAnimation(aka(), 0.0f, 0.0f, 0.0f);
            this.cuR.setDuration(300L);
            if (dVar != null) {
                this.cuR.setAnimationListener(dVar);
            }
            this.cuP.startAnimation(this.cuR);
        }
    }

    private int aka() {
        int[] iArr = new int[2];
        this.cuP.getLocationInWindow(iArr);
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m411getInst());
        return ((B - iArr[0]) - this.cuP.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.h.d dVar) {
        if (this.cuP.getVisibility() == 0) {
            this.cuS = new TranslateAnimation(0.0f, aka(), 0.0f, 0.0f);
            this.cuS.setDuration(300L);
            if (dVar != null) {
                this.cuS.setAnimationListener(dVar);
            }
            this.cuP.startAnimation(this.cuS);
        }
    }

    public void akb() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.cuP.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.cuP.startAnimation(translateAnimation);
    }

    public void akc() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.cuP.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.cuP.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.cuT = userData.getConcern_num();
            km(userData.getConcern_num());
            this.aPn.c(userData.getPortrait(), 12, false);
            this.aPn.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.cuQ.setVisibility(0);
            } else {
                this.cuQ.setVisibility(8);
            }
            this.cuP.setVisibility(0);
            return;
        }
        this.cuP.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aPn.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(int i) {
        int i2;
        if (!this.cuU) {
            if (i <= 0) {
                this.ctP.setVisibility(8);
                return;
            }
            this.ctP.setVisibility(0);
            if (i < 10) {
                this.ctP.setText(String.valueOf(i));
                i2 = t.f.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.ctP.setText(String.valueOf(i));
                i2 = t.f.icon_news_head_prompt_two;
            } else {
                this.ctP.setText("   ");
                i2 = t.f.icon_news_head_prompt_more;
            }
            this.ctP.setBackgroundResource(i2);
        }
    }
}
