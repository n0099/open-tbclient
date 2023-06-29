package com.baidu.tieba;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kx5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile kx5 e = null;
    public static String f = "ad_download_center";
    public static int g = 3;
    public static int h = 4;
    public static String i = "MYPAGE_TAB";
    public static String j = "POINT_VISIBLE";
    public static String k = "POINT_GONE";
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;
    public SharedPreferences.Editor b;
    public String c;
    public boolean d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947928481, "Lcom/baidu/tieba/kx5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947928481, "Lcom/baidu/tieba/kx5;");
        }
    }

    public kx5() {
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
        this.d = false;
        this.c = TbadkCoreApplication.getCurrentAccount();
        SharedPreferences sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences("person_download_apks", 0);
        this.a = sharedPreferences;
        this.b = sharedPreferences.edit();
    }

    public static kx5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (e == null) {
                synchronized (kx5.class) {
                    if (e == null) {
                        e = new kx5();
                    }
                }
            }
            return e;
        }
        return (kx5) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921740, Boolean.FALSE));
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && f()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921744));
            r(i, false);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921740, Boolean.TRUE));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921741));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921742));
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (str != null && !str.equals("")) {
                try {
                    if (new File(str).exists()) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (str != null && !"".equals(str)) {
                try {
                    if (TbadkCoreApplication.getInst().getPackageManager().getApplicationInfo(str, 0) != null) {
                        return true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                n(true);
                b();
                g();
                return;
            }
            n(false);
            p();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            HashMap<String, String> e2 = e();
            if (!TextUtils.isEmpty(str) && e2 != null && e2.size() > 0 && e2.containsKey(str)) {
                e2.remove(str);
                m(e2);
            }
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.d = z;
        }
    }

    public HashMap<String, String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return null;
                }
                this.c = TbadkCoreApplication.getCurrentAccount();
            }
            HashMap<String, String> hashMap = new HashMap<>();
            try {
                JSONArray jSONArray = new JSONArray(this.a.getString(this.c, ""));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    JSONArray names = jSONObject.names();
                    if (names != null) {
                        for (int i3 = 0; i3 < names.length(); i3++) {
                            String string = names.getString(i3);
                            hashMap.put(string, jSONObject.getString(string));
                        }
                    }
                }
                return hashMap;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (HashMap) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HashMap<String, String> e2 = e();
            if (e2 != null && e2.size() > 0) {
                for (Map.Entry<String, String> entry : e2.entrySet()) {
                    if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                        break;
                    } else if (entry.getKey().equals(i) && entry.getValue().equals(j)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && str != null && str.length() > 0 && i(str)) {
            File file = new File(str);
            try {
                Intent intent = new Intent();
                intent.setAction(IntentConstants.ACTION_BOX_BROWSER);
                intent.setDataAndType(UtilHelper.getUriFromFile(file, intent, TbadkCoreApplication.getInst()), "application/vnd.android.package-archive");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                TbadkCoreApplication.getInst().startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void m(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hashMap) == null) {
            if (TextUtils.isEmpty(this.c)) {
                if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return;
                }
                this.c = TbadkCoreApplication.getCurrentAccount();
            }
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                }
            }
            jSONArray.put(jSONObject);
            this.b.putString(this.c, jSONArray.toString());
            this.b.commit();
        }
    }

    public void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, str, z) == null) {
            HashMap<String, String> e2 = e();
            if (!TextUtils.isEmpty(str) && e2 != null && e2.size() > 0) {
                for (Map.Entry<String, String> entry : e2.entrySet()) {
                    if (entry != null && e2.containsKey(str)) {
                        if (z) {
                            e2.put(str, j);
                        } else {
                            e2.put(str, k);
                        }
                        m(e2);
                    }
                }
            }
        }
    }
}
