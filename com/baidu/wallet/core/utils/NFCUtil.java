package com.baidu.wallet.core.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.router.LocalRouter;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public final class NFCUtil {

    /* renamed from: a  reason: collision with root package name */
    public static NFCUtil f24295a;

    /* renamed from: b  reason: collision with root package name */
    public NfcAdapter f24296b;

    /* renamed from: c  reason: collision with root package name */
    public PendingIntent f24297c;
    public IntentFilter[] mFilters;
    public String[][] mTechlist;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static NFCUtil f24298a = new NFCUtil();
    }

    private void a(Activity activity) {
    }

    private void b(Activity activity) {
    }

    public static NFCUtil getInstance() {
        return a.f24298a;
    }

    public void disableForegroundDispatch(Activity activity, boolean z) {
    }

    public void enableForegroundDispatch(Activity activity, boolean z) {
    }

    public NfcAdapter getNFCAdapter(Activity activity) {
        return null;
    }

    public boolean isPhoneNFCEnable(Activity activity) {
        return false;
    }

    public boolean isPhoneSurportNFC(Activity activity) {
        return false;
    }

    public boolean isWalletNFCEnable(Activity activity) {
        return false;
    }

    public boolean isWalletNFCSurport(Activity activity) {
        return LocalRouter.getInstance(activity).isProviderExisted(BaiduWalletServiceProviderMap.PLUGIN_NFC) && isPhoneSurportNFC(activity);
    }

    public void setWalletNFCEnable(Activity activity, boolean z) {
    }

    public NFCUtil() {
    }
}
