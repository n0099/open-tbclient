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
    public int f28770a;

    /* renamed from: b  reason: collision with root package name */
    public int f28771b;

    /* renamed from: c  reason: collision with root package name */
    public int f28772c;

    /* renamed from: d  reason: collision with root package name */
    public float f28773d;

    /* renamed from: e  reason: collision with root package name */
    public float f28774e;

    /* renamed from: f  reason: collision with root package name */
    public float f28775f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f28776g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f28777h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f28778i;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28770a = 5;
        this.f28771b = 0;
        this.f28772c = 0;
        setOrientation(0);
        this.f28776g = ad.c(context, "tt_star_empty_bg");
        this.f28777h = ad.c(context, "tt_star_full_bg");
        this.f28778i = ad.c(context, "tt_star_empty_bg");
        this.f28773d = al.c(context, 15.0f);
        this.f28774e = al.c(context, 15.0f);
        this.f28775f = al.c(context, 5.0f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f28773d), Math.round(this.f28774e)));
        imageView.setPadding(0, 0, Math.round(this.f28775f), 0);
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
        return this.f28776g;
    }

    public int getStarEmptyNum() {
        return this.f28772c;
    }

    public Drawable getStarFillDrawable() {
        return this.f28777h;
    }

    public int getStarFillNum() {
        return this.f28770a;
    }

    public Drawable getStarHalfDrawable() {
        return this.f28778i;
    }

    public int getStarHalfNum() {
        return this.f28771b;
    }

    public float getStarImageHeight() {
        return this.f28774e;
    }

    public float getStarImagePadding() {
        return this.f28775f;
    }

    public float getStarImageWidth() {
        return this.f28773d;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f28776g = drawable;
    }

    public void setStarEmptyNum(int i2) {
        this.f28772c = i2;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f28777h = drawable;
    }

    public void setStarFillNum(int i2) {
        this.f28770a = i2;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.f28778i = drawable;
    }

    public void setStarHalfNum(int i2) {
        this.f28771b = i2;
    }

    public void setStarImageHeight(float f2) {
        this.f28774e = f2;
    }

    public void setStarImagePadding(float f2) {
        this.f28775f = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f28773d = f2;
    }
}
