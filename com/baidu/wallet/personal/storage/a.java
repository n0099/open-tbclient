package com.baidu.wallet.personal.storage;

import android.content.Context;
import com.baidu.apollon.utils.SharedPreferencesUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f26446a = "_card.preferences";

    public static void a(Context context, String str, String str2) {
        SharedPreferencesUtils.setParam(context, f26446a, str, str2);
    }

    public static String b(Context context, String str, String str2) {
        return (String) SharedPreferencesUtils.getParam(context, f26446a, str, str2);
    }

    public static void c(Context context, String str, String str2) {
        SharedPreferencesUtils.setParam(context, f26446a, str, str2);
    }

    public static String d(Context context, String str, String str2) {
        return (String) SharedPreferencesUtils.getParam(context, f26446a, str, str2);
    }

    public static void a(Context context, String str, Boolean bool) {
        SharedPreferencesUtils.setParam(context, f26446a, str, bool);
    }

    public static boolean b(Context context, String str, Boolean bool) {
        return ((Boolean) SharedPreferencesUtils.getParam(context, f26446a, str, bool)).booleanValue();
    }

    public static void c(Context context, String str, Boolean bool) {
        SharedPreferencesUtils.setParam(context, f26446a, str, bool);
    }

    public static boolean d(Context context, String str, Boolean bool) {
        return ((Boolean) SharedPreferencesUtils.getParam(context, f26446a, str, bool)).booleanValue();
    }
}
