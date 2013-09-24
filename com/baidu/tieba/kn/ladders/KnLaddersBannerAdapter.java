package com.baidu.tieba.kn.ladders;

import android.content.Context;
import android.support.v4.view.ae;
import android.support.v4.view.bn;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.kn.ladders.KnLaddersModel;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class KnLaddersBannerAdapter extends ae {

    /* renamed from: a  reason: collision with root package name */
    private KnLaddersModel.Pic[] f1241a;
    private com.baidu.tieba.util.a b;
    private ImageView[] c;

    public KnLaddersBannerAdapter(Context context, KnLaddersModel.Pic[] picArr) {
        this.f1241a = picArr;
        this.c = new ImageView[this.f1241a.length + 2];
        this.b = new com.baidu.tieba.util.a(context);
        this.b.a(this.b.f1889a.getResources().getDisplayMetrics().widthPixels, UtilHelper.a(this.b.f1889a, 210.0f));
    }

    @Override // android.support.v4.view.ae
    public final int getCount() {
        if (this.f1241a.length == 0) {
            return 0;
        }
        return this.f1241a.length + 2;
    }

    @Override // android.support.v4.view.ae
    public final boolean isViewFromObject(View view, Object obj) {
        return obj.equals(view);
    }

    public final void a() {
        ImageView[] imageViewArr;
        for (ImageView imageView : this.c) {
            if (imageView != null) {
                imageView.setImageBitmap(null);
            }
        }
    }

    public final void b() {
        int i;
        int i2 = 0;
        while (i2 < this.c.length) {
            ImageView imageView = this.c[i2];
            if (imageView != null) {
                if (i2 == 0) {
                    i = this.f1241a.length - 1;
                } else {
                    i = i2 == getCount() + (-1) ? 0 : i2 - 1;
                }
                com.baidu.adp.widget.a.c a2 = this.b.a(this.f1241a[i].pic_url, new i(this, i, imageView));
                if (a2 != null) {
                    imageView.setImageBitmap(a2.f());
                    imageView.invalidate();
                }
            }
            i2++;
        }
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int i2;
        this.c[i] = new ImageView(viewGroup.getContext());
        this.c[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.c[i].setClickable(true);
        if (i == 0) {
            i2 = this.f1241a.length - 1;
        } else if (i == getCount() - 1) {
            i2 = 0;
        } else {
            i2 = i - 1;
        }
        com.baidu.adp.widget.a.c a2 = this.b.a(this.f1241a[i2].pic_url, new j(this, i2, i));
        if (a2 != null) {
            this.c[i].setImageBitmap(a2.f());
            this.c[i].invalidate();
        }
        this.c[i].setOnClickListener(new k(this, i2));
        viewGroup.addView(this.c[i], new bn());
        return this.c[i];
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
