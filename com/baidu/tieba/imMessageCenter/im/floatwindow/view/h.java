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
    private HeadImageView aIG;
    private TextView bHo;
    private RelativeLayout bIn;
    private ImageView bIo;
    private TranslateAnimation bIp;
    private TranslateAnimation bIq;
    private int bIr;
    private FloatingPersonalChatView.a bIu;
    private final int index;
    private boolean bIs = false;
    private a bIt = new i(this);
    private Point bHp = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void Yk();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.bIn = relativeLayout;
        this.aIG = (HeadImageView) relativeLayout.findViewById(i.f.im_floating_head_view);
        this.bHo = (TextView) relativeLayout.findViewById(i.f.im_floating_unread_view);
        this.bIo = (ImageView) relativeLayout.findViewById(i.f.im_floating_arrow);
        this.aIG.setAutoChangeStyle(false);
        this.aIG.setIsRound(true);
        this.aIG.setTag(Integer.valueOf(i));
        this.aIG.setOnLongClickListener(new j(this));
        this.aIG.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.bIu = aVar;
    }

    public boolean d(Animation animation) {
        return this.bIq == animation;
    }

    public void a(com.baidu.adp.lib.g.d dVar) {
        if (this.bIn.getVisibility() == 0) {
            this.bIp = new TranslateAnimation(Yh(), 0.0f, 0.0f, 0.0f);
            this.bIp.setDuration(300L);
            if (dVar != null) {
                this.bIp.setAnimationListener(dVar);
            }
            this.bIn.startAnimation(this.bIp);
        }
    }

    private int Yh() {
        int[] iArr = new int[2];
        this.bIn.getLocationInWindow(iArr);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst());
        return ((K - iArr[0]) - this.bIn.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.g.d dVar) {
        if (this.bIn.getVisibility() == 0) {
            this.bIq = new TranslateAnimation(0.0f, Yh(), 0.0f, 0.0f);
            this.bIq.setDuration(300L);
            if (dVar != null) {
                this.bIq.setAnimationListener(dVar);
            }
            this.bIn.startAnimation(this.bIq);
        }
    }

    public void Yi() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.bIn.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bIn.startAnimation(translateAnimation);
    }

    public void Yj() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.bIn.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bIn.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.bIr = userData.getConcern_num();
            hs(userData.getConcern_num());
            this.aIG.d(userData.getPortrait(), 12, false);
            this.aIG.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.bIo.setVisibility(0);
            } else {
                this.bIo.setVisibility(8);
            }
            this.bIn.setVisibility(0);
            return;
        }
        this.bIn.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aIG.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs(int i) {
        int i2;
        if (!this.bIs) {
            if (i <= 0) {
                this.bHo.setVisibility(8);
                return;
            }
            this.bHo.setVisibility(0);
            if (i < 10) {
                this.bHo.setText(String.valueOf(i));
                i2 = i.e.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.bHo.setText(String.valueOf(i));
                i2 = i.e.icon_news_head_prompt_two;
            } else {
                this.bHo.setText("   ");
                i2 = i.e.icon_news_head_prompt_more;
            }
            this.bHo.setBackgroundResource(i2);
        }
    }
}
