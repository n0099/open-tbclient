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
    public BannerFocusImageViewGroup f23688a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f23689b;

    /* renamed from: c  reason: collision with root package name */
    public BannerBaseItemInfo[] f23690c;

    /* renamed from: d  reason: collision with root package name */
    public int f23691d;

    /* renamed from: e  reason: collision with root package name */
    public int f23692e;

    public BannerLayoutForAd(Context context) {
        super(context);
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_banner_vip"), this);
        this.f23688a = (BannerFocusImageViewGroup) findViewById(ResUtils.id(getContext(), "wallet_banner_gallery"));
        this.f23689b = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_banner_indicators"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f23688a.getLayoutParams();
        int displayWidth = (DisplayUtils.getDisplayWidth(getContext()) - this.f23691d) - this.f23692e;
        int i = (displayWidth * Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) / 750;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(displayWidth, i);
        } else {
            layoutParams.width = displayWidth;
            layoutParams.height = i;
        }
        this.f23688a.setChildLeft(getPaddingLeft());
        this.f23688a.setLayoutParams(layoutParams);
        this.f23688a.setChildLeft(this.f23691d);
        this.f23688a.setCurrFocusImagePos(new BannerFocusImageViewGroup.CurrFocusImagePos() { // from class: com.baidu.wallet.base.widget.banner.BannerLayoutForAd.1
            @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.CurrFocusImagePos
            public void setCurrPos(int i2, int i3) {
                int i4 = 0;
                while (i4 < i3) {
                    if (BannerLayoutForAd.this.f23689b.getChildAt(i4) != null) {
                        BannerLayoutForAd.this.f23689b.getChildAt(i4).setSelected(i4 == i2);
                    }
                    i4++;
                }
            }
        });
    }

    public boolean isDataValide() {
        BannerBaseItemInfo[] bannerBaseItemInfoArr = this.f23690c;
        return bannerBaseItemInfoArr != null && bannerBaseItemInfoArr.length > 0;
    }

    public void refreshData() {
        this.f23688a.setFocusConfigInfo(this.f23690c, "");
        int drawable = ResUtils.drawable(getContext(), "wallet_base_indicators");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 7.0f), DisplayUtils.dip2px(getContext(), 2.0f));
        if (this.f23690c.length > 1) {
            int i = 0;
            while (i < this.f23690c.length) {
                View view = new View(getContext());
                view.setBackgroundResource(drawable);
                view.setSelected(i == 0);
                this.f23689b.addView(view, layoutParams);
                layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 6.0f);
                i++;
            }
            this.f23689b.setVisibility(0);
            return;
        }
        this.f23689b.setVisibility(8);
    }

    public void setConfigData(BannerBaseItemInfo[] bannerBaseItemInfoArr) {
        this.f23690c = bannerBaseItemInfoArr;
        if (isDataValide()) {
            removeAllViews();
            initView();
            refreshData();
        }
    }

    public void setMaiDianDataKey(String str) {
        BannerFocusImageViewGroup bannerFocusImageViewGroup = this.f23688a;
        if (bannerFocusImageViewGroup != null) {
            bannerFocusImageViewGroup.setMaiDianDataKey(str);
        }
    }

    public void setMarginLeftAndRight(int i, int i2) {
        this.f23691d = i;
        this.f23692e = i2;
    }

    public BannerLayoutForAd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
