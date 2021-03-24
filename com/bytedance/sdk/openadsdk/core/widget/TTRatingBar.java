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
    public int f28842a;

    /* renamed from: b  reason: collision with root package name */
    public int f28843b;

    /* renamed from: c  reason: collision with root package name */
    public int f28844c;

    /* renamed from: d  reason: collision with root package name */
    public float f28845d;

    /* renamed from: e  reason: collision with root package name */
    public float f28846e;

    /* renamed from: f  reason: collision with root package name */
    public float f28847f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f28848g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f28849h;
    public Drawable i;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28842a = 5;
        this.f28843b = 0;
        this.f28844c = 0;
        setOrientation(0);
        this.f28848g = ad.c(context, "tt_star_empty_bg");
        this.f28849h = ad.c(context, "tt_star_full_bg");
        this.i = ad.c(context, "tt_star_empty_bg");
        this.f28845d = al.c(context, 15.0f);
        this.f28846e = al.c(context, 15.0f);
        this.f28847f = al.c(context, 5.0f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f28845d), Math.round(this.f28846e)));
        imageView.setPadding(0, 0, Math.round(this.f28847f), 0);
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
        return this.f28848g;
    }

    public int getStarEmptyNum() {
        return this.f28844c;
    }

    public Drawable getStarFillDrawable() {
        return this.f28849h;
    }

    public int getStarFillNum() {
        return this.f28842a;
    }

    public Drawable getStarHalfDrawable() {
        return this.i;
    }

    public int getStarHalfNum() {
        return this.f28843b;
    }

    public float getStarImageHeight() {
        return this.f28846e;
    }

    public float getStarImagePadding() {
        return this.f28847f;
    }

    public float getStarImageWidth() {
        return this.f28845d;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f28848g = drawable;
    }

    public void setStarEmptyNum(int i) {
        this.f28844c = i;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f28849h = drawable;
    }

    public void setStarFillNum(int i) {
        this.f28842a = i;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.i = drawable;
    }

    public void setStarHalfNum(int i) {
        this.f28843b = i;
    }

    public void setStarImageHeight(float f2) {
        this.f28846e = f2;
    }

    public void setStarImagePadding(float f2) {
        this.f28847f = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f28845d = f2;
    }
}
