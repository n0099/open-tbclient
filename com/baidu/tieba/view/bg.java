package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tieba.util.NetWorkCore;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bg extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    protected ProgressBar f1834a;
    protected j b;
    protected Context c;
    private bi d;
    private bh e;

    public void setCallback(bh bhVar) {
        this.e = bhVar;
    }

    public bg(Context context) {
        super(context);
        this.f1834a = null;
        this.b = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.c = context;
        a();
    }

    public j getImageView() {
        return this.b;
    }

    public void setGifSetListener(n nVar) {
        this.b.setGifSetListener(nVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.b.setImageOnClickListener(onClickListener);
    }

    public void setOnSizeChangedListener(o oVar) {
        this.b.setOnSizeChangedListener(oVar);
    }

    protected void a() {
        this.b = new j(this.c);
        this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.b);
        this.f1834a = new ProgressBar(this.c, null, 16843399);
        this.f1834a.setIndeterminateDrawable(this.c.getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f1834a.setLayoutParams(layoutParams);
        this.f1834a.setIndeterminate(true);
        addView(this.f1834a);
    }

    public void setUrl(String str) {
        this.b.setTag(str);
        NetWorkCore.NetworkStateInfo c = NetWorkCore.c(getContext());
        if (c == NetWorkCore.NetworkStateInfo.WIFI || c == NetWorkCore.NetworkStateInfo.ThreeG) {
            if (this.d != null) {
                this.d.cancel();
            }
            if (str != null) {
                this.d = new bi(this, str);
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
        this.f1834a.setVisibility(8);
    }

    public void d() {
        b();
        if (this.b != null) {
            this.b.k();
        }
        this.f1834a.setVisibility(8);
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
                    this.d = new bi(this, str);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageType() == 2) {
                if (NetWorkCore.a(getContext()) != NetWorkCore.NetworkState.UNAVAIL) {
                    this.d = new bi(this, str);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageBitmap() == null) {
                this.d = new bi(this, str);
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
