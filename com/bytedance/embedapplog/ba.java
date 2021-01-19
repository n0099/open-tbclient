package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ba {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5794a = ba.class.getSimpleName() + "#";
    private static aw<bh> pcs = new aw<bh>() { // from class: com.bytedance.embedapplog.ba.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.aw
        /* renamed from: O */
        public bh M(Object... objArr) {
            return new bh((Context) objArr[0]);
        }
    };

    @AnyThread
    public static void a(@NonNull Context context) {
        pcs.b(context).a();
    }

    @WorkerThread
    public static String c(SharedPreferences sharedPreferences) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String c = ay.c(sharedPreferences);
        bb.b("TrackerDr", f5794a + "getCdid takes " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return c;
    }

    @Nullable
    @WorkerThread
    public static Map<String, String> a(@NonNull Context context, @NonNull SharedPreferences sharedPreferences) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, String> id = pcs.b(context).id(100L);
        bb.b("TrackerDr", f5794a + "getOaid takes " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return id;
    }

    @Nullable
    @AnyThread
    public static String a(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    @AnyThread
    public static void b(@Nullable i iVar) {
        bh.b(iVar);
    }
}
