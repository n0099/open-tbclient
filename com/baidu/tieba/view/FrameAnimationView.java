package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.widget.TbImageView;
import d.a.c.e.l.d;
import d.a.c.e.m.e;
import d.a.c.e.p.k;
import java.util.List;
/* loaded from: classes5.dex */
public class FrameAnimationView extends TbImageView {
    public int B0;
    public Bitmap C0;
    public Rect D0;
    public Rect E0;
    public List<String> F0;
    public int G0;
    public boolean H0;
    public BdUniqueId I0;
    public Runnable J0;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a().removeCallbacks(FrameAnimationView.this.J0);
            if (FrameAnimationView.this.F0 != null) {
                FrameAnimationView.this.e0();
            }
        }
    }

    public FrameAnimationView(Context context) {
        super(context);
        this.B0 = 0;
        this.D0 = new Rect();
        this.E0 = new Rect();
        this.J0 = new a();
    }

    private Bitmap getFrameBitmap() {
        List<String> list = this.F0;
        if (list == null) {
            return null;
        }
        if (this.B0 >= list.size()) {
            this.B0 = 0;
        }
        String frameUrl = getFrameUrl();
        this.B0++;
        if (!k.isEmpty(frameUrl)) {
            d.a.c.k.d.a aVar = (d.a.c.k.d.a) d.h().n(frameUrl, 10, new Object[0]);
            if (aVar != null) {
                return aVar.p();
            }
            d.h().m(frameUrl, 10, null, this.I0);
        }
        return null;
    }

    private String getFrameUrl() {
        List<String> list = this.F0;
        if (list == null) {
            return null;
        }
        return list.get(this.B0);
    }

    public final void e0() {
        if (this.F0 == null) {
            return;
        }
        Bitmap frameBitmap = getFrameBitmap();
        if (frameBitmap != null && !frameBitmap.isRecycled()) {
            this.C0 = frameBitmap;
            this.D0.set(0, 0, frameBitmap.getWidth(), this.C0.getHeight());
        }
        invalidate();
        e.a().postDelayed(this.J0, this.G0);
    }

    public final boolean g0(List<String> list) {
        List<String> list2 = this.F0;
        if (list2 == null || list == null || list2.size() != list.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.F0.size(); i2++) {
            if (!this.F0.get(i2).equals(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public void h0() {
        if (this.F0 == null) {
            return;
        }
        e0();
    }

    public void i0() {
        e.a().removeCallbacks(this.J0);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.H0) {
            return;
        }
        h0();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i0();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        if (this.H0 || (bitmap = this.C0) == null || bitmap.isRecycled()) {
            return;
        }
        this.E0.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        canvas.drawBitmap(this.C0, this.D0, this.E0, (Paint) null);
    }

    public void setData(List<String> list, int i2) {
        if (list == null) {
            return;
        }
        this.H0 = false;
        this.G0 = i2;
        if (g0(list)) {
            return;
        }
        e.a().removeCallbacks(this.J0);
        this.F0 = list;
        this.B0 = 0;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setPageId(BdUniqueId bdUniqueId) {
        this.I0 = bdUniqueId;
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B0 = 0;
        this.D0 = new Rect();
        this.E0 = new Rect();
        this.J0 = new a();
    }

    public void setData(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        this.H0 = true;
        U(str, 10, false);
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.B0 = 0;
        this.D0 = new Rect();
        this.E0 = new Rect();
        this.J0 = new a();
    }
}
