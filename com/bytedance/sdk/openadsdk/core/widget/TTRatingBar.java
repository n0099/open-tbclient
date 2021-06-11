package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes6.dex */
public class TTRatingBar extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f28688a;

    /* renamed from: b  reason: collision with root package name */
    public int f28689b;

    /* renamed from: c  reason: collision with root package name */
    public int f28690c;

    /* renamed from: d  reason: collision with root package name */
    public float f28691d;

    /* renamed from: e  reason: collision with root package name */
    public float f28692e;

    /* renamed from: f  reason: collision with root package name */
    public float f28693f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f28694g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f28695h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f28696i;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28688a = 5;
        this.f28689b = 0;
        this.f28690c = 0;
        setOrientation(0);
        this.f28694g = ad.c(context, "tt_star_empty_bg");
        this.f28695h = ad.c(context, "tt_star_full_bg");
        this.f28696i = ad.c(context, "tt_star_empty_bg");
        this.f28691d = al.c(context, 15.0f);
        this.f28692e = al.c(context, 15.0f);
        this.f28693f = al.c(context, 5.0f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f28691d), Math.round(this.f28692e)));
        imageView.setPadding(0, 0, Math.round(this.f28693f), 0);
        return imageView;
    }

    public void a() {
        removeAllViews();
        for (int i2 = 0; i2 < getStarFillNum(); i2++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getStarFillDrawable());
            addView(starImageView);
        }
        for (int i3 = 0; i3 < getStarHalfNum(); i3++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getStarHalfDrawable());
            addView(starImageView2);
        }
        for (int i4 = 0; i4 < getStarEmptyNum(); i4++) {
            ImageView starImageView3 = getStarImageView();
            starImageView3.setImageDrawable(getStarEmptyDrawable());
            addView(starImageView3);
        }
    }

    public Drawable getStarEmptyDrawable() {
        return this.f28694g;
    }

    public int getStarEmptyNum() {
        return this.f28690c;
    }

    public Drawable getStarFillDrawable() {
        return this.f28695h;
    }

    public int getStarFillNum() {
        return this.f28688a;
    }

    public Drawable getStarHalfDrawable() {
        return this.f28696i;
    }

    public int getStarHalfNum() {
        return this.f28689b;
    }

    public float getStarImageHeight() {
        return this.f28692e;
    }

    public float getStarImagePadding() {
        return this.f28693f;
    }

    public float getStarImageWidth() {
        return this.f28691d;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f28694g = drawable;
    }

    public void setStarEmptyNum(int i2) {
        this.f28690c = i2;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f28695h = drawable;
    }

    public void setStarFillNum(int i2) {
        this.f28688a = i2;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.f28696i = drawable;
    }

    public void setStarHalfNum(int i2) {
        this.f28689b = i2;
    }

    public void setStarImageHeight(float f2) {
        this.f28692e = f2;
    }

    public void setStarImagePadding(float f2) {
        this.f28693f = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f28691d = f2;
    }
}
