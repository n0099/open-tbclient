package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class BaseTitleView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public HomeCfgResponse.ConfigData f24247a;

    /* renamed from: b  reason: collision with root package name */
    public b f24248b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24249c;

    public BaseTitleView(Context context) {
        super(context);
        this.f24249c = context;
        a();
    }

    private void a() {
        setOnClickListener(this);
    }

    public HomeCfgResponse.ConfigData getData() {
        return this.f24247a;
    }

    public String getGroupDesc() {
        HomeCfgResponse.ConfigData configData = this.f24247a;
        return (configData == null || TextUtils.isEmpty(configData.getGroup_desc())) ? "" : this.f24247a.getGroup_desc();
    }

    public String getGroupLayout() {
        HomeCfgResponse.ConfigData configData = this.f24247a;
        return (configData == null || TextUtils.isEmpty(configData.getGroup_layout())) ? "" : this.f24247a.getGroup_layout();
    }

    public String getGroupLink() {
        HomeCfgResponse.ConfigData configData = this.f24247a;
        return (configData == null || TextUtils.isEmpty(configData.getGroup_link())) ? "" : this.f24247a.getGroup_link();
    }

    public String getGroupName() {
        HomeCfgResponse.ConfigData configData = this.f24247a;
        return (configData == null || TextUtils.isEmpty(configData.getGroup_name())) ? "" : this.f24247a.getGroup_name();
    }

    public String getGroupType() {
        HomeCfgResponse.ConfigData configData = this.f24247a;
        return (configData == null || TextUtils.isEmpty(configData.getGroup_type())) ? "" : this.f24247a.getGroup_type();
    }

    public b getWalletInterface() {
        return this.f24248b;
    }

    @Override // android.view.View
    public boolean isClickable() {
        HomeCfgResponse.ConfigData configData = this.f24247a;
        return configData != null && configData.isGroupCanClick();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f24247a == null || getWalletInterface() == null) {
            return;
        }
        b walletInterface = getWalletInterface();
        HomeCfgResponse.ConfigData configData = this.f24247a;
        HomeCfgResponse.Stat stat = configData.stat;
        walletInterface.jump(stat != null ? stat.getName() : configData.getGroup_name(), this.f24247a.getGroup_type(), this.f24247a.getGroup_link(), this.f24247a.getGroup_prevlogin());
    }

    public void onEyeMaskChanged() {
    }

    public void setData(HomeCfgResponse.ConfigData configData, b bVar) {
        this.f24247a = configData;
        this.f24248b = bVar;
        if (!isClickable()) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
    }

    public BaseTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24249c = context;
        a();
    }
}
