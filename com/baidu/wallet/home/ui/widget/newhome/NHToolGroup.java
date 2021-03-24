package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.GridLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class NHToolGroup extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public List<BaseItemView> f24763a;
    public GridLayout mGridLayout;

    public NHToolGroup(Context context) {
        super(context);
        this.f24763a = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24763a;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_nh_whiteColor"));
        GridLayout gridLayout = new GridLayout(getContext());
        this.mGridLayout = gridLayout;
        gridLayout.setHorizontalSpacing(0);
        this.mGridLayout.setVerticalSpacing(1);
        addView(this.mGridLayout);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        this.mGridLayout.setColumnCount(dataItemArr.length);
        for (HomeCfgResponse.DataItem dataItem : dataItemArr) {
            NHToolItem nHToolItem = new NHToolItem(getContext());
            nHToolItem.setData(dataItem, getWalletInterface());
            this.mGridLayout.addView(nHToolItem);
            this.f24763a.add(nHToolItem);
        }
    }

    public NHToolGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24763a = new ArrayList();
    }
}
