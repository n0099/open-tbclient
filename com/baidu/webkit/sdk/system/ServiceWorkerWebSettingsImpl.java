package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.os.Build;
import com.baidu.webkit.sdk.ServiceWorkerWebSettings;
/* loaded from: classes5.dex */
public class ServiceWorkerWebSettingsImpl extends ServiceWorkerWebSettings {
    @TargetApi(24)
    public android.webkit.ServiceWorkerWebSettings mSettings;

    public ServiceWorkerWebSettingsImpl(android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings) {
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
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        if (Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
            return false;
        }
        return serviceWorkerWebSettings.getAllowContentAccess();
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public boolean getAllowFileAccess() {
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        if (Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
            return false;
        }
        return serviceWorkerWebSettings.getAllowFileAccess();
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public boolean getBlockNetworkLoads() {
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        if (Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
            return false;
        }
        return serviceWorkerWebSettings.getBlockNetworkLoads();
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public int getCacheMode() {
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        if (Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
            return -1;
        }
        return serviceWorkerWebSettings.getCacheMode();
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public void setAllowContentAccess(boolean z) {
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        if (Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
            return;
        }
        serviceWorkerWebSettings.setAllowContentAccess(z);
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public void setAllowFileAccess(boolean z) {
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        if (Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
            return;
        }
        serviceWorkerWebSettings.setAllowFileAccess(z);
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public void setBlockNetworkLoads(boolean z) {
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        if (Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
            return;
        }
        serviceWorkerWebSettings.setBlockNetworkLoads(z);
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public void setCacheMode(int i) {
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        if (Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
            return;
        }
        serviceWorkerWebSettings.setCacheMode(i);
    }
}
