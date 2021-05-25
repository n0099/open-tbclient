package com.baidu.wallet.home.ui.widget.newhome;

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
public class NHBannerGroup extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public FocusImageViewGroup f24342a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24343b;

    /* renamed from: c  reason: collision with root package name */
    public WalletBannerItem[] f24344c;

    public NHBannerGroup(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_banner_layout"), this);
        this.f24342a = (FocusImageViewGroup) findViewById(ResUtils.id(getContext(), "wallet_home_banner_gallery"));
        this.f24343b = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_home_banner_indicators"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24342a.getLayoutParams();
        int displayWidth = DisplayUtils.getDisplayWidth(getContext()) - DisplayUtils.dip2px(getContext(), 30.0f);
        int i2 = (displayWidth * Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) / 750;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(displayWidth, i2);
        } else {
            layoutParams.width = displayWidth;
            layoutParams.height = i2;
        }
        this.f24342a.setChildLeft(DisplayUtils.dip2px(getContext(), 15.0f));
        this.f24342a.setLayoutParams(layoutParams);
        this.f24342a.setCurrFocusImagePos(new BannerFocusImageViewGroup.CurrFocusImagePos() { // from class: com.baidu.wallet.home.ui.widget.newhome.NHBannerGroup.1
            @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.CurrFocusImagePos
            public void setCurrPos(int i3, int i4) {
                int i5 = 0;
                while (i5 < i4) {
                    if (NHBannerGroup.this.f24343b.getChildAt(i5) != null) {
                        NHBannerGroup.this.f24343b.getChildAt(i5).setSelected(i5 == i3);
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
        this.f24344c = dataItemArr;
        this.f24342a.setFocusConfigInfo(dataItemArr, getWalletInterface().getAndroidPrefix(), getWalletInterface().getPageType());
        int drawable = ResUtils.drawable(getContext(), "wallet_base_indicators");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 8.5f), DisplayUtils.dip2px(getContext(), 2.0f));
        if (this.f24344c.length > 1) {
            int i2 = 0;
            while (i2 < this.f24344c.length) {
                View view = new View(getContext());
                view.setBackgroundResource(drawable);
                view.setSelected(i2 == 0);
                this.f24343b.addView(view, layoutParams);
                layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 6.0f);
                i2++;
            }
            this.f24343b.setVisibility(0);
            return;
        }
        this.f24343b.setVisibility(8);
    }

    public NHBannerGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
