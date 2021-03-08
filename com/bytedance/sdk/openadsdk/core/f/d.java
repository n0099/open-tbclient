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
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4431a = d.class.getSimpleName();
    private static d e = null;
    private static final Map<String, Integer> f = new HashMap();
    private final Set<String> b = new HashSet(1);
    private final List<WeakReference<e>> c = new ArrayList(1);
    private final List<e> d = new ArrayList(1);

    static {
        f.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(ac.b(p.a(), "tt_request_permission_descript_location")));
        f.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(ac.b(p.a(), "tt_request_permission_descript_location")));
        f.put("android.permission.READ_PHONE_STATE", Integer.valueOf(ac.b(p.a(), "tt_request_permission_descript_read_phone_state")));
        f.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(ac.b(p.a(), "tt_request_permission_descript_external_storage")));
        if (Build.VERSION.SDK_INT >= 16) {
            f.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(ac.b(p.a(), "tt_request_permission_descript_external_storage")));
        }
    }

    public static d a() {
        if (e == null) {
            e = new d();
        }
        return e;
    }

    private d() {
        b();
    }

    private synchronized void b() {
        String str;
        if (Build.VERSION.SDK_INT > 28) {
            c();
        } else {
            for (Field field : Manifest.permission.class.getFields()) {
                try {
                    str = (String) field.get("");
                } catch (IllegalAccessException e2) {
                    Log.e(f4431a, "Could not access field", e2);
                    str = null;
                }
                this.b.add(str);
            }
        }
    }

    private void c() {
        PackageInfo packageInfo;
        String[] strArr;
        Context a2 = p.a();
        if (a2 != null) {
            try {
                PackageManager packageManager = a2.getPackageManager();
                String packageName = a2.getPackageName();
                if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                    for (int i = 0; i < strArr.length; i++) {
                        if (!TextUtils.isEmpty(strArr[i])) {
                            this.b.add(strArr[i]);
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    private synchronized void a(@NonNull String[] strArr, @Nullable e eVar) {
        if (eVar != null) {
            eVar.a(strArr);
            this.d.add(eVar);
            this.c.add(new WeakReference<>(eVar));
        }
    }

    private synchronized void a(@Nullable e eVar) {
        Iterator<WeakReference<e>> it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference<e> next = it.next();
            if (next.get() == eVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<e> it2 = this.d.iterator();
        while (it2.hasNext()) {
            if (it2.next() == eVar) {
                it2.remove();
            }
        }
    }

    public synchronized boolean a(@Nullable Context context, @NonNull String str) {
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            if (context != null) {
                if (ad.e()) {
                    if (!a.a(context, str) || (b.a(context, str) != 0 && this.b.contains(str))) {
                        z = false;
                    }
                    z2 = z;
                } else if (b.a(context, str) == 0 || !this.b.contains(str)) {
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public synchronized void a(@Nullable Activity activity, @NonNull String[] strArr, @Nullable e eVar) {
        if (activity != null) {
            try {
                a(strArr, eVar);
                if (Build.VERSION.SDK_INT < 23) {
                    b(activity, strArr, eVar);
                } else {
                    List<String> c = c(activity, strArr, eVar);
                    if (c.isEmpty()) {
                        a(eVar);
                    } else {
                        b.a(activity, (String[]) c.toArray(new String[c.size()]), 1);
                    }
                }
            } finally {
            }
        }
    }

    private void b(@NonNull Activity activity, @NonNull String[] strArr, @Nullable e eVar) {
        boolean a2;
        for (String str : strArr) {
            if (eVar != null) {
                try {
                    if (!this.b.contains(str)) {
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
            if (!this.b.contains(str)) {
                if (eVar != null) {
                    eVar.a(str, c.NOT_FOUND);
                }
            } else if (!a(activity, str)) {
                arrayList.add(str);
            } else if (eVar != null) {
                eVar.a(str, c.GRANTED);
            }
        }
        return arrayList;
    }

    public synchronized void a(@NonNull Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (ad.e() && !a.a(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            a(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(@NonNull String[] strArr, @NonNull int[] iArr, String[] strArr2) {
        try {
            int length = strArr.length;
            int length2 = iArr.length < length ? iArr.length : length;
            Iterator<WeakReference<e>> it = this.c.iterator();
            while (it.hasNext()) {
                e eVar = it.next().get();
                for (int i = 0; i < length2; i++) {
                    if (eVar == null || eVar.a(strArr[i], iArr[i])) {
                        it.remove();
                        break;
                    }
                }
            }
            Iterator<e> it2 = this.d.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
