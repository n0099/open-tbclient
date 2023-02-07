package com.baidu.tieba;

import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u32 extends t32 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends c22>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c22> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948159989, "Lcom/baidu/tieba/u32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948159989, "Lcom/baidu/tieba/u32;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", z22.class);
        m.put("fillRect", o22.class);
        m.put("setStrokeStyle", i32.class);
        m.put("strokeStyle", p32.class);
        m.put("setLineCap", c32.class);
        m.put("setLineJoin", e32.class);
        m.put("setLineWidth", f32.class);
        m.put("setLineDash", d32.class);
        m.put("setMiterLimit", g32.class);
        m.put("strokeRect", o32.class);
        m.put("moveTo", s22.class);
        m.put("lineTo", r22.class);
        m.put("stroke", n32.class);
        m.put("fill", n22.class);
        m.put("beginPath", f22.class);
        m.put("rect", u22.class);
        m.put("clearRect", h22.class);
        m.put("closePath", j22.class);
        m.put("arc", e22.class);
        m.put("bezierCurveTo", g22.class);
        m.put("quadraticCurveTo", t22.class);
        m.put("scale", y22.class);
        m.put("rotate", w22.class);
        m.put("translate", s32.class);
        m.put("transform", r32.class);
        m.put("setTransform", l32.class);
        m.put("font", q22.class);
        m.put("setFontSize", a32.class);
        m.put("setTextAlign", j32.class);
        m.put("setTextBaseline", k32.class);
        m.put("fillText", p22.class);
        m.put("strokeText", q32.class);
        m.put("clip", i22.class);
        m.put("drawImage", m22.class);
        m.put("save", x22.class);
        m.put("restore", v22.class);
        m.put("setShadow", h32.class);
        m.put("setGlobalAlpha", b32.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u32(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.l = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString(NotificationCompat.WearableExtender.KEY_ACTIONS));
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends c22> cls = m.get(optString);
                if (cls != null) {
                    c22 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (gp1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<c22> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.t32, com.baidu.tieba.m42, com.baidu.tieba.vy2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
