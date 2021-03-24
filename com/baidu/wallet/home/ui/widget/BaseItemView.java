package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public abstract class BaseItemView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public HomeCfgResponse.DataItem f24550a;

    /* renamed from: b  reason: collision with root package name */
    public b f24551b;

    /* renamed from: c  reason: collision with root package name */
    public Context f24552c;

    public BaseItemView(Context context) {
        super(context);
        this.f24552c = context;
        a();
    }

    private void a() {
        setOnClickListener(this);
        setPadding(0, 0, -1, 0);
    }

    public void forceShowPoint(String str) {
        if (TextUtils.isEmpty(this.f24550a.link_addr) || !this.f24550a.link_addr.equalsIgnoreCase(str)) {
            return;
        }
        com.baidu.wallet.home.storage.a.a(this.f24552c, this.f24550a.link_addr, "-1");
        handlePoint();
        getWalletInterface().onPointShowChanged();
    }

    public HomeCfgResponse.DataItem getData() {
        return this.f24550a;
    }

    public b getWalletInterface() {
        return this.f24551b;
    }

    public abstract boolean handlePoint();

    public boolean hasCornor() {
        HomeCfgResponse.DataItem dataItem = this.f24550a;
        return dataItem != null && dataItem.hasCornor();
    }

    public boolean isShoudShowPoint() {
        HomeCfgResponse.DataItem dataItem = this.f24550a;
        return dataItem != null && dataItem.isShoudShowPoint(getContext());
    }

    public boolean isShowCopy() {
        HomeCfgResponse.DataItem dataItem = this.f24550a;
        return dataItem != null && "3".equalsIgnoreCase(dataItem.timestamp_icon) && this.f24550a.isShoudShowPoint(getContext());
    }

    public boolean isShowRedDot() {
        HomeCfgResponse.DataItem dataItem = this.f24550a;
        return dataItem != null && "2".equalsIgnoreCase(dataItem.timestamp_icon) && this.f24550a.isShoudShowPoint(getContext());
    }

    public boolean isShowWhiteDot() {
        HomeCfgResponse.DataItem dataItem = this.f24550a;
        return dataItem != null && "1".equalsIgnoreCase(dataItem.timestamp_icon) && this.f24550a.isShoudShowPoint(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (CheckUtils.isFastDoubleClick() || this.f24550a == null || getWalletInterface() == null) {
            return;
        }
        if (isShoudShowPoint()) {
            if (!TextUtils.isEmpty(this.f24550a.link_addr)) {
                Context context = this.f24552c;
                HomeCfgResponse.DataItem dataItem = this.f24550a;
                com.baidu.wallet.home.storage.a.a(context, dataItem.link_addr, TextUtils.isEmpty(dataItem.timestamp) ? "0" : this.f24550a.timestamp);
            }
            handlePoint();
            getWalletInterface().onPointShowChanged();
        }
        b walletInterface = getWalletInterface();
        HomeCfgResponse.DataItem dataItem2 = this.f24550a;
        HomeCfgResponse.Stat stat = dataItem2.stat;
        walletInterface.jump(stat != null ? stat.getName() : dataItem2.getName(), this.f24550a.getType(), this.f24550a.getLinkAddr(), this.f24550a.getPrevlogin());
    }

    public void onEyeMaskChanged() {
    }

    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        this.f24550a = dataItem;
        this.f24551b = bVar;
    }

    public void setNetImageViewUrl(NetImageView netImageView, String str) {
        if (netImageView == null || TextUtils.isEmpty(str) || getWalletInterface() == null) {
            return;
        }
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + str);
    }

    public BaseItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24552c = context;
        a();
    }
}
