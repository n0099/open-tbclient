package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class x12 implements z12 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract d32 c(@NonNull ja2 ja2Var);

    public abstract d32 d(int i);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948247440, "Lcom/baidu/tieba/x12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948247440, "Lcom/baidu/tieba/x12;");
                return;
            }
        }
        a = db3.v;
    }

    public x12() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.z12
    public d32 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (db3.b0() == null) {
                if (a) {
                    Log.d("AbsMenuButtonHandle", "handleBoundsResult swanApp is null");
                }
                return d(1001);
            }
            ma2 U = qw2.T().U();
            if (U == null) {
                if (a) {
                    Log.d("AbsMenuButtonHandle", "handleBoundsResult fmManager is null");
                }
                return d(1001);
            }
            ja2 m = U.m();
            if (m == null) {
                if (a) {
                    Log.d("AbsMenuButtonHandle", "handleBoundsResult fragment is null");
                }
                return d(1001);
            }
            return c(m);
        }
        return (d32) invokeV.objValue;
    }

    public JSONObject b(int i, int i2, int i3, int i4) throws JSONException {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("width", Integer.valueOf(i3 - i));
            jSONObject.putOpt("height", Integer.valueOf(i4 - i2));
            jSONObject.putOpt("left", Integer.valueOf(i));
            jSONObject.putOpt("right", Integer.valueOf(i3));
            jSONObject.putOpt("top", Integer.valueOf(i2));
            jSONObject.putOpt("bottom", Integer.valueOf(i4));
            return jSONObject;
        }
        return (JSONObject) invokeIIII.objValue;
    }
}
