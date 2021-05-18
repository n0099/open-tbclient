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
/* loaded from: classes5.dex */
public class EmotionEditLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ViewDragHelper f19691e;

    /* renamed from: f  reason: collision with root package name */
    public float f19692f;

    /* renamed from: g  reason: collision with root package name */
    public float f19693g;

    /* renamed from: h  reason: collision with root package name */
    public float f19694h;

    /* renamed from: i  reason: collision with root package name */
    public long f19695i;

    /* loaded from: classes5.dex */
    public class a extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionEditText f19696a;

        public a(EmotionEditText emotionEditText) {
            this.f19696a = emotionEditText;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            return Math.min(Math.max(i2, EmotionEditLayout.this.getPaddingLeft()), EmotionEditLayout.this.getWidth() - this.f19696a.getWidth());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i2, int i3) {
            return Math.min(Math.max(i2, EmotionEditLayout.this.getPaddingTop()), EmotionEditLayout.this.getHeight() - this.f19696a.getHeight());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i2) {
            super.onViewCaptured(view, i2);
            if (view instanceof EmotionEditText) {
                EmotionEditLayout.this.f19695i = System.currentTimeMillis();
                EmotionEditLayout.this.f19693g = view.getX();
                EmotionEditLayout.this.f19694h = view.getY();
                this.f19696a.m();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            super.onViewReleased(view, f2, f3);
            if (view instanceof EmotionEditText) {
                float x = view.getX();
                float y = view.getY();
                float abs = Math.abs(x - EmotionEditLayout.this.f19693g);
                float abs2 = Math.abs(y - EmotionEditLayout.this.f19694h);
                if (abs < EmotionEditLayout.this.f19692f && abs2 < EmotionEditLayout.this.f19692f && System.currentTimeMillis() - EmotionEditLayout.this.f19695i < 300) {
                    this.f19696a.u();
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(view.getLeft(), view.getTop(), 0, 0);
                this.f19696a.setLayoutParams(layoutParams);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            boolean z = view == this.f19696a;
            if (view instanceof ImageView) {
                this.f19696a.m();
            }
            return z;
        }
    }

    public EmotionEditLayout(Context context) {
        this(context, null);
    }

    public void h(EmotionEditText emotionEditText) {
        this.f19691e = ViewDragHelper.create(this, 1.0f, new a(emotionEditText));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 3 && actionMasked != 1) {
            return this.f19691e.shouldInterceptTouchEvent(motionEvent);
        }
        this.f19691e.cancel();
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f19691e.processTouchEvent(motionEvent);
        return true;
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19692f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
