package com.baidu.tieba.newfaceshop.facemake;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class FaceImageLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f19242e;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public FaceImageLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f19242e;
        if (aVar != null) {
            aVar.a();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(a aVar) {
        this.f19242e = aVar;
    }

    public FaceImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FaceImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
