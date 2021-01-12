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
    private a oBk;
    private TextView okf;
    private TextView oks;

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
        this.okf = (TextView) findViewById(a.f.tv_sex);
        this.oks = (TextView) findViewById(a.f.tv_publish);
        setOnPublishClickListener();
    }

    public void zW(boolean z) {
        this.okf.setVisibility(0);
        this.oks.setVisibility(8);
        this.okf.setText("已选");
        if (z) {
            this.okf.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_man);
        } else {
            this.okf.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_woman);
        }
    }

    public void c(boolean z, String str, boolean z2) {
        try {
            this.okf.setVisibility(0);
            if (z2) {
                this.oks.setVisibility(0);
            } else {
                this.oks.setVisibility(8);
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(8, true), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), 1, 2, 17);
            this.okf.setText(spannableString);
            if (z) {
                this.okf.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_man);
            } else {
                this.okf.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_woman);
            }
        } catch (Exception e) {
        }
    }

    public void ecK() {
        this.okf.setVisibility(0);
        this.oks.setVisibility(8);
        this.okf.setText("放弃");
        this.okf.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_giveup);
    }

    public void setOnPublishClickListener() {
        if (this.oks != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PublishLoverView.this.oks != null && PublishLoverView.this.oks.getVisibility() == 0 && PublishLoverView.this.oBk != null) {
                        PublishLoverView.this.oBk.onClick();
                    }
                }
            });
        }
    }

    public void setOnPublishClickListener(a aVar) {
        this.oBk = aVar;
    }

    public void ecL() {
        if (this.oks != null) {
            this.oks.setVisibility(8);
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
