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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class AdStarRatingBar extends FrameLayout {
    private TextView mRatingText;
    private AppCompatRatingBar mYw;

    public AdStarRatingBar(@NonNull Context context) {
        this(context, null);
    }

    public AdStarRatingBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdStarRatingBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    protected void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ad_star_rating_bar, this);
        this.mYw = (AppCompatRatingBar) findViewById(R.id.ad_rating_bar);
        this.mRatingText = (TextView) findViewById(R.id.ad_rating_text);
        int intrinsicHeight = ContextCompat.getDrawable(getContext(), R.drawable.icon_rating_bar_star_selected).getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams = this.mYw.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = intrinsicHeight;
        this.mYw.setLayoutParams(layoutParams);
    }

    public void setRating(float f) {
        if (f >= 0.0f) {
            this.mRatingText.setText(String.valueOf(f));
            this.mYw.setRating(f);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mRatingText, R.color.CAM_X0109);
    }
}
