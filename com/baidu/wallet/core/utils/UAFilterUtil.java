package com.baidu.wallet.core.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.BussinessUtils;
/* loaded from: classes5.dex */
public class UAFilterUtil {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static UAFilterUtil f24112a = new UAFilterUtil();
    }

    public static UAFilterUtil getInstance() {
        return a.f24112a;
    }

    public synchronized String getTrueUA(Context context) {
        String ua = BussinessUtils.getUA(context);
        return TextUtils.isEmpty(ua) ? "" : ua;
    }

    public UAFilterUtil() {
    }
}
