package com.bun.miitmdid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.interfaces.IIdConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes7.dex */
public class b implements IIdConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public v a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this);
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String a2 = d0.a(context, "supplierconfig.json");
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            b bVar = new b();
            try {
                JSONObject jSONObject = (JSONObject) new JSONTokener(a2).nextValue();
                if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("supplier")) != null) {
                    if (a(bVar, optJSONObject)) {
                        return bVar;
                    }
                    return null;
                }
                return null;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (b) invokeL.objValue;
    }

    public static boolean a(b bVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bVar, jSONObject)) == null) {
            if (jSONObject == null || bVar == null) {
                return false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(RomUtils.MANUFACTURER_VIVO);
            v vVar = new v();
            if (optJSONObject != null) {
                vVar.a = optJSONObject.optString("appid");
                bVar.a.a = vVar;
            }
            return bVar.a.a != null;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.bun.miitmdid.interfaces.IIdConfig
    public String getVivoAppID() {
        InterceptResult invokeV;
        v vVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = this.a;
            return (aVar == null || (vVar = aVar.a) == null || (str = vVar.a) == null) ? "" : str;
        }
        return (String) invokeV.objValue;
    }
}
