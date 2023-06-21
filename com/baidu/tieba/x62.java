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
/* loaded from: classes8.dex */
public class x62 extends w62 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends f52>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<f52> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948252245, "Lcom/baidu/tieba/x62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948252245, "Lcom/baidu/tieba/x62;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", c62.class);
        m.put("fillRect", r52.class);
        m.put("setStrokeStyle", l62.class);
        m.put("strokeStyle", s62.class);
        m.put("setLineCap", f62.class);
        m.put("setLineJoin", h62.class);
        m.put("setLineWidth", i62.class);
        m.put("setLineDash", g62.class);
        m.put("setMiterLimit", j62.class);
        m.put("strokeRect", r62.class);
        m.put("moveTo", v52.class);
        m.put("lineTo", u52.class);
        m.put("stroke", q62.class);
        m.put("fill", q52.class);
        m.put("beginPath", i52.class);
        m.put("rect", x52.class);
        m.put("clearRect", k52.class);
        m.put("closePath", m52.class);
        m.put("arc", h52.class);
        m.put("bezierCurveTo", j52.class);
        m.put("quadraticCurveTo", w52.class);
        m.put("scale", b62.class);
        m.put("rotate", z52.class);
        m.put("translate", v62.class);
        m.put("transform", u62.class);
        m.put("setTransform", o62.class);
        m.put("font", t52.class);
        m.put("setFontSize", d62.class);
        m.put("setTextAlign", m62.class);
        m.put("setTextBaseline", n62.class);
        m.put("fillText", s52.class);
        m.put("strokeText", t62.class);
        m.put("clip", l52.class);
        m.put("drawImage", p52.class);
        m.put("save", a62.class);
        m.put("restore", y52.class);
        m.put("setShadow", k62.class);
        m.put("setGlobalAlpha", e62.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x62(String str) {
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
                Class<? extends f52> cls = m.get(optString);
                if (cls != null) {
                    f52 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (js1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<f52> h() {
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

    @Override // com.baidu.tieba.w62, com.baidu.tieba.p72, com.baidu.tieba.y13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
