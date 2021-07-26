package com.bytedance.sdk.openadsdk.core.g;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.q.l;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f30304a = "d";

    /* renamed from: e  reason: collision with root package name */
    public static d f30305e;

    /* renamed from: f  reason: collision with root package name */
    public static final Map<String, Integer> f30306f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final CopyOnWriteArraySet<String> f30307b;

    /* renamed from: c  reason: collision with root package name */
    public final List<WeakReference<e>> f30308c;

    /* renamed from: d  reason: collision with root package name */
    public final List<e> f30309d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(268178298, "Lcom/bytedance/sdk/openadsdk/core/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(268178298, "Lcom/bytedance/sdk/openadsdk/core/g/d;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        f30306f = hashMap;
        hashMap.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(t.b(o.a(), "tt_request_permission_descript_location")));
        f30306f.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(t.b(o.a(), "tt_request_permission_descript_location")));
        f30306f.put("android.permission.READ_PHONE_STATE", Integer.valueOf(t.b(o.a(), "tt_request_permission_descript_read_phone_state")));
        f30306f.put(StorageUtils.EXTERNAL_STORAGE_PERMISSION, Integer.valueOf(t.b(o.a(), "tt_request_permission_descript_external_storage")));
        if (Build.VERSION.SDK_INT >= 16) {
            f30306f.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(t.b(o.a(), "tt_request_permission_descript_external_storage")));
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30307b = new CopyOnWriteArraySet<>();
        this.f30308c = new ArrayList(1);
        this.f30309d = new ArrayList(1);
        b();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f30305e == null) {
                f30305e = new d();
            }
            return f30305e;
        }
        return (d) invokeV.objValue;
    }

    private synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            synchronized (this) {
                if (Build.VERSION.SDK_INT > 28) {
                    c();
                    return;
                }
                for (Field field : Manifest.permission.class.getFields()) {
                    String str = null;
                    try {
                        str = (String) field.get("");
                    } catch (IllegalAccessException e2) {
                        Log.e(f30304a, "Could not access field", e2);
                    }
                    this.f30307b.add(str);
                }
            }
        }
    }

    private void c() {
        Context a2;
        PackageInfo packageInfo;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (a2 = o.a()) == null) {
            return;
        }
        try {
            PackageManager packageManager = a2.getPackageManager();
            String packageName = a2.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (!TextUtils.isEmpty(strArr[i2])) {
                        this.f30307b.add(strArr[i2]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void a(@NonNull String[] strArr, @Nullable e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, strArr, eVar) == null) {
            synchronized (this) {
                if (eVar == null) {
                    return;
                }
                eVar.a(strArr);
                this.f30309d.add(eVar);
                this.f30308c.add(new WeakReference<>(eVar));
            }
        }
    }

    private synchronized void a(@Nullable e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, eVar) == null) {
            synchronized (this) {
                Iterator<WeakReference<e>> it = this.f30308c.iterator();
                while (it.hasNext()) {
                    WeakReference<e> next = it.next();
                    if (next.get() == eVar || next.get() == null) {
                        it.remove();
                    }
                }
                Iterator<e> it2 = this.f30309d.iterator();
                while (it2.hasNext()) {
                    if (it2.next() == eVar) {
                        it2.remove();
                    }
                }
            }
        }
    }

    private void b(@NonNull Activity activity, @NonNull String[] strArr, @Nullable e eVar) {
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, activity, strArr, eVar) == null) {
            for (String str : strArr) {
                if (eVar != null) {
                    try {
                        if (!this.f30307b.contains(str)) {
                            a2 = eVar.a(str, c.f30302c);
                        } else if (b.a(activity, str) != 0) {
                            a2 = eVar.a(str, c.f30301b);
                        } else {
                            a2 = eVar.a(str, c.f30300a);
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
    }

    @NonNull
    private List<String> c(@NonNull Activity activity, @NonNull String[] strArr, @Nullable e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, this, activity, strArr, eVar)) == null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (this.f30307b.contains(str)) {
                    if (!a(activity, str)) {
                        arrayList.add(str);
                    } else if (eVar != null) {
                        eVar.a(str, c.f30300a);
                    }
                } else if (eVar != null) {
                    eVar.a(str, c.f30302c);
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    public synchronized boolean a(@Nullable Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (context == null) {
                    return false;
                }
                if (l.e()) {
                    if (a.a(context, str) && (b.a(context, str) == 0 || !this.f30307b.contains(str))) {
                        z = true;
                    }
                    return z;
                }
                return (b.a(context, str) == 0 || !this.f30307b.contains(str)) ? true : true;
            }
        }
        return invokeLL.booleanValue;
    }

    public synchronized void a(@Nullable Activity activity, @NonNull String[] strArr, @Nullable e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, strArr, eVar) == null) {
            synchronized (this) {
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
        }
    }

    public synchronized void a(@NonNull Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, strArr, iArr) == null) {
            synchronized (this) {
                try {
                    new ArrayList(3);
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        String str = strArr[i2];
                        if ((iArr[i2] == -1 || (l.e() && !a.a(activity, str))) && iArr[i2] != -1) {
                            iArr[i2] = -1;
                        }
                    }
                    a(strArr, iArr, (String[]) null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private void a(@NonNull String[] strArr, @NonNull int[] iArr, String[] strArr2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, strArr, iArr, strArr2) == null) {
            try {
                int length = strArr.length;
                if (iArr.length < length) {
                    length = iArr.length;
                }
                Iterator<WeakReference<e>> it = this.f30308c.iterator();
                while (it.hasNext()) {
                    e eVar = it.next().get();
                    while (i2 < length) {
                        i2 = (eVar == null || eVar.a(strArr[i2], iArr[i2])) ? 0 : i2 + 1;
                        it.remove();
                        break;
                    }
                }
                Iterator<e> it2 = this.f30309d.iterator();
                while (it2.hasNext()) {
                    it2.next();
                    it2.remove();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
