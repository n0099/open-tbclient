package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class ConnectionLineView extends FrameLayout {
    private ImageView ojn;

    public ConnectionLineView(@NonNull Context context) {
        this(context, null, 0);
    }

    public ConnectionLineView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConnectionLineView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_connection_anim_view_layout, this);
        this.ojn = (ImageView) findViewById(a.f.connection_anim_view);
    }

    public void eaw() {
        eax();
        this.ojn.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ojn, "alpha", 0.0f, 1.0f, 0.0f, 1.0f);
        ofFloat.setDuration(900L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionLineView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
            }
        });
        ofFloat.start();
    }

    public void eax() {
        if (this.ojn != null) {
            this.ojn.clearAnimation();
        }
    }
}
