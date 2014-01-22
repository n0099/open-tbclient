package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class cq extends RelativeLayout {
    protected ProgressBar a;
    protected u b;
    protected Context c;
    private ct d;
    private cs e;
    private boolean f;

    public void setCallback(cs csVar) {
        this.e = csVar;
    }

    public cq(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.f = false;
        this.c = context;
        a();
    }

    public u getImageView() {
        return this.b;
    }

    public void setGifSetListener(y yVar) {
        this.b.setGifSetListener(yVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.b.setImageOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b.setImageOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(z zVar) {
        this.b.setOnSizeChangedListener(zVar);
    }

    protected void a() {
        this.b = new u(this.c);
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

    public void a(String str, boolean z) {
        this.b.setTag(str);
        UtilHelper.NetworkStateInfo g = UtilHelper.g(getContext());
        if (g == UtilHelper.NetworkStateInfo.WIFI || g == UtilHelper.NetworkStateInfo.ThreeG) {
            if (this.d != null) {
                this.d.cancel();
            }
            if (str != null) {
                this.d = new ct(this, str, z);
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

    public void a(boolean z) {
        String str;
        if (this.b != null && (str = (String) this.b.getTag()) != null && this.b != null && this.d == null) {
            if (this.b.getImageType() == 1) {
                if (this.b.getGifCache() == null) {
                    this.d = new ct(this, str, z);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageType() == 2) {
                if (UtilHelper.g(getContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.d = new ct(this, str, z);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageBitmap() == null) {
                this.d = new ct(this, str, z);
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

    public void setIsCdn(boolean z) {
        this.f = z;
    }
}
