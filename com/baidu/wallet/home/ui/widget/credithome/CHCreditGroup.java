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
    public CHTitleView f25095a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f25096b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f25097c;

    public CHCreditGroup(Context context) {
        super(context);
        this.f25097c = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f25097c;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_credit_group_layout"), this);
        this.f25095a = (CHTitleView) findViewById(ResUtils.id(getContext(), "ch_credit_group_title"));
        this.f25096b = (LinearLayout) findViewById(ResUtils.id(getContext(), "ch_credit_group"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        this.f25095a.setData(this.mConfigData, getWalletInterface());
        this.f25096b.removeAllViews();
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        int length = 3 >= dataItemArr.length ? dataItemArr.length : 3;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.mConfigData.list[i2] != null) {
                CHCreditItem cHCreditItem = new CHCreditItem(getContext());
                new View(getContext());
                cHCreditItem.setData(this.mConfigData.list[i2], getWalletInterface());
                this.f25096b.addView(cHCreditItem);
                this.f25097c.add(cHCreditItem);
            }
        }
    }

    public CHCreditGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25097c = new ArrayList();
    }
}
