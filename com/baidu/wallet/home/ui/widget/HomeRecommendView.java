package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class HomeRecommendView extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f24281a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f24282b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f24283c;

    public HomeRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24283c = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24283c;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_recommend_layout"), this);
        this.f24281a = (ViewGroup) findViewById(ResUtils.id(getContext(), "rmd_rl_left"));
        this.f24282b = (ViewGroup) findViewById(ResUtils.id(getContext(), "rmd_rl_right"));
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
            HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
            if (dataItemArr.length < 2) {
                setVisibility(8);
                return;
            }
            HomeRecommendItemView homeRecommendItemView = new HomeRecommendItemView(getContext());
            homeRecommendItemView.setData(dataItemArr[0], getWalletInterface());
            HomeRecommendItemView homeRecommendItemView2 = new HomeRecommendItemView(getContext());
            homeRecommendItemView2.setData(dataItemArr[1], getWalletInterface());
            this.f24281a.addView(homeRecommendItemView);
            this.f24282b.addView(homeRecommendItemView2);
            this.f24283c.add(homeRecommendItemView);
            this.f24283c.add(homeRecommendItemView2);
        }
    }

    public HomeRecommendView(Context context) {
        super(context);
        this.f24283c = new ArrayList();
    }
}
