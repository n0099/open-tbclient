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
public class r22 extends q22 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends z02>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<z02> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948069655, "Lcom/baidu/tieba/r22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948069655, "Lcom/baidu/tieba/r22;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", w12.class);
        m.put("fillRect", l12.class);
        m.put("setStrokeStyle", f22.class);
        m.put("strokeStyle", m22.class);
        m.put("setLineCap", z12.class);
        m.put("setLineJoin", b22.class);
        m.put("setLineWidth", c22.class);
        m.put("setLineDash", a22.class);
        m.put("setMiterLimit", d22.class);
        m.put("strokeRect", l22.class);
        m.put("moveTo", p12.class);
        m.put("lineTo", o12.class);
        m.put("stroke", k22.class);
        m.put("fill", k12.class);
        m.put("beginPath", c12.class);
        m.put("rect", r12.class);
        m.put("clearRect", e12.class);
        m.put("closePath", g12.class);
        m.put("arc", b12.class);
        m.put("bezierCurveTo", d12.class);
        m.put("quadraticCurveTo", q12.class);
        m.put("scale", v12.class);
        m.put("rotate", t12.class);
        m.put("translate", p22.class);
        m.put("transform", o22.class);
        m.put("setTransform", i22.class);
        m.put("font", n12.class);
        m.put("setFontSize", x12.class);
        m.put("setTextAlign", g22.class);
        m.put("setTextBaseline", h22.class);
        m.put("fillText", m12.class);
        m.put("strokeText", n22.class);
        m.put("clip", f12.class);
        m.put("drawImage", j12.class);
        m.put("save", u12.class);
        m.put("restore", s12.class);
        m.put("setShadow", e22.class);
        m.put("setGlobalAlpha", y12.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r22(String str) {
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
                Class<? extends z02> cls = m.get(optString);
                if (cls != null) {
                    z02 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (do1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<z02> h() {
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

    @Override // com.baidu.tieba.q22, com.baidu.tieba.j32, com.baidu.tieba.sx2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
