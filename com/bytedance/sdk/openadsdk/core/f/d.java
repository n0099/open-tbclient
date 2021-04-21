package com.bytedance.sdk.openadsdk.core.f;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ae;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28034a = "d";

    /* renamed from: e  reason: collision with root package name */
    public static d f28035e;

    /* renamed from: f  reason: collision with root package name */
    public static final Map<String, Integer> f28036f;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f28037b = new HashSet(1);

    /* renamed from: c  reason: collision with root package name */
    public final List<WeakReference<e>> f28038c = new ArrayList(1);

    /* renamed from: d  reason: collision with root package name */
    public final List<e> f28039d = new ArrayList(1);

    static {
        HashMap hashMap = new HashMap();
        f28036f = hashMap;
        hashMap.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(ad.b(p.a(), "tt_request_permission_descript_location")));
        f28036f.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(ad.b(p.a(), "tt_request_permission_descript_location")));
        f28036f.put("android.permission.READ_PHONE_STATE", Integer.valueOf(ad.b(p.a(), "tt_request_permission_descript_read_phone_state")));
        f28036f.put(StorageUtils.EXTERNAL_STORAGE_PERMISSION, Integer.valueOf(ad.b(p.a(), "tt_request_permission_descript_external_storage")));
        if (Build.VERSION.SDK_INT >= 16) {
            f28036f.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(ad.b(p.a(), "tt_request_permission_descript_external_storage")));
        }
    }

    public d() {
        b();
    }

    public static d a() {
        if (f28035e == null) {
            f28035e = new d();
        }
        return f28035e;
    }

    private synchronized void b() {
        if (Build.VERSION.SDK_INT > 28) {
            c();
            return;
        }
        for (Field field : Manifest.permission.class.getFields()) {
            String str = null;
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException e2) {
                Log.e(f28034a, "Could not access field", e2);
            }
            this.f28037b.add(str);
        }
    }

    private void c() {
        PackageInfo packageInfo;
        String[] strArr;
        Context a2 = p.a();
        if (a2 == null) {
            return;
        }
        try {
            PackageManager packageManager = a2.getPackageManager();
            String packageName = a2.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.f28037b.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void a(@NonNull String[] strArr, @Nullable e eVar) {
        if (eVar == null) {
            return;
        }
        eVar.a(strArr);
        this.f28039d.add(eVar);
        this.f28038c.add(new WeakReference<>(eVar));
    }

    private synchronized void a(@Nullable e eVar) {
        Iterator<WeakReference<e>> it = this.f28038c.iterator();
        while (it.hasNext()) {
            WeakReference<e> next = it.next();
            if (next.get() == eVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<e> it2 = this.f28039d.iterator();
        while (it2.hasNext()) {
            if (it2.next() == eVar) {
                it2.remove();
            }
        }
    }

    private void b(@NonNull Activity activity, @NonNull String[] strArr, @Nullable e eVar) {
        boolean a2;
        for (String str : strArr) {
            if (eVar != null) {
                try {
                    if (!this.f28037b.contains(str)) {
                        a2 = eVar.a(str, c.NOT_FOUND);
                    } else if (b.a(activity, str) != 0) {
                        a2 = eVar.a(str, c.DENIED);
                    } else {
                        a2 = eVar.a(str, c.GRANTED);
                    }
                    if (a2) {
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        a(eVar);
    }

    @NonNull
    private List<String> c(@NonNull Activity activity, @NonNull String[] strArr, @Nullable e eVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.f28037b.contains(str)) {
                if (!a(activity, str)) {
                    arrayList.add(str);
                } else if (eVar != null) {
                    eVar.a(str, c.GRANTED);
                }
            } else if (eVar != null) {
                eVar.a(str, c.NOT_FOUND);
            }
        }
        return arrayList;
    }

    public synchronized boolean a(@Nullable Context context, @NonNull String str) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (ae.e()) {
            if (a.a(context, str) && (b.a(context, str) == 0 || !this.f28037b.contains(str))) {
                z = true;
            }
            return z;
        }
        return (b.a(context, str) == 0 || !this.f28037b.contains(str)) ? true : true;
    }

    public synchronized void a(@Nullable Activity activity, @NonNull String[] strArr, @Nullable e eVar) {
        if (activity == null) {
            return;
        }
        try {
            a(strArr, eVar);
            if (Build.VERSION.SDK_INT < 23) {
                b(activity, strArr, eVar);
            } else {
                List<String> c2 = c(activity, strArr, eVar);
                if (c2.isEmpty()) {
                    a(eVar);
                } else {
                    b.a(activity, (String[]) c2.toArray(new String[c2.size()]), 1);
                }
            }
        } finally {
        }
    }

    public synchronized void a(@NonNull Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (ae.e() && !a.a(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            a(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(@NonNull String[] strArr, @NonNull int[] iArr, String[] strArr2) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<e>> it = this.f28038c.iterator();
            while (it.hasNext()) {
                e eVar = it.next().get();
                while (i < length) {
                    i = (eVar == null || eVar.a(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<e> it2 = this.f28039d.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
