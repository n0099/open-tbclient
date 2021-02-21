package com.baidu.tieba.yuyinala.charm;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView aDr;
    private View bex;
    private String ePk;
    private LottieAnimationView gOs;
    private ImageView gOt;
    private View gOu;
    private TextView gOv;
    private TextView gOw;
    private ImageView gOx;
    private TextView gOy;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void uh(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bTM();
            bTO();
            switch (i) {
                case 1:
                    this.gOt.setImageResource(a.e.icon_redpacket_charm_body_02);
                    this.aDr.setVisibility(0);
                    this.bex.setVisibility(8);
                    this.gOy.setVisibility(0);
                    return;
                case 2:
                    this.gOt.setImageResource(a.e.icon_redpacket_charm_body_02);
                    bTK();
                    return;
                case 3:
                    this.gOt.setImageResource(a.e.icon_redpacket_charm_body_01);
                    bTK();
                    bTL();
                    return;
                case 4:
                    this.gOt.setImageResource(a.e.icon_redpacket_charm_body_01);
                    this.aDr.setVisibility(8);
                    this.bex.setVisibility(0);
                    this.gOw.setVisibility(8);
                    this.gOx.setVisibility(0);
                    this.gOy.setVisibility(4);
                    bTL();
                    bTN();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.gOu.setVisibility(0);
            if (TextUtils.isEmpty(this.gOv.getText()) || !this.gOv.getText().equals(str)) {
                this.gOv.setText(str);
                Drawable background = this.gOu.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.gOu.setBackgroundDrawable(background);
                }
                Drawable background2 = this.gOv.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.gOv.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.gOu.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.ePk) || !this.ePk.equals(str)) {
            this.ePk = str;
            this.aDr.startLoad(this.ePk, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.gOw.setText(str);
        this.gOy.setText(str2);
    }

    public void release() {
        this.ePk = "";
        bTM();
        bTO();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.red_packet_widget_charm, (ViewGroup) this, true);
        this.gOs = (LottieAnimationView) findViewById(a.f.lottie_redpacket_charm);
        this.gOt = (ImageView) findViewById(a.f.iv_redpacket_charm_body);
        this.gOu = findViewById(a.f.layout_badge);
        this.gOv = (TextView) findViewById(a.f.tv_badge);
        this.aDr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bex = findViewById(a.f.layout_action);
        this.gOw = (TextView) findViewById(a.f.tv_countdown_action);
        this.gOx = (ImageView) findViewById(a.f.iv_process);
        this.gOy = (TextView) findViewById(a.f.tv_countdown_format);
        this.gOs.loop(true);
        this.gOs.setAnimation("sdk_redpacket_charm_coin.json");
        this.aDr.setIsRound(true);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setBorderColor(-4981);
        this.aDr.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aDr.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bTK() {
        this.aDr.setVisibility(8);
        this.bex.setVisibility(0);
        this.gOw.setVisibility(0);
        this.gOx.setVisibility(8);
        this.gOy.setVisibility(4);
    }

    private void bTL() {
        if (this.gOs != null) {
            this.gOs.setVisibility(0);
            this.gOs.playAnimation();
        }
    }

    private void bTM() {
        if (this.gOs != null) {
            this.gOs.cancelAnimation();
            this.gOs.setVisibility(4);
        }
    }

    private void bTN() {
        if (this.bex != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bex, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bex, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.bex.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bTO() {
        if (this.bex != null && (this.bex.getTag() instanceof Animator)) {
            ((Animator) this.bex.getTag()).cancel();
        }
    }
}
