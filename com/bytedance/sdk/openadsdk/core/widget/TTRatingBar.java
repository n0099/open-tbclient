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
    public int f28528a;

    /* renamed from: b  reason: collision with root package name */
    public int f28529b;

    /* renamed from: c  reason: collision with root package name */
    public int f28530c;

    /* renamed from: d  reason: collision with root package name */
    public float f28531d;

    /* renamed from: e  reason: collision with root package name */
    public float f28532e;

    /* renamed from: f  reason: collision with root package name */
    public float f28533f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f28534g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f28535h;
    public Drawable i;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28528a = 5;
        this.f28529b = 0;
        this.f28530c = 0;
        setOrientation(0);
        this.f28534g = ad.c(context, "tt_star_empty_bg");
        this.f28535h = ad.c(context, "tt_star_full_bg");
        this.i = ad.c(context, "tt_star_empty_bg");
        this.f28531d = al.c(context, 15.0f);
        this.f28532e = al.c(context, 15.0f);
        this.f28533f = al.c(context, 5.0f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f28531d), Math.round(this.f28532e)));
        imageView.setPadding(0, 0, Math.round(this.f28533f), 0);
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
        return this.f28534g;
    }

    public int getStarEmptyNum() {
        return this.f28530c;
    }

    public Drawable getStarFillDrawable() {
        return this.f28535h;
    }

    public int getStarFillNum() {
        return this.f28528a;
    }

    public Drawable getStarHalfDrawable() {
        return this.i;
    }

    public int getStarHalfNum() {
        return this.f28529b;
    }

    public float getStarImageHeight() {
        return this.f28532e;
    }

    public float getStarImagePadding() {
        return this.f28533f;
    }

    public float getStarImageWidth() {
        return this.f28531d;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f28534g = drawable;
    }

    public void setStarEmptyNum(int i) {
        this.f28530c = i;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f28535h = drawable;
    }

    public void setStarFillNum(int i) {
        this.f28528a = i;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.i = drawable;
    }

    public void setStarHalfNum(int i) {
        this.f28529b = i;
    }

    public void setStarImageHeight(float f2) {
        this.f28532e = f2;
    }

    public void setStarImagePadding(float f2) {
        this.f28533f = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f28531d = f2;
    }
}
