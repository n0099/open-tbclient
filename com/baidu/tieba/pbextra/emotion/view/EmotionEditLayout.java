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
/* loaded from: classes22.dex */
public class EmotionEditLayout extends FrameLayout {
    private float ibo;
    private float lAD;
    private float lAE;
    private long lAF;
    private ViewDragHelper mDragHelper;

    public EmotionEditLayout(Context context) {
        this(context, null);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ibo = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void a(final EmotionEditText emotionEditText) {
        this.mDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditLayout.1
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                boolean z = view == emotionEditText;
                if (view instanceof ImageView) {
                    emotionEditText.dnr();
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
                    EmotionEditLayout.this.lAF = System.currentTimeMillis();
                    EmotionEditLayout.this.lAD = view.getX();
                    EmotionEditLayout.this.lAE = view.getY();
                    emotionEditText.dnr();
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                if (view instanceof EmotionEditText) {
                    float x = view.getX();
                    float y = view.getY();
                    float abs = Math.abs(x - EmotionEditLayout.this.lAD);
                    float abs2 = Math.abs(y - EmotionEditLayout.this.lAE);
                    if (abs < EmotionEditLayout.this.ibo && abs2 < EmotionEditLayout.this.ibo && System.currentTimeMillis() - EmotionEditLayout.this.lAF < 300) {
                        emotionEditText.dnt();
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
