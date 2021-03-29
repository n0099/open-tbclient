package com.baidu.wallet.statistics.impl;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.core.utils.UAFilterUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f26813b = new ArrayList<String>() { // from class: com.baidu.wallet.statistics.impl.HeaderService$1
        {
            add("9774d56d682e549c");
            add("0123456789abcdef");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Pattern f26814a;

    /* renamed from: com.baidu.wallet.statistics.impl.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0283a {

        /* renamed from: a  reason: collision with root package name */
        public static a f26815a = new a();
    }

    public static a a() {
        return C0283a.f26815a;
    }

    public String b(Context context) {
        try {
        } catch (Exception e2) {
            e = e2;
        }
        try {
            return this.f26814a.matcher(PhoneUtils.getCUID2(context)).replaceAll("");
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return null;
        }
    }

    public String c(Context context) {
        try {
            return UAFilterUtil.getInstance().getTrueUA(context);
        } catch (Exception unused) {
            return null;
        }
    }

    public String d(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public a() {
        this.f26814a = Pattern.compile("\\s*|\t|\r|\n");
    }

    public String a(Context context) {
        try {
        } catch (Exception e2) {
            e = e2;
        }
        try {
            return this.f26814a.matcher(PhoneUtils.getCUID(context)).replaceAll("");
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return null;
        }
    }
}
