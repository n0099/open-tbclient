package com.bytedance.sdk.openadsdk;

import java.util.Map;
/* loaded from: classes2.dex */
public interface ComplianceInfo {
    String getAppName();

    String getAppVersion();

    String getDeveloperName();

    Map<String, String> getPermissionsMap();

    String getPrivacyUrl();
}
