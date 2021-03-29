package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.h0.z0.h;
import d.b.i0.u3.v.n.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class StickerLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f22592e;

    /* renamed from: f  reason: collision with root package name */
    public List<StickerView> f22593f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout.LayoutParams f22594g;

    /* renamed from: h  reason: collision with root package name */
    public int f22595h;

    /* loaded from: classes5.dex */
    public class a implements d.b.i0.u3.v.n.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StickerView f22596a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f22597b;

        public a(StickerView stickerView, c cVar) {
            this.f22596a = stickerView;
            this.f22597b = cVar;
        }

        @Override // d.b.i0.u3.v.n.b.a
        public void a() {
            StickerLayout.this.removeView(this.f22596a);
            StickerLayout.this.f22593f.remove(this.f22596a);
            StickerLayout.this.e();
            c cVar = this.f22597b;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // d.b.i0.u3.v.n.b.a
        public void b(StickerView stickerView) {
        }

        @Override // d.b.i0.u3.v.n.b.a
        public void c(StickerView stickerView, boolean z) {
            stickerView.setEdit(z);
            if (z) {
                stickerView.bringToFront();
            }
        }

        @Override // d.b.i0.u3.v.n.b.a
        public void d(StickerView stickerView) {
        }
    }

    public StickerLayout(Context context) {
        this(context, null);
    }

    public StickerView b(Bitmap bitmap, c cVar) {
        StickerView stickerView = new StickerView(this.f22592e);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.f22594g);
        stickerView.setmOnStickerActionListener(new a(stickerView, cVar));
        addView(stickerView);
        this.f22593f.add(stickerView);
        e();
        if (cVar != null) {
            cVar.d();
        }
        return stickerView;
    }

    public Bitmap c() {
        if (ListUtils.isEmpty(this.f22593f)) {
            return null;
        }
        e();
        return h.a(this);
    }

    public final void d(Context context) {
        this.f22592e = context;
        this.f22593f = new ArrayList();
        this.f22594g = new FrameLayout.LayoutParams(-1, -1);
    }

    public void e() {
        if (this.f22593f.size() <= 0) {
            return;
        }
        for (StickerView stickerView : this.f22593f) {
            if (stickerView != null) {
                stickerView.setRemoveRes(this.f22595h);
                stickerView.setEdit(false);
            }
        }
    }

    public void f(c cVar) {
        Iterator<StickerView> it = this.f22593f.iterator();
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
        return this.f22593f;
    }

    public void setRemoveRes(int i) {
        this.f22595h = i;
    }

    public StickerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(context);
    }
}
