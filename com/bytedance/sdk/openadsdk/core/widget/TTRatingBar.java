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
    public int f28656a;

    /* renamed from: b  reason: collision with root package name */
    public int f28657b;

    /* renamed from: c  reason: collision with root package name */
    public int f28658c;

    /* renamed from: d  reason: collision with root package name */
    public float f28659d;

    /* renamed from: e  reason: collision with root package name */
    public float f28660e;

    /* renamed from: f  reason: collision with root package name */
    public float f28661f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f28662g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f28663h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f28664i;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28656a = 5;
        this.f28657b = 0;
        this.f28658c = 0;
        setOrientation(0);
        this.f28662g = ad.c(context, "tt_star_empty_bg");
        this.f28663h = ad.c(context, "tt_star_full_bg");
        this.f28664i = ad.c(context, "tt_star_empty_bg");
        this.f28659d = al.c(context, 15.0f);
        this.f28660e = al.c(context, 15.0f);
        this.f28661f = al.c(context, 5.0f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f28659d), Math.round(this.f28660e)));
        imageView.setPadding(0, 0, Math.round(this.f28661f), 0);
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
        return this.f28662g;
    }

    public int getStarEmptyNum() {
        return this.f28658c;
    }

    public Drawable getStarFillDrawable() {
        return this.f28663h;
    }

    public int getStarFillNum() {
        return this.f28656a;
    }

    public Drawable getStarHalfDrawable() {
        return this.f28664i;
    }

    public int getStarHalfNum() {
        return this.f28657b;
    }

    public float getStarImageHeight() {
        return this.f28660e;
    }

    public float getStarImagePadding() {
        return this.f28661f;
    }

    public float getStarImageWidth() {
        return this.f28659d;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f28662g = drawable;
    }

    public void setStarEmptyNum(int i2) {
        this.f28658c = i2;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f28663h = drawable;
    }

    public void setStarFillNum(int i2) {
        this.f28656a = i2;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.f28664i = drawable;
    }

    public void setStarHalfNum(int i2) {
        this.f28657b = i2;
    }

    public void setStarImageHeight(float f2) {
        this.f28660e = f2;
    }

    public void setStarImagePadding(float f2) {
        this.f28661f = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f28659d = f2;
    }
}
