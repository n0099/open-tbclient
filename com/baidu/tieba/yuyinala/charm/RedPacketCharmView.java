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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView aGa;
    private View bev;
    private String eHR;
    private LottieAnimationView gEt;
    private ImageView gEu;
    private View gEv;
    private TextView gEw;
    private TextView gEx;
    private ImageView gEy;
    private TextView gEz;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void vw(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bUp();
            bUr();
            switch (i) {
                case 1:
                    this.gEu.setImageResource(a.e.icon_redpacket_charm_body_02);
                    this.aGa.setVisibility(0);
                    this.bev.setVisibility(8);
                    this.gEz.setVisibility(0);
                    return;
                case 2:
                    this.gEu.setImageResource(a.e.icon_redpacket_charm_body_02);
                    bUn();
                    return;
                case 3:
                    this.gEu.setImageResource(a.e.icon_redpacket_charm_body_01);
                    bUn();
                    bUo();
                    return;
                case 4:
                    this.gEu.setImageResource(a.e.icon_redpacket_charm_body_01);
                    this.aGa.setVisibility(8);
                    this.bev.setVisibility(0);
                    this.gEx.setVisibility(8);
                    this.gEy.setVisibility(0);
                    this.gEz.setVisibility(4);
                    bUo();
                    bUq();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.gEv.setVisibility(0);
            if (TextUtils.isEmpty(this.gEw.getText()) || !this.gEw.getText().equals(str)) {
                this.gEw.setText(str);
                Drawable background = this.gEv.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.gEv.setBackgroundDrawable(background);
                }
                Drawable background2 = this.gEw.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.gEw.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.gEv.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.eHR) || !this.eHR.equals(str)) {
            this.eHR = str;
            this.aGa.startLoad(this.eHR, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.gEx.setText(str);
        this.gEz.setText(str2);
    }

    public void release() {
        this.eHR = "";
        bUp();
        bUr();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.red_packet_widget_charm, (ViewGroup) this, true);
        this.gEt = (LottieAnimationView) findViewById(a.f.lottie_redpacket_charm);
        this.gEu = (ImageView) findViewById(a.f.iv_redpacket_charm_body);
        this.gEv = findViewById(a.f.layout_badge);
        this.gEw = (TextView) findViewById(a.f.tv_badge);
        this.aGa = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bev = findViewById(a.f.layout_action);
        this.gEx = (TextView) findViewById(a.f.tv_countdown_action);
        this.gEy = (ImageView) findViewById(a.f.iv_process);
        this.gEz = (TextView) findViewById(a.f.tv_countdown_format);
        this.gEt.loop(true);
        this.gEt.setAnimation("sdk_redpacket_charm_coin.json");
        this.aGa.setIsRound(true);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setBorderColor(-4981);
        this.aGa.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aGa.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bUn() {
        this.aGa.setVisibility(8);
        this.bev.setVisibility(0);
        this.gEx.setVisibility(0);
        this.gEy.setVisibility(8);
        this.gEz.setVisibility(4);
    }

    private void bUo() {
        if (this.gEt != null) {
            this.gEt.setVisibility(0);
            this.gEt.playAnimation();
        }
    }

    private void bUp() {
        if (this.gEt != null) {
            this.gEt.cancelAnimation();
            this.gEt.setVisibility(4);
        }
    }

    private void bUq() {
        if (this.bev != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bev, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bev, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.bev.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bUr() {
        if (this.bev != null && (this.bev.getTag() instanceof Animator)) {
            ((Animator) this.bev.getTag()).cancel();
        }
    }
}
