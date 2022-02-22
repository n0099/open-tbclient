package com.baidu.webkit.sdk;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface IABTestInterface {
    JSONObject getRawSwitch();

    double getSwitch(String str, double d2);

    int getSwitch(String str, int i2);

    long getSwitch(String str, long j2);

    String getSwitch(String str, String str2);

    boolean getSwitch(String str, boolean z);

    boolean has(String str);
}
