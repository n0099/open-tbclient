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
    private HeadImageView aLn;
    private TextView ceL;
    private RelativeLayout cfJ;
    private ImageView cfK;
    private TranslateAnimation cfL;
    private TranslateAnimation cfM;
    private int cfN;
    private FloatingPersonalChatView.a cfQ;
    private final int index;
    private boolean cfO = false;
    private a cfP = new i(this);
    private Point ceM = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void adA();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.cfJ = relativeLayout;
        this.aLn = (HeadImageView) relativeLayout.findViewById(n.g.im_floating_head_view);
        this.ceL = (TextView) relativeLayout.findViewById(n.g.im_floating_unread_view);
        this.cfK = (ImageView) relativeLayout.findViewById(n.g.im_floating_arrow);
        this.aLn.setAutoChangeStyle(false);
        this.aLn.setIsRound(true);
        this.aLn.setTag(Integer.valueOf(i));
        this.aLn.setOnLongClickListener(new j(this));
        this.aLn.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.cfQ = aVar;
    }

    public boolean d(Animation animation) {
        return this.cfM == animation;
    }

    public void a(com.baidu.adp.lib.h.d dVar) {
        if (this.cfJ.getVisibility() == 0) {
            this.cfL = new TranslateAnimation(adx(), 0.0f, 0.0f, 0.0f);
            this.cfL.setDuration(300L);
            if (dVar != null) {
                this.cfL.setAnimationListener(dVar);
            }
            this.cfJ.startAnimation(this.cfL);
        }
    }

    private int adx() {
        int[] iArr = new int[2];
        this.cfJ.getLocationInWindow(iArr);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst());
        return ((K - iArr[0]) - this.cfJ.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.h.d dVar) {
        if (this.cfJ.getVisibility() == 0) {
            this.cfM = new TranslateAnimation(0.0f, adx(), 0.0f, 0.0f);
            this.cfM.setDuration(300L);
            if (dVar != null) {
                this.cfM.setAnimationListener(dVar);
            }
            this.cfJ.startAnimation(this.cfM);
        }
    }

    public void ady() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.cfJ.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.cfJ.startAnimation(translateAnimation);
    }

    public void adz() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.cfJ.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.cfJ.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.cfN = userData.getConcern_num();
            ji(userData.getConcern_num());
            this.aLn.d(userData.getPortrait(), 12, false);
            this.aLn.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.cfK.setVisibility(0);
            } else {
                this.cfK.setVisibility(8);
            }
            this.cfJ.setVisibility(0);
            return;
        }
        this.cfJ.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aLn.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji(int i) {
        int i2;
        if (!this.cfO) {
            if (i <= 0) {
                this.ceL.setVisibility(8);
                return;
            }
            this.ceL.setVisibility(0);
            if (i < 10) {
                this.ceL.setText(String.valueOf(i));
                i2 = n.f.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.ceL.setText(String.valueOf(i));
                i2 = n.f.icon_news_head_prompt_two;
            } else {
                this.ceL.setText("   ");
                i2 = n.f.icon_news_head_prompt_more;
            }
            this.ceL.setBackgroundResource(i2);
        }
    }
}
