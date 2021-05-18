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
    public HomeCfgResponse.ConfigData f24244a;

    /* renamed from: b  reason: collision with root package name */
    public b f24245b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24246c;

    public BaseTitleView(Context context) {
        super(context);
        this.f24246c = context;
        a();
    }

    private void a() {
        setOnClickListener(this);
    }

    public HomeCfgResponse.ConfigData getData() {
        return this.f24244a;
    }

    public String getGroupDesc() {
        HomeCfgResponse.ConfigData configData = this.f24244a;
        return (configData == null || TextUtils.isEmpty(configData.getGroup_desc())) ? "" : this.f24244a.getGroup_desc();
    }

    public String getGroupLayout() {
        HomeCfgResponse.ConfigData configData = this.f24244a;
        return (configData == null || TextUtils.isEmpty(configData.getGroup_layout())) ? "" : this.f24244a.getGroup_layout();
    }

    public String getGroupLink() {
        HomeCfgResponse.ConfigData configData = this.f24244a;
        return (configData == null || TextUtils.isEmpty(configData.getGroup_link())) ? "" : this.f24244a.getGroup_link();
    }

    public String getGroupName() {
        HomeCfgResponse.ConfigData configData = this.f24244a;
        return (configData == null || TextUtils.isEmpty(configData.getGroup_name())) ? "" : this.f24244a.getGroup_name();
    }

    public String getGroupType() {
        HomeCfgResponse.ConfigData configData = this.f24244a;
        return (configData == null || TextUtils.isEmpty(configData.getGroup_type())) ? "" : this.f24244a.getGroup_type();
    }

    public b getWalletInterface() {
        return this.f24245b;
    }

    @Override // android.view.View
    public boolean isClickable() {
        HomeCfgResponse.ConfigData configData = this.f24244a;
        return configData != null && configData.isGroupCanClick();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f24244a == null || getWalletInterface() == null) {
            return;
        }
        b walletInterface = getWalletInterface();
        HomeCfgResponse.ConfigData configData = this.f24244a;
        HomeCfgResponse.Stat stat = configData.stat;
        walletInterface.jump(stat != null ? stat.getName() : configData.getGroup_name(), this.f24244a.getGroup_type(), this.f24244a.getGroup_link(), this.f24244a.getGroup_prevlogin());
    }

    public void onEyeMaskChanged() {
    }

    public void setData(HomeCfgResponse.ConfigData configData, b bVar) {
        this.f24244a = configData;
        this.f24245b = bVar;
        if (!isClickable()) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
    }

    public BaseTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24246c = context;
        a();
    }
}
