package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bl extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    protected ProgressBar f2560a;
    protected k b;
    protected Context c;
    private bo d;
    private bn e;
    private boolean f;

    public void setCallback(bn bnVar) {
        this.e = bnVar;
    }

    public bl(Context context) {
        super(context);
        this.f2560a = null;
        this.b = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.f = false;
        this.c = context;
        a();
    }

    public k getImageView() {
        return this.b;
    }

    public void setGifSetListener(o oVar) {
        this.b.setGifSetListener(oVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.b.setImageOnClickListener(onClickListener);
    }

    public void setOnSizeChangedListener(p pVar) {
        this.b.setOnSizeChangedListener(pVar);
    }

    protected void a() {
        this.b = new k(this.c);
        this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.b);
        this.f2560a = new ProgressBar(this.c, null, 16843399);
        this.f2560a.setIndeterminateDrawable(this.c.getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f2560a.setLayoutParams(layoutParams);
        this.f2560a.setIndeterminate(true);
        addView(this.f2560a);
    }

    public void a(String str, boolean z) {
        this.b.setTag(str);
        UtilHelper.NetworkStateInfo i = UtilHelper.i(getContext());
        if (i == UtilHelper.NetworkStateInfo.WIFI || i == UtilHelper.NetworkStateInfo.ThreeG) {
            if (this.d != null) {
                this.d.cancel();
            }
            if (str != null) {
                this.d = new bo(this, str, z);
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
        this.f2560a.setVisibility(8);
    }

    public void d() {
        b();
        if (this.b != null) {
            this.b.k();
        }
        this.f2560a.setVisibility(8);
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
                    this.d = new bo(this, str, z);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageType() == 2) {
                if (UtilHelper.i(getContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.d = new bo(this, str, z);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageBitmap() == null) {
                this.d = new bo(this, str, z);
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
