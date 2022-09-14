package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.funAd.strategy.FunAdSidConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nu6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nu6 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, FunAdSidConfigData> a;

    public nu6() {
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
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap.clear();
        this.a.putAll(c());
    }

    public static nu6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (nu6.class) {
                    if (b == null) {
                        b = new nu6();
                    }
                }
            }
            return b;
        }
        return (nu6) invokeV.objValue;
    }

    public final FunAdSidConfigData a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            FunAdSidConfigData funAdSidConfigData = new FunAdSidConfigData();
            funAdSidConfigData.parserJson(jSONObject);
            return funAdSidConfigData;
        }
        return (FunAdSidConfigData) invokeL.objValue;
    }

    public FunAdSidConfigData b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.a == null || TextUtils.isEmpty(str) || !this.a.containsKey(str)) {
                return null;
            }
            return this.a.get(str);
        }
        return (FunAdSidConfigData) invokeL.objValue;
    }

    public final Map<String, FunAdSidConfigData> c() {
        InterceptResult invokeV;
        FunAdSidConfigData d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap hashMap = new HashMap();
            for (String str : ou6.e().c()) {
                if (!TextUtils.isEmpty(str) && (d = d(str)) != null) {
                    hashMap.put(str, d);
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public final FunAdSidConfigData d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            JSONObject jSONObject = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String string = ou6.g().getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e) {
                BdLog.detailException(e);
            }
            return a(jSONObject);
        }
        return (FunAdSidConfigData) invokeL.objValue;
    }

    public void f(String str, FunAdSidConfigData funAdSidConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, funAdSidConfigData) == null) || this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.a.put(str, funAdSidConfigData);
        g(str);
    }

    public final void g(String str) {
        FunAdSidConfigData funAdSidConfigData;
        JSONObject json;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.a == null || TextUtils.isEmpty(str) || !this.a.containsKey(str) || (funAdSidConfigData = this.a.get(str)) == null || (json = funAdSidConfigData.toJson()) == null) {
            return;
        }
        EditorHelper.putString(ou6.g(), str, json.toString());
    }
}
