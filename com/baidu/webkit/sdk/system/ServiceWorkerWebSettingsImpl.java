package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.os.Build;
import com.baidu.webkit.sdk.ServiceWorkerWebSettings;
/* loaded from: classes8.dex */
public class ServiceWorkerWebSettingsImpl extends ServiceWorkerWebSettings {
    @TargetApi(24)
    android.webkit.ServiceWorkerWebSettings mSettings;

    private ServiceWorkerWebSettingsImpl(android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mSettings = serviceWorkerWebSettings;
        }
    }

    public static ServiceWorkerWebSettingsImpl from(android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new ServiceWorkerWebSettingsImpl(serviceWorkerWebSettings);
        }
        return null;
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public boolean getAllowContentAccess() {
        if (Build.VERSION.SDK_INT < 24 || this.mSettings == null) {
            return false;
        }
        return this.mSettings.getAllowContentAccess();
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public boolean getAllowFileAccess() {
        if (Build.VERSION.SDK_INT < 24 || this.mSettings == null) {
            return false;
        }
        return this.mSettings.getAllowFileAccess();
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public boolean getBlockNetworkLoads() {
        if (Build.VERSION.SDK_INT < 24 || this.mSettings == null) {
            return false;
        }
        return this.mSettings.getBlockNetworkLoads();
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public int getCacheMode() {
        if (Build.VERSION.SDK_INT < 24 || this.mSettings == null) {
            return -1;
        }
        return this.mSettings.getCacheMode();
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public void setAllowContentAccess(boolean z) {
        if (Build.VERSION.SDK_INT < 24 || this.mSettings == null) {
            return;
        }
        this.mSettings.setAllowContentAccess(z);
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public void setAllowFileAccess(boolean z) {
        if (Build.VERSION.SDK_INT < 24 || this.mSettings == null) {
            return;
        }
        this.mSettings.setAllowFileAccess(z);
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public void setBlockNetworkLoads(boolean z) {
        if (Build.VERSION.SDK_INT < 24 || this.mSettings == null) {
            return;
        }
        this.mSettings.setBlockNetworkLoads(z);
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public void setCacheMode(int i) {
        if (Build.VERSION.SDK_INT < 24 || this.mSettings == null) {
            return;
        }
        this.mSettings.setCacheMode(i);
    }
}
