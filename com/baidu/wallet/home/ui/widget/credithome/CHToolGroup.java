package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.FlowLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CHToolGroup extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public final int f24381a;

    /* renamed from: b  reason: collision with root package name */
    public FlowLayout f24382b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f24383c;

    /* renamed from: e  reason: collision with root package name */
    public List<BaseItemView> f24384e;

    public CHToolGroup(Context context) {
        super(context);
        this.f24381a = 4;
        this.f24384e = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24384e;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_tools_layout"), this);
        this.f24382b = (FlowLayout) findViewById(ResUtils.id(getContext(), "ch_tools_layout"));
        this.f24383c = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_tools_bg"));
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
        int length = dataItemArr.length <= 4 ? dataItemArr.length : 4;
        this.f24382b.setHorizontalChildNum(length);
        this.f24382b.setHorizontalSpacing(0);
        this.f24382b.setChildViewHeight(DisplayUtils.dip2px(getContext(), 80.0f));
        for (int i2 = 0; i2 < length; i2++) {
            if (dataItemArr[i2] != null) {
                CHToolItem cHToolItem = new CHToolItem(getContext());
                cHToolItem.setData(dataItemArr[i2], getWalletInterface());
                this.f24382b.addView(cHToolItem);
                this.f24384e.add(cHToolItem);
            }
        }
        NetImageView netImageView = this.f24383c;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.group_background);
    }

    public CHToolGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24381a = 4;
        this.f24384e = new ArrayList();
    }
}
