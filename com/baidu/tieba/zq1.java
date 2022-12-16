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
public class zq1 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948368495, "Lcom/baidu/tieba/zq1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948368495, "Lcom/baidu/tieba/zq1;");
                return;
            }
        }
        boolean z = ok1.a;
    }

    public zq1(String str, String str2, String str3, int i, int i2, int i3, boolean z) {
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

    public ys2 a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showMuteBtn", true);
                jSONObject.put("showCenterPlayBtn", true);
                ys2 ys2Var = new ys2();
                ys2Var.j = "SwanAdPlayer";
                ys2Var.b = "SwanAdPlayer";
                ys2Var.o = true;
                ys2Var.k = false;
                if (!this.g) {
                    z = true;
                } else {
                    z = false;
                }
                ys2Var.x = z;
                ys2Var.I = false;
                ys2Var.l = this.a;
                ys2Var.y = this.b;
                ys2Var.c = this.c;
                ku2 ku2Var = new ku2(0, 0, this.d, this.e);
                ys2Var.h = ku2Var;
                ku2Var.i(true);
                ys2Var.m = this.f;
                if (this.g) {
                    ys2Var.q = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
                }
                return ys2.h(jSONObject, ys2Var);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (ys2) invokeV.objValue;
    }
}
