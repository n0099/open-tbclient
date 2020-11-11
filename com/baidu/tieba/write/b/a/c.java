package com.baidu.tieba.write.b.a;

import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements CookieManager {
    private static String nHv;
    private boolean nCh;
    private boolean nHw;

    public c(boolean z, boolean z2) {
        this.nCh = true;
        this.nHw = false;
        this.nCh = z;
        this.nHw = z2;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.nHw || !UK(str2);
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        return true;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        CookieSyncManager cookieSyncManager;
        if (list != null && list.size() > 0) {
            try {
                android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
                for (String str2 : list) {
                    cookieManager.setCookie(str, str2);
                }
                if (this.nCh && (cookieSyncManager = CookieSyncManager.getInstance()) != null) {
                    cookieSyncManager.sync();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        return nHv;
    }

    public static void bP(String str) {
        nHv = "BAIDUCUID=" + AppCuidRuntime.getAppCuidManager().getCuid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + "BDUSS=" + str;
    }

    public static void dTP() {
        nHv = "";
    }

    public static boolean UK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("bduss=");
    }
}
