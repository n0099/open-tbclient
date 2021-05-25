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
    public ViewDragHelper f19613e;

    /* renamed from: f  reason: collision with root package name */
    public float f19614f;

    /* renamed from: g  reason: collision with root package name */
    public float f19615g;

    /* renamed from: h  reason: collision with root package name */
    public float f19616h;

    /* renamed from: i  reason: collision with root package name */
    public long f19617i;

    /* loaded from: classes5.dex */
    public class a extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionEditText f19618a;

        public a(EmotionEditText emotionEditText) {
            this.f19618a = emotionEditText;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            return Math.min(Math.max(i2, EmotionEditLayout.this.getPaddingLeft()), EmotionEditLayout.this.getWidth() - this.f19618a.getWidth());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i2, int i3) {
            return Math.min(Math.max(i2, EmotionEditLayout.this.getPaddingTop()), EmotionEditLayout.this.getHeight() - this.f19618a.getHeight());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i2) {
            super.onViewCaptured(view, i2);
            if (view instanceof EmotionEditText) {
                EmotionEditLayout.this.f19617i = System.currentTimeMillis();
                EmotionEditLayout.this.f19615g = view.getX();
                EmotionEditLayout.this.f19616h = view.getY();
                this.f19618a.m();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            super.onViewReleased(view, f2, f3);
            if (view instanceof EmotionEditText) {
                float x = view.getX();
                float y = view.getY();
                float abs = Math.abs(x - EmotionEditLayout.this.f19615g);
                float abs2 = Math.abs(y - EmotionEditLayout.this.f19616h);
                if (abs < EmotionEditLayout.this.f19614f && abs2 < EmotionEditLayout.this.f19614f && System.currentTimeMillis() - EmotionEditLayout.this.f19617i < 300) {
                    this.f19618a.u();
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(view.getLeft(), view.getTop(), 0, 0);
                this.f19618a.setLayoutParams(layoutParams);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            boolean z = view == this.f19618a;
            if (view instanceof ImageView) {
                this.f19618a.m();
            }
            return z;
        }
    }

    public EmotionEditLayout(Context context) {
        this(context, null);
    }

    public void h(EmotionEditText emotionEditText) {
        this.f19613e = ViewDragHelper.create(this, 1.0f, new a(emotionEditText));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 3 && actionMasked != 1) {
            return this.f19613e.shouldInterceptTouchEvent(motionEvent);
        }
        this.f19613e.cancel();
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f19613e.processTouchEvent(motionEvent);
        return true;
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19614f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
