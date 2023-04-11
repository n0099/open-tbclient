package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.Vector;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class ue0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Vector<Integer> a;
    public long b;
    public long c;
    public Vector<Integer> d;

    public ue0() {
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
        this.a = new Vector<>();
        this.c = 0L;
        this.d = new Vector<>();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.b <= 0) {
                this.b = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i = (int) (currentTimeMillis - this.b);
            if (i < 0) {
                return;
            }
            this.a.add(Integer.valueOf(i));
            this.b = currentTimeMillis;
        }
    }

    public String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            Vector<Integer> vector = this.a;
            if (vector == null || vector.size() == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            float f = 0.0f;
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                Integer num = this.a.get(i);
                if (num != null) {
                    f += num.intValue();
                    jSONArray.put(num);
                }
            }
            if (z) {
                String jSONArray2 = jSONArray.toString();
                if (TextUtils.isEmpty(jSONArray2)) {
                    return "";
                }
                return jSONArray2;
            }
            return new DecimalFormat(".0").format(f / size);
        }
        return (String) invokeZ.objValue;
    }

    public String c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            Vector<Integer> vector = this.d;
            if (vector == null || vector.size() == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            float f = 0.0f;
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                Integer num = this.d.get(i);
                if (num != null) {
                    f += num.intValue();
                    jSONArray.put(num);
                }
            }
            if (z) {
                String jSONArray2 = jSONArray.toString();
                if (TextUtils.isEmpty(jSONArray2)) {
                    return "";
                }
                return jSONArray2;
            }
            return new DecimalFormat(".0").format(f / size);
        }
        return (String) invokeZ.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Vector<Integer> vector = this.a;
            if (vector == null || vector.size() == 0) {
                return 0;
            }
            int size = this.a.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Integer num = this.a.get(i2);
                if (num != null) {
                    i += num.intValue();
                }
            }
            float f = (i * 1.0f) / size;
            if (f == 0.0f) {
                return 0;
            }
            return Math.round(1000.0f / f);
        }
        return invokeV.intValue;
    }

    public void e() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.c <= 0 || (currentTimeMillis = (int) (System.currentTimeMillis() - this.c)) < 0) {
            return;
        }
        this.d.add(Integer.valueOf(currentTimeMillis));
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c = System.currentTimeMillis();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b = 0L;
            this.c = 0L;
            this.a.clear();
            this.d.clear();
        }
    }
}
