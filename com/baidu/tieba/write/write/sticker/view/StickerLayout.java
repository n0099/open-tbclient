package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.j0.z0.h;
import d.a.k0.v3.u.n.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class StickerLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f22220e;

    /* renamed from: f  reason: collision with root package name */
    public List<StickerView> f22221f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout.LayoutParams f22222g;

    /* renamed from: h  reason: collision with root package name */
    public int f22223h;

    /* loaded from: classes5.dex */
    public class a implements d.a.k0.v3.u.n.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StickerView f22224a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f22225b;

        public a(StickerView stickerView, c cVar) {
            this.f22224a = stickerView;
            this.f22225b = cVar;
        }

        @Override // d.a.k0.v3.u.n.b.a
        public void a(StickerView stickerView) {
        }

        @Override // d.a.k0.v3.u.n.b.a
        public void b(StickerView stickerView, boolean z) {
            stickerView.setEdit(z);
            if (z) {
                stickerView.bringToFront();
            }
        }

        @Override // d.a.k0.v3.u.n.b.a
        public void c(StickerView stickerView) {
        }

        @Override // d.a.k0.v3.u.n.b.a
        public void onDelete() {
            StickerLayout.this.removeView(this.f22224a);
            StickerLayout.this.f22221f.remove(this.f22224a);
            StickerLayout.this.e();
            c cVar = this.f22225b;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public StickerLayout(Context context) {
        this(context, null);
    }

    public StickerView b(Bitmap bitmap, c cVar) {
        StickerView stickerView = new StickerView(this.f22220e);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.f22222g);
        stickerView.setmOnStickerActionListener(new a(stickerView, cVar));
        addView(stickerView);
        this.f22221f.add(stickerView);
        e();
        if (cVar != null) {
            cVar.d();
        }
        return stickerView;
    }

    public Bitmap c() {
        if (ListUtils.isEmpty(this.f22221f)) {
            return null;
        }
        e();
        return h.a(this);
    }

    public final void d(Context context) {
        this.f22220e = context;
        this.f22221f = new ArrayList();
        this.f22222g = new FrameLayout.LayoutParams(-1, -1);
    }

    public void e() {
        if (this.f22221f.size() <= 0) {
            return;
        }
        for (StickerView stickerView : this.f22221f) {
            if (stickerView != null) {
                stickerView.setRemoveRes(this.f22223h);
                stickerView.setEdit(false);
            }
        }
    }

    public void f(c cVar) {
        Iterator<StickerView> it = this.f22221f.iterator();
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
        return this.f22221f;
    }

    public void setRemoveRes(int i2) {
        this.f22223h = i2;
    }

    public StickerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d(context);
    }
}
