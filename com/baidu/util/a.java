package com.baidu.util;

import android.content.Context;
/* loaded from: classes17.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f3895a;
    private Context b;

    private a(Context context) {
        this.b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f3895a == null) {
                f3895a = new a(context);
            }
            aVar = f3895a;
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
