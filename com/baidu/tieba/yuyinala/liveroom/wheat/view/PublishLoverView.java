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
/* loaded from: classes10.dex */
public class PublishLoverView extends FrameLayout {
    private AnimatorSet bPz;
    private a oBl;
    private TextView okg;
    private TextView okt;

    /* loaded from: classes10.dex */
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
        this.okg = (TextView) findViewById(a.f.tv_sex);
        this.okt = (TextView) findViewById(a.f.tv_publish);
        setOnPublishClickListener();
    }

    public void zW(boolean z) {
        this.okg.setVisibility(0);
        this.okt.setVisibility(8);
        this.okg.setText("已选");
        if (z) {
            this.okg.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_man);
        } else {
            this.okg.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_woman);
        }
    }

    public void c(boolean z, String str, boolean z2) {
        try {
            this.okg.setVisibility(0);
            if (z2) {
                this.okt.setVisibility(0);
            } else {
                this.okt.setVisibility(8);
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(8, true), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), 1, 2, 17);
            this.okg.setText(spannableString);
            if (z) {
                this.okg.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_man);
            } else {
                this.okg.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_woman);
            }
        } catch (Exception e) {
        }
    }

    public void ecK() {
        this.okg.setVisibility(0);
        this.okt.setVisibility(8);
        this.okg.setText("放弃");
        this.okg.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_giveup);
    }

    public void setOnPublishClickListener() {
        if (this.okt != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PublishLoverView.this.okt != null && PublishLoverView.this.okt.getVisibility() == 0 && PublishLoverView.this.oBl != null) {
                        PublishLoverView.this.oBl.onClick();
                    }
                }
            });
        }
    }

    public void setOnPublishClickListener(a aVar) {
        this.oBl = aVar;
    }

    public void ecL() {
        if (this.okt != null) {
            this.okt.setVisibility(8);
        }
    }

    public void ev(View view) {
        if (this.bPz == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "ScaleX", 0.0f, 1.2f, 0.8f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "ScaleY", 0.0f, 1.2f, 0.8f, 1.0f);
            this.bPz = new AnimatorSet();
            this.bPz.playTogether(ofFloat, ofFloat2);
            this.bPz.setDuration(300L);
            this.bPz.setInterpolator(new LinearInterpolator());
        }
        this.bPz.start();
    }
}
