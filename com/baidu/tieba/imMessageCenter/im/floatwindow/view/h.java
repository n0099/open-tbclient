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
    private HeadImageView aMs;
    private TextView cjk;
    private RelativeLayout ckj;
    private ImageView ckk;
    private TranslateAnimation ckl;
    private TranslateAnimation ckm;
    private int ckn;
    private FloatingPersonalChatView.a ckq;
    private final int index;
    private boolean cko = false;
    private a ckp = new i(this);
    private Point cjl = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void agJ();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.ckj = relativeLayout;
        this.aMs = (HeadImageView) relativeLayout.findViewById(t.g.im_floating_head_view);
        this.cjk = (TextView) relativeLayout.findViewById(t.g.im_floating_unread_view);
        this.ckk = (ImageView) relativeLayout.findViewById(t.g.im_floating_arrow);
        this.aMs.setAutoChangeStyle(false);
        this.aMs.setIsRound(true);
        this.aMs.setTag(Integer.valueOf(i));
        this.aMs.setOnLongClickListener(new j(this));
        this.aMs.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.ckq = aVar;
    }

    public boolean d(Animation animation) {
        return this.ckm == animation;
    }

    public void a(com.baidu.adp.lib.h.d dVar) {
        if (this.ckj.getVisibility() == 0) {
            this.ckl = new TranslateAnimation(agG(), 0.0f, 0.0f, 0.0f);
            this.ckl.setDuration(300L);
            if (dVar != null) {
                this.ckl.setAnimationListener(dVar);
            }
            this.ckj.startAnimation(this.ckl);
        }
    }

    private int agG() {
        int[] iArr = new int[2];
        this.ckj.getLocationInWindow(iArr);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst());
        return ((K - iArr[0]) - this.ckj.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.h.d dVar) {
        if (this.ckj.getVisibility() == 0) {
            this.ckm = new TranslateAnimation(0.0f, agG(), 0.0f, 0.0f);
            this.ckm.setDuration(300L);
            if (dVar != null) {
                this.ckm.setAnimationListener(dVar);
            }
            this.ckj.startAnimation(this.ckm);
        }
    }

    public void agH() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.ckj.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.ckj.startAnimation(translateAnimation);
    }

    public void agI() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.ckj.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.ckj.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.ckn = userData.getConcern_num();
            jG(userData.getConcern_num());
            this.aMs.d(userData.getPortrait(), 12, false);
            this.aMs.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.ckk.setVisibility(0);
            } else {
                this.ckk.setVisibility(8);
            }
            this.ckj.setVisibility(0);
            return;
        }
        this.ckj.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aMs.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jG(int i) {
        int i2;
        if (!this.cko) {
            if (i <= 0) {
                this.cjk.setVisibility(8);
                return;
            }
            this.cjk.setVisibility(0);
            if (i < 10) {
                this.cjk.setText(String.valueOf(i));
                i2 = t.f.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.cjk.setText(String.valueOf(i));
                i2 = t.f.icon_news_head_prompt_two;
            } else {
                this.cjk.setText("   ");
                i2 = t.f.icon_news_head_prompt_more;
            }
            this.cjk.setBackgroundResource(i2);
        }
    }
}
