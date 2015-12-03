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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class h {
    private HeadImageView aJP;
    private TextView caK;
    private RelativeLayout cbJ;
    private ImageView cbK;
    private TranslateAnimation cbL;
    private TranslateAnimation cbM;
    private int cbN;
    private FloatingPersonalChatView.a cbQ;
    private final int index;
    private boolean cbO = false;
    private a cbP = new i(this);
    private Point caL = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void acr();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.cbJ = relativeLayout;
        this.aJP = (HeadImageView) relativeLayout.findViewById(n.f.im_floating_head_view);
        this.caK = (TextView) relativeLayout.findViewById(n.f.im_floating_unread_view);
        this.cbK = (ImageView) relativeLayout.findViewById(n.f.im_floating_arrow);
        this.aJP.setAutoChangeStyle(false);
        this.aJP.setIsRound(true);
        this.aJP.setTag(Integer.valueOf(i));
        this.aJP.setOnLongClickListener(new j(this));
        this.aJP.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.cbQ = aVar;
    }

    public boolean d(Animation animation) {
        return this.cbM == animation;
    }

    public void a(com.baidu.adp.lib.h.d dVar) {
        if (this.cbJ.getVisibility() == 0) {
            this.cbL = new TranslateAnimation(aco(), 0.0f, 0.0f, 0.0f);
            this.cbL.setDuration(300L);
            if (dVar != null) {
                this.cbL.setAnimationListener(dVar);
            }
            this.cbJ.startAnimation(this.cbL);
        }
    }

    private int aco() {
        int[] iArr = new int[2];
        this.cbJ.getLocationInWindow(iArr);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst());
        return ((K - iArr[0]) - this.cbJ.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.h.d dVar) {
        if (this.cbJ.getVisibility() == 0) {
            this.cbM = new TranslateAnimation(0.0f, aco(), 0.0f, 0.0f);
            this.cbM.setDuration(300L);
            if (dVar != null) {
                this.cbM.setAnimationListener(dVar);
            }
            this.cbJ.startAnimation(this.cbM);
        }
    }

    public void acp() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.cbJ.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.cbJ.startAnimation(translateAnimation);
    }

    public void acq() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.cbJ.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.cbJ.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.cbN = userData.getConcern_num();
            iJ(userData.getConcern_num());
            this.aJP.d(userData.getPortrait(), 12, false);
            this.aJP.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.cbK.setVisibility(0);
            } else {
                this.cbK.setVisibility(8);
            }
            this.cbJ.setVisibility(0);
            return;
        }
        this.cbJ.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aJP.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iJ(int i) {
        int i2;
        if (!this.cbO) {
            if (i <= 0) {
                this.caK.setVisibility(8);
                return;
            }
            this.caK.setVisibility(0);
            if (i < 10) {
                this.caK.setText(String.valueOf(i));
                i2 = n.e.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.caK.setText(String.valueOf(i));
                i2 = n.e.icon_news_head_prompt_two;
            } else {
                this.caK.setText("   ");
                i2 = n.e.icon_news_head_prompt_more;
            }
            this.caK.setBackgroundResource(i2);
        }
    }
}
