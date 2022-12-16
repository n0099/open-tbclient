package com.baidu.tieba;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class ry4 {
    public static /* synthetic */ Interceptable $ic;
    public static ry4 f;
    public static ContentResolver g;
    public static HashMap<String, String> h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public SharedPreferences b;
    public String c;
    public ConcurrentHashMap<String, Object> d;
    public String e;

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;
        public final /* synthetic */ ContentValues b;
        public final /* synthetic */ ry4 c;

        public a(ry4 ry4Var, Uri uri, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry4Var, uri, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ry4Var;
            this.a = uri;
            this.b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.c.H(this.a, this.b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;
        public final /* synthetic */ ry4 b;

        public b(ry4 ry4Var, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry4Var, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ry4Var;
            this.a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.b.h(this.a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public ry4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.d = new ConcurrentHashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        h = hashMap;
        hashMap.put(qy4.a, AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS);
        h.put(qy4.b, "remote_settings");
        h.put(qy4.c, "bdservice_settings");
        h.put(qy4.d, qy4.g);
        h.put(qy4.e, qy4.h);
        h.put(qy4.f, qy4.i);
        g = TbadkCoreApplication.getInst().getContext().getContentResolver();
    }

    public synchronized SharedPreferences q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this) {
                if (!PermissionUtil.isBrowseMode() && PermissionUtil.isAgreePrivacyPolicy()) {
                    if (this.c == null || this.c.length() == 0) {
                        if (this.a == null || this.a.length() == 0) {
                            this.a = o();
                        }
                        if (h.containsKey(this.a)) {
                            this.c = h.get(this.a);
                        } else {
                            this.c = AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS;
                        }
                    }
                    return TbadkCoreApplication.getInst().getSharedPreferences(this.c, 0);
                }
                return TbadkCoreApplication.getInst().getSharedPreferences(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS, 0);
            }
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public final void C(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            Uri parse = Uri.parse(j() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, str2);
            G(parse, contentValues);
        }
    }

    public void G(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, uri, contentValues) == null) {
            if (yi.E()) {
                new a(this, uri, contentValues).execute(new Void[0]);
            } else {
                H(uri, contentValues);
            }
        }
    }

    public final void H(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, uri, contentValues) == null) {
            try {
                g.insert(uri, contentValues);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void J(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, str, i) == null) {
            SharedPreferences q = q();
            this.b = q;
            SharedPreferences.Editor edit = q.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public void K(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, str, j) == null) {
            SharedPreferences q = q();
            this.b = q;
            SharedPreferences.Editor edit = q.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public final void w(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, str, obj) == null) && str != null && obj != null) {
            this.d.put(str, obj);
            f();
        }
    }

    public static synchronized ry4 l() {
        InterceptResult invokeV;
        ry4 ry4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (ry4.class) {
                if (f == null) {
                    f = new ry4();
                }
                ry4Var = f;
            }
            return ry4Var;
        }
        return (ry4) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            SharedPreferences q = q();
            this.b = q;
            SharedPreferences.Editor edit = q.edit();
            if (edit != null) {
                edit.clear();
                edit.commit();
            }
        }
    }

    public ContentResolver k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return g;
        }
        return (ContentResolver) invokeV.objValue;
    }

    public static String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return str + "_" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeL.objValue;
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (c(str)) {
                F(str);
            } else if (this.d.containsKey(str)) {
                this.d.remove(str);
            } else {
                SharedPreferences q = q();
                this.b = q;
                EditorHelper.remove(q, str);
            }
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            g(Uri.parse(j() + str));
        }
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (str != null && str.length() != 0) {
                int length = qy4.j.length;
                for (int i = 0; i < length; i++) {
                    if (str.equals(qy4.j[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, uri) == null) {
            if (yi.E()) {
                new b(this, uri).execute(new Void[0]);
            } else {
                h(uri);
            }
        }
    }

    public final void h(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, uri) == null) {
            try {
                g.delete(uri, null, null);
            } catch (SecurityException e) {
                BdLog.detailException(e);
            }
        }
    }

    public String s(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, uri)) == null) {
            try {
                return g.getType(uri);
            } catch (SecurityException e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            return s(Uri.parse(j() + str));
        }
        return (String) invokeL.objValue;
    }

    public boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (c(str)) {
                return false;
            }
            if (!this.d.containsKey(str) && !q().contains(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void A(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            Uri parse = Uri.parse(j() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(i));
            G(parse, contentValues);
        }
    }

    public final void B(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            Uri parse = Uri.parse(j() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(j));
            G(parse, contentValues);
        }
    }

    public final void D(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) {
            Uri parse = Uri.parse(j() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(z));
            G(parse, contentValues);
        }
    }

    public boolean i(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048593, this, str, z)) == null) {
            if (c(str)) {
                String t = t(str);
                if (t == null) {
                    return z;
                }
                try {
                    return Boolean.parseBoolean(t);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return z;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            SharedPreferences q = q();
            this.b = q;
            return q.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public int m(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, str, i)) == null) {
            if (c(str)) {
                String t = t(str);
                if (t == null) {
                    return i;
                }
                try {
                    return Integer.parseInt(t);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return i;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            SharedPreferences q = q();
            this.b = q;
            return q.getInt(str, i);
        }
        return invokeLI.intValue;
    }

    public String r(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, str, str2)) == null) {
            if (c(str)) {
                String t = t(str);
                if (t != null) {
                    return t;
                }
                return str2;
            }
            Object obj = this.d.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            SharedPreferences q = q();
            this.b = q;
            return q.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public void v(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, str, z) == null) {
            if (c(str)) {
                D(str, z);
            } else if (yi.E()) {
                w(str, Boolean.valueOf(z));
            } else {
                SharedPreferences q = q();
                this.b = q;
                SharedPreferences.Editor edit = q.edit();
                edit.putBoolean(str, z);
                edit.commit();
            }
        }
    }

    public void x(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048606, this, str, i) == null) {
            if (c(str)) {
                A(str, i);
            } else if (yi.E()) {
                w(str, Integer.valueOf(i));
            } else {
                SharedPreferences q = q();
                this.b = q;
                SharedPreferences.Editor edit = q.edit();
                edit.putInt(str, i);
                edit.commit();
            }
        }
    }

    public void y(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048607, this, str, j) == null) {
            if (c(str)) {
                B(str, j);
            } else if (yi.E()) {
                w(str, Long.valueOf(j));
            } else {
                SharedPreferences q = q();
                this.b = q;
                SharedPreferences.Editor edit = q.edit();
                edit.putLong(str, j);
                edit.commit();
            }
        }
    }

    public void z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, str, str2) == null) {
            if (c(str)) {
                C(str, str2);
            } else if (StringUtil.NULL_STRING.equals(str2)) {
                E(str);
            } else if (yi.E()) {
                w(str, str2);
            } else {
                SharedPreferences q = q();
                this.b = q;
                SharedPreferences.Editor edit = q.edit();
                edit.putString(str, str2);
                edit.commit();
            }
        }
    }

    public void I() {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.d.isEmpty()) {
            return;
        }
        SharedPreferences q = q();
        this.b = q;
        if (q == null || (edit = q.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.d.entrySet()) {
            if (entry != null) {
                String valueOf = String.valueOf(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(valueOf, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(valueOf, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(valueOf, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(valueOf, ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    edit.putFloat(valueOf, ((Float) value).floatValue());
                }
            }
        }
        edit.commit();
        this.d.clear();
    }

    public void f() {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.d.isEmpty()) {
            return;
        }
        SharedPreferences q = q();
        this.b = q;
        if (q == null || (edit = q.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.d.entrySet()) {
            if (entry != null) {
                String valueOf = String.valueOf(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(valueOf, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(valueOf, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(valueOf, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(valueOf, ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    edit.putFloat(valueOf, ((Float) value).floatValue());
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
        this.d.clear();
    }

    public void e(String str) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.b = q();
            if (!TextUtils.isEmpty(str) && (sharedPreferences = this.b) != null) {
                Set<String> keySet = sharedPreferences.getAll().keySet();
                SharedPreferences.Editor edit = this.b.edit();
                for (String str2 : keySet) {
                    if (str2.endsWith("_" + str)) {
                        edit.remove(str2);
                    }
                }
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            }
        }
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.e == null) {
                String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
                if ("com.baidu.tieba".equals(packageName)) {
                    this.e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
                } else {
                    this.e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
                }
            }
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
            String str = qy4.a;
            ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.getInst().getSystemService("activity");
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                int myPid = Process.myPid();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                    return str;
                }
                return str;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public long n(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048597, this, str, j)) == null) {
            if (c(str)) {
                String t = t(str);
                if (t == null) {
                    return j;
                }
                try {
                    return Long.parseLong(t);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return j;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            SharedPreferences q = q();
            this.b = q;
            try {
                return q.getLong(str, j);
            } catch (ClassCastException e2) {
                BdLog.e(e2);
                return j;
            }
        }
        return invokeLJ.longValue;
    }
}
