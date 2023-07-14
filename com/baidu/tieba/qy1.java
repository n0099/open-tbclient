package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public boolean g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948108064, "Lcom/baidu/tieba/qy1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948108064, "Lcom/baidu/tieba/qy1;");
                return;
            }
        }
        boolean z = fs1.a;
    }

    public qy1(String str, String str2, String str3, int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = z;
    }

    public p03 a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showMuteBtn", true);
                jSONObject.put("showCenterPlayBtn", true);
                p03 p03Var = new p03();
                p03Var.j = "SwanAdPlayer";
                p03Var.b = "SwanAdPlayer";
                p03Var.o = true;
                p03Var.k = false;
                if (!this.g) {
                    z = true;
                } else {
                    z = false;
                }
                p03Var.x = z;
                p03Var.I = false;
                p03Var.l = this.a;
                p03Var.y = this.b;
                p03Var.c = this.c;
                b23 b23Var = new b23(0, 0, this.d, this.e);
                p03Var.h = b23Var;
                b23Var.i(true);
                p03Var.m = this.f;
                if (this.g) {
                    p03Var.q = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
                }
                return p03.h(jSONObject, p03Var);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (p03) invokeV.objValue;
    }
}
