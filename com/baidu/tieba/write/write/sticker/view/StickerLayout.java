package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.h0.z0.h;
import d.b.i0.v3.v.n.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class StickerLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f22277e;

    /* renamed from: f  reason: collision with root package name */
    public List<StickerView> f22278f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout.LayoutParams f22279g;

    /* renamed from: h  reason: collision with root package name */
    public int f22280h;

    /* loaded from: classes5.dex */
    public class a implements d.b.i0.v3.v.n.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StickerView f22281a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f22282b;

        public a(StickerView stickerView, c cVar) {
            this.f22281a = stickerView;
            this.f22282b = cVar;
        }

        @Override // d.b.i0.v3.v.n.b.a
        public void a() {
            StickerLayout.this.removeView(this.f22281a);
            StickerLayout.this.f22278f.remove(this.f22281a);
            StickerLayout.this.e();
            c cVar = this.f22282b;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // d.b.i0.v3.v.n.b.a
        public void b(StickerView stickerView) {
        }

        @Override // d.b.i0.v3.v.n.b.a
        public void c(StickerView stickerView, boolean z) {
            stickerView.setEdit(z);
            if (z) {
                stickerView.bringToFront();
            }
        }

        @Override // d.b.i0.v3.v.n.b.a
        public void d(StickerView stickerView) {
        }
    }

    public StickerLayout(Context context) {
        this(context, null);
    }

    public StickerView b(Bitmap bitmap, c cVar) {
        StickerView stickerView = new StickerView(this.f22277e);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.f22279g);
        stickerView.setmOnStickerActionListener(new a(stickerView, cVar));
        addView(stickerView);
        this.f22278f.add(stickerView);
        e();
        if (cVar != null) {
            cVar.d();
        }
        return stickerView;
    }

    public Bitmap c() {
        if (ListUtils.isEmpty(this.f22278f)) {
            return null;
        }
        e();
        return h.a(this);
    }

    public final void d(Context context) {
        this.f22277e = context;
        this.f22278f = new ArrayList();
        this.f22279g = new FrameLayout.LayoutParams(-1, -1);
    }

    public void e() {
        if (this.f22278f.size() <= 0) {
            return;
        }
        for (StickerView stickerView : this.f22278f) {
            if (stickerView != null) {
                stickerView.setRemoveRes(this.f22280h);
                stickerView.setEdit(false);
            }
        }
    }

    public void f(c cVar) {
        Iterator<StickerView> it = this.f22278f.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                e();
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
    }

    public List<StickerView> getStickerViews() {
        return this.f22278f;
    }

    public void setRemoveRes(int i) {
        this.f22280h = i;
    }

    public StickerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(context);
    }
}
