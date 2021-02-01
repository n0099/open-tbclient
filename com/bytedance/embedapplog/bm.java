package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemProperties;
import android.util.Base64;
import android.util.Log;
import com.bytedance.embedapplog.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class bm implements bi {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5807a = a("cGVyc2lzdC5zeXMuaWRlbnRpZmllcmlkLnN1cHBvcnRlZA==");
    private static final aw<Boolean> pmH = new aw<Boolean>() { // from class: com.bytedance.embedapplog.bm.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.aw
        /* renamed from: N */
        public Boolean M(Object... objArr) {
            return Boolean.valueOf("1".equals(bm.b(bm.f5807a, "0")));
        }
    };
    private com.bytedance.a.b pmT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(Context context) {
        try {
            bq.a(context);
        } catch (Throwable th) {
        }
        try {
            this.pmT = new com.bytedance.a.b();
            this.pmT.hO(context);
        } catch (Throwable th2) {
            bb.b("OaidVivo", Log.getStackTraceString(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return pmH.b(new Object[0]).booleanValue();
    }

    @Override // com.bytedance.embedapplog.bi
    public boolean a(Context context) {
        return a();
    }

    @Override // com.bytedance.embedapplog.bi
    public bi.a hS(Context context) {
        if (this.pmT == null) {
            return null;
        }
        return this.pmT.hQ(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable th) {
            return str2;
        }
    }

    public static String a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (Exception e) {
            return "";
        }
    }
}
