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
public class t22 extends s22 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends b12>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b12> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948129237, "Lcom/baidu/tieba/t22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948129237, "Lcom/baidu/tieba/t22;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", y12.class);
        m.put("fillRect", n12.class);
        m.put("setStrokeStyle", h22.class);
        m.put("strokeStyle", o22.class);
        m.put("setLineCap", b22.class);
        m.put("setLineJoin", d22.class);
        m.put("setLineWidth", e22.class);
        m.put("setLineDash", c22.class);
        m.put("setMiterLimit", f22.class);
        m.put("strokeRect", n22.class);
        m.put("moveTo", r12.class);
        m.put("lineTo", q12.class);
        m.put("stroke", m22.class);
        m.put("fill", m12.class);
        m.put("beginPath", e12.class);
        m.put("rect", t12.class);
        m.put("clearRect", g12.class);
        m.put("closePath", i12.class);
        m.put("arc", d12.class);
        m.put("bezierCurveTo", f12.class);
        m.put("quadraticCurveTo", s12.class);
        m.put("scale", x12.class);
        m.put("rotate", v12.class);
        m.put("translate", r22.class);
        m.put("transform", q22.class);
        m.put("setTransform", k22.class);
        m.put("font", p12.class);
        m.put("setFontSize", z12.class);
        m.put("setTextAlign", i22.class);
        m.put("setTextBaseline", j22.class);
        m.put("fillText", o12.class);
        m.put("strokeText", p22.class);
        m.put("clip", h12.class);
        m.put("drawImage", l12.class);
        m.put("save", w12.class);
        m.put("restore", u12.class);
        m.put("setShadow", g22.class);
        m.put("setGlobalAlpha", a22.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t22(String str) {
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
                Class<? extends b12> cls = m.get(optString);
                if (cls != null) {
                    b12 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (fo1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<b12> h() {
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

    @Override // com.baidu.tieba.s22, com.baidu.tieba.l32, com.baidu.tieba.ux2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
