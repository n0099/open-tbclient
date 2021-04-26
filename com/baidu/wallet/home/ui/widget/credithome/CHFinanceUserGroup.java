package com.baidu.wallet.home.ui.widget.credithome;

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
public class CHFinanceUserGroup extends BaseItemLayout {
    public static final int ITEM_LIMIT = 1;

    /* renamed from: a  reason: collision with root package name */
    public List<BaseItemView> f25115a;
    public LinearLayout mList;
    public CHTitleView mTitle;

    public CHFinanceUserGroup(Context context) {
        super(context);
        this.f25115a = new ArrayList();
    }

    private void a() {
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        if (dataItemArr == null) {
            return;
        }
        int length = 1 >= dataItemArr.length ? dataItemArr.length : 1;
        for (int i2 = 0; i2 < length; i2++) {
            CHFinanceUserItem cHFinanceUserItem = new CHFinanceUserItem(getContext());
            cHFinanceUserItem.setData(dataItemArr[i2], getWalletInterface());
            this.mList.addView(cHFinanceUserItem);
            this.f25115a.add(cHFinanceUserItem);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f25115a;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_finance_user_layout"), this);
        this.mTitle = (CHTitleView) findViewById(ResUtils.id(getContext(), "ch_fu_group_title"));
        this.mList = (LinearLayout) findViewById(ResUtils.id(getContext(), "ch_fu_group_list"));
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
        a();
    }

    public CHFinanceUserGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25115a = new ArrayList();
    }
}
