package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class x7b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public JSONObject c;
    public JSONObject d;
    public JSONObject e;
    public String f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public List<k7b> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948254694, "Lcom/baidu/tieba/x7b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948254694, "Lcom/baidu/tieba/x7b;");
                return;
            }
        }
        n = c8b.m();
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (JSONObject) invokeV.objValue;
    }

    public List<k7b> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m;
        }
        return (List) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public x7b(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = new ArrayList();
        this.c = jSONObject;
    }

    public x7b(List<k7b> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = new ArrayList();
        if (list != null && list.size() > 0) {
            this.m.addAll(list);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        JSONObject optJSONObject;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                if (this.c != null && this.c.length() != 0) {
                    JSONObject jSONObject = this.c;
                    this.d = jSONObject.optJSONObject("set");
                    this.a = jSONObject.optInt("threshold", 10000);
                    this.b = jSONObject.optInt("timeup", 604800000);
                    this.f = jSONObject.optString("step");
                    jSONObject.optString(StickerDataChangeType.REPLACE);
                    this.e = jSONObject.optJSONObject("del");
                    this.g = jSONObject.optInt("all_size", 614400);
                    this.h = jSONObject.optInt("single_size", 153600);
                    this.i = jSONObject.optInt("real_size", 614400);
                    this.j = jSONObject.optInt("non_real_size", 614400);
                    this.k = jSONObject.optInt("trigger_number", 100);
                    this.l = jSONObject.optInt("trigger_interval", 180);
                    int i = 1;
                    if (this.d != null) {
                        Iterator<String> keys = this.d.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next) && (optJSONObject = this.d.optJSONObject(next)) != null && optJSONObject.length() != 0) {
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                                String optString = optJSONObject.optString("version");
                                if (optJSONObject2 != null && !TextUtils.isEmpty(optString)) {
                                    if (optJSONObject2.optInt("switch", i) != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (optJSONObject2.optInt(Constant.IS_REAL, 0) == 1) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (optJSONObject2.optInt("isAbtest", 0) == 1) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    Iterator<String> it = keys;
                                    k7b k7bVar = new k7b(next, z, z2, optJSONObject2.optInt("timeout", 60), optJSONObject2.optInt("type", 0), z3);
                                    if (n7b.a(next)) {
                                        if (optJSONObject2.optInt("isSend", 1) == 1) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        k7bVar.z(z7);
                                    }
                                    if (optJSONObject2.has("rate")) {
                                        k7bVar.E(optJSONObject2.getInt("rate"));
                                    }
                                    if (optJSONObject2.has("c")) {
                                        k7bVar.v(optJSONObject2.getString("c"));
                                    }
                                    if (optJSONObject2.has("limitUnit")) {
                                        k7bVar.B(optJSONObject2.getInt("limitUnit"));
                                    }
                                    if (optJSONObject2.has("limitCnt")) {
                                        k7bVar.A(optJSONObject2.getInt("limitCnt"));
                                    }
                                    if (optJSONObject2.has(Constant.ID_TYPE)) {
                                        k7bVar.x(optJSONObject2.getInt(Constant.ID_TYPE));
                                    }
                                    if (optJSONObject2.optInt("ch", 0) == 1) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    k7bVar.D(z4);
                                    if (optJSONObject2.has("dfc")) {
                                        if (optJSONObject2.getInt("dfc") == 1) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        k7bVar.y(z6);
                                    }
                                    if (optJSONObject2.has("reallog")) {
                                        if (optJSONObject2.getInt("reallog") == 1) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        k7bVar.F(z5);
                                    }
                                    if (optJSONObject2.has("gflow")) {
                                        k7bVar.w(optJSONObject2.getInt("gflow"));
                                    }
                                    if (optJSONObject2.has("uploadType")) {
                                        k7bVar.G(optJSONObject2.optInt("uploadType", -1));
                                    }
                                    int optInt = optJSONObject2.optInt("lcache", 2);
                                    if (optInt == 1 || optInt == 0) {
                                        k7bVar.C(optInt);
                                    }
                                    k7bVar.H(optString);
                                    this.m.add(k7bVar);
                                    keys = it;
                                    i = 1;
                                }
                            }
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            } catch (JSONException e) {
                if (n) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void m(List<k7b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.m = list;
        }
    }
}
