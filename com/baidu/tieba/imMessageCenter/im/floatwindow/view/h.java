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
    private HeadImageView aVj;
    private TextView doI;
    private RelativeLayout dpH;
    private ImageView dpI;
    private TranslateAnimation dpJ;
    private TranslateAnimation dpK;
    private int dpL;
    private FloatingPersonalChatView.a dpO;
    private final int index;
    private boolean dpM = false;
    private a dpN = new i(this);
    private Point doJ = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void axZ();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.dpH = relativeLayout;
        this.aVj = (HeadImageView) relativeLayout.findViewById(t.g.im_floating_head_view);
        this.doI = (TextView) relativeLayout.findViewById(t.g.im_floating_unread_view);
        this.dpI = (ImageView) relativeLayout.findViewById(t.g.im_floating_arrow);
        this.aVj.setAutoChangeStyle(false);
        this.aVj.setIsRound(true);
        this.aVj.setTag(Integer.valueOf(i));
        this.aVj.setOnLongClickListener(new j(this));
        this.aVj.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.dpO = aVar;
    }

    public boolean d(Animation animation) {
        return this.dpK == animation;
    }

    public void a(com.baidu.adp.lib.h.d dVar) {
        if (this.dpH.getVisibility() == 0) {
            this.dpJ = new TranslateAnimation(axW(), 0.0f, 0.0f, 0.0f);
            this.dpJ.setDuration(300L);
            if (dVar != null) {
                this.dpJ.setAnimationListener(dVar);
            }
            this.dpH.startAnimation(this.dpJ);
        }
    }

    private int axW() {
        int[] iArr = new int[2];
        this.dpH.getLocationInWindow(iArr);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst());
        return ((K - iArr[0]) - this.dpH.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.h.d dVar) {
        if (this.dpH.getVisibility() == 0) {
            this.dpK = new TranslateAnimation(0.0f, axW(), 0.0f, 0.0f);
            this.dpK.setDuration(300L);
            if (dVar != null) {
                this.dpK.setAnimationListener(dVar);
            }
            this.dpH.startAnimation(this.dpK);
        }
    }

    public void axX() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.dpH.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.dpH.startAnimation(translateAnimation);
    }

    public void axY() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.dpH.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.dpH.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.dpL = userData.getConcern_num();
            mb(userData.getConcern_num());
            this.aVj.c(userData.getPortrait(), 12, false);
            this.aVj.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.dpI.setVisibility(0);
            } else {
                this.dpI.setVisibility(8);
            }
            this.dpH.setVisibility(0);
            return;
        }
        this.dpH.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aVj.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(int i) {
        int i2;
        if (!this.dpM) {
            if (i <= 0) {
                this.doI.setVisibility(8);
                return;
            }
            this.doI.setVisibility(0);
            if (i < 10) {
                this.doI.setText(String.valueOf(i));
                i2 = t.f.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.doI.setText(String.valueOf(i));
                i2 = t.f.icon_news_head_prompt_two;
            } else {
                this.doI.setText("   ");
                i2 = t.f.icon_news_head_prompt_more;
            }
            this.doI.setBackgroundResource(i2);
        }
    }
}
