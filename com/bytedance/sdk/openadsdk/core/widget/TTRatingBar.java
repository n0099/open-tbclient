package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes5.dex */
public class TTRatingBar extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f29411a;

    /* renamed from: b  reason: collision with root package name */
    public int f29412b;

    /* renamed from: c  reason: collision with root package name */
    public int f29413c;

    /* renamed from: d  reason: collision with root package name */
    public float f29414d;

    /* renamed from: e  reason: collision with root package name */
    public float f29415e;

    /* renamed from: f  reason: collision with root package name */
    public float f29416f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f29417g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f29418h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f29419i;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29411a = 5;
        this.f29412b = 0;
        this.f29413c = 0;
        setOrientation(0);
        this.f29417g = ad.c(context, "tt_star_empty_bg");
        this.f29418h = ad.c(context, "tt_star_full_bg");
        this.f29419i = ad.c(context, "tt_star_empty_bg");
        this.f29414d = al.c(context, 15.0f);
        this.f29415e = al.c(context, 15.0f);
        this.f29416f = al.c(context, 5.0f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f29414d), Math.round(this.f29415e)));
        imageView.setPadding(0, 0, Math.round(this.f29416f), 0);
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
        return this.f29417g;
    }

    public int getStarEmptyNum() {
        return this.f29413c;
    }

    public Drawable getStarFillDrawable() {
        return this.f29418h;
    }

    public int getStarFillNum() {
        return this.f29411a;
    }

    public Drawable getStarHalfDrawable() {
        return this.f29419i;
    }

    public int getStarHalfNum() {
        return this.f29412b;
    }

    public float getStarImageHeight() {
        return this.f29415e;
    }

    public float getStarImagePadding() {
        return this.f29416f;
    }

    public float getStarImageWidth() {
        return this.f29414d;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f29417g = drawable;
    }

    public void setStarEmptyNum(int i2) {
        this.f29413c = i2;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f29418h = drawable;
    }

    public void setStarFillNum(int i2) {
        this.f29411a = i2;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.f29419i = drawable;
    }

    public void setStarHalfNum(int i2) {
        this.f29412b = i2;
    }

    public void setStarImageHeight(float f2) {
        this.f29415e = f2;
    }

    public void setStarImagePadding(float f2) {
        this.f29416f = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f29414d = f2;
    }
}
