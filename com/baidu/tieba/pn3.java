package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public on3 i;
    public on3 j;
    public on3 k;
    public on3 l;

    public pn3() {
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
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.h) {
                return b(this.l);
            }
            on3 on3Var = this.k;
            if (on3Var != null) {
                return on3Var.c;
            }
            on3 on3Var2 = this.i;
            if (on3Var2 != null) {
                return on3Var2.c;
            }
            on3 on3Var3 = this.j;
            if (on3Var3 != null) {
                return on3Var3.c;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final int b(on3 on3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on3Var)) == null) {
            if (on3Var != null) {
                return on3Var.c;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final int c(on3 on3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, on3Var)) == null) {
            if (on3Var != null) {
                return on3Var.b;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g != -1 : invokeV.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cores", this.a);
                jSONObject.put("is_biglittle", this.h);
                if (this.h) {
                    jSONObject.put("little_freq_min", c(this.j));
                    jSONObject.put("little_freq_max", b(this.j));
                    jSONObject.put("big_freq_min", c(this.i));
                    jSONObject.put("big_freq_max", b(this.i));
                    jSONObject.put("little_cores", this.b);
                    jSONObject.put("big_cores", this.d);
                    jSONObject.put("little_index", this.c);
                    jSONObject.put("big_index", this.e);
                    if (this.g != -1) {
                        jSONObject.put("super_freq_min", c(this.k));
                        jSONObject.put("super_freq_max", b(this.k));
                        jSONObject.put("super_cores", this.f);
                        jSONObject.put("super_index", this.g);
                    }
                } else {
                    jSONObject.put("freq_min", c(this.l));
                    jSONObject.put("freq_max", b(this.l));
                }
                return jSONObject.toString();
            } catch (JSONException unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
