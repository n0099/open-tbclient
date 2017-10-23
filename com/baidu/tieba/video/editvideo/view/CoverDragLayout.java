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
    private float ceZ;
    private float eNZ;
    private float eOa;
    private long eOb;
    private ViewDragHelper mDragHelper;

    public CoverDragLayout(Context context) {
        this(context, null);
    }

    public CoverDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverDragLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ceZ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void a(final b bVar, final View view) {
        this.mDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() { // from class: com.baidu.tieba.video.editvideo.view.CoverDragLayout.1
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view2, int i) {
                boolean z = view2 == view;
                if (!z) {
                    bVar.beQ();
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
                    CoverDragLayout.this.eOb = System.currentTimeMillis();
                    CoverDragLayout.this.eNZ = view2.getX();
                    CoverDragLayout.this.eOa = view2.getY();
                    bVar.beQ();
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewReleased(View view2, float f, float f2) {
                super.onViewReleased(view2, f, f2);
                if (view2 == view) {
                    float x = view2.getX();
                    float y = view2.getY();
                    float abs = Math.abs(x - CoverDragLayout.this.eNZ);
                    float abs2 = Math.abs(y - CoverDragLayout.this.eOa);
                    if (abs < CoverDragLayout.this.ceZ && abs2 < CoverDragLayout.this.ceZ && System.currentTimeMillis() - CoverDragLayout.this.eOb < 300) {
                        bVar.bwb();
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
