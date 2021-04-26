package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.GridLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CHLifeGridGroup extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public CHTitleView f25123a;

    /* renamed from: b  reason: collision with root package name */
    public GridLayout f25124b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f25125c;

    public CHLifeGridGroup(Context context) {
        super(context);
        this.f25125c = new ArrayList();
    }

    private void a(GridLayout gridLayout) {
        gridLayout.setEmptyAreaColor(ResUtils.getColor(getContext(), "bd_wallet_white"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f25125c;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_life_layout"), this);
        this.f25124b = (GridLayout) findViewById(ResUtils.id(getContext(), "ch_life_group"));
        this.f25123a = (CHTitleView) findViewById(ResUtils.id(getContext(), "ch_life_lable"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        this.f25123a.setData(this.mConfigData, getWalletInterface());
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        this.f25124b.setColumnCount(4);
        this.f25124b.setHorizontalSpacing(0);
        this.f25124b.setVerticalSpacing(0);
        a(this.f25124b);
        int length = dataItemArr.length <= 16 ? dataItemArr.length : 16;
        for (int i2 = 0; i2 < length; i2++) {
            if (dataItemArr[i2] != null) {
                CHLifeGridItem cHLifeGridItem = new CHLifeGridItem(getContext());
                cHLifeGridItem.setData(dataItemArr[i2], getWalletInterface());
                this.f25124b.addView(cHLifeGridItem);
                this.f25125c.add(cHLifeGridItem);
            }
        }
    }

    public CHLifeGridGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25125c = new ArrayList();
    }
}
