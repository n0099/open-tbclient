package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ah extends RelativeLayout {
    protected ProgressBar a;
    protected f b;
    protected Context c;
    private aj d;
    private ai e;

    public void setCallback(ai aiVar) {
        this.e = aiVar;
    }

    public ah(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.c = context;
        a();
    }

    public f getImageView() {
        return this.b;
    }

    public void setGifSetListener(j jVar) {
        this.b.setGifSetListener(jVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.b.setImageOnClickListener(onClickListener);
    }

    public void setOnSizeChangedListener(k kVar) {
        this.b.setOnSizeChangedListener(kVar);
    }

    protected void a() {
        this.b = new f(this.c);
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
        com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(getContext());
        if (c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG) {
            if (this.d != null) {
                this.d.a();
            }
            if (str != null) {
                this.d = new aj(this, str);
                this.d.execute(new String[0]);
            }
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.b.setGifMaxUseableMem(i);
    }

    public void b() {
        if (this.d != null) {
            this.d.a();
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
                    this.d = new aj(this, str);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageType() == 2) {
                if (com.baidu.tieba.c.w.a(getContext()) != com.baidu.tieba.c.y.UNAVAIL) {
                    this.d = new aj(this, str);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageBitmap() == null) {
                this.d = new aj(this, str);
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
