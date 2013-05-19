package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ap extends RelativeLayout {
    protected ProgressBar a;
    protected g b;
    protected Context c;
    private ar d;
    private aq e;

    public void setCallback(aq aqVar) {
        this.e = aqVar;
    }

    public ap(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.c = context;
        a();
    }

    public g getImageView() {
        return this.b;
    }

    public void setGifSetListener(k kVar) {
        this.b.setGifSetListener(kVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.b.setImageOnClickListener(onClickListener);
    }

    public void setOnSizeChangedListener(l lVar) {
        this.b.setOnSizeChangedListener(lVar);
    }

    protected void a() {
        this.b = new g(this.c);
        this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.b);
        this.a = new ProgressBar(this.c, null, 16843399);
        this.a.setIndeterminateDrawable(this.c.getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.a.setLayoutParams(layoutParams);
        this.a.setIndeterminate(true);
        addView(this.a);
    }

    public void setUrl(String str) {
        this.b.setTag(str);
        com.baidu.tieba.d.z c = com.baidu.tieba.d.w.c(getContext());
        if (c == com.baidu.tieba.d.z.WIFI || c == com.baidu.tieba.d.z.ThreeG) {
            if (this.d != null) {
                this.d.cancel();
            }
            if (str != null) {
                this.d = new ar(this, str);
                this.d.execute(new String[0]);
            }
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.b.setGifMaxUseableMem(i);
    }

    public void b() {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
    }

    public void c() {
        b();
        if (this.b != null) {
            this.b.j();
        }
        this.a.setVisibility(8);
    }

    public void d() {
        b();
        if (this.b != null) {
            this.b.k();
        }
        this.a.setVisibility(8);
    }

    public void e() {
        if (this.b != null && this.b.getImageType() == 1) {
            this.b.g();
        }
    }

    public void f() {
        String str;
        if (this.b != null && (str = (String) this.b.getTag()) != null && this.b != null && this.d == null) {
            if (this.b.getImageType() == 1) {
                if (this.b.getGifCache() == null) {
                    this.d = new ar(this, str);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageType() == 2) {
                if (com.baidu.tieba.d.w.a(getContext()) != com.baidu.tieba.d.y.UNAVAIL) {
                    this.d = new ar(this, str);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageBitmap() == null) {
                this.d = new ar(this, str);
                this.d.execute(new String[0]);
            }
        }
    }

    public int getImageType() {
        if (this.b != null) {
            return this.b.getImageType();
        }
        return 0;
    }
}
