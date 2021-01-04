package com.baidu.ufosdk.f;

import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
public final class s {
    public static String a(String str) {
        if (com.baidu.ufosdk.b.ab == null) {
            com.baidu.ufosdk.b.ab = UfoSDK.getChineseMap();
        }
        return com.baidu.ufosdk.b.ab.containsKey(str) ? (String) com.baidu.ufosdk.b.ab.get(str) : "";
    }
}
