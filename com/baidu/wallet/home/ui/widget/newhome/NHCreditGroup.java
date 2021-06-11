package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class NHCreditGroup extends BaseItemLayout {
    public static final int ITEM_LIMIT = 12;

    /* renamed from: a  reason: collision with root package name */
    public List<BaseItemView> f24449a;
    public LinearLayout mList;
    public NHTitleView mTitle;

    public NHCreditGroup(Context context) {
        super(context);
        this.f24449a = new ArrayList();
    }

    private void a() {
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        if (dataItemArr == null) {
            return;
        }
        int length = 12 >= dataItemArr.length ? dataItemArr.length : 12;
        for (int i2 = 0; i2 < length; i2++) {
            NHCreditItem nHCreditItem = new NHCreditItem(getContext());
            nHCreditItem.setData(dataItemArr[i2], getWalletInterface());
            this.mList.addView(nHCreditItem);
            this.f24449a.add(nHCreditItem);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24449a;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_credit_layout"), this);
        this.mTitle = (NHTitleView) findViewById(ResUtils.id(getContext(), "credit_group_title"));
        this.mList = (LinearLayout) findViewById(ResUtils.id(getContext(), "credit_group_list"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        this.mTitle.setData(this.mConfigData, getWalletInterface());
        this.mTitle.setHasGap(this.mConfigData.isLayoutHasGap());
        a();
    }

    public NHCreditGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24449a = new ArrayList();
    }
}
