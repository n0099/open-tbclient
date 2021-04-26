package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.GridLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class LifeGridLayout extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public GridLayout f25039a;

    /* renamed from: b  reason: collision with root package name */
    public HomeLayoutOneTipView f25040b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f25041c;

    public LifeGridLayout(Context context) {
        super(context);
        this.f25041c = new ArrayList();
    }

    private void a(GridLayout gridLayout) {
        gridLayout.setEmptyAreaColor(ResUtils.getColor(getContext(), "bd_wallet_white"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f25041c;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_life_layout_finance"), this);
        GridLayout gridLayout = (GridLayout) findViewById(ResUtils.id(getContext(), "grid_layout"));
        this.f25039a = gridLayout;
        gridLayout.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_whiteColor"));
        this.f25040b = (HomeLayoutOneTipView) findViewById(ResUtils.id(getContext(), "tip_view"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        this.f25040b.setData(this.mConfigData, getWalletInterface());
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        this.f25039a.setColumnCount(4);
        this.f25039a.setHorizontalSpacing(0);
        this.f25039a.setVerticalSpacing(0);
        this.f25039a.setPadding(20, 20, 20, 30);
        a(this.f25039a);
        for (HomeCfgResponse.DataItem dataItem : dataItemArr) {
            LifeItemViewForType3 lifeItemViewForType3 = new LifeItemViewForType3(getContext());
            lifeItemViewForType3.setData(dataItem, getWalletInterface());
            this.f25039a.addView(lifeItemViewForType3);
            this.f25041c.add(lifeItemViewForType3);
        }
    }

    public LifeGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25041c = new ArrayList();
    }
}
