package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;

    public lh5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                return "";
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                str = "skin=dark";
            } else {
                str = "skin=default";
            }
            if (this.b.contains("?")) {
                this.b += "&customfullscreen=1&nonavigationbar=1&" + str;
            } else {
                this.b += "?customfullscreen=1&nonavigationbar=1&" + str;
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, jSONObject) != null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("homepage_guide")) == null) {
            return;
        }
        this.a = optJSONObject.optString("guide_picture");
        this.b = optJSONObject.optString("guide_url");
    }
}
