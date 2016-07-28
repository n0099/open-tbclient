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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class h {
    private HeadImageView aPP;
    private RelativeLayout ddZ;
    private TextView dda;
    private ImageView dea;
    private TranslateAnimation deb;
    private TranslateAnimation dec;
    private int ded;
    private FloatingPersonalChatView.a deg;
    private final int index;
    private boolean dee = false;
    private a def = new i(this);
    private Point ddb = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void atl();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.ddZ = relativeLayout;
        this.aPP = (HeadImageView) relativeLayout.findViewById(u.g.im_floating_head_view);
        this.dda = (TextView) relativeLayout.findViewById(u.g.im_floating_unread_view);
        this.dea = (ImageView) relativeLayout.findViewById(u.g.im_floating_arrow);
        this.aPP.setAutoChangeStyle(false);
        this.aPP.setIsRound(true);
        this.aPP.setTag(Integer.valueOf(i));
        this.aPP.setOnLongClickListener(new j(this));
        this.aPP.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.deg = aVar;
    }

    public boolean d(Animation animation) {
        return this.dec == animation;
    }

    public void a(com.baidu.adp.lib.h.d dVar) {
        if (this.ddZ.getVisibility() == 0) {
            this.deb = new TranslateAnimation(ati(), 0.0f, 0.0f, 0.0f);
            this.deb.setDuration(300L);
            if (dVar != null) {
                this.deb.setAnimationListener(dVar);
            }
            this.ddZ.startAnimation(this.deb);
        }
    }

    private int ati() {
        int[] iArr = new int[2];
        this.ddZ.getLocationInWindow(iArr);
        int A = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m10getInst());
        return ((A - iArr[0]) - this.ddZ.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m10getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.h.d dVar) {
        if (this.ddZ.getVisibility() == 0) {
            this.dec = new TranslateAnimation(0.0f, ati(), 0.0f, 0.0f);
            this.dec.setDuration(300L);
            if (dVar != null) {
                this.dec.setAnimationListener(dVar);
            }
            this.ddZ.startAnimation(this.dec);
        }
    }

    public void atj() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.ddZ.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.ddZ.startAnimation(translateAnimation);
    }

    public void atk() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.ddZ.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.ddZ.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.ded = userData.getConcern_num();
            ly(userData.getConcern_num());
            this.aPP.c(userData.getPortrait(), 12, false);
            this.aPP.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.dea.setVisibility(0);
            } else {
                this.dea.setVisibility(8);
            }
            this.ddZ.setVisibility(0);
            return;
        }
        this.ddZ.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aPP.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly(int i) {
        int i2;
        if (!this.dee) {
            if (i <= 0) {
                this.dda.setVisibility(8);
                return;
            }
            this.dda.setVisibility(0);
            if (i < 10) {
                this.dda.setText(String.valueOf(i));
                i2 = u.f.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.dda.setText(String.valueOf(i));
                i2 = u.f.icon_news_head_prompt_two;
            } else {
                this.dda.setText("   ");
                i2 = u.f.icon_news_head_prompt_more;
            }
            this.dda.setBackgroundResource(i2);
        }
    }
}
