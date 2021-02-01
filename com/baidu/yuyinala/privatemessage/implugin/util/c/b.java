package com.baidu.yuyinala.privatemessage.implugin.util.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Looper;
import android.preference.PreferenceManager;
/* loaded from: classes11.dex */
public class b {
    public static String B(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    public static void C(Context context, String str, String str2) {
        commitEditor(PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, str2));
    }

    public static boolean i(Context context, String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static void j(Context context, String str, boolean z) {
        commitEditor(PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z));
    }

    public static void j(Context context, String str, int i) {
        commitEditor(PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(str, i));
    }

    public static int k(Context context, String str, int i) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str, i);
    }

    public static void e(Context context, String str, long j) {
        commitEditor(PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(str, j));
    }

    public static long f(Context context, String str, long j) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str, j);
    }

    public static void g(Context context, String str, long j) {
        commitEditor(PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(str, j));
    }

    public static long h(Context context, String str, long j) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str, j);
    }

    public static void commitEditor(final SharedPreferences.Editor editor) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.util.c.b.1
                @Override // java.lang.Runnable
                public void run() {
                    editor.commit();
                }
            });
        } else {
            editor.commit();
        }
    }
}
