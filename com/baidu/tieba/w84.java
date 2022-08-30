package com.baidu.tieba;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
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
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class w84 extends v84 {
    public static /* synthetic */ Interceptable $ic;
    public static final ae4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public z84 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948224438, "Lcom/baidu/tieba/w84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948224438, "Lcom/baidu/tieba/w84;");
                return;
            }
        }
        c = ae4.c();
    }

    public w84() {
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
        this.b = new z84();
    }

    public final <T extends w94> boolean A(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            try {
                ae4 ae4Var = c;
                ae4Var.i("PMSDBImpl", "#addPackage bundleId=" + t);
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.b.b(t.getClass()), this.b.a(t.getClass()).c(t));
                if (insert != null) {
                    return ContentUris.parseId(insert) > 0;
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
                y84 a = this.b.a(PMSAppInfo.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
                if (cursor != null) {
                    try {
                        try {
                            PMSAppInfo pMSAppInfo = (PMSAppInfo) a.d(cursor);
                            de4.a(cursor);
                            return pMSAppInfo;
                        } catch (Exception e) {
                            e = e;
                            c.g("PMSDBImpl", "#queryAppInfo error", e);
                            de4.a(cursor);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        de4.a(cursor);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                de4.a(cursor);
                throw th;
            }
            de4.a(cursor);
            return null;
        }
        return (PMSAppInfo) invokeL.objValue;
    }

    public final <T> List<T> C(Class<T> cls, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cls, str, strArr, str2)) == null) {
            Cursor cursor2 = null;
            try {
                y84<T> a = this.b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        try {
                            List<T> e = a.e(cursor);
                            de4.a(cursor);
                            return e;
                        } catch (Exception e2) {
                            e = e2;
                            c.g("PMSDBImpl", "#queryAppInfoList error", e);
                            de4.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        de4.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                de4.a(cursor2);
                throw th;
            }
            de4.a(cursor);
            return null;
        }
        return (List) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final <T> T D(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, str)) == null) {
            ?? r0 = 0;
            try {
                try {
                    y84<T> a = this.b.a(cls);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(cls), null, "bundle_id =? ", new String[]{str}, "version_code DESC");
                    if (cursor != null) {
                        try {
                            T d = a.d(cursor);
                            de4.a(cursor);
                            return d;
                        } catch (Exception e) {
                            e = e;
                            c.g("PMSDBImpl", "#queryPackage error", e);
                            de4.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r0 = cls;
                    de4.a(r0);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                de4.a(r0);
                throw th;
            }
            de4.a(cursor);
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final <T> List<T> E(Class<T> cls, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, cls, str, strArr, str2)) == null) {
            Cursor cursor2 = null;
            try {
                y84<T> a = this.b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        try {
                            List<T> e = a.e(cursor);
                            de4.a(cursor);
                            return e;
                        } catch (Exception e2) {
                            e = e2;
                            c.g("PMSDBImpl", "#queryPackageList error", e);
                            de4.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        de4.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                de4.a(cursor2);
                throw th;
            }
            de4.a(cursor);
            return null;
        }
        return (List) invokeLLLL.objValue;
    }

    public List<z94> F(String str, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            Cursor cursor2 = null;
            try {
                y84 a = this.b.a(z94.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(z94.class), null, "bundle_id = ? AND version_code >= ? AND version_code <= ? ", new String[]{str, String.valueOf(j), String.valueOf(j2)}, "version_code DESC");
                if (cursor != null) {
                    try {
                        List<z94> singletonList = z ? Collections.singletonList(a.d(cursor)) : a.e(cursor);
                        de4.a(cursor);
                        return singletonList;
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        de4.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            de4.a(cursor);
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.v84
    public boolean a(x94 x94Var, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, x94Var, pMSAppInfo)) == null) ? b(x94Var, null, null, null, pMSAppInfo) : invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.v84
    public boolean b(x94 x94Var, List<y94> list, v94 v94Var, t94 t94Var, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLLLL;
        ContentProviderResult[] applyBatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048583, this, x94Var, list, v94Var, t94Var, pMSAppInfo)) == null) {
            c.i("PMSDBImpl", "#bulkInsert");
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (x94Var != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.b.b(x94.class)).withValues(this.b.a(x94.class).c(x94Var)).build());
            }
            if (list != null && !list.isEmpty()) {
                y84 a = this.b.a(y94.class);
                for (y94 y94Var : list) {
                    arrayList.add(ContentProviderOperation.newInsert(this.b.b(y94.class)).withValues(a.c(y94Var)).build());
                }
            }
            if (v94Var != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.b.b(v94.class)).withValues(this.b.a(v94.class).c(v94Var)).build());
            }
            if (t94Var != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.b.b(t94.class)).withValues(this.b.a(t94.class).c(t94Var)).build());
            }
            if (pMSAppInfo != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.b.b(PMSAppInfo.class)).withValues(this.b.a(PMSAppInfo.class).c(pMSAppInfo)).build());
            }
            try {
                for (ContentProviderResult contentProviderResult : AppRuntime.getAppContext().getContentResolver().applyBatch(p94.c, arrayList)) {
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

    @Override // com.baidu.tieba.v84
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            ae4 ae4Var = c;
            ae4Var.i("PMSDBImpl", "#clearSubPackage appId=" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                AppRuntime.getAppContext().getContentResolver().delete(this.b.b(y94.class), "app_id=?", new String[]{str});
            } catch (Exception e) {
                c.g("PMSDBImpl", "#clearSubPackage error", e);
            }
        }
    }

    @Override // com.baidu.tieba.v84
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            ae4 ae4Var = c;
            ae4Var.i("PMSDBImpl", "#clearSubPackage appId=" + str + " versionCode=" + str2);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                AppRuntime.getAppContext().getContentResolver().delete(this.b.b(y94.class), "app_id=? AND version_code=?", new String[]{str, str2});
            } catch (Exception e) {
                c.g("PMSDBImpl", "#clearSubPackage error", e);
            }
        }
    }

    @Override // com.baidu.tieba.v84
    public <T extends w94> boolean e(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cls, str)) == null) {
            try {
                ae4 ae4Var = c;
                ae4Var.i("PMSDBImpl", "#deletePkg bundleId=" + str);
            } catch (Exception e) {
                c.g("PMSDBImpl", "#deletePkg error", e);
            }
            return AppRuntime.getAppContext().getContentResolver().delete(this.b.b(cls), "bundle_id =? ", new String[]{str}) > 0;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.v84
    public boolean f(@NonNull z94 z94Var) {
        InterceptResult invokeL;
        Uri b;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, z94Var)) == null) {
            try {
                ae4 ae4Var = c;
                ae4Var.i("PMSDBImpl", "#deletePlugin bundleId=" + z94Var.g + " versionCode=" + z94Var.i);
                b = this.b.b(z94Var.getClass());
                if (z94Var.i >= 0) {
                    str = "bundle_id = ?  and version_code < ? ";
                    strArr = new String[]{z94Var.g, String.valueOf(z94Var.i)};
                } else {
                    str = "bundle_id = ? ";
                    strArr = new String[]{z94Var.g};
                }
            } catch (Exception e) {
                c.g("PMSDBImpl", "#deletePlugin error", e);
            }
            return AppRuntime.getAppContext().getContentResolver().delete(b, str, strArr) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.v84
    public boolean g(List<z94> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                try {
                    Uri b = this.b.b(z94.class);
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    boolean z = true;
                    for (z94 z94Var : list) {
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
                        arrayList.add(z94Var.g);
                        arrayList.add(String.valueOf(z94Var.i));
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

    @Override // com.baidu.tieba.v84
    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            ae4 ae4Var = c;
            ae4Var.i("PMSDBImpl", "#deleteSwanApp appId=" + str);
            try {
            } catch (Exception e) {
                c.g("PMSDBImpl", "#deleteSwanApp error", e);
            }
            return AppRuntime.getAppContext().getContentResolver().delete(this.b.b(PMSAppInfo.class), "app_id =? ", new String[]{str}) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.v84
    @WorkerThread
    public int j(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            Cursor cursor = null;
            int i = -1;
            try {
                try {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(y94.class), new String[]{"version_code"}, "app_id=?", new String[]{str}, "version_code DESC limit 1");
                    if (cursor != null && cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                    }
                } catch (Exception e) {
                    c.g("PMSDBImpl", "#getNewestSubPkgVersion fail", e);
                }
                return i;
            } finally {
                de4.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.v84
    @NonNull
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<y94> k(@NonNull String str, int i) {
        InterceptResult invokeLI;
        Cursor cursor;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, str, i)) == null) {
            Cursor cursor2 = null;
            r1 = null;
            r1 = null;
            List<y94> list = null;
            try {
                if (i >= 0) {
                    str2 = "app_id=? and version_code=?";
                } else {
                    str2 = "app_id=? and version_code>?";
                }
                Uri b = this.b.b(y94.class);
                y84 a = this.b.a(y94.class);
                Cursor query = AppRuntime.getAppContext().getContentResolver().query(b, null, str2, new String[]{str, String.valueOf(i)}, null);
                if (query != null && a != null) {
                    try {
                        list = a.e(query);
                    } catch (Exception e) {
                        cursor = query;
                        e = e;
                        try {
                            c.g("PMSDBImpl", "#getSubPackageByAppId fail", e);
                            de4.a(cursor);
                            if (list != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            de4.a(cursor2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        cursor2 = query;
                        th = th2;
                        de4.a(cursor2);
                        throw th;
                    }
                }
                de4.a(query);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
            return list != null ? Collections.emptyList() : list;
        }
        return (List) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.v84
    public boolean l(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pMSAppInfo)) == null) {
            try {
                ae4 ae4Var = c;
                ae4Var.i("PMSDBImpl", "#insertOrUpdateSwanApp appId=" + pMSAppInfo.appId);
                Class<?> cls = pMSAppInfo.getClass();
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.b.b(cls), this.b.a(cls).c(pMSAppInfo));
                if (insert != null) {
                    return ContentUris.parseId(insert) > 0;
                }
                return false;
            } catch (Exception e) {
                c.g("PMSDBImpl", "#insertOrUpdateSwanApp error", e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.v84
    public <T extends w94> boolean m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, t)) == null) {
            c.i("PMSDBImpl", "#insertPkg");
            return A(t);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.v84
    public boolean n(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, str2, str3)) == null) {
            Cursor cursor = null;
            try {
                try {
                    Uri b = this.b.b(y94.class);
                    y84 a = this.b.a(y94.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(b, null, "app_id=? AND version_code=? AND sub_pkg_name=?", new String[]{str, str2, str3}, null);
                    if (cursor != null) {
                        return a.d(cursor) != null;
                    }
                } catch (Exception e) {
                    c.g("PMSDBImpl", "#isSubPackageExist error", e);
                }
                return false;
            } finally {
                de4.a(cursor);
            }
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.v84
    public <T extends w94> T o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, cls, str)) == null) ? (T) D(cls, str) : (T) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.v84
    public Map<String, x94> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            HashMap hashMap = new HashMap();
            List<x94> E = E(x94.class, "state =? ", new String[]{"10"}, "version_code ASC");
            if (E != null && E.size() > 0) {
                for (x94 x94Var : E) {
                    if (x94Var != null) {
                        hashMap.put(x94Var.g, x94Var);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v84
    public z94 q(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            List<z94> F = F(str, j, j2, true);
            if (F == null || F.isEmpty()) {
                return null;
            }
            return F.get(0);
        }
        return (z94) invokeCommon.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0030 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // com.baidu.tieba.v84
    public List<z94> r(String str, String[] strArr) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, strArr)) == null) {
            ?? r1 = 0;
            try {
                try {
                    y84 a = this.b.a(z94.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(z94.class), null, str, strArr, "update_time DESC");
                    if (cursor != null) {
                        try {
                            List<z94> e = a.e(cursor);
                            de4.a(cursor);
                            return e;
                        } catch (Exception e2) {
                            e = e2;
                            c.g("PMSDBImpl", "#queryPlugin error", e);
                            de4.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                    de4.a(r1);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                de4.a(r1);
                throw th;
            }
            de4.a(cursor);
            return null;
        }
        return (List) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.v84
    public List<z94> s(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) ? F(str, j, j2, false) : (List) invokeCommon.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // com.baidu.tieba.v84
    @Nullable
    public aa4 t(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            ?? r1 = 0;
            try {
                try {
                    y84 a = this.b.a(aa4.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(aa4.class), null, "lib_name =? ", new String[]{str}, "version_code DESC");
                    if (cursor != null) {
                        try {
                            aa4 aa4Var = (aa4) a.d(cursor);
                            de4.a(cursor);
                            return aa4Var;
                        } catch (Exception e) {
                            e = e;
                            c.g("PMSDBImpl", "#querySoLib error", e);
                            de4.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                    de4.a(r1);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                de4.a(r1);
                throw th;
            }
            de4.a(cursor);
            return null;
        }
        return (aa4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v84
    public PMSAppInfo u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? B(str) : (PMSAppInfo) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v84
    public Map<String, PMSAppInfo> v() {
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

    @Override // com.baidu.tieba.v84
    public List<z94> w(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            Cursor cursor2 = null;
            try {
                y84 a = this.b.a(z94.class);
                Uri.Builder buildUpon = this.b.b(z94.class).buildUpon();
                buildUpon.appendQueryParameter("rawQuery", "");
                cursor = AppRuntime.getAppContext().getContentResolver().query(buildUpon.build(), null, str, null, null);
                if (cursor != null) {
                    try {
                        try {
                            List<z94> e = a.e(cursor);
                            de4.a(cursor);
                            return e;
                        } catch (Exception e2) {
                            e = e2;
                            c.g("PMSDBImpl", "#rawQueryPlugins error", e);
                            de4.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        de4.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                de4.a(cursor2);
                throw th;
            }
            de4.a(cursor);
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v84
    public boolean x(@NonNull z94 z94Var) {
        InterceptResult invokeL;
        Uri b;
        ContentValues c2;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, z94Var)) == null) {
            try {
                ae4 ae4Var = c;
                ae4Var.i("PMSDBImpl", "#deletePlugin bundleId=" + z94Var.g + " versionCode=" + z94Var.i);
                y84 a = this.b.a(z94Var.getClass());
                b = this.b.b(z94Var.getClass());
                c2 = a.c(z94Var);
                if (z94Var.i >= 0) {
                    str = "bundle_id = ?  and version_code = ? ";
                    strArr = new String[]{z94Var.g, String.valueOf(z94Var.i)};
                } else {
                    str = "bundle_id = ?  and version_name = ? ";
                    strArr = new String[]{z94Var.g, z94Var.j};
                }
            } catch (Exception e) {
                c.g("PMSDBImpl", "#updatePlugin error", e);
            }
            return AppRuntime.getAppContext().getContentResolver().update(b, c2, str, strArr) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.v84
    public boolean y(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, pMSAppInfo)) == null) {
            try {
                ae4 ae4Var = c;
                ae4Var.i("PMSDBImpl", "#updateSwanApp appId=" + pMSAppInfo.appId);
            } catch (Exception e) {
                c.g("PMSDBImpl", "#updateSwanApp error", e);
            }
            return AppRuntime.getAppContext().getContentResolver().update(this.b.b(pMSAppInfo.getClass()), this.b.a(pMSAppInfo.getClass()).c(pMSAppInfo), "app_id =? ", new String[]{pMSAppInfo.appId}) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.v84
    public boolean z(String str, int i) {
        InterceptResult invokeLI;
        Uri b;
        ContentValues contentValues;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048606, this, str, i)) == null) {
            ae4 ae4Var = c;
            ae4Var.i("PMSDBImpl", "#updateSwanAppPendingErrCode appId=" + str + " errCode=" + i);
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
            return AppRuntime.getAppContext().getContentResolver().update(b, contentValues, "app_id =? ", new String[]{str}) > 0;
        }
        return invokeLI.booleanValue;
    }
}
