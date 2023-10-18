package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class iv2 extends wv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "UpdateMenuStyleApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iv2(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final int z(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1866956286) {
                if (hashCode == -838846263 && str.equals(StickerDataChangeType.UPDATE)) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (str.equals("webDegrade")) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    return 12;
                }
                return 20;
            }
            return 19;
        }
        return invokeL.intValue;
    }

    public qx1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#changeMenuStyle", false);
            Pair<qx1, JSONObject> t = t(str);
            JSONObject jSONObject = (JSONObject) t.second;
            if (((qx1) t.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new qx1(202);
                }
                int z = z(optString);
                cr2 V = cr2.V();
                if (V == null) {
                    return new qx1(1001);
                }
                y42 W = V.W();
                if (W == null) {
                    return new qx1(1001);
                }
                v42 m = W.m();
                if (m == null) {
                    return new qx1(1001);
                }
                wb4 V1 = m.V1();
                if (V1 == null) {
                    if (m instanceof c52) {
                        ((c52) m).q3(z);
                        return qx1.f();
                    }
                    return new qx1(1001);
                }
                V1.e(z);
                V1.x();
                return qx1.f();
            }
            return new qx1(202);
        }
        return (qx1) invokeL.objValue;
    }
}
