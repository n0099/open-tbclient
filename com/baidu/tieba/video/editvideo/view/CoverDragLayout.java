package com.baidu.tieba.video.editvideo.view;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class CoverDragLayout extends FrameLayout {
    private float cfl;
    private float eOn;
    private float eOo;
    private long eOp;
    private ViewDragHelper mDragHelper;

    public CoverDragLayout(Context context) {
        this(context, null);
    }

    public CoverDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverDragLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cfl = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void a(final b bVar, final View view) {
        this.mDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() { // from class: com.baidu.tieba.video.editvideo.view.CoverDragLayout.1
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view2, int i) {
                boolean z = view2 == view;
                if (!z) {
                    bVar.beW();
                }
                return z;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view2, int i, int i2) {
                return Math.min(Math.max(i, CoverDragLayout.this.getPaddingTop()), CoverDragLayout.this.getHeight() - view.getHeight());
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewCaptured(View view2, int i) {
                super.onViewCaptured(view2, i);
                if (view2 == view) {
                    CoverDragLayout.this.eOp = System.currentTimeMillis();
                    CoverDragLayout.this.eOn = view2.getX();
                    CoverDragLayout.this.eOo = view2.getY();
                    bVar.beW();
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewReleased(View view2, float f, float f2) {
                super.onViewReleased(view2, f, f2);
                if (view2 == view) {
                    float x = view2.getX();
                    float y = view2.getY();
                    float abs = Math.abs(x - CoverDragLayout.this.eOn);
                    float abs2 = Math.abs(y - CoverDragLayout.this.eOo);
                    if (abs < CoverDragLayout.this.cfl && abs2 < CoverDragLayout.this.cfl && System.currentTimeMillis() - CoverDragLayout.this.eOp < 300) {
                        bVar.bwk();
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(0, view2.getTop(), 0, 0);
                    view.setLayoutParams(layoutParams);
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
