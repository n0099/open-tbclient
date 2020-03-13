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
    private boolean jBP;
    private boolean jBQ;

    public d(boolean z, boolean z2) {
        this.jBP = true;
        this.jBQ = false;
        this.jBP = z;
        this.jBQ = z2;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.jBQ || !Hr(str2);
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
                if (this.jBP && (cookieSyncManager = CookieSyncManager.getInstance()) != null) {
                    cookieSyncManager.sync();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        return com.baidu.tbadk.data.h.dvG;
    }

    public static void au(String str) {
        com.baidu.tbadk.data.h.dvG = "BAIDUCUID=" + AppCuidRuntime.getAppCuidManager().getCuid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + "BDUSS=" + str;
        com.baidu.tbadk.data.h.bduss = str;
        if (PluginPackageManager.js().ba("com.baidu.tieba.pluginPublisher")) {
            com.baidu.tbadk.data.h aNR = com.baidu.tbadk.data.h.aNR();
            if (aNR != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921429, aNR));
                return;
            }
            return;
        }
        com.baidu.tbadk.data.h.dvH = true;
    }

    public static void cAV() {
        com.baidu.tbadk.data.h.dvG = "";
        if (PluginPackageManager.js().ba("com.baidu.tieba.pluginPublisher")) {
            com.baidu.tbadk.data.h aNQ = com.baidu.tbadk.data.h.aNQ();
            if (aNQ != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921429, aNQ));
                return;
            }
            return;
        }
        com.baidu.tbadk.data.h.dvI = true;
    }

    public static boolean Hr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("bduss=");
    }
}
