package com.baidu.util;

import android.content.Context;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f3803a;
    private Context b;

    private a(Context context) {
        this.b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f3803a == null) {
                f3803a = new a(context);
            }
            aVar = f3803a;
        }
        return aVar;
    }

    public long a(String str, String str2, long j) {
        try {
            return this.b.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Exception e) {
            e.printStackTrace();
            return System.currentTimeMillis();
        }
    }

    public String a(String str, String str2, String str3) {
        try {
            return this.b.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void b(String str, String str2, long j) {
        this.b.getSharedPreferences(str, 0).edit().putLong(str2, j).commit();
    }

    public void b(String str, String str2, String str3) {
        this.b.getSharedPreferences(str, 0).edit().putString(str2, str3).commit();
    }
}
