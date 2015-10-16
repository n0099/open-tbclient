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
    private HeadImageView aHW;
    private TextView bLl;
    private RelativeLayout bMk;
    private ImageView bMl;
    private TranslateAnimation bMm;
    private TranslateAnimation bMn;
    private int bMo;
    private FloatingPersonalChatView.a bMr;
    private final int index;
    private boolean bMp = false;
    private a bMq = new i(this);
    private Point bLm = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void YU();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.bMk = relativeLayout;
        this.aHW = (HeadImageView) relativeLayout.findViewById(i.f.im_floating_head_view);
        this.bLl = (TextView) relativeLayout.findViewById(i.f.im_floating_unread_view);
        this.bMl = (ImageView) relativeLayout.findViewById(i.f.im_floating_arrow);
        this.aHW.setAutoChangeStyle(false);
        this.aHW.setIsRound(true);
        this.aHW.setTag(Integer.valueOf(i));
        this.aHW.setOnLongClickListener(new j(this));
        this.aHW.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.bMr = aVar;
    }

    public boolean d(Animation animation) {
        return this.bMn == animation;
    }

    public void a(com.baidu.adp.lib.g.d dVar) {
        if (this.bMk.getVisibility() == 0) {
            this.bMm = new TranslateAnimation(YR(), 0.0f, 0.0f, 0.0f);
            this.bMm.setDuration(300L);
            if (dVar != null) {
                this.bMm.setAnimationListener(dVar);
            }
            this.bMk.startAnimation(this.bMm);
        }
    }

    private int YR() {
        int[] iArr = new int[2];
        this.bMk.getLocationInWindow(iArr);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst());
        return ((K - iArr[0]) - this.bMk.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.g.d dVar) {
        if (this.bMk.getVisibility() == 0) {
            this.bMn = new TranslateAnimation(0.0f, YR(), 0.0f, 0.0f);
            this.bMn.setDuration(300L);
            if (dVar != null) {
                this.bMn.setAnimationListener(dVar);
            }
            this.bMk.startAnimation(this.bMn);
        }
    }

    public void YS() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.bMk.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bMk.startAnimation(translateAnimation);
    }

    public void YT() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.bMk.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bMk.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.bMo = userData.getConcern_num();
            hI(userData.getConcern_num());
            this.aHW.d(userData.getPortrait(), 12, false);
            this.aHW.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.bMl.setVisibility(0);
            } else {
                this.bMl.setVisibility(8);
            }
            this.bMk.setVisibility(0);
            return;
        }
        this.bMk.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aHW.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(int i) {
        int i2;
        if (!this.bMp) {
            if (i <= 0) {
                this.bLl.setVisibility(8);
                return;
            }
            this.bLl.setVisibility(0);
            if (i < 10) {
                this.bLl.setText(String.valueOf(i));
                i2 = i.e.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.bLl.setText(String.valueOf(i));
                i2 = i.e.icon_news_head_prompt_two;
            } else {
                this.bLl.setText("   ");
                i2 = i.e.icon_news_head_prompt_more;
            }
            this.bLl.setBackgroundResource(i2);
        }
    }
}
