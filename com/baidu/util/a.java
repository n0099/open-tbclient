package com.baidu.util;

import android.content.Context;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f22962a;

    /* renamed from: b  reason: collision with root package name */
    public Context f22963b;

    public a(Context context) {
        this.f22963b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f22962a == null) {
                f22962a = new a(context);
            }
            aVar = f22962a;
        }
        return aVar;
    }

    public long a(String str, String str2, long j) {
        try {
            return this.f22963b.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Exception e2) {
            e2.printStackTrace();
            return System.currentTimeMillis();
        }
    }

    public String a(String str, String str2, String str3) {
        try {
            return this.f22963b.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void b(String str, String str2, long j) {
        this.f22963b.getSharedPreferences(str, 0).edit().putLong(str2, j).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f22963b.getSharedPreferences(str, 0).edit().putString(str2, str3).commit();
    }
}
