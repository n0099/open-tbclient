package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ViewFlipper;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CHNoticeBarGroup extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public List<BaseItemView> f24306a;
    public ViewFlipper flipper;

    public CHNoticeBarGroup(Context context) {
        super(context);
        this.f24306a = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24306a;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_credit_card_notice_layout"), this);
        this.flipper = (ViewFlipper) findViewById(ResUtils.id(getContext(), "ch_credit_card_notice_view_flipper"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        int length = dataItemArr.length <= 6 ? dataItemArr.length : 6;
        for (int i2 = 0; i2 < length; i2++) {
            HomeCfgResponse.DataItem dataItem = this.mConfigData.list[i2];
            if (dataItem != null && !TextUtils.isEmpty(dataItem.name)) {
                CHNoticeItem cHNoticeItem = new CHNoticeItem(getContext());
                cHNoticeItem.setData(dataItem, this.mWalletHomeInterface);
                this.flipper.addView(cHNoticeItem);
                this.f24306a.add(cHNoticeItem);
            }
        }
        if (this.mConfigData.list.length == 1) {
            return;
        }
        this.flipper.setAutoStart(true);
        this.flipper.startFlipping();
        this.flipper.setOutAnimation(ResUtils.getAnimation(getContext(), "wallet_home_ch_noticebar_push_up_out"));
        this.flipper.setInAnimation(ResUtils.getAnimation(getContext(), "wallet_home_ch_noticebar_push_down_in"));
    }

    public CHNoticeBarGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24306a = new ArrayList();
    }
}
