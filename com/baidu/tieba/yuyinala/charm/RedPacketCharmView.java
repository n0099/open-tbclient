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
    private HeadImageView aEp;
    private LottieAnimationView gqm;
    private ImageView gqn;
    private View gqo;
    private TextView gqp;
    private View gqq;
    private TextView gqr;
    private ImageView gqs;
    private TextView gqt;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void uh(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bOL();
            bON();
            switch (i) {
                case 1:
                    this.gqn.setImageResource(a.f.icon_redpacket_charm_body_02);
                    this.aEp.setVisibility(0);
                    this.gqq.setVisibility(8);
                    this.gqt.setVisibility(0);
                    return;
                case 2:
                    this.gqn.setImageResource(a.f.icon_redpacket_charm_body_02);
                    bOJ();
                    return;
                case 3:
                    this.gqn.setImageResource(a.f.icon_redpacket_charm_body_01);
                    bOJ();
                    bOK();
                    return;
                case 4:
                    this.gqn.setImageResource(a.f.icon_redpacket_charm_body_01);
                    this.aEp.setVisibility(8);
                    this.gqq.setVisibility(0);
                    this.gqr.setVisibility(8);
                    this.gqs.setVisibility(0);
                    this.gqt.setVisibility(4);
                    bOK();
                    bOM();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.gqo.setVisibility(0);
            if (TextUtils.isEmpty(this.gqp.getText()) || !this.gqp.getText().equals(str)) {
                this.gqp.setText(str);
                Drawable background = this.gqo.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.gqo.setBackgroundDrawable(background);
                }
                Drawable background2 = this.gqp.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.gqp.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.gqo.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.aEp.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.gqr.setText(str);
        this.gqt.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bOL();
        bON();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.gqm = (LottieAnimationView) findViewById(a.g.lottie_redpacket_charm);
        this.gqn = (ImageView) findViewById(a.g.iv_redpacket_charm_body);
        this.gqo = findViewById(a.g.layout_badge);
        this.gqp = (TextView) findViewById(a.g.tv_badge);
        this.aEp = (HeadImageView) findViewById(a.g.iv_avatar);
        this.gqq = findViewById(a.g.layout_action);
        this.gqr = (TextView) findViewById(a.g.tv_countdown_action);
        this.gqs = (ImageView) findViewById(a.g.iv_process);
        this.gqt = (TextView) findViewById(a.g.tv_countdown_format);
        this.gqm.loop(true);
        this.gqm.setAnimation("sdk_redpacket_charm_coin.json");
        this.aEp.setIsRound(true);
        this.aEp.setAutoChangeStyle(false);
        this.aEp.setBorderColor(-4981);
        this.aEp.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aEp.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bOJ() {
        this.aEp.setVisibility(8);
        this.gqq.setVisibility(0);
        this.gqr.setVisibility(0);
        this.gqs.setVisibility(8);
        this.gqt.setVisibility(4);
    }

    private void bOK() {
        if (this.gqm != null) {
            this.gqm.setVisibility(0);
            this.gqm.playAnimation();
        }
    }

    private void bOL() {
        if (this.gqm != null) {
            this.gqm.cancelAnimation();
            this.gqm.setVisibility(4);
        }
    }

    private void bOM() {
        if (this.gqq != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gqq, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gqq, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.gqq.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bON() {
        if (this.gqq != null && (this.gqq.getTag() instanceof Animator)) {
            ((Animator) this.gqq.getTag()).cancel();
        }
    }
}
