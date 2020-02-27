package com.baidu.tieba.publisher.a;

import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements CookieManager {
    private boolean jBB;
    private boolean jBC;

    public d(boolean z, boolean z2) {
        this.jBB = true;
        this.jBC = false;
        this.jBB = z;
        this.jBC = z2;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.jBC || !Hq(str2);
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
                if (this.jBB && (cookieSyncManager = CookieSyncManager.getInstance()) != null) {
                    cookieSyncManager.sync();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        return com.baidu.tbadk.data.h.dvs;
    }

    public static void au(String str) {
        com.baidu.tbadk.data.h.dvs = "BAIDUCUID=" + AppCuidRuntime.getAppCuidManager().getCuid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + "BDUSS=" + str;
        com.baidu.tbadk.data.h.bduss = str;
        if (PluginPackageManager.js().ba("com.baidu.tieba.pluginPublisher")) {
            com.baidu.tbadk.data.h aNO = com.baidu.tbadk.data.h.aNO();
            if (aNO != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921429, aNO));
                return;
            }
            return;
        }
        com.baidu.tbadk.data.h.dvt = true;
    }

    public static void cAS() {
        com.baidu.tbadk.data.h.dvs = "";
        if (PluginPackageManager.js().ba("com.baidu.tieba.pluginPublisher")) {
            com.baidu.tbadk.data.h aNN = com.baidu.tbadk.data.h.aNN();
            if (aNN != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921429, aNN));
                return;
            }
            return;
        }
        com.baidu.tbadk.data.h.dvu = true;
    }

    public static boolean Hq(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("bduss=");
    }
}
