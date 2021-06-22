package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.n0.z0.h;
import d.a.o0.w3.u.n.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class StickerLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f22334e;

    /* renamed from: f  reason: collision with root package name */
    public List<StickerView> f22335f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout.LayoutParams f22336g;

    /* renamed from: h  reason: collision with root package name */
    public int f22337h;

    /* loaded from: classes5.dex */
    public class a implements d.a.o0.w3.u.n.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StickerView f22338a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f22339b;

        public a(StickerView stickerView, c cVar) {
            this.f22338a = stickerView;
            this.f22339b = cVar;
        }

        @Override // d.a.o0.w3.u.n.b.a
        public void a(StickerView stickerView) {
        }

        @Override // d.a.o0.w3.u.n.b.a
        public void b(StickerView stickerView, boolean z) {
            stickerView.setEdit(z);
            if (z) {
                stickerView.bringToFront();
            }
        }

        @Override // d.a.o0.w3.u.n.b.a
        public void c(StickerView stickerView) {
        }

        @Override // d.a.o0.w3.u.n.b.a
        public void onDelete() {
            StickerLayout.this.removeView(this.f22338a);
            StickerLayout.this.f22335f.remove(this.f22338a);
            StickerLayout.this.e();
            c cVar = this.f22339b;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public StickerLayout(Context context) {
        this(context, null);
    }

    public StickerView b(Bitmap bitmap, c cVar) {
        StickerView stickerView = new StickerView(this.f22334e);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.f22336g);
        stickerView.setmOnStickerActionListener(new a(stickerView, cVar));
        addView(stickerView);
        this.f22335f.add(stickerView);
        e();
        if (cVar != null) {
            cVar.d();
        }
        return stickerView;
    }

    public Bitmap c() {
        if (ListUtils.isEmpty(this.f22335f)) {
            return null;
        }
        e();
        return h.a(this);
    }

    public final void d(Context context) {
        this.f22334e = context;
        this.f22335f = new ArrayList();
        this.f22336g = new FrameLayout.LayoutParams(-1, -1);
    }

    public void e() {
        if (this.f22335f.size() <= 0) {
            return;
        }
        for (StickerView stickerView : this.f22335f) {
            if (stickerView != null) {
                stickerView.setRemoveRes(this.f22337h);
                stickerView.setEdit(false);
            }
        }
    }

    public void f(c cVar) {
        Iterator<StickerView> it = this.f22335f.iterator();
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
        return this.f22335f;
    }

    public void setRemoveRes(int i2) {
        this.f22337h = i2;
    }

    public StickerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d(context);
    }
}
