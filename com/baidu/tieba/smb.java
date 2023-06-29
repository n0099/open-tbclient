package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class smb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public float b;
    public float c;
    public float d;
    public float e;

    public smb(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.a = true;
    }

    public smb(float f, float f2, float f3, float f4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.a = z;
    }

    public static smb a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            smb smbVar = new smb(0.0f, 1.0f, 1.0f, 0.0f);
            try {
                JSONObject jSONObject = new JSONObject(str);
                smbVar.b = (float) jSONObject.optDouble("bottomLeftX");
                smbVar.c = (float) jSONObject.optDouble("bottomLeftY");
                smbVar.d = (float) jSONObject.optDouble("upperRightX");
                smbVar.e = (float) jSONObject.optDouble("upperRightY");
                smbVar.a = jSONObject.optBoolean("forceEnable");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return smbVar;
        }
        return (smb) invokeL.objValue;
    }
}
