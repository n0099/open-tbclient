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
    public CHTitleView f24649a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24650b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f24651c;

    public CHCreditGroup(Context context) {
        super(context);
        this.f24651c = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24651c;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_credit_group_layout"), this);
        this.f24649a = (CHTitleView) findViewById(ResUtils.id(getContext(), "ch_credit_group_title"));
        this.f24650b = (LinearLayout) findViewById(ResUtils.id(getContext(), "ch_credit_group"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        this.f24649a.setData(this.mConfigData, getWalletInterface());
        this.f24650b.removeAllViews();
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        int length = 3 >= dataItemArr.length ? dataItemArr.length : 3;
        for (int i = 0; i < length; i++) {
            if (this.mConfigData.list[i] != null) {
                CHCreditItem cHCreditItem = new CHCreditItem(getContext());
                new View(getContext());
                cHCreditItem.setData(this.mConfigData.list[i], getWalletInterface());
                this.f24650b.addView(cHCreditItem);
                this.f24651c.add(cHCreditItem);
            }
        }
    }

    public CHCreditGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24651c = new ArrayList();
    }
}
