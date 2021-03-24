package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.widget.TbImageView;
import d.b.b.e.l.d;
import d.b.b.e.m.e;
import d.b.b.e.p.k;
import java.util.List;
/* loaded from: classes5.dex */
public class FrameAnimationView extends TbImageView {
    public List<String> A0;
    public int B0;
    public boolean C0;
    public BdUniqueId D0;
    public Runnable E0;
    public int w0;
    public Bitmap x0;
    public Rect y0;
    public Rect z0;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a().removeCallbacks(FrameAnimationView.this.E0);
            if (FrameAnimationView.this.A0 != null) {
                FrameAnimationView.this.i0();
            }
        }
    }

    public FrameAnimationView(Context context) {
        super(context);
        this.w0 = 0;
        this.y0 = new Rect();
        this.z0 = new Rect();
        this.E0 = new a();
    }

    private Bitmap getFrameBitmap() {
        List<String> list = this.A0;
        if (list == null) {
            return null;
        }
        if (this.w0 >= list.size()) {
            this.w0 = 0;
        }
        String frameUrl = getFrameUrl();
        this.w0++;
        if (!k.isEmpty(frameUrl)) {
            d.b.b.j.d.a aVar = (d.b.b.j.d.a) d.h().n(frameUrl, 10, new Object[0]);
            if (aVar != null) {
                return aVar.p();
            }
            d.h().m(frameUrl, 10, null, this.D0);
        }
        return null;
    }

    private String getFrameUrl() {
        List<String> list = this.A0;
        if (list == null) {
            return null;
        }
        return list.get(this.w0);
    }

    public final void i0() {
        if (this.A0 == null) {
            return;
        }
        Bitmap frameBitmap = getFrameBitmap();
        if (frameBitmap != null && !frameBitmap.isRecycled()) {
            this.x0 = frameBitmap;
            this.y0.set(0, 0, frameBitmap.getWidth(), this.x0.getHeight());
        }
        invalidate();
        e.a().postDelayed(this.E0, this.B0);
    }

    public final boolean j0(List<String> list) {
        List<String> list2 = this.A0;
        if (list2 == null || list == null || list2.size() != list.size()) {
            return false;
        }
        for (int i = 0; i < this.A0.size(); i++) {
            if (!this.A0.get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void l0() {
        if (this.A0 == null) {
            return;
        }
        i0();
    }

    public void m0() {
        e.a().removeCallbacks(this.E0);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C0) {
            return;
        }
        l0();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m0();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        if (this.C0 || (bitmap = this.x0) == null || bitmap.isRecycled()) {
            return;
        }
        this.z0.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        canvas.drawBitmap(this.x0, this.y0, this.z0, (Paint) null);
    }

    public void setData(List<String> list, int i) {
        if (list == null) {
            return;
        }
        this.C0 = false;
        this.B0 = i;
        if (j0(list)) {
            return;
        }
        e.a().removeCallbacks(this.E0);
        this.A0 = list;
        this.w0 = 0;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setPageId(BdUniqueId bdUniqueId) {
        this.D0 = bdUniqueId;
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w0 = 0;
        this.y0 = new Rect();
        this.z0 = new Rect();
        this.E0 = new a();
    }

    public void setData(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        this.C0 = true;
        W(str, 10, false);
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w0 = 0;
        this.y0 = new Rect();
        this.z0 = new Rect();
        this.E0 = new a();
    }
}
