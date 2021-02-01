package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class TTRatingBar extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f6779a;

    /* renamed from: b  reason: collision with root package name */
    private int f6780b;
    private int c;
    private float d;
    private float e;
    private float f;
    private Drawable g;
    private Drawable h;
    private Drawable i;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6779a = 5;
        this.f6780b = 0;
        this.c = 0;
        setOrientation(0);
        this.g = ac.c(context, "tt_star_empty_bg");
        this.h = ac.c(context, "tt_star_full_bg");
        this.i = ac.c(context, "tt_star_empty_bg");
        this.d = ak.c(context, 15.0f);
        this.e = ak.c(context, 15.0f);
        this.f = ak.c(context, 5.0f);
    }

    public int getStarFillNum() {
        return this.f6779a;
    }

    public void setStarFillNum(int i) {
        this.f6779a = i;
    }

    public int getStarHalfNum() {
        return this.f6780b;
    }

    public void setStarHalfNum(int i) {
        this.f6780b = i;
    }

    public int getStarEmptyNum() {
        return this.c;
    }

    public void setStarEmptyNum(int i) {
        this.c = i;
    }

    public float getStarImageWidth() {
        return this.d;
    }

    public void setStarImageWidth(float f) {
        this.d = f;
    }

    public float getStarImageHeight() {
        return this.e;
    }

    public void setStarImageHeight(float f) {
        this.e = f;
    }

    public float getStarImagePadding() {
        return this.f;
    }

    public void setStarImagePadding(float f) {
        this.f = f;
    }

    public Drawable getStarEmptyDrawable() {
        return this.g;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.g = drawable;
    }

    public Drawable getStarFillDrawable() {
        return this.h;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.h = drawable;
    }

    public Drawable getStarHalfDrawable() {
        return this.i;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.i = drawable;
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

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.d), Math.round(this.e)));
        imageView.setPadding(0, 0, Math.round(this.f), 0);
        return imageView;
    }
}
