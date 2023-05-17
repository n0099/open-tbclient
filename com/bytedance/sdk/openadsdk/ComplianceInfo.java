package com.bytedance.sdk.openadsdk;

import java.util.Map;
/* loaded from: classes8.dex */
public interface ComplianceInfo {
    String getAppName();

    String getAppVersion();

    String getDeveloperName();

    Map<String, String> getPermissionsMap();

    String getPrivacyUrl();
}
