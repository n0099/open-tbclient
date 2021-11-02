package com.bytedance.sdk.openadsdk;

import java.util.Map;
/* loaded from: classes11.dex */
public interface ComplianceInfo {
    String getAppName();

    String getAppVersion();

    String getDeveloperName();

    Map<String, String> getPermissionsMap();

    String getPrivacyUrl();
}
