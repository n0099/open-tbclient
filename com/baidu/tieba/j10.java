package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes4.dex */
public class j10 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean g;
    public static String h;
    public static HashMap<String, Integer> i;
    public static HashMap<String, Integer> j;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public boolean b;
    public String c;
    public String d;
    public int e;
    public int f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947830304, "Lcom/baidu/tieba/j10;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947830304, "Lcom/baidu/tieba/j10;");
                return;
            }
        }
        g = AppConfig.isDebug();
        h = "networkparam";
        i = new HashMap<>();
        j = new HashMap<>();
        i.put("WIFI", 1);
        i.put("3GNET", 21);
        i.put("3GWAP", 22);
        i.put("CMNET", 31);
        i.put("UNINET", 32);
        i.put("CTNET", 33);
        i.put("CMWAP", 41);
        i.put("UNIWAP", 42);
        i.put("CTWAP", 43);
        j.put("46000", 1);
        j.put("46001", 2);
        j.put("46002", 1);
        j.put("46003", 3);
        j.put("46004", 1);
        j.put("46005", 3);
        j.put("46006", 2);
        j.put("46007", 1);
        j.put("46008", 1);
        j.put("46009", 2);
        j.put("46010", 2);
        j.put("46011", 3);
        j.put("46012", 3);
    }

    public j10() {
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
        this.a = AppRuntime.getAppContext();
    }

    @Deprecated
    public String a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long uptimeMillis = g ? SystemClock.uptimeMillis() : 0L;
            ConnectManager connectManager = new ConnectManager(this.a);
            String netType = connectManager.getNetType();
            int subType = connectManager.getSubType();
            if (!TextUtils.isEmpty(netType)) {
                netType = netType.toUpperCase(Locale.getDefault());
                Integer num = i.get(netType);
                if (num == null) {
                    num = 5;
                }
                str = num + "_" + subType;
            } else {
                str = ((Object) 5) + "_" + subType;
            }
            if (g) {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                Log.i(h, "getCurrentNetTypeId cost " + (uptimeMillis2 - uptimeMillis) + "ms, current net type: " + netType + ", type id: " + str + ", subtype id: " + subType + ", subtype name: " + connectManager.getSubTypeName());
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (d10.b().f() && !this.b) {
                DeviceIdBag operator = DeviceInfoManager.INSTANCE.getOperator(AppRuntime.getAppContext(), "pub_param", "");
                if (operator.errorCode != 3) {
                    return true;
                }
                return !f(operator.deviceId, this.f);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean f(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = j.get(str);
                if (num != null) {
                    if (i2 > 30 && (i2 - num.intValue()) % 10 == 0) {
                        return true;
                    }
                    if ((i2 == 21 || i2 == 22) && num.intValue() == 2) {
                        return true;
                    }
                } else {
                    d10.b().g(new k10(3));
                }
            }
            d10.b().g(new k10(2));
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            ConnectManager connectManager = new ConnectManager(this.a);
            String netType = connectManager.getNetType();
            int subType = connectManager.getSubType();
            if (!TextUtils.isEmpty(netType)) {
                String upperCase = netType.toUpperCase(Locale.getDefault());
                if (i.get(upperCase) == null) {
                    this.f = 5;
                    d10.b().g(new k10(4));
                } else {
                    this.f = i.get(upperCase).intValue();
                }
                this.c = this.f + "_" + subType;
                this.d = h(this.f, subType);
            } else {
                this.f = 5;
                String str = this.f + "_" + subType;
                this.c = str;
                this.d = str;
            }
            this.e = subType;
            int i2 = this.f;
            if (i2 != 5 && i2 != 1) {
                this.b = false;
            } else {
                this.b = true;
            }
            if (z) {
                this.c = i(this.c);
            }
        }
    }

    public final String h(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) {
            if (i2 == 21 || i2 == 22 || i2 == 42) {
                i2 = 32;
            } else if (i2 == 41) {
                i2 = 31;
            } else if (i2 == 43) {
                i2 = 33;
            }
            return i2 + "_" + i3;
        }
        return (String) invokeII.objValue;
    }

    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.equals(str, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                return PreferenceManager.getDefaultSharedPreferences(this.a.getApplicationContext()).getString(NetworkParam.LAST_NETWORK_TYPE, NetworkParam.NET_TYPE_ID_DISCONNECT);
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.a.getApplicationContext()).edit();
                edit.putString(NetworkParam.LAST_NETWORK_TYPE, str);
                edit.apply();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
