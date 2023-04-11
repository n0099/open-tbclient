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
public class s22 extends r22 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends a12>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a12> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948099446, "Lcom/baidu/tieba/s22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948099446, "Lcom/baidu/tieba/s22;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", x12.class);
        m.put("fillRect", m12.class);
        m.put("setStrokeStyle", g22.class);
        m.put("strokeStyle", n22.class);
        m.put("setLineCap", a22.class);
        m.put("setLineJoin", c22.class);
        m.put("setLineWidth", d22.class);
        m.put("setLineDash", b22.class);
        m.put("setMiterLimit", e22.class);
        m.put("strokeRect", m22.class);
        m.put("moveTo", q12.class);
        m.put("lineTo", p12.class);
        m.put("stroke", l22.class);
        m.put("fill", l12.class);
        m.put("beginPath", d12.class);
        m.put("rect", s12.class);
        m.put("clearRect", f12.class);
        m.put("closePath", h12.class);
        m.put("arc", c12.class);
        m.put("bezierCurveTo", e12.class);
        m.put("quadraticCurveTo", r12.class);
        m.put("scale", w12.class);
        m.put("rotate", u12.class);
        m.put("translate", q22.class);
        m.put("transform", p22.class);
        m.put("setTransform", j22.class);
        m.put("font", o12.class);
        m.put("setFontSize", y12.class);
        m.put("setTextAlign", h22.class);
        m.put("setTextBaseline", i22.class);
        m.put("fillText", n12.class);
        m.put("strokeText", o22.class);
        m.put("clip", g12.class);
        m.put("drawImage", k12.class);
        m.put("save", v12.class);
        m.put("restore", t12.class);
        m.put("setShadow", f22.class);
        m.put("setGlobalAlpha", z12.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s22(String str) {
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
                Class<? extends a12> cls = m.get(optString);
                if (cls != null) {
                    a12 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (eo1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<a12> h() {
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

    @Override // com.baidu.tieba.r22, com.baidu.tieba.k32, com.baidu.tieba.tx2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
