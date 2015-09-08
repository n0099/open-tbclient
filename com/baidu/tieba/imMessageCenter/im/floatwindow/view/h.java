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
import com.baidu.tieba.i;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
/* loaded from: classes.dex */
public class h {
    private HeadImageView aIT;
    private TextView bHV;
    private RelativeLayout bIU;
    private ImageView bIV;
    private TranslateAnimation bIW;
    private TranslateAnimation bIX;
    private int bIY;
    private FloatingPersonalChatView.a bJb;
    private final int index;
    private boolean bIZ = false;
    private a bJa = new i(this);
    private Point bHW = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void Ym();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.bIU = relativeLayout;
        this.aIT = (HeadImageView) relativeLayout.findViewById(i.f.im_floating_head_view);
        this.bHV = (TextView) relativeLayout.findViewById(i.f.im_floating_unread_view);
        this.bIV = (ImageView) relativeLayout.findViewById(i.f.im_floating_arrow);
        this.aIT.setAutoChangeStyle(false);
        this.aIT.setIsRound(true);
        this.aIT.setTag(Integer.valueOf(i));
        this.aIT.setOnLongClickListener(new j(this));
        this.aIT.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.bJb = aVar;
    }

    public boolean d(Animation animation) {
        return this.bIX == animation;
    }

    public void a(com.baidu.adp.lib.g.d dVar) {
        if (this.bIU.getVisibility() == 0) {
            this.bIW = new TranslateAnimation(Yj(), 0.0f, 0.0f, 0.0f);
            this.bIW.setDuration(300L);
            if (dVar != null) {
                this.bIW.setAnimationListener(dVar);
            }
            this.bIU.startAnimation(this.bIW);
        }
    }

    private int Yj() {
        int[] iArr = new int[2];
        this.bIU.getLocationInWindow(iArr);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst());
        return ((K - iArr[0]) - this.bIU.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.g.d dVar) {
        if (this.bIU.getVisibility() == 0) {
            this.bIX = new TranslateAnimation(0.0f, Yj(), 0.0f, 0.0f);
            this.bIX.setDuration(300L);
            if (dVar != null) {
                this.bIX.setAnimationListener(dVar);
            }
            this.bIU.startAnimation(this.bIX);
        }
    }

    public void Yk() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.bIU.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bIU.startAnimation(translateAnimation);
    }

    public void Yl() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.bIU.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bIU.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.bIY = userData.getConcern_num();
            hC(userData.getConcern_num());
            this.aIT.d(userData.getPortrait(), 12, false);
            this.aIT.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.bIV.setVisibility(0);
            } else {
                this.bIV.setVisibility(8);
            }
            this.bIU.setVisibility(0);
            return;
        }
        this.bIU.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aIT.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC(int i) {
        int i2;
        if (!this.bIZ) {
            if (i <= 0) {
                this.bHV.setVisibility(8);
                return;
            }
            this.bHV.setVisibility(0);
            if (i < 10) {
                this.bHV.setText(String.valueOf(i));
                i2 = i.e.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.bHV.setText(String.valueOf(i));
                i2 = i.e.icon_news_head_prompt_two;
            } else {
                this.bHV.setText("   ");
                i2 = i.e.icon_news_head_prompt_more;
            }
            this.bHV.setBackgroundResource(i2);
        }
    }
}
