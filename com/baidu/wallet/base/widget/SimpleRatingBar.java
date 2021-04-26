package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class SimpleRatingBar extends LinearLayout {
    public OnSimpleRatingBarChangeListener mChangeListener;
    public String mImageBackground;
    public String mImageStar;
    public int mMaxRate;
    public int mRate;
    public float mSeparationDP;
    public ArrayList<ImageView> mStars;
    public float mVerticalPaddingDP;

    /* loaded from: classes5.dex */
    public interface OnSimpleRatingBarChangeListener {
        void onRatingChanged(SimpleRatingBar simpleRatingBar, int i2, boolean z);
    }

    /* loaded from: classes5.dex */
    public class OnStarClickListener implements View.OnClickListener {
        public OnStarClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int indexOf = SimpleRatingBar.this.mStars.indexOf(view) + 1;
            SimpleRatingBar simpleRatingBar = SimpleRatingBar.this;
            if (indexOf == simpleRatingBar.mRate || indexOf <= 0 || indexOf > simpleRatingBar.mMaxRate) {
                return;
            }
            simpleRatingBar.setRate(indexOf, true);
        }
    }

    public SimpleRatingBar(Context context) {
        super(context);
        this.mMaxRate = 5;
        this.mSeparationDP = 0.0f;
        this.mVerticalPaddingDP = 4.0f;
        this.mRate = 0;
        this.mImageBackground = "wallet_cashdesk_rating_gray";
        this.mImageStar = "wallet_cashdesk_rating_gold";
        init();
    }

    public void addStar() {
        ImageView imageView = new ImageView(getContext());
        imageView.setPadding(DisplayUtils.dip2px(getContext(), this.mSeparationDP / 2.0f), DisplayUtils.dip2px(getContext(), this.mVerticalPaddingDP), DisplayUtils.dip2px(getContext(), this.mSeparationDP / 2.0f), DisplayUtils.dip2px(getContext(), this.mVerticalPaddingDP));
        imageView.setOnClickListener(new OnStarClickListener());
        imageView.setImageResource(ResUtils.drawable(getContext(), this.mImageBackground));
        this.mStars.add(imageView);
        addView(imageView, new LinearLayout.LayoutParams(-2, -2));
    }

    public int getRating() {
        return this.mRate;
    }

    public void init() {
        setOrientation(0);
        this.mStars = new ArrayList<>();
        initRatingBar();
    }

    public void initRatingBar() {
        removeAllViews();
        this.mStars.clear();
        this.mRate = 0;
        for (int i2 = 0; i2 < this.mMaxRate; i2++) {
            addStar();
        }
    }

    public void setOnChangeListener(OnSimpleRatingBarChangeListener onSimpleRatingBarChangeListener) {
        this.mChangeListener = onSimpleRatingBarChangeListener;
    }

    public void setRate(int i2, boolean z) {
        this.mRate = i2;
        int i3 = 0;
        while (i3 < this.mStars.size()) {
            this.mStars.get(i3).setImageResource(ResUtils.drawable(getContext(), i3 < i2 ? this.mImageStar : this.mImageBackground));
            i3++;
        }
        OnSimpleRatingBarChangeListener onSimpleRatingBarChangeListener = this.mChangeListener;
        if (onSimpleRatingBarChangeListener != null) {
            onSimpleRatingBarChangeListener.onRatingChanged(this, this.mRate, z);
        }
    }

    public void setRating(int i2) {
        setRate(i2, false);
    }

    public SimpleRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxRate = 5;
        this.mSeparationDP = 0.0f;
        this.mVerticalPaddingDP = 4.0f;
        this.mRate = 0;
        this.mImageBackground = "wallet_cashdesk_rating_gray";
        this.mImageStar = "wallet_cashdesk_rating_gold";
        init();
    }
}
