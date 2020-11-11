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
    private AnimatorSet bLK;
    private TextView nVB;
    private TextView nVn;
    private a ohU;

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
        this.nVn = (TextView) findViewById(a.f.tv_sex);
        this.nVB = (TextView) findViewById(a.f.tv_publish);
        setOnPublishClickListener();
    }

    public void zn(boolean z) {
        this.nVn.setVisibility(0);
        this.nVB.setVisibility(8);
        this.nVn.setText("已选");
        if (z) {
            this.nVn.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_man);
        } else {
            this.nVn.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_woman);
        }
    }

    public void c(boolean z, String str, boolean z2) {
        try {
            this.nVn.setVisibility(0);
            if (z2) {
                this.nVB.setVisibility(0);
            } else {
                this.nVB.setVisibility(8);
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(8, true), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), 1, 2, 17);
            this.nVn.setText(spannableString);
            if (z) {
                this.nVn.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_man);
            } else {
                this.nVn.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_woman);
            }
        } catch (Exception e) {
        }
    }

    public void eaz() {
        this.nVn.setVisibility(0);
        this.nVB.setVisibility(8);
        this.nVn.setText("放弃");
        this.nVn.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_giveup);
    }

    public void setOnPublishClickListener() {
        if (this.nVB != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PublishLoverView.this.nVB != null && PublishLoverView.this.nVB.getVisibility() == 0 && PublishLoverView.this.ohU != null) {
                        PublishLoverView.this.ohU.onClick();
                    }
                }
            });
        }
    }

    public void setOnPublishClickListener(a aVar) {
        this.ohU = aVar;
    }

    public void eaA() {
        if (this.nVB != null) {
            this.nVB.setVisibility(8);
        }
    }

    public void dS(View view) {
        if (this.bLK == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "ScaleX", 0.0f, 1.2f, 0.8f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "ScaleY", 0.0f, 1.2f, 0.8f, 1.0f);
            this.bLK = new AnimatorSet();
            this.bLK.playTogether(ofFloat, ofFloat2);
            this.bLK.setDuration(300L);
            this.bLK.setInterpolator(new LinearInterpolator());
        }
        this.bLK.start();
    }
}
