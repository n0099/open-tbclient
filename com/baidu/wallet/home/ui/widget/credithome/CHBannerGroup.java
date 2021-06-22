package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.datamodel.WalletBannerItem;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.FocusImageViewGroup;
import java.util.List;
/* loaded from: classes5.dex */
public class CHBannerGroup extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public FocusImageViewGroup f24434a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24435b;

    /* renamed from: c  reason: collision with root package name */
    public WalletBannerItem[] f24436c;

    public CHBannerGroup(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_banner_group"), this);
        this.f24434a = (FocusImageViewGroup) findViewById(ResUtils.id(getContext(), "wallet_home_banner_gallery"));
        this.f24435b = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_home_banner_indicators"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24434a.getLayoutParams();
        int displayWidth = DisplayUtils.getDisplayWidth(getContext()) - DisplayUtils.dip2px(getContext(), 40.0f);
        int i2 = (displayWidth * Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) / 750;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(displayWidth, i2);
        } else {
            layoutParams.width = displayWidth;
            layoutParams.height = i2;
        }
        this.f24434a.setChildLeft(DisplayUtils.dip2px(getContext(), 20.0f));
        this.f24434a.setLayoutParams(layoutParams);
        this.f24434a.setCurrFocusImagePos(new BannerFocusImageViewGroup.CurrFocusImagePos() { // from class: com.baidu.wallet.home.ui.widget.credithome.CHBannerGroup.1
            @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.CurrFocusImagePos
            public void setCurrPos(int i3, int i4) {
                int i5 = 0;
                while (i5 < i4) {
                    if (CHBannerGroup.this.f24435b.getChildAt(i5) != null) {
                        CHBannerGroup.this.f24435b.getChildAt(i5).setSelected(i5 == i3);
                    }
                    i5++;
                }
            }
        });
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        this.f24436c = dataItemArr;
        this.f24434a.setFocusConfigInfo(dataItemArr, getWalletInterface().getAndroidPrefix(), getWalletInterface().getPageType());
        int drawable = ResUtils.drawable(getContext(), "wallet_home_ch_indicators");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 8.5f), DisplayUtils.dip2px(getContext(), 2.0f));
        WalletBannerItem[] walletBannerItemArr = this.f24436c;
        if (walletBannerItemArr.length > 1) {
            int length = walletBannerItemArr.length <= 10 ? walletBannerItemArr.length : 10;
            int i2 = 0;
            while (i2 < length) {
                View view = new View(getContext());
                view.setBackgroundResource(drawable);
                view.setSelected(i2 == 0);
                this.f24435b.addView(view, layoutParams);
                layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 6.0f);
                i2++;
            }
            this.f24435b.setVisibility(0);
            return;
        }
        this.f24435b.setVisibility(8);
    }

    public CHBannerGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
