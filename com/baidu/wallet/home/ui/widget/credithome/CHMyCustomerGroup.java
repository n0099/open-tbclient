package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.b;
import java.util.List;
/* loaded from: classes5.dex */
public class CHMyCustomerGroup extends BaseItemLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f25130a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25131b;

    public CHMyCustomerGroup(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_intelligent_customer_layout"), this);
        this.f25130a = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_intelligent_customer_icon"));
        this.f25131b = (TextView) findViewById(ResUtils.id(getContext(), "ch_intelligent_customer_txt"));
        setOnClickListener(this);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        return this.mConfigData != null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (isDataValid()) {
            b walletInterface = getWalletInterface();
            HomeCfgResponse.ConfigData configData = this.mConfigData;
            walletInterface.jump(configData.group_name, configData.group_type, configData.getGroup_link(), this.mConfigData.getGroup_prevlogin());
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        NetImageView netImageView = this.f25130a;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.group_logo);
        this.f25131b.setText(this.mConfigData.group_name);
    }

    public CHMyCustomerGroup(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
