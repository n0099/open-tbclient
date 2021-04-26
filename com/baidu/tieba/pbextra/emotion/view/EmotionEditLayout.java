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
/* loaded from: classes3.dex */
public class EmotionEditLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ViewDragHelper f20403e;

    /* renamed from: f  reason: collision with root package name */
    public float f20404f;

    /* renamed from: g  reason: collision with root package name */
    public float f20405g;

    /* renamed from: h  reason: collision with root package name */
    public float f20406h;

    /* renamed from: i  reason: collision with root package name */
    public long f20407i;

    /* loaded from: classes3.dex */
    public class a extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionEditText f20408a;

        public a(EmotionEditText emotionEditText) {
            this.f20408a = emotionEditText;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            return Math.min(Math.max(i2, EmotionEditLayout.this.getPaddingLeft()), EmotionEditLayout.this.getWidth() - this.f20408a.getWidth());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i2, int i3) {
            return Math.min(Math.max(i2, EmotionEditLayout.this.getPaddingTop()), EmotionEditLayout.this.getHeight() - this.f20408a.getHeight());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i2) {
            super.onViewCaptured(view, i2);
            if (view instanceof EmotionEditText) {
                EmotionEditLayout.this.f20407i = System.currentTimeMillis();
                EmotionEditLayout.this.f20405g = view.getX();
                EmotionEditLayout.this.f20406h = view.getY();
                this.f20408a.m();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            super.onViewReleased(view, f2, f3);
            if (view instanceof EmotionEditText) {
                float x = view.getX();
                float y = view.getY();
                float abs = Math.abs(x - EmotionEditLayout.this.f20405g);
                float abs2 = Math.abs(y - EmotionEditLayout.this.f20406h);
                if (abs < EmotionEditLayout.this.f20404f && abs2 < EmotionEditLayout.this.f20404f && System.currentTimeMillis() - EmotionEditLayout.this.f20407i < 300) {
                    this.f20408a.u();
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(view.getLeft(), view.getTop(), 0, 0);
                this.f20408a.setLayoutParams(layoutParams);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            boolean z = view == this.f20408a;
            if (view instanceof ImageView) {
                this.f20408a.m();
            }
            return z;
        }
    }

    public EmotionEditLayout(Context context) {
        this(context, null);
    }

    public void h(EmotionEditText emotionEditText) {
        this.f20403e = ViewDragHelper.create(this, 1.0f, new a(emotionEditText));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 3 && actionMasked != 1) {
            return this.f20403e.shouldInterceptTouchEvent(motionEvent);
        }
        this.f20403e.cancel();
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f20403e.processTouchEvent(motionEvent);
        return true;
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20404f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
