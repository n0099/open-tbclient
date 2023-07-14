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
/* loaded from: classes7.dex */
public class o13 extends b22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "UpdateMenuStyleApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o13(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final int y(String str) {
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

    public v32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#changeMenuStyle", false);
            Pair<v32, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((v32) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new v32(202);
                }
                int y = y(optString);
                ix2 T2 = ix2.T();
                if (T2 == null) {
                    return new v32(1001);
                }
                eb2 U = T2.U();
                if (U == null) {
                    return new v32(1001);
                }
                bb2 m = U.m();
                if (m == null) {
                    return new v32(1001);
                }
                ci4 Q1 = m.Q1();
                if (Q1 == null) {
                    if (m instanceof ib2) {
                        ((ib2) m).l3(y);
                        return v32.f();
                    }
                    return new v32(1001);
                }
                Q1.e(y);
                Q1.y();
                return v32.f();
            }
            return new v32(202);
        }
        return (v32) invokeL.objValue;
    }
}
