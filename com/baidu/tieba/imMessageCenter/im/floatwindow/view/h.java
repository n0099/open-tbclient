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
    private HeadImageView aOV;
    private TextView dac;
    private RelativeLayout dbc;
    private ImageView dbd;
    private TranslateAnimation dbe;
    private TranslateAnimation dbf;
    private int dbg;
    private FloatingPersonalChatView.a dbj;
    private final int index;
    private boolean dbh = false;
    private a dbi = new i(this);
    private Point dad = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void asz();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.dbc = relativeLayout;
        this.aOV = (HeadImageView) relativeLayout.findViewById(u.g.im_floating_head_view);
        this.dac = (TextView) relativeLayout.findViewById(u.g.im_floating_unread_view);
        this.dbd = (ImageView) relativeLayout.findViewById(u.g.im_floating_arrow);
        this.aOV.setAutoChangeStyle(false);
        this.aOV.setIsRound(true);
        this.aOV.setTag(Integer.valueOf(i));
        this.aOV.setOnLongClickListener(new j(this));
        this.aOV.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.dbj = aVar;
    }

    public boolean d(Animation animation) {
        return this.dbf == animation;
    }

    public void a(com.baidu.adp.lib.h.d dVar) {
        if (this.dbc.getVisibility() == 0) {
            this.dbe = new TranslateAnimation(asw(), 0.0f, 0.0f, 0.0f);
            this.dbe.setDuration(300L);
            if (dVar != null) {
                this.dbe.setAnimationListener(dVar);
            }
            this.dbc.startAnimation(this.dbe);
        }
    }

    private int asw() {
        int[] iArr = new int[2];
        this.dbc.getLocationInWindow(iArr);
        int A = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m9getInst());
        return ((A - iArr[0]) - this.dbc.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.h.d dVar) {
        if (this.dbc.getVisibility() == 0) {
            this.dbf = new TranslateAnimation(0.0f, asw(), 0.0f, 0.0f);
            this.dbf.setDuration(300L);
            if (dVar != null) {
                this.dbf.setAnimationListener(dVar);
            }
            this.dbc.startAnimation(this.dbf);
        }
    }

    public void asx() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.dbc.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.dbc.startAnimation(translateAnimation);
    }

    public void asy() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.dbc.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.dbc.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.dbg = userData.getConcern_num();
            ls(userData.getConcern_num());
            this.aOV.c(userData.getPortrait(), 12, false);
            this.aOV.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.dbd.setVisibility(0);
            } else {
                this.dbd.setVisibility(8);
            }
            this.dbc.setVisibility(0);
            return;
        }
        this.dbc.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aOV.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls(int i) {
        int i2;
        if (!this.dbh) {
            if (i <= 0) {
                this.dac.setVisibility(8);
                return;
            }
            this.dac.setVisibility(0);
            if (i < 10) {
                this.dac.setText(String.valueOf(i));
                i2 = u.f.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.dac.setText(String.valueOf(i));
                i2 = u.f.icon_news_head_prompt_two;
            } else {
                this.dac.setText("   ");
                i2 = u.f.icon_news_head_prompt_more;
            }
            this.dac.setBackgroundResource(i2);
        }
    }
}
