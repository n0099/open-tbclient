package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.GridLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.HomeLayoutOneTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class NHLifeGridLayout extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public GridLayout f24760a;

    /* renamed from: b  reason: collision with root package name */
    public HomeLayoutOneTipView f24761b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f24762c;

    public NHLifeGridLayout(Context context) {
        super(context);
        this.f24762c = new ArrayList();
    }

    private void a(GridLayout gridLayout) {
        gridLayout.setEmptyAreaColor(ResUtils.getColor(getContext(), "bd_wallet_white"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24762c;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_life_layout_finance"), this);
        GridLayout gridLayout = (GridLayout) findViewById(ResUtils.id(getContext(), "grid_layout"));
        this.f24760a = gridLayout;
        gridLayout.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_whiteColor"));
        this.f24761b = (HomeLayoutOneTipView) findViewById(ResUtils.id(getContext(), "tip_view"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        this.f24761b.setData(this.mConfigData, getWalletInterface());
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        this.f24760a.setColumnCount(4);
        this.f24760a.setHorizontalSpacing(0);
        this.f24760a.setVerticalSpacing(0);
        this.f24760a.setPadding(20, 20, 20, 30);
        a(this.f24760a);
        for (HomeCfgResponse.DataItem dataItem : dataItemArr) {
            NHLifeGridItem nHLifeGridItem = new NHLifeGridItem(getContext());
            nHLifeGridItem.setData(dataItem, getWalletInterface());
            this.f24760a.addView(nHLifeGridItem);
            this.f24762c.add(nHLifeGridItem);
        }
    }

    public NHLifeGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24762c = new ArrayList();
    }
}
