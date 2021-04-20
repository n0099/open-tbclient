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
    public FocusImageViewGroup f24405a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24406b;

    /* renamed from: c  reason: collision with root package name */
    public WalletBannerItem[] f24407c;

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
        this.f24405a = (FocusImageViewGroup) findViewById(ResUtils.id(getContext(), "wallet_home_banner_gallery"));
        this.f24406b = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_home_banner_indicators"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24405a.getLayoutParams();
        int displayWidth = DisplayUtils.getDisplayWidth(getContext()) - DisplayUtils.dip2px(getContext(), 30.0f);
        int i = (displayWidth * Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) / 750;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(displayWidth, i);
        } else {
            layoutParams.width = displayWidth;
            layoutParams.height = i;
        }
        this.f24405a.setChildLeft(DisplayUtils.dip2px(getContext(), 15.0f));
        this.f24405a.setLayoutParams(layoutParams);
        this.f24405a.setCurrFocusImagePos(new BannerFocusImageViewGroup.CurrFocusImagePos() { // from class: com.baidu.wallet.home.ui.widget.newhome.NHBannerGroup.1
            @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.CurrFocusImagePos
            public void setCurrPos(int i2, int i3) {
                int i4 = 0;
                while (i4 < i3) {
                    if (NHBannerGroup.this.f24406b.getChildAt(i4) != null) {
                        NHBannerGroup.this.f24406b.getChildAt(i4).setSelected(i4 == i2);
                    }
                    i4++;
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
        this.f24407c = dataItemArr;
        this.f24405a.setFocusConfigInfo(dataItemArr, getWalletInterface().getAndroidPrefix(), getWalletInterface().getPageType());
        int drawable = ResUtils.drawable(getContext(), "wallet_base_indicators");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 8.5f), DisplayUtils.dip2px(getContext(), 2.0f));
        if (this.f24407c.length > 1) {
            int i = 0;
            while (i < this.f24407c.length) {
                View view = new View(getContext());
                view.setBackgroundResource(drawable);
                view.setSelected(i == 0);
                this.f24406b.addView(view, layoutParams);
                layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 6.0f);
                i++;
            }
            this.f24406b.setVisibility(0);
            return;
        }
        this.f24406b.setVisibility(8);
    }

    public NHBannerGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
