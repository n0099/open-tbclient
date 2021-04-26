package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.GridLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class LifeSingleLineLayoutForType6 extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public GridLayout f25048a;

    /* renamed from: b  reason: collision with root package name */
    public List<BaseItemView> f25049b;

    public LifeSingleLineLayoutForType6(Context context) {
        super(context);
        this.f25049b = new ArrayList();
    }

    private void a(GridLayout gridLayout) {
        gridLayout.setHorizontalSpacing(0);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f25049b;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_life_layout"), this);
        GridLayout gridLayout = (GridLayout) findViewById(ResUtils.id(getContext(), "grid_layout"));
        this.f25048a = gridLayout;
        gridLayout.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        this.f25048a.setColumnCount(dataItemArr.length);
        a(this.f25048a);
        for (HomeCfgResponse.DataItem dataItem : dataItemArr) {
            LifeItemViewForType6 lifeItemViewForType6 = new LifeItemViewForType6(getContext());
            lifeItemViewForType6.setData(dataItem, getWalletInterface());
            this.f25048a.addView(lifeItemViewForType6);
            this.f25049b.add(lifeItemViewForType6);
        }
    }

    public LifeSingleLineLayoutForType6(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25049b = new ArrayList();
    }
}
