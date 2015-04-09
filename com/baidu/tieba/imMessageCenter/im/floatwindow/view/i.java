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
    private HeadImageView azz;
    private TextView bqM;
    private RelativeLayout brK;
    private ImageView brL;
    private TranslateAnimation brM;
    private TranslateAnimation brN;
    private int brO;
    private ao brR;
    private final int index;
    private boolean brP = false;
    private m brQ = new j(this);
    private Point bqN = new Point();

    public i(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.brK = relativeLayout;
        this.azz = (HeadImageView) relativeLayout.findViewById(com.baidu.tieba.v.im_floating_head_view);
        this.bqM = (TextView) relativeLayout.findViewById(com.baidu.tieba.v.im_floating_unread_view);
        this.brL = (ImageView) relativeLayout.findViewById(com.baidu.tieba.v.im_floating_arrow);
        this.azz.setAutoChangeStyle(false);
        this.azz.setIsRound(true);
        this.azz.setTag(Integer.valueOf(i));
        this.azz.setOnLongClickListener(new k(this));
        this.azz.setOnTouchListener(new l(this));
    }

    public void a(ao aoVar) {
        this.brR = aoVar;
    }

    public boolean d(Animation animation) {
        return this.brN == animation;
    }

    public void a(com.baidu.adp.lib.g.e eVar) {
        if (this.brK.getVisibility() == 0) {
            this.brM = new TranslateAnimation(Vi(), 0.0f, 0.0f, 0.0f);
            this.brM.setDuration(300L);
            if (eVar != null) {
                this.brM.setAnimationListener(eVar);
            }
            this.brK.startAnimation(this.brM);
        }
    }

    private int Vi() {
        int[] iArr = new int[2];
        this.brK.getLocationInWindow(iArr);
        int M = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst());
        return ((M - iArr[0]) - this.brK.getMeasuredWidth()) - com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.g.e eVar) {
        if (this.brK.getVisibility() == 0) {
            this.brN = new TranslateAnimation(0.0f, Vi(), 0.0f, 0.0f);
            this.brN.setDuration(300L);
            if (eVar != null) {
                this.brN.setAnimationListener(eVar);
            }
            this.brK.startAnimation(this.brN);
        }
    }

    public void Vj() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.brK.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.brK.startAnimation(translateAnimation);
    }

    public void Vk() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.brK.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.brK.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.brO = userData.getConcern_num();
            gx(userData.getConcern_num());
            this.azz.c(userData.getPortrait(), 12, false);
            this.azz.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.brL.setVisibility(0);
            } else {
                this.brL.setVisibility(8);
            }
            this.brK.setVisibility(0);
            return;
        }
        this.brK.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.azz.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(int i) {
        int i2;
        if (!this.brP) {
            if (i <= 0) {
                this.bqM.setVisibility(8);
                return;
            }
            this.bqM.setVisibility(0);
            if (i < 10) {
                this.bqM.setText(String.valueOf(i));
                i2 = com.baidu.tieba.u.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.bqM.setText(String.valueOf(i));
                i2 = com.baidu.tieba.u.icon_news_head_prompt_two;
            } else {
                this.bqM.setText("   ");
                i2 = com.baidu.tieba.u.icon_news_head_prompt_more;
            }
            this.bqM.setBackgroundResource(i2);
        }
    }
}
