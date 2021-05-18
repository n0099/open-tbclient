package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.core.content.ContextCompat;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class AdStarRatingBar extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public AppCompatRatingBar f20333e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20334f;

    /* renamed from: g  reason: collision with root package name */
    public int f20335g;

    public AdStarRatingBar(@NonNull Context context) {
        this(context, null);
    }

    public void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ad_star_rating_bar, this);
        this.f20333e = (AppCompatRatingBar) findViewById(R.id.ad_rating_bar);
        this.f20334f = (TextView) findViewById(R.id.ad_rating_text);
        int intrinsicHeight = ContextCompat.getDrawable(getContext(), R.drawable.icon_rating_bar_star_selected).getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams = this.f20333e.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = intrinsicHeight;
        this.f20333e.setLayoutParams(layoutParams);
        SkinManager.setViewTextColor(this.f20334f, this.f20335g);
    }

    public void onChangeSkinType() {
        SkinManager.setViewTextColor(this.f20334f, this.f20335g);
    }

    public void setRating(float f2) {
        if (f2 < 0.0f) {
            return;
        }
        this.f20334f.setText(String.valueOf(f2));
        this.f20333e.setRating(f2);
    }

    public void setTextColor(int i2) {
        this.f20335g = i2;
        SkinManager.setViewTextColor(this.f20334f, i2);
        postInvalidate();
    }

    public AdStarRatingBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdStarRatingBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20335g = R.color.CAM_X0109;
        a();
    }
}
