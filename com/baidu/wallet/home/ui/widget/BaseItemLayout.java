package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.wallet.home.WalletNewHomeActivity;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class BaseItemLayout extends RelativeLayout {

    /* renamed from: d  reason: collision with root package name */
    public int f24272d;
    public HomeCfgResponse.ConfigData mConfigData;
    public b mWalletHomeInterface;

    public BaseItemLayout(Context context) {
        super(context);
        this.f24272d = -1;
    }

    public void dispatchShowPoint(String str) {
        List<BaseItemView> children = getChildren();
        if (children == null) {
            return;
        }
        for (BaseItemView baseItemView : children) {
            baseItemView.forceShowPoint(str);
        }
    }

    public abstract List<BaseItemView> getChildren();

    public b getWalletInterface() {
        return this.mWalletHomeInterface;
    }

    public boolean hasItemShowPoint() {
        List<BaseItemView> children = getChildren();
        if (children == null) {
            return false;
        }
        for (BaseItemView baseItemView : children) {
            if (baseItemView.isShoudShowPoint()) {
                return true;
            }
        }
        return false;
    }

    public abstract void initView();

    public abstract boolean isDataValid();

    public void onEyeMaskChanged() {
        List<BaseItemView> children = getChildren();
        if (children == null) {
            return;
        }
        for (BaseItemView baseItemView : children) {
            baseItemView.onEyeMaskChanged();
        }
    }

    public abstract void refreshData();

    public void setConfigData(HomeCfgResponse.ConfigData configData, b bVar) {
        if (this.mConfigData == null || ((bVar instanceof WalletNewHomeActivity.r) && ((WalletNewHomeActivity.r) bVar).f24226a.f24207a > this.f24272d)) {
            this.mConfigData = configData;
            this.mWalletHomeInterface = bVar;
            if (bVar instanceof WalletNewHomeActivity.r) {
                this.f24272d = ((WalletNewHomeActivity.r) bVar).f24226a.f24207a;
            }
            if (!isDataValid() || this.mWalletHomeInterface == null) {
                return;
            }
            removeAllViews();
            initView();
            refreshData();
        }
    }

    public BaseItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24272d = -1;
    }
}
