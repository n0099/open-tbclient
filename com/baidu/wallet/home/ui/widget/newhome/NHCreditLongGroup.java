package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class NHCreditLongGroup extends BaseItemLayout {
    public static final int ITEM_LIMIT = 12;
    public static final float WIDTH_DIVIDER = 15.0f;

    /* renamed from: a  reason: collision with root package name */
    public NHTitleView f24535a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24536b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f24537c;

    public NHCreditLongGroup(Context context) {
        super(context);
        this.f24537c = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24537c;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_credit_long_layout"), this);
        this.f24535a = (NHTitleView) findViewById(ResUtils.id(getContext(), "credit_group_title"));
        this.f24536b = (LinearLayout) findViewById(ResUtils.id(getContext(), "credit_group_list"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        this.f24535a.setData(this.mConfigData, getWalletInterface());
        this.f24535a.setHasGap(this.mConfigData.isLayoutHasGap());
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        if (dataItemArr == null) {
            return;
        }
        int length = 12 >= dataItemArr.length ? dataItemArr.length : 12;
        int i2 = 0;
        while (i2 < length) {
            NHCreditLongItem nHCreditLongItem = new NHCreditLongItem(getContext());
            nHCreditLongItem.setData(dataItemArr[i2], getWalletInterface());
            this.f24536b.addView(nHCreditLongItem);
            this.f24537c.add(nHCreditLongItem);
            ((LinearLayout.LayoutParams) nHCreditLongItem.getLayoutParams()).setMargins(0, DisplayUtils.dip2px(getContext(), i2 == 0 ? 0.0f : 15.0f), 0, 0);
            i2++;
        }
    }

    public NHCreditLongGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24537c = new ArrayList();
    }
}
