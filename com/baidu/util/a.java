package com.baidu.util;

import android.content.Context;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f5905a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5906b;

    private a(Context context) {
        this.f5906b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f5905a == null) {
                f5905a = new a(context);
            }
            aVar = f5905a;
        }
        return aVar;
    }

    public long a(String str, String str2, long j) {
        try {
            return this.f5906b.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Exception e) {
            e.printStackTrace();
            return System.currentTimeMillis();
        }
    }

    public String a(String str, String str2, String str3) {
        try {
            return this.f5906b.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void b(String str, String str2, long j) {
        this.f5906b.getSharedPreferences(str, 0).edit().putLong(str2, j).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f5906b.getSharedPreferences(str, 0).edit().putString(str2, str3).commit();
    }
}
