package com.baidu.webkit.sdk;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface IABTestInterface {
    JSONObject getRawSwitch();

    double getSwitch(String str, double d);

    int getSwitch(String str, int i);

    long getSwitch(String str, long j);

    String getSwitch(String str, String str2);

    boolean getSwitch(String str, boolean z);

    boolean has(String str);
}
