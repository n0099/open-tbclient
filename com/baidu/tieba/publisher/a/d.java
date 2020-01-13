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
/* loaded from: classes12.dex */
public class d implements CookieManager {
    private boolean jAG;
    private boolean jAH;

    public d(boolean z, boolean z2) {
        this.jAG = true;
        this.jAH = false;
        this.jAG = z;
        this.jAH = z2;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.jAH || !Hc(str2);
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
                if (this.jAG && (cookieSyncManager = CookieSyncManager.getInstance()) != null) {
                    cookieSyncManager.sync();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        return com.baidu.tbadk.data.h.drk;
    }

    public static void au(String str) {
        com.baidu.tbadk.data.h.drk = "BAIDUCUID=" + AppCuidRuntime.getAppCuidManager().getCuid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + "BDUSS=" + str;
        com.baidu.tbadk.data.h.bduss = str;
        if (PluginPackageManager.jd().aY("com.baidu.tieba.pluginPublisher")) {
            com.baidu.tbadk.data.h aLs = com.baidu.tbadk.data.h.aLs();
            if (aLs != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921429, aLs));
                return;
            }
            return;
        }
        com.baidu.tbadk.data.h.drl = true;
    }

    public static void czv() {
        com.baidu.tbadk.data.h.drk = "";
        if (PluginPackageManager.jd().aY("com.baidu.tieba.pluginPublisher")) {
            com.baidu.tbadk.data.h aLr = com.baidu.tbadk.data.h.aLr();
            if (aLr != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921429, aLr));
                return;
            }
            return;
        }
        com.baidu.tbadk.data.h.drm = true;
    }

    public static boolean Hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("bduss=");
    }
}
