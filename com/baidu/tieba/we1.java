package com.baidu.tieba;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.SubBundleInfo;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class we1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile we1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ye1 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948267590, "Lcom/baidu/tieba/we1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948267590, "Lcom/baidu/tieba/we1;");
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) {
            return 0;
        }
        return invokeLLL.intValue;
    }

    /* loaded from: classes8.dex */
    public class a extends ze1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ContentValues b;
        public final /* synthetic */ we1 c;

        public a(we1 we1Var, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we1Var, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = we1Var;
            this.b = contentValues;
        }

        @Override // com.baidu.tieba.ze1
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                return this.c.k(sQLiteDatabase, this.b);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends ze1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BundleInfo b;
        public final /* synthetic */ List c;
        public final /* synthetic */ we1 d;

        public b(we1 we1Var, BundleInfo bundleInfo, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we1Var, bundleInfo, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = we1Var;
            this.b = bundleInfo;
            this.c = list;
        }

        @Override // com.baidu.tieba.ze1
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                this.d.k(sQLiteDatabase, BundleInfo.toContentValues(this.b));
                for (BundleInfo bundleInfo : this.c) {
                    this.d.l(sQLiteDatabase, BundleInfo.toContentValues(bundleInfo));
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public we1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = new ye1(context);
    }

    public static we1 d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (b == null) {
                synchronized (we1.class) {
                    if (b == null) {
                        Application applicationContext = ContextHolder.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        b = new we1(context);
                    }
                }
            }
            return b;
        }
        return (we1) invokeL.objValue;
    }

    public int h(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bundleInfo)) == null) {
            bundleInfo.setType(1);
            this.a.getWritableDatabase().update("bundleinfo", BundleInfo.toContentValues(bundleInfo), "pkg_name =? AND version_code = ? ", new String[]{bundleInfo.getPackageName(), String.valueOf(bundleInfo.getVersionCode())});
            return 0;
        }
        return invokeL.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.a.getWritableDatabase().delete("bundleinfo", "abi <>? AND abi <> 3", new String[]{String.valueOf(of1.a())});
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
        if (com.baidu.tieba.kf1.a() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (com.baidu.tieba.kf1.a() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<BundleInfo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Cursor query = this.a.getReadableDatabase().query("bundleinfo", null, "", null, null, null, null);
            List<BundleInfo> arrayList = new ArrayList<>();
            try {
                try {
                    arrayList = BundleInfo.toBundleInfoList(query);
                    try {
                        query.close();
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    if (kf1.a()) {
                        e2.printStackTrace();
                    }
                    try {
                        query.close();
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                try {
                    query.close();
                } catch (Exception e4) {
                    if (kf1.a()) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return (List) invokeV.objValue;
    }

    public Cursor f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) {
            return query(null, null, "pkg_name =? AND type = ? AND broken = ? ", new String[]{str, String.valueOf(i), "0"}, null);
        }
        return (Cursor) invokeLI.objValue;
    }

    public Cursor g(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, str, i, i2)) == null) {
            return query(null, null, "pkg_name =? AND type = ? AND version_code >= ? AND broken = ? ", new String[]{str, String.valueOf(i2), String.valueOf(i), "0"}, null);
        }
        return (Cursor) invokeLII.objValue;
    }

    public final boolean i(ze1 ze1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ze1Var)) == null) {
            ze1Var.c(this.a.getWritableDatabase());
            return ze1Var.a();
        }
        return invokeL.booleanValue;
    }

    public void j(BundleInfo bundleInfo) {
        List<SubBundleInfo> subBundle;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bundleInfo) == null) && (subBundle = bundleInfo.getSubBundle()) != null && !subBundle.isEmpty()) {
            Cursor query = this.a.getReadableDatabase().query("bundleinfo", null, null, null, null, null, null);
            Map<String, BundleInfoGroup> bundleInfoGroups = BundleInfo.toBundleInfoGroups(BundleInfo.toBundleInfoList(query), 0L);
            try {
                query.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ArrayList arrayList = new ArrayList();
            for (SubBundleInfo subBundleInfo : subBundle) {
                String packageName = subBundleInfo.getPackageName();
                int minVersion = subBundleInfo.getMinVersion();
                int maxVersion = subBundleInfo.getMaxVersion();
                BundleInfoGroup bundleInfoGroup = bundleInfoGroups.get(packageName);
                if (bundleInfoGroup != null) {
                    BundleInfo bundleByType = bundleInfoGroup.getBundleByType(1);
                    BundleInfo bundleByType2 = bundleInfoGroup.getBundleByType(2);
                    BundleInfo bundleByType3 = bundleInfoGroup.getBundleByType(3);
                    bundleByType = (bundleByType == null || bundleByType.getVersionCode() < minVersion || bundleByType.getVersionCode() > maxVersion) ? null : null;
                    if (bundleByType2 == null || bundleByType2.getVersionCode() < minVersion || bundleByType2.getVersionCode() > maxVersion) {
                        bundleByType2 = bundleByType;
                    }
                    if (bundleByType3 == null || bundleByType3.getVersionCode() < minVersion || bundleByType3.getVersionCode() > maxVersion) {
                        bundleByType3 = bundleByType2;
                    }
                    if (bundleByType3 != null) {
                        bundleByType3.setType(4);
                        arrayList.add(bundleByType3);
                    }
                }
            }
            i(new b(this, bundleInfo, arrayList));
        }
    }

    public final boolean k(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, contentValues)) == null) {
            BundleInfo bundleInfo = BundleInfo.toBundleInfo(contentValues);
            if (bundleInfo == null) {
                return false;
            }
            Cursor query = sQLiteDatabase.query("bundleinfo", null, "pkg_name =? ", new String[]{bundleInfo.getPackageName()}, null, null, null);
            List<BundleInfo> bundleInfoList = BundleInfo.toBundleInfoList(query);
            try {
                query.close();
            } catch (Exception unused) {
            }
            if (bundleInfoList.isEmpty()) {
                sQLiteDatabase.insert("bundleinfo", null, contentValues);
                return true;
            }
            HashMap hashMap = new HashMap();
            for (BundleInfo bundleInfo2 : bundleInfoList) {
                if (bundleInfo2 != null) {
                    hashMap.put(Integer.valueOf(bundleInfo2.getType()), bundleInfo2);
                }
            }
            BundleInfo bundleInfo3 = (BundleInfo) hashMap.get(3);
            BundleInfo bundleInfo4 = (BundleInfo) hashMap.get(2);
            BundleInfo bundleInfo5 = (BundleInfo) hashMap.get(1);
            if (bundleInfo3 != null && bundleInfo3.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo3.getUpdateV() > bundleInfo.getUpdateV()) {
                BundleInfo.updateBundleInfoConfig(bundleInfo, bundleInfo3);
            }
            if (bundleInfo4 != null && bundleInfo4.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo4.getUpdateV() > bundleInfo.getUpdateV()) {
                BundleInfo.updateBundleInfoConfig(bundleInfo, bundleInfo4);
            }
            if (bundleInfo5 != null && bundleInfo5.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo5.getUpdateV() > bundleInfo.getUpdateV()) {
                BundleInfo.updateBundleInfoConfig(bundleInfo, bundleInfo5);
            }
            int type = bundleInfo.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type == 3) {
                        if (bundleInfo3 == null || bundleInfo3.getVersionCode() <= bundleInfo.getVersionCode()) {
                            hashMap.put(3, bundleInfo);
                        }
                        if (bundleInfo4 != null && bundleInfo4.getVersionCode() <= bundleInfo.getVersionCode()) {
                            hashMap.remove(2);
                        }
                        if (bundleInfo5 != null && bundleInfo5.getVersionCode() <= bundleInfo.getVersionCode()) {
                            hashMap.remove(1);
                        }
                    }
                } else if (bundleInfo3 == null || bundleInfo3.getVersionCode() <= bundleInfo.getVersionCode()) {
                    if (bundleInfo3 != null && bundleInfo3.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo3.getUpdateV() <= bundleInfo.getUpdateV()) {
                        BundleInfo.updateBundleInfoConfig(bundleInfo3, bundleInfo);
                    } else {
                        if (bundleInfo4 == null || bundleInfo4.getVersionCode() <= bundleInfo.getVersionCode()) {
                            hashMap.put(2, bundleInfo);
                        }
                        if (bundleInfo5 != null && bundleInfo5.getVersionCode() <= bundleInfo.getVersionCode()) {
                            hashMap.remove(1);
                        }
                    }
                }
            } else if ((bundleInfo3 == null || bundleInfo3.getVersionCode() <= bundleInfo.getVersionCode()) && (bundleInfo4 == null || bundleInfo4.getVersionCode() <= bundleInfo.getVersionCode())) {
                if (bundleInfo3 != null && bundleInfo3.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo3.getUpdateV() <= bundleInfo.getUpdateV()) {
                    BundleInfo.updateBundleInfoConfig(bundleInfo3, bundleInfo);
                } else if (bundleInfo4 != null && bundleInfo4.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo4.getUpdateV() <= bundleInfo.getUpdateV()) {
                    BundleInfo.updateBundleInfoConfig(bundleInfo4, bundleInfo);
                } else if (bundleInfo5 == null || bundleInfo5.getVersionCode() <= bundleInfo.getVersionCode()) {
                    hashMap.put(1, bundleInfo);
                }
            }
            sQLiteDatabase.delete("bundleinfo", "pkg_name =? ", new String[]{contentValues.getAsString("pkg_name")});
            for (BundleInfo bundleInfo6 : hashMap.values()) {
                sQLiteDatabase.insert("bundleinfo", null, BundleInfo.toContentValues(bundleInfo6));
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void l(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, sQLiteDatabase, contentValues) == null) {
            boolean z = false;
            String[] strArr = {contentValues.getAsString("pkg_name"), contentValues.getAsString("type")};
            Cursor query = sQLiteDatabase.query("bundleinfo", null, "pkg_name =?  AND type =? ", strArr, null, null, null);
            if (query.getCount() == 0) {
                z = true;
            }
            try {
                query.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (z) {
                sQLiteDatabase.insert("bundleinfo", null, contentValues);
            } else {
                sQLiteDatabase.update("bundleinfo", contentValues, "pkg_name =?  AND type =? ", strArr);
            }
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048586, this, uri, strArr, str, strArr2, str2)) == null) {
            return this.a.getReadableDatabase().query("bundleinfo", null, str, strArr2, null, null, null);
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, uri, contentValues, str, strArr)) == null) {
            i(new a(this, contentValues));
            return 1;
        }
        return invokeLLLL.intValue;
    }
}
