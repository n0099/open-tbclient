package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import androidx.customview.widget.ViewDragHelper;
/* loaded from: classes2.dex */
public class EmotionEditLayout extends FrameLayout {
    private float iUE;
    private ViewDragHelper mDragHelper;
    private float mtr;
    private float mts;
    private long mtt;

    public EmotionEditLayout(Context context) {
        this(context, null);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void a(final EmotionEditText emotionEditText) {
        this.mDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditLayout.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                boolean z = view == emotionEditText;
                if (view instanceof ImageView) {
                    emotionEditText.dwr();
                }
                return z;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return Math.min(Math.max(i, EmotionEditLayout.this.getPaddingLeft()), EmotionEditLayout.this.getWidth() - emotionEditText.getWidth());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return Math.min(Math.max(i, EmotionEditLayout.this.getPaddingTop()), EmotionEditLayout.this.getHeight() - emotionEditText.getHeight());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewCaptured(View view, int i) {
                super.onViewCaptured(view, i);
                if (view instanceof EmotionEditText) {
                    EmotionEditLayout.this.mtt = System.currentTimeMillis();
                    EmotionEditLayout.this.mtr = view.getX();
                    EmotionEditLayout.this.mts = view.getY();
                    emotionEditText.dwr();
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                if (view instanceof EmotionEditText) {
                    float x = view.getX();
                    float y = view.getY();
                    float abs = Math.abs(x - EmotionEditLayout.this.mtr);
                    float abs2 = Math.abs(y - EmotionEditLayout.this.mts);
                    if (abs < EmotionEditLayout.this.iUE && abs2 < EmotionEditLayout.this.iUE && System.currentTimeMillis() - EmotionEditLayout.this.mtt < 300) {
                        emotionEditText.dws();
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
