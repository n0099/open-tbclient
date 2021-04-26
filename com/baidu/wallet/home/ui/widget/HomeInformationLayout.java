package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class HomeInformationLayout extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public HomeLayoutOneTipView f25023a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f25024b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f25025c;

    public HomeInformationLayout(Context context) {
        super(context);
        this.f25025c = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f25025c;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_information_layout"), this);
        this.f25023a = (HomeLayoutOneTipView) findViewById(ResUtils.id(getContext(), "home_information_layout_title"));
        this.f25024b = (LinearLayout) findViewById(ResUtils.id(getContext(), "home_information_layout_content"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        if (isDataValid()) {
            HomeCfgResponse.ConfigData configData = this.mConfigData;
            HomeCfgResponse.DataItem[] dataItemArr = configData.list;
            if (!TextUtils.isEmpty(configData.getGroup_name())) {
                this.f25023a.setData(this.mConfigData, getWalletInterface());
            } else {
                this.f25023a.setVisibility(8);
            }
            HomeInformationItemView homeInformationItemView = null;
            for (HomeCfgResponse.DataItem dataItem : dataItemArr) {
                homeInformationItemView = new HomeInformationItemView(getContext());
                homeInformationItemView.setData(dataItem, getWalletInterface());
                this.f25024b.addView(homeInformationItemView);
                this.f25025c.add(homeInformationItemView);
            }
            if (homeInformationItemView != null) {
                homeInformationItemView.setLineVisibility(false);
            }
        }
    }

    public HomeInformationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25025c = new ArrayList();
    }
}
