package com.baidu.tieba.pb.pb.main.emotion.view;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class EmotionEditLayout extends FrameLayout {
    private float cmM;
    private float eXo;
    private float eXp;
    private long eXq;
    private ViewDragHelper mDragHelper;

    public EmotionEditLayout(Context context) {
        this(context, null);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cmM = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void a(final b bVar) {
        this.mDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.EmotionEditLayout.1
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                boolean z = view == bVar;
                if (view instanceof ImageView) {
                    bVar.aVU();
                }
                return z;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return Math.min(Math.max(i, EmotionEditLayout.this.getPaddingLeft()), EmotionEditLayout.this.getWidth() - bVar.getWidth());
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return Math.min(Math.max(i, EmotionEditLayout.this.getPaddingTop()), EmotionEditLayout.this.getHeight() - bVar.getHeight());
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewCaptured(View view, int i) {
                super.onViewCaptured(view, i);
                if (view instanceof b) {
                    EmotionEditLayout.this.eXq = System.currentTimeMillis();
                    EmotionEditLayout.this.eXo = view.getX();
                    EmotionEditLayout.this.eXp = view.getY();
                    bVar.aVU();
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                if (view instanceof b) {
                    float x = view.getX();
                    float y = view.getY();
                    float abs = Math.abs(x - EmotionEditLayout.this.eXo);
                    float abs2 = Math.abs(y - EmotionEditLayout.this.eXp);
                    if (abs < EmotionEditLayout.this.cmM && abs2 < EmotionEditLayout.this.cmM && System.currentTimeMillis() - EmotionEditLayout.this.eXq < 300) {
                        bVar.aVV();
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(view.getLeft(), view.getTop(), 0, 0);
                    bVar.setLayoutParams(layoutParams);
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
