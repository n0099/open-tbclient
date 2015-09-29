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
    private HeadImageView aHL;
    private RelativeLayout bLZ;
    private TextView bLa;
    private ImageView bMa;
    private TranslateAnimation bMb;
    private TranslateAnimation bMc;
    private int bMd;
    private FloatingPersonalChatView.a bMg;
    private final int index;
    private boolean bMe = false;
    private a bMf = new i(this);
    private Point bLb = new Point();

    /* loaded from: classes.dex */
    public interface a {
        void YU();
    }

    public h(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.bLZ = relativeLayout;
        this.aHL = (HeadImageView) relativeLayout.findViewById(i.f.im_floating_head_view);
        this.bLa = (TextView) relativeLayout.findViewById(i.f.im_floating_unread_view);
        this.bMa = (ImageView) relativeLayout.findViewById(i.f.im_floating_arrow);
        this.aHL.setAutoChangeStyle(false);
        this.aHL.setIsRound(true);
        this.aHL.setTag(Integer.valueOf(i));
        this.aHL.setOnLongClickListener(new j(this));
        this.aHL.setOnTouchListener(new k(this));
    }

    public void a(FloatingPersonalChatView.a aVar) {
        this.bMg = aVar;
    }

    public boolean d(Animation animation) {
        return this.bMc == animation;
    }

    public void a(com.baidu.adp.lib.g.d dVar) {
        if (this.bLZ.getVisibility() == 0) {
            this.bMb = new TranslateAnimation(YR(), 0.0f, 0.0f, 0.0f);
            this.bMb.setDuration(300L);
            if (dVar != null) {
                this.bMb.setAnimationListener(dVar);
            }
            this.bLZ.startAnimation(this.bMb);
        }
    }

    private int YR() {
        int[] iArr = new int[2];
        this.bLZ.getLocationInWindow(iArr);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst());
        return ((K - iArr[0]) - this.bLZ.getMeasuredWidth()) - com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.g.d dVar) {
        if (this.bLZ.getVisibility() == 0) {
            this.bMc = new TranslateAnimation(0.0f, YR(), 0.0f, 0.0f);
            this.bMc.setDuration(300L);
            if (dVar != null) {
                this.bMc.setAnimationListener(dVar);
            }
            this.bLZ.startAnimation(this.bMc);
        }
    }

    public void YS() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.bLZ.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bLZ.startAnimation(translateAnimation);
    }

    public void YT() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.bLZ.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bLZ.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.bMd = userData.getConcern_num();
            hI(userData.getConcern_num());
            this.aHL.d(userData.getPortrait(), 12, false);
            this.aHL.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.bMa.setVisibility(0);
            } else {
                this.bMa.setVisibility(8);
            }
            this.bLZ.setVisibility(0);
            return;
        }
        this.bLZ.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aHL.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(int i) {
        int i2;
        if (!this.bMe) {
            if (i <= 0) {
                this.bLa.setVisibility(8);
                return;
            }
            this.bLa.setVisibility(0);
            if (i < 10) {
                this.bLa.setText(String.valueOf(i));
                i2 = i.e.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.bLa.setText(String.valueOf(i));
                i2 = i.e.icon_news_head_prompt_two;
            } else {
                this.bLa.setText("   ");
                i2 = i.e.icon_news_head_prompt_more;
            }
            this.bLa.setBackgroundResource(i2);
        }
    }
}
