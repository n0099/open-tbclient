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
    public int f28536a;

    /* renamed from: b  reason: collision with root package name */
    public int f28537b;

    /* renamed from: c  reason: collision with root package name */
    public int f28538c;

    /* renamed from: d  reason: collision with root package name */
    public float f28539d;

    /* renamed from: e  reason: collision with root package name */
    public float f28540e;

    /* renamed from: f  reason: collision with root package name */
    public float f28541f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f28542g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f28543h;
    public Drawable i;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28536a = 5;
        this.f28537b = 0;
        this.f28538c = 0;
        setOrientation(0);
        this.f28542g = ad.c(context, "tt_star_empty_bg");
        this.f28543h = ad.c(context, "tt_star_full_bg");
        this.i = ad.c(context, "tt_star_empty_bg");
        this.f28539d = al.c(context, 15.0f);
        this.f28540e = al.c(context, 15.0f);
        this.f28541f = al.c(context, 5.0f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f28539d), Math.round(this.f28540e)));
        imageView.setPadding(0, 0, Math.round(this.f28541f), 0);
        return imageView;
    }

    public void a() {
        removeAllViews();
        for (int i = 0; i < getStarFillNum(); i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getStarFillDrawable());
            addView(starImageView);
        }
        for (int i2 = 0; i2 < getStarHalfNum(); i2++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getStarHalfDrawable());
            addView(starImageView2);
        }
        for (int i3 = 0; i3 < getStarEmptyNum(); i3++) {
            ImageView starImageView3 = getStarImageView();
            starImageView3.setImageDrawable(getStarEmptyDrawable());
            addView(starImageView3);
        }
    }

    public Drawable getStarEmptyDrawable() {
        return this.f28542g;
    }

    public int getStarEmptyNum() {
        return this.f28538c;
    }

    public Drawable getStarFillDrawable() {
        return this.f28543h;
    }

    public int getStarFillNum() {
        return this.f28536a;
    }

    public Drawable getStarHalfDrawable() {
        return this.i;
    }

    public int getStarHalfNum() {
        return this.f28537b;
    }

    public float getStarImageHeight() {
        return this.f28540e;
    }

    public float getStarImagePadding() {
        return this.f28541f;
    }

    public float getStarImageWidth() {
        return this.f28539d;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f28542g = drawable;
    }

    public void setStarEmptyNum(int i) {
        this.f28538c = i;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f28543h = drawable;
    }

    public void setStarFillNum(int i) {
        this.f28536a = i;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.i = drawable;
    }

    public void setStarHalfNum(int i) {
        this.f28537b = i;
    }

    public void setStarImageHeight(float f2) {
        this.f28540e = f2;
    }

    public void setStarImagePadding(float f2) {
        this.f28541f = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f28539d = f2;
    }
}
