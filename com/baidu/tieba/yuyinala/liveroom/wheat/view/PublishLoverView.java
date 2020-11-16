package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class PublishLoverView extends FrameLayout {
    private AnimatorSet bJZ;
    private TextView nWQ;
    private TextView nXe;
    private a ojx;

    /* loaded from: classes4.dex */
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
        this.nWQ = (TextView) findViewById(a.f.tv_sex);
        this.nXe = (TextView) findViewById(a.f.tv_publish);
        setOnPublishClickListener();
    }

    public void zu(boolean z) {
        this.nWQ.setVisibility(0);
        this.nXe.setVisibility(8);
        this.nWQ.setText("已选");
        if (z) {
            this.nWQ.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_man);
        } else {
            this.nWQ.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_woman);
        }
    }

    public void c(boolean z, String str, boolean z2) {
        try {
            this.nWQ.setVisibility(0);
            if (z2) {
                this.nXe.setVisibility(0);
            } else {
                this.nXe.setVisibility(8);
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(8, true), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), 1, 2, 17);
            this.nWQ.setText(spannableString);
            if (z) {
                this.nWQ.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_man);
            } else {
                this.nWQ.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_woman);
            }
        } catch (Exception e) {
        }
    }

    public void eay() {
        this.nWQ.setVisibility(0);
        this.nXe.setVisibility(8);
        this.nWQ.setText("放弃");
        this.nWQ.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_giveup);
    }

    public void setOnPublishClickListener() {
        if (this.nXe != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PublishLoverView.this.nXe != null && PublishLoverView.this.nXe.getVisibility() == 0 && PublishLoverView.this.ojx != null) {
                        PublishLoverView.this.ojx.onClick();
                    }
                }
            });
        }
    }

    public void setOnPublishClickListener(a aVar) {
        this.ojx = aVar;
    }

    public void eaz() {
        if (this.nXe != null) {
            this.nXe.setVisibility(8);
        }
    }

    public void dZ(View view) {
        if (this.bJZ == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "ScaleX", 0.0f, 1.2f, 0.8f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "ScaleY", 0.0f, 1.2f, 0.8f, 1.0f);
            this.bJZ = new AnimatorSet();
            this.bJZ.playTogether(ofFloat, ofFloat2);
            this.bJZ.setDuration(300L);
            this.bJZ.setInterpolator(new LinearInterpolator());
        }
        this.bJZ.start();
    }
}
