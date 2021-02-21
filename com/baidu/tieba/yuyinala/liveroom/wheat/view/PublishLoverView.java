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
    private a oLD;
    private TextView ouL;
    private TextView ouz;

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
        this.ouz = (TextView) findViewById(a.f.tv_sex);
        this.ouL = (TextView) findViewById(a.f.tv_publish);
        setOnPublishClickListener();
    }

    public void Ap(boolean z) {
        this.ouz.setVisibility(0);
        this.ouL.setVisibility(8);
        this.ouz.setText("已选");
        if (z) {
            this.ouz.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_man);
        } else {
            this.ouz.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_woman);
        }
    }

    public void d(boolean z, String str, boolean z2) {
        try {
            this.ouz.setVisibility(0);
            if (z2) {
                this.ouL.setVisibility(0);
            } else {
                this.ouL.setVisibility(8);
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(8, true), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), 1, 2, 17);
            this.ouz.setText(spannableString);
            if (z) {
                this.ouz.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_man);
            } else {
                this.ouz.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_woman);
            }
        } catch (Exception e) {
        }
    }

    public void efh() {
        this.ouz.setVisibility(0);
        this.ouL.setVisibility(8);
        this.ouz.setText("放弃");
        this.ouz.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_giveup);
    }

    public void efi() {
        this.ouz.setVisibility(0);
        this.ouL.setVisibility(8);
        this.ouz.setText("未公布");
        this.ouz.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_giveup);
    }

    public void setOnPublishClickListener() {
        if (this.ouL != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PublishLoverView.this.ouL != null && PublishLoverView.this.ouL.getVisibility() == 0 && PublishLoverView.this.oLD != null) {
                        PublishLoverView.this.oLD.onClick();
                    }
                }
            });
        }
    }

    public void setOnPublishClickListener(a aVar) {
        this.oLD = aVar;
    }

    public void efj() {
        if (this.ouL != null) {
            this.ouL.setVisibility(8);
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
