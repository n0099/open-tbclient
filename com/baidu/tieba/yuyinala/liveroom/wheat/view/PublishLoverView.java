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
    private AnimatorSet bUl;
    private a oFP;
    private TextView ooL;
    private TextView ooY;

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
        this.ooL = (TextView) findViewById(a.f.tv_sex);
        this.ooY = (TextView) findViewById(a.f.tv_publish);
        setOnPublishClickListener();
    }

    public void Aa(boolean z) {
        this.ooL.setVisibility(0);
        this.ooY.setVisibility(8);
        this.ooL.setText("已选");
        if (z) {
            this.ooL.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_man);
        } else {
            this.ooL.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choosed_woman);
        }
    }

    public void c(boolean z, String str, boolean z2) {
        try {
            this.ooL.setVisibility(0);
            if (z2) {
                this.ooY.setVisibility(0);
            } else {
                this.ooY.setVisibility(8);
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(8, true), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), 1, 2, 17);
            this.ooL.setText(spannableString);
            if (z) {
                this.ooL.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_man);
            } else {
                this.ooL.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_choose_woman);
            }
        } catch (Exception e) {
        }
    }

    public void egC() {
        this.ooL.setVisibility(0);
        this.ooY.setVisibility(8);
        this.ooL.setText("放弃");
        this.ooL.setBackgroundResource(a.e.yuyinala_liveroom_publish_lover_giveup);
    }

    public void setOnPublishClickListener() {
        if (this.ooY != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PublishLoverView.this.ooY != null && PublishLoverView.this.ooY.getVisibility() == 0 && PublishLoverView.this.oFP != null) {
                        PublishLoverView.this.oFP.onClick();
                    }
                }
            });
        }
    }

    public void setOnPublishClickListener(a aVar) {
        this.oFP = aVar;
    }

    public void egD() {
        if (this.ooY != null) {
            this.ooY.setVisibility(8);
        }
    }

    public void ev(View view) {
        if (this.bUl == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "ScaleX", 0.0f, 1.2f, 0.8f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "ScaleY", 0.0f, 1.2f, 0.8f, 1.0f);
            this.bUl = new AnimatorSet();
            this.bUl.playTogether(ofFloat, ofFloat2);
            this.bUl.setDuration(300L);
            this.bUl.setInterpolator(new LinearInterpolator());
        }
        this.bUl.start();
    }
}
