package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import java.util.List;
/* loaded from: classes5.dex */
public class UMHHeadGroup extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f24806a;

    public UMHHeadGroup(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        this.f24806a = new LinearLayout(getContext());
        addView(this.f24806a, new ViewGroup.LayoutParams(-1, (DisplayUtils.getDisplayWidth(getContext()) * 185) / 750));
        setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_background"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        return this.mConfigData != null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        if (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length < 1) {
            return;
        }
        UMHHeadItem uMHHeadItem = new UMHHeadItem(getContext());
        uMHHeadItem.setData(this.mConfigData.list[0], getWalletInterface());
        this.f24806a.addView(uMHHeadItem, new ViewGroup.LayoutParams(-1, -1));
    }

    public UMHHeadGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
