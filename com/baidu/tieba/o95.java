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
import com.baidu.android.util.KVStorageFactory;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.UniKVTestSwitch;
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
/* loaded from: classes7.dex */
public class o95 {
    public static /* synthetic */ Interceptable $ic;
    public static o95 f;
    public static ContentResolver g;
    public static HashMap<String, String> h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public SharedPreferences b;
    public String c;
    public ConcurrentHashMap<String, Object> d;
    public String e;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;
        public final /* synthetic */ ContentValues b;
        public final /* synthetic */ o95 c;

        public a(o95 o95Var, Uri uri, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o95Var, uri, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o95Var;
            this.a = uri;
            this.b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.c.U(this.a, this.b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;
        public final /* synthetic */ o95 b;

        public b(o95 o95Var, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o95Var, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o95Var;
            this.a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.b.k(this.a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public o95() {
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
        hashMap.put(n95.a, AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS);
        h.put(n95.b, "remote_settings");
        h.put(n95.c, "bdservice_settings");
        h.put(n95.d, n95.g);
        h.put(n95.e, n95.h);
        h.put(n95.f, n95.i);
        g = TbadkCoreApplication.getInst().getContext().getContentResolver();
    }

    public synchronized SharedPreferences u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            synchronized (this) {
                if (!PermissionUtil.isBrowseMode() && PermissionUtil.isAgreePrivacyPolicy()) {
                    if (this.c == null || this.c.length() == 0) {
                        if (this.a == null || this.a.length() == 0) {
                            this.a = s();
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

    public synchronized SharedPreferences v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            synchronized (this) {
                if (!PermissionUtil.isBrowseMode() && PermissionUtil.isAgreePrivacyPolicy()) {
                    if (this.c == null || this.c.length() == 0) {
                        if (this.a == null || this.a.length() == 0) {
                            this.a = s();
                        }
                        if (h.containsKey(this.a)) {
                            this.c = h.get(this.a);
                        } else {
                            this.c = AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS;
                        }
                    }
                    return KVStorageFactory.getSharedPreferences(this.c, 0);
                }
                return KVStorageFactory.getSharedPreferences(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS, 0);
            }
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public final void B(String str, boolean z, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), sharedPreferences}) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public final void E(String str, float f2, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Float.valueOf(f2), sharedPreferences}) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putFloat(str, f2);
            edit.commit();
        }
    }

    public final void G(String str, int i, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, sharedPreferences) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public final void I(String str, long j, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Long.valueOf(j), sharedPreferences}) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public final void K(String str, String str2, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, sharedPreferences) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public final void Y(String str, int i, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048600, this, str, i, sharedPreferences) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public final void a0(String str, long j, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{str, Long.valueOf(j), sharedPreferences}) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public final void C(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) && str != null && obj != null) {
            this.d.put(str, obj);
            h();
        }
    }

