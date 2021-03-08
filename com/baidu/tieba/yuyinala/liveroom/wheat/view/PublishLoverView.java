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
    private AnimatorSet bUP;
    private a oNI;
    private TextView owE;
    private TextView owQ;

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
        this.owE = (TextView) findViewById(a.f.tv_sex);
        this.owQ = (TextView) findViewById(a.f.tv_publish);
        setOnPublishClickListener();
    }

    public void Ao(boolean z) {
        this.owE.setVisibility(0);
        this.owQ.setVisibility(8);
        this.owE.setText("已选");
        if (z) {
            this.owE.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_man);
        } else {
            this.owE.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_woman);
        }
    }

    public void d(boolean z, String str, boolean z2) {
        try {
            this.owE.setVisibility(0);
            if (z2) {
                this.owQ.setVisibility(0);
            } else {
                this.owQ.setVisibility(8);
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(8, true), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), 1, 2, 17);
            this.owE.setText(spannableString);
            if (z) {
                this.owE.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_man);
            } else {
                this.owE.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_woman);
            }
        } catch (Exception e) {
        }
    }

    public void efp() {
        this.owE.setVisibility(0);
        this.owQ.setVisibility(8);
        this.owE.setText("放弃");
        this.owE.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_giveup);
    }

    public void efq() {
        this.owE.setVisibility(0);
        this.owQ.setVisibility(8);
        this.owE.setText("未公布");
        this.owE.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_giveup);
    }

    public void setOnPublishClickListener() {
        if (this.owQ != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PublishLoverView.this.owQ != null && PublishLoverView.this.owQ.getVisibility() == 0 && PublishLoverView.this.oNI != null) {
                        PublishLoverView.this.oNI.onClick();
                    }
                }
            });
        }
    }

    public void setOnPublishClickListener(a aVar) {
        this.oNI = aVar;
    }

    public void efr() {
        if (this.owQ != null) {
            this.owQ.setVisibility(8);
        }
    }

    public void et(View view) {
        if (this.bUP == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "ScaleX", 0.0f, 1.2f, 0.8f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "ScaleY", 0.0f, 1.2f, 0.8f, 1.0f);
            this.bUP = new AnimatorSet();
            this.bUP.playTogether(ofFloat, ofFloat2);
            this.bUP.setDuration(300L);
            this.bUP.setInterpolator(new LinearInterpolator());
        }
        this.bUP.start();
    }
}
