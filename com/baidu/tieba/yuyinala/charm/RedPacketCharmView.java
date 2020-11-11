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
    private HeadImageView aFf;
    private LottieAnimationView gwa;
    private ImageView gwb;
    private View gwc;
    private TextView gwd;
    private View gwe;
    private TextView gwf;
    private ImageView gwg;
    private TextView gwh;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void ur(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bRl();
            bRn();
            switch (i) {
                case 1:
                    this.gwb.setImageResource(a.e.icon_redpacket_charm_body_02);
                    this.aFf.setVisibility(0);
                    this.gwe.setVisibility(8);
                    this.gwh.setVisibility(0);
                    return;
                case 2:
                    this.gwb.setImageResource(a.e.icon_redpacket_charm_body_02);
                    bRj();
                    return;
                case 3:
                    this.gwb.setImageResource(a.e.icon_redpacket_charm_body_01);
                    bRj();
                    bRk();
                    return;
                case 4:
                    this.gwb.setImageResource(a.e.icon_redpacket_charm_body_01);
                    this.aFf.setVisibility(8);
                    this.gwe.setVisibility(0);
                    this.gwf.setVisibility(8);
                    this.gwg.setVisibility(0);
                    this.gwh.setVisibility(4);
                    bRk();
                    bRm();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.gwc.setVisibility(0);
            if (TextUtils.isEmpty(this.gwd.getText()) || !this.gwd.getText().equals(str)) {
                this.gwd.setText(str);
                Drawable background = this.gwc.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.gwc.setBackgroundDrawable(background);
                }
                Drawable background2 = this.gwd.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.gwd.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.gwc.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.aFf.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.gwf.setText(str);
        this.gwh.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bRl();
        bRn();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.red_packet_widget_charm, (ViewGroup) this, true);
        this.gwa = (LottieAnimationView) findViewById(a.f.lottie_redpacket_charm);
        this.gwb = (ImageView) findViewById(a.f.iv_redpacket_charm_body);
        this.gwc = findViewById(a.f.layout_badge);
        this.gwd = (TextView) findViewById(a.f.tv_badge);
        this.aFf = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gwe = findViewById(a.f.layout_action);
        this.gwf = (TextView) findViewById(a.f.tv_countdown_action);
        this.gwg = (ImageView) findViewById(a.f.iv_process);
        this.gwh = (TextView) findViewById(a.f.tv_countdown_format);
        this.gwa.loop(true);
        this.gwa.setAnimation("sdk_redpacket_charm_coin.json");
        this.aFf.setIsRound(true);
        this.aFf.setAutoChangeStyle(false);
        this.aFf.setBorderColor(-4981);
        this.aFf.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aFf.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bRj() {
        this.aFf.setVisibility(8);
        this.gwe.setVisibility(0);
        this.gwf.setVisibility(0);
        this.gwg.setVisibility(8);
        this.gwh.setVisibility(4);
    }

    private void bRk() {
        if (this.gwa != null) {
            this.gwa.setVisibility(0);
            this.gwa.playAnimation();
        }
    }

    private void bRl() {
        if (this.gwa != null) {
            this.gwa.cancelAnimation();
            this.gwa.setVisibility(4);
        }
    }

    private void bRm() {
        if (this.gwe != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gwe, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gwe, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.gwe.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bRn() {
        if (this.gwe != null && (this.gwe.getTag() instanceof Animator)) {
            ((Animator) this.gwe.getTag()).cancel();
        }
    }
}