    public final void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            Uri parse = Uri.parse(m() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, str2);
            T(parse, contentValues);
        }
    }

    public void R(String str, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, sharedPreferences) == null) {
            EditorHelper.remove(sharedPreferences, str);
        }
    }

    public void T(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, uri, contentValues) == null) {
            if (wi.E()) {
                new a(this, uri, contentValues).execute(new Void[0]);
            } else {
                U(uri, contentValues);
            }
        }
    }

    public final void U(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, uri, contentValues) == null) {
            try {
                g.insert(uri, contentValues);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public static synchronized o95 p() {
        InterceptResult invokeV;
        o95 o95Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (o95.class) {
                if (f == null) {
                    f = new o95();
                }
                o95Var = f;
            }
            return o95Var;
        }
        return (o95) invokeV.objValue;
    }

    public ContentResolver n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return g;
        }
        return (ContentResolver) invokeV.objValue;
    }

    public static String t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return str + "_" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeL.objValue;
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            j(Uri.parse(m() + str));
        }
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (str != null && str.length() != 0) {
                int length = n95.k.length;
                for (int i = 0; i < length; i++) {
                    if (str.equals(n95.k[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void g(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, sharedPreferences) == null) && (edit = sharedPreferences.edit()) != null) {
            edit.clear();
            edit.commit();
        }
    }

    public void j(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, uri) == null) {
            if (wi.E()) {
                new b(this, uri).execute(new Void[0]);
            } else {
                k(uri);
            }
        }
    }

    public final void k(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, uri) == null) {
            try {
                g.delete(uri, null, null);
            } catch (SecurityException e) {
                BdLog.detailException(e);
            }
        }
    }

    public String x(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, uri)) == null) {
            try {
                return g.getType(uri);
            } catch (SecurityException e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, str)) == null) {
            return x(Uri.parse(m() + str));
        }
        return (String) invokeL.objValue;
    }

    public void A(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            if (c(str)) {
                P(str, z);
            } else if (wi.E()) {
                C(str, Boolean.valueOf(z));
            } else {
                if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                    B(str, z, u());
                }
                if (UniKVTestSwitch.isTypeKv() || UniKVTestSwitch.isTypeDoubleKv()) {
                    B(str, z, v());
                }
            }
        }
    }

    public void D(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048579, this, str, f2) == null) {
            if (c(str)) {
                L(str, f2);
            } else if (wi.E()) {
                C(str, Float.valueOf(f2));
            } else {
                if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                    E(str, f2, u());
                }
                if (UniKVTestSwitch.isTypeKv() || UniKVTestSwitch.isTypeDoubleKv()) {
                    E(str, f2, v());
                }
            }
        }
    }

    public void F(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            if (c(str)) {
                M(str, i);
            } else if (wi.E()) {
                C(str, Integer.valueOf(i));
            } else {
                if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                    G(str, i, u());
                }
                if (UniKVTestSwitch.isTypeKv() || UniKVTestSwitch.isTypeDoubleKv()) {
                    G(str, i, v());
                }
            }
        }
    }

    public void H(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, str, j) == null) {
            if (c(str)) {
                N(str, j);
            } else if (wi.E()) {
                C(str, Long.valueOf(j));
            } else {
                if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                    I(str, j, u());
                }
                if (UniKVTestSwitch.isTypeKv() || UniKVTestSwitch.isTypeDoubleKv()) {
                    I(str, j, v());
                }
            }
        }
    }

    public void J(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            if (c(str)) {
                O(str, str2);
            } else if (StringUtil.NULL_STRING.equals(str2)) {
                Q(str);
            } else if (wi.E()) {
                C(str, str2);
            } else {
                if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                    K(str, str2, u());
                }
                if (UniKVTestSwitch.isTypeKv() || UniKVTestSwitch.isTypeDoubleKv()) {
                    K(str, str2, v());
                }
            }
        }
    }

    public final void f(String str, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048606, this, str, sharedPreferences) == null) && !TextUtils.isEmpty(str) && sharedPreferences != null) {
            Set<String> keySet = sharedPreferences.getAll().keySet();
            SharedPreferences.Editor edit = sharedPreferences.edit();
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

    public boolean l(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048612, this, str, z)) == null) {
            if (c(str)) {
                String y = y(str);
                if (y == null) {
                    return z;
                }
                try {
                    return Boolean.parseBoolean(y);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return z;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (UniKVTestSwitch.isTypeSp()) {
                this.b = u();
            } else {
                this.b = v();
            }
            return this.b.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public float o(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048615, this, str, f2)) == null) {
            if (c(str)) {
                String y = y(str);
                if (y == null) {
                    return f2;
                }
                try {
                    return Float.parseFloat(y);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return f2;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            if (UniKVTestSwitch.isTypeSp()) {
                this.b = u();
            } else {
                this.b = v();
            }
            return this.b.getFloat(str, f2);
        }
        return invokeLF.floatValue;
    }

    public int q(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048616, this, str, i)) == null) {
            if (c(str)) {
                String y = y(str);
                if (y == null) {
                    return i;
                }
                try {
                    return Integer.parseInt(y);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return i;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (UniKVTestSwitch.isTypeSp()) {
                this.b = u();
            } else {
                this.b = v();
            }
            return this.b.getInt(str, i);
        }
        return invokeLI.intValue;
    }

    public long r(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048617, this, str, j)) == null) {
            if (c(str)) {
                String y = y(str);
                if (y == null) {
                    return j;
                }
                try {
                    return Long.parseLong(y);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return j;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            if (UniKVTestSwitch.isTypeSp()) {
                this.b = u();
            } else {
                this.b = v();
            }
            try {
                return this.b.getLong(str, j);
            } catch (ClassCastException e2) {
                BdLog.e(e2);
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public String w(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048621, this, str, str2)) == null) {
            if (c(str)) {
                String y = y(str);
                if (y != null) {
                    return y;
                }
                return str2;
            }
            Object obj = this.d.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            if (UniKVTestSwitch.isTypeSp()) {
                this.b = u();
            } else {
                this.b = v();
            }
            return this.b.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public final void L(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048587, this, str, f2) == null) {
            Uri parse = Uri.parse(m() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(f2));
            T(parse, contentValues);
        }
    }

    public final void M(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i) == null) {
            Uri parse = Uri.parse(m() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(i));
            T(parse, contentValues);
        }
    }

    public final void N(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048589, this, str, j) == null) {
            Uri parse = Uri.parse(m() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(j));
            T(parse, contentValues);
        }
    }

    public final void P(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) {
            Uri parse = Uri.parse(m() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(z));
            T(parse, contentValues);
        }
    }

    public void X(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, str, i) == null) {
            if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                Y(str, i, u());
            }
            if (UniKVTestSwitch.isTypeKv() || UniKVTestSwitch.isTypeDoubleKv()) {
                Y(str, i, v());
            }
        }
    }

    public void Z(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048601, this, str, j) == null) {
            if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                a0(str, j, u());
            }
            if (UniKVTestSwitch.isTypeKv() || UniKVTestSwitch.isTypeDoubleKv()) {
                a0(str, j, v());
            }
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            if (c(str)) {
                S(str);
            } else if (this.d.containsKey(str)) {
                this.d.remove(str);
            } else {
                if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                    R(str, u());
                }
                if (UniKVTestSwitch.isTypeKv() || UniKVTestSwitch.isTypeDoubleKv()) {
                    R(str, v());
                }
            }
        }
    }

    public boolean z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) {
            if (c(str)) {
                return false;
            }
            if (UniKVTestSwitch.isTypeSp()) {
                if (!this.d.containsKey(str) && !u().contains(str)) {
                    return false;
                }
                return true;
            } else if (!this.d.containsKey(str) && !v().contains(str)) {
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || this.d.isEmpty()) {
            return;
        }
        if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv()) {
            W(u());
        }
        if (UniKVTestSwitch.isTypeKv() || UniKVTestSwitch.isTypeDoubleKv()) {
            W(v());
        }
        this.d.clear();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                g(u());
            }
            if (UniKVTestSwitch.isTypeKv() || UniKVTestSwitch.isTypeDoubleKv()) {
                g(v());
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048608, this) != null) || this.d.isEmpty()) {
            return;
        }
        if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv()) {
            i(u());
        }
        if (UniKVTestSwitch.isTypeKv() || UniKVTestSwitch.isTypeDoubleKv()) {
            i(v());
        }
        this.d.clear();
    }

    public final void W(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, sharedPreferences) != null) || sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
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
    }

    public final void i(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, sharedPreferences) != null) || sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
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
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                f(str, u());
            }
            if (UniKVTestSwitch.isTypeKv() || UniKVTestSwitch.isTypeDoubleKv()) {
                f(str, v());
            }
        }
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.e == null) {
                String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
                if ("com.baidu.tieba".equals(packageName)) {
                    this.e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
                } else {
                    this.e = DownloadConstants.LOCAL_DATA_URI_PREFIX + packageName + ".sharedPref.MainSharedPrefProvider/";
                }
            }
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
            String str = n95.a;
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
}
