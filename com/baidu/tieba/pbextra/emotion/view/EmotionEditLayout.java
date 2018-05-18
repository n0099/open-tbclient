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
/* loaded from: classes3.dex */
public class EmotionEditLayout extends FrameLayout {
    private float cLJ;
    private float fCw;
    private float fCx;
    private long fCy;
    private ViewDragHelper mDragHelper;

    public EmotionEditLayout(Context context) {
        this(context, null);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cLJ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void a(final EmotionEditText emotionEditText) {
        this.mDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditLayout.1
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view2, int i) {
                boolean z = view2 == emotionEditText;
                if (view2 instanceof ImageView) {
                    emotionEditText.bdm();
                }
                return z;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view2, int i, int i2) {
                return Math.min(Math.max(i, EmotionEditLayout.this.getPaddingLeft()), EmotionEditLayout.this.getWidth() - emotionEditText.getWidth());
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view2, int i, int i2) {
                return Math.min(Math.max(i, EmotionEditLayout.this.getPaddingTop()), EmotionEditLayout.this.getHeight() - emotionEditText.getHeight());
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewCaptured(View view2, int i) {
                super.onViewCaptured(view2, i);
                if (view2 instanceof EmotionEditText) {
                    EmotionEditLayout.this.fCy = System.currentTimeMillis();
                    EmotionEditLayout.this.fCw = view2.getX();
                    EmotionEditLayout.this.fCx = view2.getY();
                    emotionEditText.bdm();
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewReleased(View view2, float f, float f2) {
                super.onViewReleased(view2, f, f2);
                if (view2 instanceof EmotionEditText) {
                    float x = view2.getX();
                    float y = view2.getY();
                    float abs = Math.abs(x - EmotionEditLayout.this.fCw);
                    float abs2 = Math.abs(y - EmotionEditLayout.this.fCx);
                    if (abs < EmotionEditLayout.this.cLJ && abs2 < EmotionEditLayout.this.cLJ && System.currentTimeMillis() - EmotionEditLayout.this.fCy < 300) {
                        emotionEditText.bdn();
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(view2.getLeft(), view2.getTop(), 0, 0);
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
