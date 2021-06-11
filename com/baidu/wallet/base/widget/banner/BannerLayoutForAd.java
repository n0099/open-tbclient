package com.baidu.wallet.base.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
/* loaded from: classes5.dex */
public class BannerLayoutForAd extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public BannerFocusImageViewGroup f23711a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f23712b;

    /* renamed from: c  reason: collision with root package name */
    public BannerBaseItemInfo[] f23713c;

    /* renamed from: d  reason: collision with root package name */
    public int f23714d;

    /* renamed from: e  reason: collision with root package name */
    public int f23715e;

    public BannerLayoutForAd(Context context) {
        super(context);
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_banner_vip"), this);
        this.f23711a = (BannerFocusImageViewGroup) findViewById(ResUtils.id(getContext(), "wallet_banner_gallery"));
        this.f23712b = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_banner_indicators"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f23711a.getLayoutParams();
        int displayWidth = (DisplayUtils.getDisplayWidth(getContext()) - this.f23714d) - this.f23715e;
        int i2 = (displayWidth * Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) / 750;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(displayWidth, i2);
        } else {
            layoutParams.width = displayWidth;
            layoutParams.height = i2;
        }
        this.f23711a.setChildLeft(getPaddingLeft());
        this.f23711a.setLayoutParams(layoutParams);
        this.f23711a.setChildLeft(this.f23714d);
        this.f23711a.setCurrFocusImagePos(new BannerFocusImageViewGroup.CurrFocusImagePos() { // from class: com.baidu.wallet.base.widget.banner.BannerLayoutForAd.1
            @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.CurrFocusImagePos
            public void setCurrPos(int i3, int i4) {
                int i5 = 0;
                while (i5 < i4) {
                    if (BannerLayoutForAd.this.f23712b.getChildAt(i5) != null) {
                        BannerLayoutForAd.this.f23712b.getChildAt(i5).setSelected(i5 == i3);
                    }
                    i5++;
                }
            }
        });
    }

    public boolean isDataValide() {
        BannerBaseItemInfo[] bannerBaseItemInfoArr = this.f23713c;
        return bannerBaseItemInfoArr != null && bannerBaseItemInfoArr.length > 0;
    }

    public void refreshData() {
        this.f23711a.setFocusConfigInfo(this.f23713c, "");
        int drawable = ResUtils.drawable(getContext(), "wallet_base_indicators");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 7.0f), DisplayUtils.dip2px(getContext(), 2.0f));
        if (this.f23713c.length > 1) {
            int i2 = 0;
            while (i2 < this.f23713c.length) {
                View view = new View(getContext());
                view.setBackgroundResource(drawable);
                view.setSelected(i2 == 0);
                this.f23712b.addView(view, layoutParams);
                layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 6.0f);
                i2++;
            }
            this.f23712b.setVisibility(0);
            return;
        }
        this.f23712b.setVisibility(8);
    }

    public void setConfigData(BannerBaseItemInfo[] bannerBaseItemInfoArr) {
        this.f23713c = bannerBaseItemInfoArr;
        if (isDataValide()) {
            removeAllViews();
            initView();
            refreshData();
        }
    }

    public void setMaiDianDataKey(String str) {
        BannerFocusImageViewGroup bannerFocusImageViewGroup = this.f23711a;
        if (bannerFocusImageViewGroup != null) {
            bannerFocusImageViewGroup.setMaiDianDataKey(str);
        }
    }

    public void setMarginLeftAndRight(int i2, int i3) {
        this.f23714d = i2;
        this.f23715e = i3;
    }

    public BannerLayoutForAd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
