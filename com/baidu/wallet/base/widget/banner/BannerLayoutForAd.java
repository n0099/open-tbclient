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
    public BannerFocusImageViewGroup f24003a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24004b;

    /* renamed from: c  reason: collision with root package name */
    public BannerBaseItemInfo[] f24005c;

    /* renamed from: d  reason: collision with root package name */
    public int f24006d;

    /* renamed from: e  reason: collision with root package name */
    public int f24007e;

    public BannerLayoutForAd(Context context) {
        super(context);
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_banner_vip"), this);
        this.f24003a = (BannerFocusImageViewGroup) findViewById(ResUtils.id(getContext(), "wallet_banner_gallery"));
        this.f24004b = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_banner_indicators"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24003a.getLayoutParams();
        int displayWidth = (DisplayUtils.getDisplayWidth(getContext()) - this.f24006d) - this.f24007e;
        int i = (displayWidth * Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) / 750;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(displayWidth, i);
        } else {
            layoutParams.width = displayWidth;
            layoutParams.height = i;
        }
        this.f24003a.setChildLeft(getPaddingLeft());
        this.f24003a.setLayoutParams(layoutParams);
        this.f24003a.setChildLeft(this.f24006d);
        this.f24003a.setCurrFocusImagePos(new BannerFocusImageViewGroup.CurrFocusImagePos() { // from class: com.baidu.wallet.base.widget.banner.BannerLayoutForAd.1
            @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.CurrFocusImagePos
            public void setCurrPos(int i2, int i3) {
                int i4 = 0;
                while (i4 < i3) {
                    if (BannerLayoutForAd.this.f24004b.getChildAt(i4) != null) {
                        BannerLayoutForAd.this.f24004b.getChildAt(i4).setSelected(i4 == i2);
                    }
                    i4++;
                }
            }
        });
    }

    public boolean isDataValide() {
        BannerBaseItemInfo[] bannerBaseItemInfoArr = this.f24005c;
        return bannerBaseItemInfoArr != null && bannerBaseItemInfoArr.length > 0;
    }

    public void refreshData() {
        this.f24003a.setFocusConfigInfo(this.f24005c, "");
        int drawable = ResUtils.drawable(getContext(), "wallet_base_indicators");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 7.0f), DisplayUtils.dip2px(getContext(), 2.0f));
        if (this.f24005c.length > 1) {
            int i = 0;
            while (i < this.f24005c.length) {
                View view = new View(getContext());
                view.setBackgroundResource(drawable);
                view.setSelected(i == 0);
                this.f24004b.addView(view, layoutParams);
                layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 6.0f);
                i++;
            }
            this.f24004b.setVisibility(0);
            return;
        }
        this.f24004b.setVisibility(8);
    }

    public void setConfigData(BannerBaseItemInfo[] bannerBaseItemInfoArr) {
        this.f24005c = bannerBaseItemInfoArr;
        if (isDataValide()) {
            removeAllViews();
            initView();
            refreshData();
        }
    }

    public void setMaiDianDataKey(String str) {
        BannerFocusImageViewGroup bannerFocusImageViewGroup = this.f24003a;
        if (bannerFocusImageViewGroup != null) {
            bannerFocusImageViewGroup.setMaiDianDataKey(str);
        }
    }

    public void setMarginLeftAndRight(int i, int i2) {
        this.f24006d = i;
        this.f24007e = i2;
    }

    public BannerLayoutForAd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
