package com.baidu.util;

import android.content.Context;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f23004a;

    /* renamed from: b  reason: collision with root package name */
    public Context f23005b;

    public a(Context context) {
        this.f23005b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f23004a == null) {
                f23004a = new a(context);
            }
            aVar = f23004a;
        }
        return aVar;
    }

    public long a(String str, String str2, long j) {
        try {
            return this.f23005b.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Exception e2) {
            e2.printStackTrace();
            return System.currentTimeMillis();
        }
    }

    public String a(String str, String str2, String str3) {
        try {
            return this.f23005b.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void b(String str, String str2, long j) {
        this.f23005b.getSharedPreferences(str, 0).edit().putLong(str2, j).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f23005b.getSharedPreferences(str, 0).edit().putString(str2, str3).commit();
    }
}
