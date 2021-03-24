package com.baidu.wallet.core.beans;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.net.URLDecoder;
/* loaded from: classes5.dex */
public abstract class BeanRequestBase {
    public static final String TAG = "BeanRequestBase";
    public boolean mBelongPaySdk = false;

    public abstract boolean checkRequestValidity();

    public abstract String getRequestId();

    @SuppressLint({"DefaultLocale"})
    public String getSinalParam(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            for (String str3 : str.split("&")) {
                String[] split = str3.split("=");
                if (split != null && !TextUtils.isEmpty(split[0]) && str2.equals(split[0].toUpperCase()) && split.length > 1) {
                    return URLDecoder.decode(split[1]);
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public void setBelongPaySdk() {
        this.mBelongPaySdk = true;
    }
}
