package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.credithome.CHFinanceEntryItem;
import java.util.List;
/* loaded from: classes5.dex */
public class CHFinanceEntryGroup extends BaseItemLayout {
    public static final float BOTTOM_PANEL_HEIGHT_DP = 28.0f;
    public static final float ITEM_PANEL_HEIGHT_DP = 93.0f;
    public static final int MAX_ITEM = 6;
    public static final int MIN_ITEM = 2;
    public static final float PANEL_HEIGHT_DP = 19.0f;
    public LinearLayout mList;
    public CHTitleView mTitle;

    public CHFinanceEntryGroup(Context context) {
        super(context);
    }

    private void a(LinearLayout linearLayout, HomeCfgResponse.DataItem dataItem, HomeCfgResponse.DataItem dataItem2, HomeCfgResponse.DataItem dataItem3) {
        LinearLayout a2 = a(linearLayout, 93.0f);
        a(a2, dataItem, CHFinanceEntryItem.EntryType.ENTRY_TYPE_NORMAL);
        a(a2, dataItem2, CHFinanceEntryItem.EntryType.ENTRY_TYPE_NORMAL);
        a(a2, dataItem3, CHFinanceEntryItem.EntryType.ENTRY_TYPE_NORMAL);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_finance_entry_layout"), this);
        this.mTitle = (CHTitleView) findViewById(ResUtils.id(getContext(), "ch_fe_group_title"));
        this.mList = (LinearLayout) findViewById(ResUtils.id(getContext(), "ch_fe_group_list"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length < 2) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        int length = dataItemArr.length <= 6 ? dataItemArr.length : 6;
        a(this.mList, 19.0f);
        if (length == 2) {
            LinearLayout linearLayout = this.mList;
            HomeCfgResponse.DataItem[] dataItemArr2 = this.mConfigData.list;
            a(linearLayout, dataItemArr2[0], dataItemArr2[1]);
        } else if (length == 3) {
            LinearLayout linearLayout2 = this.mList;
            HomeCfgResponse.DataItem[] dataItemArr3 = this.mConfigData.list;
            a(linearLayout2, dataItemArr3[0], dataItemArr3[1], dataItemArr3[2]);
        } else if (length == 4) {
            LinearLayout linearLayout3 = this.mList;
            HomeCfgResponse.DataItem[] dataItemArr4 = this.mConfigData.list;
            a(linearLayout3, dataItemArr4[0], dataItemArr4[1]);
            LinearLayout linearLayout4 = this.mList;
            HomeCfgResponse.DataItem[] dataItemArr5 = this.mConfigData.list;
            a(linearLayout4, dataItemArr5[2], dataItemArr5[3]);
        } else if (length == 5) {
            LinearLayout linearLayout5 = this.mList;
            HomeCfgResponse.DataItem[] dataItemArr6 = this.mConfigData.list;
            a(linearLayout5, dataItemArr6[0], dataItemArr6[1], dataItemArr6[2]);
            LinearLayout linearLayout6 = this.mList;
            HomeCfgResponse.DataItem[] dataItemArr7 = this.mConfigData.list;
            a(linearLayout6, dataItemArr7[3], dataItemArr7[4], null);
        } else if (length == 6) {
            LinearLayout linearLayout7 = this.mList;
            HomeCfgResponse.DataItem[] dataItemArr8 = this.mConfigData.list;
            a(linearLayout7, dataItemArr8[0], dataItemArr8[1], dataItemArr8[2]);
            LinearLayout linearLayout8 = this.mList;
            HomeCfgResponse.DataItem[] dataItemArr9 = this.mConfigData.list;
            a(linearLayout8, dataItemArr9[3], dataItemArr9[4], dataItemArr9[5]);
        }
        a(this.mList, 28.0f);
        this.mTitle.setData(this.mConfigData, getWalletInterface());
    }

    public CHFinanceEntryGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(LinearLayout linearLayout, HomeCfgResponse.DataItem dataItem, HomeCfgResponse.DataItem dataItem2) {
        LinearLayout a2 = a(linearLayout, 93.0f);
        a(a2, dataItem, CHFinanceEntryItem.EntryType.ENTRY_TYPE_LARGE);
        a(a2, dataItem2, CHFinanceEntryItem.EntryType.ENTRY_TYPE_LARGE);
    }

    private LinearLayout a(LinearLayout linearLayout, float f2) {
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(15);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), f2)));
        return linearLayout2;
    }

    private void a(LinearLayout linearLayout, HomeCfgResponse.DataItem dataItem, CHFinanceEntryItem.EntryType entryType) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        if (dataItem != null) {
            CHFinanceEntryItem cHFinanceEntryItem = new CHFinanceEntryItem(getContext());
            cHFinanceEntryItem.setData(dataItem, getWalletInterface(), entryType);
            linearLayout.addView(cHFinanceEntryItem, layoutParams);
            return;
        }
        linearLayout.addView(new View(getContext()), layoutParams);
    }
}
