package com.baidu.wallet.api;

import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.passport.ThirdPartyLoginUtil;
/* loaded from: classes5.dex */
public class WalletApiExt {

    /* renamed from: a  reason: collision with root package name */
    public static WalletApiExt f23242a;

    /* renamed from: b  reason: collision with root package name */
    public WalletApiExtListener.SensorsAdapter f23243b;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final WalletApiExt f23244a = new WalletApiExt();
    }

    public static final WalletApiExt getInstance() {
        return a.f23244a;
    }

    public WalletApiExtListener.SensorsAdapter getSensorsAdapter() {
        return this.f23243b;
    }

    public void setLoginSyncListener(WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener) {
        WalletLoginHelper.getInstance().setLoginSyncListener(loginstatuSyncListener);
    }

    public void setSensorsAdapterImpl(WalletApiExtListener.SensorsAdapter sensorsAdapter) {
        this.f23243b = sensorsAdapter;
    }

    public void setThirdPartyLoginImpl(WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface) {
        ThirdPartyLoginUtil.getInstance().setThirdPartyLoginImpl(thirdPartyLoginInterface);
    }

    public WalletApiExt() {
    }
}
