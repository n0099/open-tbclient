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
public class v22 extends u22 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends d12>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<d12> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948188819, "Lcom/baidu/tieba/v22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948188819, "Lcom/baidu/tieba/v22;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", a22.class);
        m.put("fillRect", p12.class);
        m.put("setStrokeStyle", j22.class);
        m.put("strokeStyle", q22.class);
        m.put("setLineCap", d22.class);
        m.put("setLineJoin", f22.class);
        m.put("setLineWidth", g22.class);
        m.put("setLineDash", e22.class);
        m.put("setMiterLimit", h22.class);
        m.put("strokeRect", p22.class);
        m.put("moveTo", t12.class);
        m.put("lineTo", s12.class);
        m.put("stroke", o22.class);
        m.put("fill", o12.class);
        m.put("beginPath", g12.class);
        m.put("rect", v12.class);
        m.put("clearRect", i12.class);
        m.put("closePath", k12.class);
        m.put("arc", f12.class);
        m.put("bezierCurveTo", h12.class);
        m.put("quadraticCurveTo", u12.class);
        m.put("scale", z12.class);
        m.put("rotate", x12.class);
        m.put("translate", t22.class);
        m.put("transform", s22.class);
        m.put("setTransform", m22.class);
        m.put("font", r12.class);
        m.put("setFontSize", b22.class);
        m.put("setTextAlign", k22.class);
        m.put("setTextBaseline", l22.class);
        m.put("fillText", q12.class);
        m.put("strokeText", r22.class);
        m.put("clip", j12.class);
        m.put("drawImage", n12.class);
        m.put("save", y12.class);
        m.put("restore", w12.class);
        m.put("setShadow", i22.class);
        m.put("setGlobalAlpha", c22.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v22(String str) {
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
                Class<? extends d12> cls = m.get(optString);
                if (cls != null) {
                    d12 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (ho1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<d12> h() {
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

    @Override // com.baidu.tieba.u22, com.baidu.tieba.n32, com.baidu.tieba.wx2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
