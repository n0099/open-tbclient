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
    public CHTitleView f24368a;

    /* renamed from: b  reason: collision with root package name */
    public GridLayout f24369b;

    /* renamed from: c  reason: collision with root package name */
    public List<BaseItemView> f24370c;

    public CHLifeGridGroup(Context context) {
        super(context);
        this.f24370c = new ArrayList();
    }

    private void a(GridLayout gridLayout) {
        gridLayout.setEmptyAreaColor(ResUtils.getColor(getContext(), "bd_wallet_white"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24370c;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_life_layout"), this);
        this.f24369b = (GridLayout) findViewById(ResUtils.id(getContext(), "ch_life_group"));
        this.f24368a = (CHTitleView) findViewById(ResUtils.id(getContext(), "ch_life_lable"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        this.f24368a.setData(this.mConfigData, getWalletInterface());
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        this.f24369b.setColumnCount(4);
        this.f24369b.setHorizontalSpacing(0);
        this.f24369b.setVerticalSpacing(0);
        a(this.f24369b);
        int length = dataItemArr.length <= 16 ? dataItemArr.length : 16;
        for (int i2 = 0; i2 < length; i2++) {
            if (dataItemArr[i2] != null) {
                CHLifeGridItem cHLifeGridItem = new CHLifeGridItem(getContext());
                cHLifeGridItem.setData(dataItemArr[i2], getWalletInterface());
                this.f24369b.addView(cHLifeGridItem);
                this.f24370c.add(cHLifeGridItem);
            }
        }
    }

    public CHLifeGridGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24370c = new ArrayList();
    }
}
