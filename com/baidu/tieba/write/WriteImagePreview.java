package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class WriteImagePreview extends FrameLayout {
    protected Context a;
    protected ImageView b;
    protected ProgressBar c;
    protected Bitmap d;
    protected bc e;
    protected com.baidu.tieba.editortool.h f;
    protected Handler g;
    protected Runnable h;
    private boolean i;

    public WriteImagePreview(Context context) {
        super(context);
        this.i = false;
        this.a = context;
        a();
    }

    public WriteImagePreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = false;
        this.a = context;
        a();
    }

    protected void a() {
        LayoutInflater.from(this.a).inflate(R.layout.write_image_preview, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(R.id.image);
        this.c = (ProgressBar) findViewById(R.id.image_progress);
        this.g = new Handler();
        this.h = new ba(this);
    }

    public void setOnActionListener(com.baidu.tieba.editortool.h hVar) {
        this.f = hVar;
        this.b.setOnClickListener(new bb(this, hVar));
    }

    public void a(String str) {
        d();
        this.e = new bc(this, str);
        this.e.execute(new Object[0]);
        this.g.removeCallbacks(this.h);
        this.g.postDelayed(this.h, 10000L);
    }

    public boolean b() {
        return this.i;
    }

    public void c() {
        if (this.e != null) {
            this.e.cancel();
        }
        this.e = null;
        this.g.removeCallbacks(this.h);
        this.c.setVisibility(8);
        this.b.setVisibility(8);
        if (this.d != null && !this.d.isRecycled()) {
            this.d.recycle();
        }
        this.d = null;
        g();
        this.i = false;
    }

    protected void d() {
        if (this.e != null) {
            this.e.cancel();
        }
        this.b.setVisibility(8);
        this.b.setImageBitmap(null);
        h();
        if (this.d != null && !this.d.isRecycled()) {
            this.d.recycle();
        }
        this.d = null;
        this.c.setVisibility(0);
        if (this.f != null) {
            this.f.a(32, null);
        }
        this.i = true;
    }

    public void e() {
        this.d = null;
        this.b.setVisibility(8);
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bitmap bitmap) {
        this.e = null;
        this.c.setVisibility(8);
        this.i = false;
        this.g.removeCallbacks(this.h);
        if (bitmap != null) {
            this.d = bitmap;
            this.b.setImageBitmap(this.d);
            this.b.setVisibility(0);
            if (this.f != null) {
                this.f.a(30, null);
                return;
            }
            return;
        }
        this.b.setVisibility(8);
        g();
        if (this.d != null && !this.d.isRecycled()) {
            this.d.recycle();
        }
        this.d = null;
        if (this.f != null) {
            this.f.a(29, null);
        }
    }

    public boolean f() {
        return this.d != null;
    }

    public void g() {
        setVisibility(8);
    }

    public void h() {
        setVisibility(0);
    }
}
