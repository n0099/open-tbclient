package com.baidu.wallet.home.ui.widget;

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
import java.util.List;
/* loaded from: classes5.dex */
public class BannerLayout extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public FocusImageViewGroup f24239a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24240b;

    /* renamed from: c  reason: collision with root package name */
    public WalletBannerItem[] f24241c;

    public BannerLayout(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_banner_vip"), this);
        this.f24239a = (FocusImageViewGroup) findViewById(ResUtils.id(getContext(), "wallet_home_banner_gallery"));
        this.f24240b = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_home_banner_indicators"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24239a.getLayoutParams();
        int displayWidth = DisplayUtils.getDisplayWidth(getContext());
        int i = (displayWidth * Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) / 750;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(displayWidth, i);
        } else {
            layoutParams.width = displayWidth;
            layoutParams.height = i;
        }
        this.f24239a.setLayoutParams(layoutParams);
        this.f24239a.setCurrFocusImagePos(new BannerFocusImageViewGroup.CurrFocusImagePos() { // from class: com.baidu.wallet.home.ui.widget.BannerLayout.1
            @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.CurrFocusImagePos
            public void setCurrPos(int i2, int i3) {
                int i4 = 0;
                while (i4 < i3) {
                    if (BannerLayout.this.f24240b.getChildAt(i4) != null) {
                        BannerLayout.this.f24240b.getChildAt(i4).setSelected(i4 == i2);
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
        this.f24241c = dataItemArr;
        this.f24239a.setFocusConfigInfo(dataItemArr, getWalletInterface().getAndroidPrefix(), getWalletInterface().getPageType());
        int drawable = ResUtils.drawable(getContext(), "wallet_base_indicators");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 7.0f), DisplayUtils.dip2px(getContext(), 1.5f));
        if (this.f24241c.length > 1) {
            int i = 0;
            while (i < this.f24241c.length) {
                View view = new View(getContext());
                view.setBackgroundResource(drawable);
                view.setSelected(i == 0);
                this.f24240b.addView(view, layoutParams);
                layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 6.0f);
                i++;
            }
            this.f24240b.setVisibility(0);
            return;
        }
        this.f24240b.setVisibility(8);
    }

    public BannerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
