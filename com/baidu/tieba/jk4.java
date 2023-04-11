package com.baidu.tieba;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class jk4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jk4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public volatile boolean b;

    /* loaded from: classes5.dex */
    public static class a extends eo4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super("updatecore_node_host");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public jk4() {
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
        this.b = false;
        this.a = new a();
    }

    public static jk4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (jk4.class) {
                    if (c == null) {
                        c = new jk4();
                    }
                }
            }
            return c;
        }
        return (jk4) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String c2 = c("failureUrl");
            if (!TextUtils.isEmpty(c2)) {
                return c2;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public Long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return Long.valueOf(this.a.getLong("identity", 0L));
        }
        return (Long) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a.contains("version")) {
                return this.a.getString("version", "0");
            }
            if (!f()) {
                return "0";
            }
            return this.a.getString("version", "0");
        }
        return (String) invokeV.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String string = this.a.getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            if (f()) {
                String string2 = this.a.getString(str, "");
                if (!TextUtils.isEmpty(string2)) {
                    return string2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public synchronized boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.b) {
                    return true;
                }
                String D = yn4.D(AppRuntime.getAppContext(), "config/union-cfg.json");
                HashSet hashSet = null;
                if (TextUtils.isEmpty(D)) {
                    File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
                    if (file.exists()) {
                        D = yn4.E(file);
                    } else {
                        D = null;
                    }
                }
                if (TextUtils.isEmpty(D)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(D);
                    String optString = jSONObject.optString("hostName");
                    String optString2 = jSONObject.optString("schemeHead");
                    String optString3 = jSONObject.optString("shareCallbackUrl");
                    String optString4 = jSONObject.optString("failureUrl");
                    int optInt = jSONObject.optInt("version");
                    JSONArray optJSONArray = jSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        hashSet = new HashSet();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            hashSet.add(optJSONArray.optString(i));
                        }
                    }
                    HashSet hashSet2 = hashSet;
                    int optInt2 = jSONObject.optInt("officialNo");
                    int optInt3 = jSONObject.optInt("containerNo");
                    JSONObject optJSONObject = jSONObject.optJSONObject("confsk");
                    long j = 0;
                    if (optJSONObject != null) {
                        String optString5 = optJSONObject.optString("value");
                        long optLong = optJSONObject.optLong("identity");
                        if (ff4.b() != null) {
                            ff4.b().d(optString5.getBytes());
                        }
                        j = optLong;
                    }
                    h(new ik4(null, optInt2, optInt3, optString, optString3, optString4, String.valueOf(optInt), hashSet2, optString2, Long.valueOf(j)));
                    this.b = true;
                    return true;
                } catch (JSONException unused) {
                    return false;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public boolean g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            int i = this.a.getInt("use_openbundleid", -1);
            if (i == -1) {
                return z;
            }
            if (i == 1) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a.edit().putInt("use_openbundleid", i).apply();
        }
    }

    public final void h(ik4 ik4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ik4Var) == null) && ik4Var != null && !TextUtils.isEmpty(ik4Var.d) && !TextUtils.isEmpty(ik4Var.i) && !TextUtils.isEmpty(ik4Var.g)) {
            SharedPreferences.Editor putString = this.a.edit().putString("hostName", ik4Var.d).putString("schemeHead", ik4Var.i).putString("shareCallbackUrl", ik4Var.e).putString("failureUrl", ik4Var.f).putString("version", ik4Var.g);
            Set<String> set = ik4Var.h;
            if (set != null && !set.isEmpty()) {
                putString.putStringSet(SocialOperation.GAME_SIGNATURE, ik4Var.h);
            }
            Long l = ik4Var.j;
            if (l != null) {
                putString.putLong("identity", l.longValue());
            }
            putString.apply();
        }
    }

    public void i(ik4 ik4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, ik4Var) != null) || ik4Var == null) {
            return;
        }
        SharedPreferences.Editor putString = this.a.edit().putString("hostName", ik4Var.d).putString("schemeHead", ik4Var.i).putString("shareCallbackUrl", ik4Var.e).putString("failureUrl", ik4Var.f).putString(CameraActivityConfig.KEY_CONTENT_TYPE, ik4Var.a).putInt("containerNo", ik4Var.c).putInt("officialNo", ik4Var.b).putString("version", ik4Var.g);
        Set<String> set = ik4Var.h;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, ik4Var.h);
        }
        putString.apply();
    }
}
