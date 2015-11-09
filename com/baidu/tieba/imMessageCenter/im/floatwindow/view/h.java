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
    private HeadImageView aGQ;
    private TextView bLG;
    private RelativeLayout bMF;
    private ImageView bMG;
    private TranslateAnimation bMH;
    private TranslateAnimation bMI;
    private int bMJ;
    private FloatingPersonalChatView.a bMM;
    private final int index;
    private boolean bMK = false;
    private a bML = new i(this);
    private Point bLH = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void Zl();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.bMF = relativeLayout;
        this.aGQ = (HeadImageView) relativeLayout.findViewById(i.f.im_floating_head_view);
        this.bLG = (TextView) relativeLayout.findViewById(i.f.im_floating_unread_view);
        this.bMG = (ImageView) relativeLayout.findViewById(i.f.im_floating_arrow);
        this.aGQ.setAutoChangeStyle(false);
        this.aGQ.setIsRound(true);
        this.aGQ.setTag(Integer.valueOf(i));
        this.aGQ.setOnLongClickListener(new j(this));
        this.aGQ.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.bMM = aVar;
    }

    public boolean d(Animation animation) {
        return this.bMI == animation;
    }

    public void a(com.baidu.adp.lib.g.d dVar) {
        if (this.bMF.getVisibility() == 0) {
            this.bMH = new TranslateAnimation(Zi(), 0.0f, 0.0f, 0.0f);
            this.bMH.setDuration(300L);
            if (dVar != null) {
                this.bMH.setAnimationListener(dVar);
            }
            this.bMF.startAnimation(this.bMH);
        }
    }

    private int Zi() {
        int[] iArr = new int[2];
        this.bMF.getLocationInWindow(iArr);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst());
        return ((K - iArr[0]) - this.bMF.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.g.d dVar) {
        if (this.bMF.getVisibility() == 0) {
            this.bMI = new TranslateAnimation(0.0f, Zi(), 0.0f, 0.0f);
            this.bMI.setDuration(300L);
            if (dVar != null) {
                this.bMI.setAnimationListener(dVar);
            }
            this.bMF.startAnimation(this.bMI);
        }
    }

    public void Zj() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.bMF.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bMF.startAnimation(translateAnimation);
    }

    public void Zk() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.bMF.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bMF.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.bMJ = userData.getConcern_num();
            hV(userData.getConcern_num());
            this.aGQ.d(userData.getPortrait(), 12, false);
            this.aGQ.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.bMG.setVisibility(0);
            } else {
                this.bMG.setVisibility(8);
            }
            this.bMF.setVisibility(0);
            return;
        }
        this.bMF.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aGQ.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hV(int i) {
        int i2;
        if (!this.bMK) {
            if (i <= 0) {
                this.bLG.setVisibility(8);
                return;
            }
            this.bLG.setVisibility(0);
            if (i < 10) {
                this.bLG.setText(String.valueOf(i));
                i2 = i.e.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.bLG.setText(String.valueOf(i));
                i2 = i.e.icon_news_head_prompt_two;
            } else {
                this.bLG.setText("   ");
                i2 = i.e.icon_news_head_prompt_more;
            }
            this.bLG.setBackgroundResource(i2);
        }
    }
}
