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
    public ViewDragHelper f19893e;

    /* renamed from: f  reason: collision with root package name */
    public float f19894f;

    /* renamed from: g  reason: collision with root package name */
    public float f19895g;

    /* renamed from: h  reason: collision with root package name */
    public float f19896h;
    public long i;

    /* loaded from: classes3.dex */
    public class a extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionEditText f19897a;

        public a(EmotionEditText emotionEditText) {
            this.f19897a = emotionEditText;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return Math.min(Math.max(i, EmotionEditLayout.this.getPaddingLeft()), EmotionEditLayout.this.getWidth() - this.f19897a.getWidth());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return Math.min(Math.max(i, EmotionEditLayout.this.getPaddingTop()), EmotionEditLayout.this.getHeight() - this.f19897a.getHeight());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            super.onViewCaptured(view, i);
            if (view instanceof EmotionEditText) {
                EmotionEditLayout.this.i = System.currentTimeMillis();
                EmotionEditLayout.this.f19895g = view.getX();
                EmotionEditLayout.this.f19896h = view.getY();
                this.f19897a.m();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            super.onViewReleased(view, f2, f3);
            if (view instanceof EmotionEditText) {
                float x = view.getX();
                float y = view.getY();
                float abs = Math.abs(x - EmotionEditLayout.this.f19895g);
                float abs2 = Math.abs(y - EmotionEditLayout.this.f19896h);
                if (abs < EmotionEditLayout.this.f19894f && abs2 < EmotionEditLayout.this.f19894f && System.currentTimeMillis() - EmotionEditLayout.this.i < 300) {
                    this.f19897a.u();
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(view.getLeft(), view.getTop(), 0, 0);
                this.f19897a.setLayoutParams(layoutParams);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            boolean z = view == this.f19897a;
            if (view instanceof ImageView) {
                this.f19897a.m();
            }
            return z;
        }
    }

    public EmotionEditLayout(Context context) {
        this(context, null);
    }

    public void h(EmotionEditText emotionEditText) {
        this.f19893e = ViewDragHelper.create(this, 1.0f, new a(emotionEditText));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 3 && actionMasked != 1) {
            return this.f19893e.shouldInterceptTouchEvent(motionEvent);
        }
        this.f19893e.cancel();
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f19893e.processTouchEvent(motionEvent);
        return true;
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19894f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
