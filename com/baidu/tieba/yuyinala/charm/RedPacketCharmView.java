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
    private LottieAnimationView gEr;
    private ImageView gEs;
    private View gEt;
    private TextView gEu;
    private TextView gEv;
    private ImageView gEw;
    private TextView gEx;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void vw(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bUo();
            bUq();
            switch (i) {
                case 1:
                    this.gEs.setImageResource(a.e.icon_redpacket_charm_body_02);
                    this.aGa.setVisibility(0);
                    this.bev.setVisibility(8);
                    this.gEx.setVisibility(0);
                    return;
                case 2:
                    this.gEs.setImageResource(a.e.icon_redpacket_charm_body_02);
                    bUm();
                    return;
                case 3:
                    this.gEs.setImageResource(a.e.icon_redpacket_charm_body_01);
                    bUm();
                    bUn();
                    return;
                case 4:
                    this.gEs.setImageResource(a.e.icon_redpacket_charm_body_01);
                    this.aGa.setVisibility(8);
                    this.bev.setVisibility(0);
                    this.gEv.setVisibility(8);
                    this.gEw.setVisibility(0);
                    this.gEx.setVisibility(4);
                    bUn();
                    bUp();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.gEt.setVisibility(0);
            if (TextUtils.isEmpty(this.gEu.getText()) || !this.gEu.getText().equals(str)) {
                this.gEu.setText(str);
                Drawable background = this.gEt.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.gEt.setBackgroundDrawable(background);
                }
                Drawable background2 = this.gEu.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.gEu.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.gEt.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.eHR) || !this.eHR.equals(str)) {
            this.eHR = str;
            this.aGa.startLoad(this.eHR, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.gEv.setText(str);
        this.gEx.setText(str2);
    }

    public void release() {
        this.eHR = "";
        bUo();
        bUq();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.red_packet_widget_charm, (ViewGroup) this, true);
        this.gEr = (LottieAnimationView) findViewById(a.f.lottie_redpacket_charm);
        this.gEs = (ImageView) findViewById(a.f.iv_redpacket_charm_body);
        this.gEt = findViewById(a.f.layout_badge);
        this.gEu = (TextView) findViewById(a.f.tv_badge);
        this.aGa = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bev = findViewById(a.f.layout_action);
        this.gEv = (TextView) findViewById(a.f.tv_countdown_action);
        this.gEw = (ImageView) findViewById(a.f.iv_process);
        this.gEx = (TextView) findViewById(a.f.tv_countdown_format);
        this.gEr.loop(true);
        this.gEr.setAnimation("sdk_redpacket_charm_coin.json");
        this.aGa.setIsRound(true);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setBorderColor(-4981);
        this.aGa.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aGa.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bUm() {
        this.aGa.setVisibility(8);
        this.bev.setVisibility(0);
        this.gEv.setVisibility(0);
        this.gEw.setVisibility(8);
        this.gEx.setVisibility(4);
    }

    private void bUn() {
        if (this.gEr != null) {
            this.gEr.setVisibility(0);
            this.gEr.playAnimation();
        }
    }

    private void bUo() {
        if (this.gEr != null) {
            this.gEr.cancelAnimation();
            this.gEr.setVisibility(4);
        }
    }

    private void bUp() {
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

    private void bUq() {
        if (this.bev != null && (this.bev.getTag() instanceof Animator)) {
            ((Animator) this.bev.getTag()).cancel();
        }
    }
}
