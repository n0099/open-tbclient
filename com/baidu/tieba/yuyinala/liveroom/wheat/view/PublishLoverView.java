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
    private AnimatorSet bPg;
    private TextView olQ;
    private TextView ome;
    private a oyA;

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
        this.olQ = (TextView) findViewById(a.f.tv_sex);
        this.ome = (TextView) findViewById(a.f.tv_publish);
        setOnPublishClickListener();
    }

    public void zY(boolean z) {
        this.olQ.setVisibility(0);
        this.ome.setVisibility(8);
        this.olQ.setText("已选");
        if (z) {
            this.olQ.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_man);
        } else {
            this.olQ.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_woman);
        }
    }

    public void c(boolean z, String str, boolean z2) {
        try {
            this.olQ.setVisibility(0);
            if (z2) {
                this.ome.setVisibility(0);
            } else {
                this.ome.setVisibility(8);
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(8, true), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), 1, 2, 17);
            this.olQ.setText(spannableString);
            if (z) {
                this.olQ.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_man);
            } else {
                this.olQ.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_woman);
            }
        } catch (Exception e) {
        }
    }

    public void ege() {
        this.olQ.setVisibility(0);
        this.ome.setVisibility(8);
        this.olQ.setText("放弃");
        this.olQ.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_giveup);
    }

    public void setOnPublishClickListener() {
        if (this.ome != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PublishLoverView.this.ome != null && PublishLoverView.this.ome.getVisibility() == 0 && PublishLoverView.this.oyA != null) {
                        PublishLoverView.this.oyA.onClick();
                    }
                }
            });
        }
    }

    public void setOnPublishClickListener(a aVar) {
        this.oyA = aVar;
    }

    public void egf() {
        if (this.ome != null) {
            this.ome.setVisibility(8);
        }
    }

    public void ek(View view) {
        if (this.bPg == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "ScaleX", 0.0f, 1.2f, 0.8f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "ScaleY", 0.0f, 1.2f, 0.8f, 1.0f);
            this.bPg = new AnimatorSet();
            this.bPg.playTogether(ofFloat, ofFloat2);
            this.bPg.setDuration(300L);
            this.bPg.setInterpolator(new LinearInterpolator());
        }
        this.bPg.start();
    }
}
