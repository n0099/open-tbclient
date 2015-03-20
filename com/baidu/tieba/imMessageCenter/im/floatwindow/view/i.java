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
/* loaded from: classes.dex */
public class i {
    private HeadImageView azr;
    private TextView bqw;
    private ao brB;
    private RelativeLayout bru;
    private ImageView brv;
    private TranslateAnimation brw;
    private TranslateAnimation brx;
    private int bry;
    private final int index;
    private boolean brz = false;
    private m brA = new j(this);
    private Point bqx = new Point();

    public i(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.bru = relativeLayout;
        this.azr = (HeadImageView) relativeLayout.findViewById(com.baidu.tieba.v.im_floating_head_view);
        this.bqw = (TextView) relativeLayout.findViewById(com.baidu.tieba.v.im_floating_unread_view);
        this.brv = (ImageView) relativeLayout.findViewById(com.baidu.tieba.v.im_floating_arrow);
        this.azr.setAutoChangeStyle(false);
        this.azr.setIsRound(true);
        this.azr.setTag(Integer.valueOf(i));
        this.azr.setOnLongClickListener(new k(this));
        this.azr.setOnTouchListener(new l(this));
    }

    public void a(ao aoVar) {
        this.brB = aoVar;
    }

    public boolean d(Animation animation) {
        return this.brx == animation;
    }

    public void a(com.baidu.adp.lib.g.e eVar) {
        if (this.bru.getVisibility() == 0) {
            this.brw = new TranslateAnimation(UV(), 0.0f, 0.0f, 0.0f);
            this.brw.setDuration(300L);
            if (eVar != null) {
                this.brw.setAnimationListener(eVar);
            }
            this.bru.startAnimation(this.brw);
        }
    }

    private int UV() {
        int[] iArr = new int[2];
        this.bru.getLocationInWindow(iArr);
        int M = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst());
        return ((M - iArr[0]) - this.bru.getMeasuredWidth()) - com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.g.e eVar) {
        if (this.bru.getVisibility() == 0) {
            this.brx = new TranslateAnimation(0.0f, UV(), 0.0f, 0.0f);
            this.brx.setDuration(300L);
            if (eVar != null) {
                this.brx.setAnimationListener(eVar);
            }
            this.bru.startAnimation(this.brx);
        }
    }

    public void UW() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.bru.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bru.startAnimation(translateAnimation);
    }

    public void UX() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.bru.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.bru.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.bry = userData.getConcern_num();
            gv(userData.getConcern_num());
            this.azr.c(userData.getPortrait(), 12, false);
            this.azr.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.brv.setVisibility(0);
            } else {
                this.brv.setVisibility(8);
            }
            this.bru.setVisibility(0);
            return;
        }
        this.bru.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.azr.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gv(int i) {
        int i2;
        if (!this.brz) {
            if (i <= 0) {
                this.bqw.setVisibility(8);
                return;
            }
            this.bqw.setVisibility(0);
            if (i < 10) {
                this.bqw.setText(String.valueOf(i));
                i2 = com.baidu.tieba.u.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.bqw.setText(String.valueOf(i));
                i2 = com.baidu.tieba.u.icon_news_head_prompt_two;
            } else {
                this.bqw.setText("   ");
                i2 = com.baidu.tieba.u.icon_news_head_prompt_more;
            }
            this.bqw.setBackgroundResource(i2);
        }
    }
}
