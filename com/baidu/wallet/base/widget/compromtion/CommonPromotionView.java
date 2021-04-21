package com.baidu.wallet.base.widget.compromtion;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class CommonPromotionView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final int f23708a;
    public NetImageView leftDraw;
    public View mView;
    public TextView promotionTxt;
    public ImageView rigthDraw;

    public CommonPromotionView(Context context) {
        super(context);
        this.f23708a = 33;
        initViews();
    }

    public String getLayout() {
        return "wallet_base_promotion_layout";
    }

    public int getMarginLeft() {
        return 33;
    }

    public int getMarginRight() {
        return 33;
    }

    public void initViews() {
        View inflate = View.inflate(getContext(), ResUtils.layout(getContext(), getLayout()), null);
        this.mView = inflate;
        inflate.setBackgroundColor(ResUtils.getColor(inflate.getContext(), "wallet_base_promotion_bg"));
        View view = this.mView;
        NetImageView netImageView = (NetImageView) view.findViewById(ResUtils.id(view.getContext(), "wallet_charge_promotion_img"));
        this.leftDraw = netImageView;
        netImageView.setVisibility(8);
        View view2 = this.mView;
        ImageView imageView = (ImageView) view2.findViewById(ResUtils.id(view2.getContext(), "wallet_charge_promotion_image_del"));
        this.rigthDraw = imageView;
        imageView.setVisibility(8);
        View view3 = this.mView;
        this.promotionTxt = (TextView) view3.findViewById(ResUtils.id(view3.getContext(), "wallet_promotion_txt"));
        addView(this.mView);
    }

    public CommonPromotionView setBackGroundColor(int i) {
        this.mView.setBackgroundColor(i);
        return this;
    }

    public CommonPromotionView setCenText(CharSequence charSequence) {
        this.promotionTxt.setText(Html.fromHtml(charSequence.toString()));
        return this;
    }

    public CommonPromotionView setCenTextColor(int i) {
        this.promotionTxt.setTextColor(i);
        return this;
    }

    public CommonPromotionView setClickRightImgToClose() {
        setRightImgClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.compromtion.CommonPromotionView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommonPromotionView.this.setVisibility(8);
            }
        });
        return this;
    }

    public CommonPromotionView setDefLeftDrawable(Drawable drawable, String str) {
        if (drawable == null) {
            return this;
        }
        this.leftDraw.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.promotionTxt.getLayoutParams();
        layoutParams.setMargins(DisplayUtils.dip2px(this.mView.getContext(), getMarginLeft()), 0, layoutParams.rightMargin, 0);
        this.leftDraw.setImageDrawable(drawable);
        if (!TextUtils.isEmpty(str)) {
            this.leftDraw.setImageUrl(str);
        }
        return this;
    }

    public CommonPromotionView setDefRightDrawable(Drawable drawable) {
        if (drawable == null) {
            return this;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.promotionTxt.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, DisplayUtils.dip2px(this.mView.getContext(), getMarginRight()), 0);
        this.rigthDraw.setImageDrawable(drawable);
        this.rigthDraw.setVisibility(0);
        return this;
    }

    public CommonPromotionView setRightImgClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.rigthDraw.setOnClickListener(onClickListener);
        }
        return this;
    }

    public CommonPromotionView setTextClickListener(View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            return this;
        }
        this.mView.setOnClickListener(onClickListener);
        return this;
    }

    public CommonPromotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23708a = 33;
        initViews();
    }

    public CommonPromotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23708a = 33;
        initViews();
    }
}
