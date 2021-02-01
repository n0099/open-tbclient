package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.embedapplog.bi;
import com.bytedance.embedapplog.bp;
import com.bytedance.embedapplog.cl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class bd implements bi {
    private static final aw<Boolean> pmL = new aw<Boolean>() { // from class: com.bytedance.embedapplog.bd.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.aw
        /* renamed from: N */
        public Boolean M(Object... objArr) {
            return Boolean.valueOf(bc.a((Context) objArr[0], "com.huawei.hwid"));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return pmL.b(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.bi
    public boolean a(Context context) {
        return c(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.embedapplog.bi
    @Nullable
    @WorkerThread
    /* renamed from: hT */
    public a hS(Context context) {
        a aVar = new a();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    aVar.f5803b = string;
                    aVar.c = Boolean.parseBoolean(string2);
                    aVar.f5800a = 202003021704L;
                    return aVar;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        Pair<String, Boolean> hU = hU(context);
        if (hU != null) {
            aVar.f5803b = (String) hU.first;
            aVar.c = ((Boolean) hU.second).booleanValue();
            aVar.f5800a = e(context);
        }
        return aVar;
    }

    private static int e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Nullable
    private static Pair<String, Boolean> hU(Context context) {
        return (Pair) new bp(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new bp.b<cl, Pair<String, Boolean>>() { // from class: com.bytedance.embedapplog.bd.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.embedapplog.bp.b
            /* renamed from: a */
            public cl e(IBinder iBinder) {
                return cl.a.a(iBinder);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.embedapplog.bp.b
            public Pair<String, Boolean> a(cl clVar) {
                if (clVar == null) {
                    return null;
                }
                return new Pair<>(clVar.a(), Boolean.valueOf(clVar.b()));
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends bi.a {

        /* renamed from: a  reason: collision with root package name */
        long f5800a = 0;

        a() {
        }
    }
}
