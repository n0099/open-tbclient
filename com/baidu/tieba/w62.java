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
public class w62 extends v62 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends e52>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<e52> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222454, "Lcom/baidu/tieba/w62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222454, "Lcom/baidu/tieba/w62;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", b62.class);
        m.put("fillRect", q52.class);
        m.put("setStrokeStyle", k62.class);
        m.put("strokeStyle", r62.class);
        m.put("setLineCap", e62.class);
        m.put("setLineJoin", g62.class);
        m.put("setLineWidth", h62.class);
        m.put("setLineDash", f62.class);
        m.put("setMiterLimit", i62.class);
        m.put("strokeRect", q62.class);
        m.put("moveTo", u52.class);
        m.put("lineTo", t52.class);
        m.put("stroke", p62.class);
        m.put("fill", p52.class);
        m.put("beginPath", h52.class);
        m.put("rect", w52.class);
        m.put("clearRect", j52.class);
        m.put("closePath", l52.class);
        m.put("arc", g52.class);
        m.put("bezierCurveTo", i52.class);
        m.put("quadraticCurveTo", v52.class);
        m.put("scale", a62.class);
        m.put("rotate", y52.class);
        m.put("translate", u62.class);
        m.put("transform", t62.class);
        m.put("setTransform", n62.class);
        m.put("font", s52.class);
        m.put("setFontSize", c62.class);
        m.put("setTextAlign", l62.class);
        m.put("setTextBaseline", m62.class);
        m.put("fillText", r52.class);
        m.put("strokeText", s62.class);
        m.put("clip", k52.class);
        m.put("drawImage", o52.class);
        m.put("save", z52.class);
        m.put("restore", x52.class);
        m.put("setShadow", j62.class);
        m.put("setGlobalAlpha", d62.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w62(String str) {
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
                Class<? extends e52> cls = m.get(optString);
                if (cls != null) {
                    e52 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (is1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<e52> h() {
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

    @Override // com.baidu.tieba.v62, com.baidu.tieba.o72, com.baidu.tieba.x13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
