package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class PublishLoverView extends FrameLayout {
    private AnimatorSet bTp;
    private a oLd;
    private TextView otY;
    private TextView ouk;

    /* loaded from: classes11.dex */
    public interface a {
        void onClick();
    }

    public PublishLoverView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public PublishLoverView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.yuyinala_liveroom_publish_lover, this);
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.otY = (TextView) findViewById(a.f.tv_sex);
        this.ouk = (TextView) findViewById(a.f.tv_publish);
        setOnPublishClickListener();
    }

    public void Ap(boolean z) {
        this.otY.setVisibility(0);
        this.ouk.setVisibility(8);
        this.otY.setText("已选");
        if (z) {
            this.otY.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_man);
        } else {
            this.otY.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_woman);
        }
    }

    public void d(boolean z, String str, boolean z2) {
        try {
            this.otY.setVisibility(0);
            if (z2) {
                this.ouk.setVisibility(0);
            } else {
                this.ouk.setVisibility(8);
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(8, true), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), 1, 2, 17);
            this.otY.setText(spannableString);
            if (z) {
                this.otY.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_man);
            } else {
                this.otY.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_woman);
            }
        } catch (Exception e) {
        }
    }

    public void eeZ() {
        this.otY.setVisibility(0);
        this.ouk.setVisibility(8);
        this.otY.setText("放弃");
        this.otY.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_giveup);
    }

    public void efa() {
        this.otY.setVisibility(0);
        this.ouk.setVisibility(8);
        this.otY.setText("未公布");
        this.otY.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_giveup);
    }

    public void setOnPublishClickListener() {
        if (this.ouk != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PublishLoverView.this.ouk != null && PublishLoverView.this.ouk.getVisibility() == 0 && PublishLoverView.this.oLd != null) {
                        PublishLoverView.this.oLd.onClick();
                    }
                }
            });
        }
    }

    public void setOnPublishClickListener(a aVar) {
        this.oLd = aVar;
    }

    public void efb() {
        if (this.ouk != null) {
            this.ouk.setVisibility(8);
        }
    }

    public void et(View view) {
        if (this.bTp == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "ScaleX", 0.0f, 1.2f, 0.8f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "ScaleY", 0.0f, 1.2f, 0.8f, 1.0f);
            this.bTp = new AnimatorSet();
            this.bTp.playTogether(ofFloat, ofFloat2);
            this.bTp.setDuration(300L);
            this.bTp.setInterpolator(new LinearInterpolator());
        }
        this.bTp.start();
    }
}
