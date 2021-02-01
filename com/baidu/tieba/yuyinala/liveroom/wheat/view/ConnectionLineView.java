package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class ConnectionLineView extends FrameLayout {
    private ImageView oKG;

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
        this.oKG = (ImageView) findViewById(a.f.connection_anim_view);
    }

    public void eeW() {
        eeX();
        this.oKG.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.oKG, "alpha", 0.0f, 1.0f, 0.0f, 1.0f);
        ofFloat.setDuration(900L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionLineView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
            }
        });
        ofFloat.start();
    }

    public void eeX() {
        if (this.oKG != null) {
            this.oKG.clearAnimation();
        }
    }
}
