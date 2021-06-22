package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CHCreditGroup extends BaseItemLayout {
    public static final int ITEM_LIMIT = 3;

    /* renamed from: a  reason: collision with root package name */
    public CHTitleView f24454a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24455b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f24456c;

    public CHCreditGroup(Context context) {
        super(context);
        this.f24456c = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24456c;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_credit_group_layout"), this);
        this.f24454a = (CHTitleView) findViewById(ResUtils.id(getContext(), "ch_credit_group_title"));
        this.f24455b = (LinearLayout) findViewById(ResUtils.id(getContext(), "ch_credit_group"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        this.f24454a.setData(this.mConfigData, getWalletInterface());
        this.f24455b.removeAllViews();
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        int length = 3 >= dataItemArr.length ? dataItemArr.length : 3;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.mConfigData.list[i2] != null) {
                CHCreditItem cHCreditItem = new CHCreditItem(getContext());
                new View(getContext());
                cHCreditItem.setData(this.mConfigData.list[i2], getWalletInterface());
                this.f24455b.addView(cHCreditItem);
                this.f24456c.add(cHCreditItem);
            }
        }
    }

    public CHCreditGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24456c = new ArrayList();
    }
}
