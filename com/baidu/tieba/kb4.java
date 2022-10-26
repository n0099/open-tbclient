package com.baidu.tieba;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class kb4 extends jb4 {
    public static /* synthetic */ Interceptable $ic;
    public static final og4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public nb4 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947907308, "Lcom/baidu/tieba/kb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947907308, "Lcom/baidu/tieba/kb4;");
                return;
            }
        }
        c = og4.c();
    }

    public kb4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new nb4();
    }

    public final boolean A(kc4 kc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kc4Var)) == null) {
            try {
                og4 og4Var = c;
                og4Var.i("PMSDBImpl", "#addPackage bundleId=" + kc4Var);
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.b.b(kc4Var.getClass()), this.b.a(kc4Var.getClass()).c(kc4Var));
                if (insert != null) {
                    if (ContentUris.parseId(insert) > 0) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                c.g("PMSDBImpl", "#addPackage error", e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final PMSAppInfo B(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                mb4 a = this.b.a(PMSAppInfo.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
                if (cursor != null) {
                    try {
                        try {
                            PMSAppInfo pMSAppInfo = (PMSAppInfo) a.d(cursor);
                            rg4.a(cursor);
                            return pMSAppInfo;
                        } catch (Exception e) {
                            e = e;
                            c.g("PMSDBImpl", "#queryAppInfo error", e);
                            rg4.a(cursor);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        rg4.a(cursor);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                rg4.a(cursor);
                throw th;
            }
            rg4.a(cursor);
            return null;
        }
        return (PMSAppInfo) invokeL.objValue;
    }

    @Override // com.baidu.tieba.jb4
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            og4 og4Var = c;
            og4Var.i("PMSDBImpl", "#clearSubPackage appId=" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                AppRuntime.getAppContext().getContentResolver().delete(this.b.b(mc4.class), "app_id=?", new String[]{str});
            } catch (Exception e) {
                c.g("PMSDBImpl", "#clearSubPackage error", e);
            }
        }
    }

    @Override // com.baidu.tieba.jb4
    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            og4 og4Var = c;
            og4Var.i("PMSDBImpl", "#deleteSwanApp appId=" + str);
            try {
            } catch (Exception e) {
                c.g("PMSDBImpl", "#deleteSwanApp error", e);
            }
            if (AppRuntime.getAppContext().getContentResolver().delete(this.b.b(PMSAppInfo.class), "app_id =? ", new String[]{str}) <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jb4
    public int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            Cursor cursor = null;
            int i = -1;
            try {
                try {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(mc4.class), new String[]{"version_code"}, "app_id=?", new String[]{str}, "version_code DESC limit 1");
                    if (cursor != null && cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                    }
                } catch (Exception e) {
                    c.g("PMSDBImpl", "#getNewestSubPkgVersion fail", e);
                }
                return i;
            } finally {
                rg4.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.jb4
    public boolean l(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pMSAppInfo)) == null) {
            try {
                og4 og4Var = c;
                og4Var.i("PMSDBImpl", "#insertOrUpdateSwanApp appId=" + pMSAppInfo.appId);
                Class<?> cls = pMSAppInfo.getClass();
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.b.b(cls), this.b.a(cls).c(pMSAppInfo));
                if (insert != null) {
                    if (ContentUris.parseId(insert) > 0) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                c.g("PMSDBImpl", "#insertOrUpdateSwanApp error", e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // com.baidu.tieba.jb4
    public oc4 t(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            ?? r1 = 0;
            try {
                try {
                    mb4 a = this.b.a(oc4.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(oc4.class), null, "lib_name =? ", new String[]{str}, "version_code DESC");
                    if (cursor != null) {
                        try {
                            oc4 oc4Var = (oc4) a.d(cursor);
                            rg4.a(cursor);
                            return oc4Var;
                        } catch (Exception e) {
                            e = e;
                            c.g("PMSDBImpl", "#querySoLib error", e);
                            rg4.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                    rg4.a(r1);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                rg4.a(r1);
                throw th;
            }
            rg4.a(cursor);
            return null;
        }
        return (oc4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.jb4
    public List w(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            Cursor cursor2 = null;
            try {
                mb4 a = this.b.a(nc4.class);
                Uri.Builder buildUpon = this.b.b(nc4.class).buildUpon();
                buildUpon.appendQueryParameter("rawQuery", "");
                cursor = AppRuntime.getAppContext().getContentResolver().query(buildUpon.build(), null, str, null, null);
                if (cursor != null) {
                    try {
                        try {
                            List e = a.e(cursor);
                            rg4.a(cursor);
                            return e;
                        } catch (Exception e2) {
                            e = e2;
                            c.g("PMSDBImpl", "#rawQueryPlugins error", e);
                            rg4.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        rg4.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                rg4.a(cursor2);
                throw th;
            }
            rg4.a(cursor);
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final List C(Class cls, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cls, str, strArr, str2)) == null) {
            Cursor cursor2 = null;
            try {
                mb4 a = this.b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        try {
                            List e = a.e(cursor);
                            rg4.a(cursor);
                            return e;
                        } catch (Exception e2) {
                            e = e2;
                            c.g("PMSDBImpl", "#queryAppInfoList error", e);
                            rg4.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        rg4.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                rg4.a(cursor2);
                throw th;
            }
            rg4.a(cursor);
            return null;
        }
        return (List) invokeLLLL.objValue;
    }

    public final List E(Class cls, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, cls, str, strArr, str2)) == null) {
            Cursor cursor2 = null;
            try {
                mb4 a = this.b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        try {
                            List e = a.e(cursor);
                            rg4.a(cursor);
                            return e;
                        } catch (Exception e2) {
                            e = e2;
                            c.g("PMSDBImpl", "#queryPackageList error", e);
                            rg4.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        rg4.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                rg4.a(cursor2);
                throw th;
            }
            rg4.a(cursor);
            return null;
        }
        return (List) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final Object D(Class cls, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, str)) == null) {
            ?? r0 = 0;
            try {
                try {
                    mb4 a = this.b.a(cls);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(cls), null, "bundle_id =? ", new String[]{str}, "version_code DESC");
                    if (cursor != null) {
                        try {
                            Object d = a.d(cursor);
                            rg4.a(cursor);
                            return d;
                        } catch (Exception e) {
                            e = e;
                            c.g("PMSDBImpl", "#queryPackage error", e);
                            rg4.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r0 = cls;
                    rg4.a(r0);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                rg4.a(r0);
                throw th;
            }
            rg4.a(cursor);
            return null;
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.jb4
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            og4 og4Var = c;
            og4Var.i("PMSDBImpl", "#clearSubPackage appId=" + str + " versionCode=" + str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    AppRuntime.getAppContext().getContentResolver().delete(this.b.b(mc4.class), "app_id=? AND version_code=?", new String[]{str, str2});
                } catch (Exception e) {
                    c.g("PMSDBImpl", "#clearSubPackage error", e);
                }
            }
        }
    }

    @Override // com.baidu.tieba.jb4
    public boolean e(Class cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cls, str)) == null) {
            try {
                og4 og4Var = c;
                og4Var.i("PMSDBImpl", "#deletePkg bundleId=" + str);
            } catch (Exception e) {
                c.g("PMSDBImpl", "#deletePkg error", e);
            }
            if (AppRuntime.getAppContext().getContentResolver().delete(this.b.b(cls), "bundle_id =? ", new String[]{str}) <= 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0030 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // com.baidu.tieba.jb4
    public List r(String str, String[] strArr) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, strArr)) == null) {
            ?? r1 = 0;
            try {
                try {
                    mb4 a = this.b.a(nc4.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(nc4.class), null, str, strArr, "update_time DESC");
                    if (cursor != null) {
                        try {
                            List e = a.e(cursor);
                            rg4.a(cursor);
                            return e;
                        } catch (Exception e2) {
                            e = e2;
                            c.g("PMSDBImpl", "#queryPlugin error", e);
                            rg4.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                    rg4.a(r1);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                rg4.a(r1);
                throw th;
            }
            rg4.a(cursor);
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public List F(String str, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Cursor cursor;
        List e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            Cursor cursor2 = null;
            try {
                mb4 a = this.b.a(nc4.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(nc4.class), null, "bundle_id = ? AND version_code >= ? AND version_code <= ? ", new String[]{str, String.valueOf(j), String.valueOf(j2)}, "version_code DESC");
                if (cursor != null) {
                    try {
                        if (z) {
                            e = Collections.singletonList(a.d(cursor));
                        } else {
                            e = a.e(cursor);
                        }
                        rg4.a(cursor);
                        return e;
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        rg4.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            rg4.a(cursor);
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.jb4
    public boolean a(lc4 lc4Var, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, lc4Var, pMSAppInfo)) == null) {
            return b(lc4Var, null, null, null, pMSAppInfo);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.jb4
    public kc4 o(Class cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, cls, str)) == null) {
            return (kc4) D(cls, str);
        }
        return (kc4) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.jb4
    public boolean b(lc4 lc4Var, List list, jc4 jc4Var, hc4 hc4Var, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLLLL;
        ContentProviderResult[] applyBatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048583, this, lc4Var, list, jc4Var, hc4Var, pMSAppInfo)) == null) {
            c.i("PMSDBImpl", "#bulkInsert");
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (lc4Var != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.b.b(lc4.class)).withValues(this.b.a(lc4.class).c(lc4Var)).build());
            }
            if (list != null && !list.isEmpty()) {
                mb4 a = this.b.a(mc4.class);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(ContentProviderOperation.newInsert(this.b.b(mc4.class)).withValues(a.c((mc4) it.next())).build());
                }
            }
            if (jc4Var != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.b.b(jc4.class)).withValues(this.b.a(jc4.class).c(jc4Var)).build());
            }
            if (hc4Var != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.b.b(hc4.class)).withValues(this.b.a(hc4.class).c(hc4Var)).build());
            }
            if (pMSAppInfo != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.b.b(PMSAppInfo.class)).withValues(this.b.a(PMSAppInfo.class).c(pMSAppInfo)).build());
            }
            try {
                for (ContentProviderResult contentProviderResult : AppRuntime.getAppContext().getContentResolver().applyBatch(dc4.c, arrayList)) {
                    if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                c.g("PMSDBImpl", "#bulkInsert error", e);
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.jb4
    public boolean f(nc4 nc4Var) {
        InterceptResult invokeL;
        Uri b;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, nc4Var)) == null) {
            try {
                og4 og4Var = c;
                og4Var.i("PMSDBImpl", "#deletePlugin bundleId=" + nc4Var.g + " versionCode=" + nc4Var.i);
                b = this.b.b(nc4Var.getClass());
                if (nc4Var.i >= 0) {
                    str = "bundle_id = ?  and version_code < ? ";
                    strArr = new String[]{nc4Var.g, String.valueOf(nc4Var.i)};
                } else {
                    str = "bundle_id = ? ";
                    strArr = new String[]{nc4Var.g};
                }
            } catch (Exception e) {
                c.g("PMSDBImpl", "#deletePlugin error", e);
            }
            if (AppRuntime.getAppContext().getContentResolver().delete(b, str, strArr) <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jb4
    public boolean g(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                try {
                    Uri b = this.b.b(nc4.class);
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    boolean z = true;
                    while (it.hasNext()) {
                        nc4 nc4Var = (nc4) it.next();
                        if (z) {
                            z = false;
                        } else {
                            sb.append(" or ");
                        }
                        sb.append("( ");
                        sb.append("bundle_id");
                        sb.append(" = ? and ");
                        sb.append("version_code");
                        sb.append(" = ?");
                        sb.append(" )");
                        arrayList.add(nc4Var.g);
                        arrayList.add(String.valueOf(nc4Var.i));
                    }
                    if (AppRuntime.getAppContext().getContentResolver().delete(b, sb.toString(), (String[]) arrayList.toArray(new String[0])) > 0) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jb4
    public boolean x(nc4 nc4Var) {
        InterceptResult invokeL;
        Uri b;
        ContentValues c2;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, nc4Var)) == null) {
            try {
                og4 og4Var = c;
                og4Var.i("PMSDBImpl", "#deletePlugin bundleId=" + nc4Var.g + " versionCode=" + nc4Var.i);
                mb4 a = this.b.a(nc4Var.getClass());
                b = this.b.b(nc4Var.getClass());
                c2 = a.c(nc4Var);
                if (nc4Var.i >= 0) {
                    str = "bundle_id = ?  and version_code = ? ";
                    strArr = new String[]{nc4Var.g, String.valueOf(nc4Var.i)};
                } else {
                    str = "bundle_id = ?  and version_name = ? ";
                    strArr = new String[]{nc4Var.g, nc4Var.j};
                }
            } catch (Exception e) {
                c.g("PMSDBImpl", "#updatePlugin error", e);
            }
            if (AppRuntime.getAppContext().getContentResolver().update(b, c2, str, strArr) <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jb4
    public boolean y(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, pMSAppInfo)) == null) {
            try {
                og4 og4Var = c;
                og4Var.i("PMSDBImpl", "#updateSwanApp appId=" + pMSAppInfo.appId);
            } catch (Exception e) {
                c.g("PMSDBImpl", "#updateSwanApp error", e);
            }
            if (AppRuntime.getAppContext().getContentResolver().update(this.b.b(pMSAppInfo.getClass()), this.b.a(pMSAppInfo.getClass()).c(pMSAppInfo), "app_id =? ", new String[]{pMSAppInfo.appId}) <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.jb4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List k(String str, int i) {
        InterceptResult invokeLI;
        Cursor cursor;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, str, i)) == null) {
            Cursor cursor2 = null;
            r1 = null;
            r1 = null;
            List list = null;
            try {
                if (i >= 0) {
                    str2 = "app_id=? and version_code=?";
                } else {
                    str2 = "app_id=? and version_code>?";
                }
                Uri b = this.b.b(mc4.class);
                mb4 a = this.b.a(mc4.class);
                Cursor query = AppRuntime.getAppContext().getContentResolver().query(b, null, str2, new String[]{str, String.valueOf(i)}, null);
                if (query != null && a != null) {
                    try {
                        list = a.e(query);
                    } catch (Exception e) {
                        cursor = query;
                        e = e;
                        try {
                            c.g("PMSDBImpl", "#getSubPackageByAppId fail", e);
                            rg4.a(cursor);
                            if (list != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            rg4.a(cursor2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        cursor2 = query;
                        th = th2;
                        rg4.a(cursor2);
                        throw th;
                    }
                }
                rg4.a(query);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
            if (list != null) {
                return Collections.emptyList();
            }
            return list;
        }
        return (List) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.jb4
    public boolean m(kc4 kc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, kc4Var)) == null) {
            c.i("PMSDBImpl", "#insertPkg");
            return A(kc4Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jb4
    public PMSAppInfo u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            return B(str);
        }
        return (PMSAppInfo) invokeL.objValue;
    }

    @Override // com.baidu.tieba.jb4
    public boolean n(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, str2, str3)) == null) {
            boolean z = false;
            Cursor cursor = null;
            try {
                try {
                    Uri b = this.b.b(mc4.class);
                    mb4 a = this.b.a(mc4.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(b, null, "app_id=? AND version_code=? AND sub_pkg_name=?", new String[]{str, str2, str3}, null);
                    if (cursor != null) {
                        if (a.d(cursor) != null) {
                            z = true;
                        }
                        return z;
                    }
                } catch (Exception e) {
                    c.g("PMSDBImpl", "#isSubPackageExist error", e);
                }
                return false;
            } finally {
                rg4.a(cursor);
            }
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.jb4
    public Map p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            HashMap hashMap = new HashMap();
            List<lc4> E = E(lc4.class, "state =? ", new String[]{"10"}, "version_code ASC");
            if (E != null && E.size() > 0) {
                for (lc4 lc4Var : E) {
                    if (lc4Var != null) {
                        hashMap.put(lc4Var.g, lc4Var);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jb4
    public Map v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            HashMap hashMap = new HashMap();
            List<PMSAppInfo> C = C(PMSAppInfo.class, null, null, null);
            if (C != null && C.size() > 0) {
                for (PMSAppInfo pMSAppInfo : C) {
                    if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                        hashMap.put(pMSAppInfo.appId, pMSAppInfo);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jb4
    public nc4 q(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            List F = F(str, j, j2, true);
            if (F != null && !F.isEmpty()) {
                return (nc4) F.get(0);
            }
            return null;
        }
        return (nc4) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.jb4
    public List s(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return F(str, j, j2, false);
        }
        return (List) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.jb4
    public boolean z(String str, int i) {
        InterceptResult invokeLI;
        Uri b;
        ContentValues contentValues;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048606, this, str, i)) == null) {
            og4 og4Var = c;
            og4Var.i("PMSDBImpl", "#updateSwanAppPendingErrCode appId=" + str + " errCode=" + i);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                b = this.b.b(PMSAppInfo.class);
                contentValues = new ContentValues();
                contentValues.put("pending_err_code", Integer.valueOf(i));
            } catch (Exception e) {
                c.g("PMSDBImpl", "#updateSwanAppPendingErrCode error", e);
            }
            if (AppRuntime.getAppContext().getContentResolver().update(b, contentValues, "app_id =? ", new String[]{str}) <= 0) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
