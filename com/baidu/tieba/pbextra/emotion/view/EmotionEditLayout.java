package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
/* loaded from: classes9.dex */
public class EmotionEditLayout extends FrameLayout {
    private float hmk;
    private float kDu;
    private float kDv;
    private long kDw;
    private ViewDragHelper mDragHelper;

    public EmotionEditLayout(Context context) {
        this(context, null);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hmk = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void a(final EmotionEditText emotionEditText) {
        this.mDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditLayout.1
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                boolean z = view == emotionEditText;
                if (view instanceof ImageView) {
                    emotionEditText.cRq();
                }
                return z;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return Math.min(Math.max(i, EmotionEditLayout.this.getPaddingLeft()), EmotionEditLayout.this.getWidth() - emotionEditText.getWidth());
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return Math.min(Math.max(i, EmotionEditLayout.this.getPaddingTop()), EmotionEditLayout.this.getHeight() - emotionEditText.getHeight());
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewCaptured(View view, int i) {
                super.onViewCaptured(view, i);
                if (view instanceof EmotionEditText) {
                    EmotionEditLayout.this.kDw = System.currentTimeMillis();
                    EmotionEditLayout.this.kDu = view.getX();
                    EmotionEditLayout.this.kDv = view.getY();
                    emotionEditText.cRq();
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                if (view instanceof EmotionEditText) {
                    float x = view.getX();
                    float y = view.getY();
                    float abs = Math.abs(x - EmotionEditLayout.this.kDu);
                    float abs2 = Math.abs(y - EmotionEditLayout.this.kDv);
                    if (abs < EmotionEditLayout.this.hmk && abs2 < EmotionEditLayout.this.hmk && System.currentTimeMillis() - EmotionEditLayout.this.kDw < 300) {
                        emotionEditText.cRr();
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(view.getLeft(), view.getTop(), 0, 0);
                    emotionEditText.setLayoutParams(layoutParams);
                }
            }
        });
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        }
        return this.mDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mDragHelper.processTouchEvent(motionEvent);
        return true;
    }
}
