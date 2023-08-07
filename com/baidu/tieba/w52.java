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
public class w52 extends v52 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends e42>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<e42> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948221493, "Lcom/baidu/tieba/w52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948221493, "Lcom/baidu/tieba/w52;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", b52.class);
        m.put("fillRect", q42.class);
        m.put("setStrokeStyle", k52.class);
        m.put("strokeStyle", r52.class);
        m.put("setLineCap", e52.class);
        m.put("setLineJoin", g52.class);
        m.put("setLineWidth", h52.class);
        m.put("setLineDash", f52.class);
        m.put("setMiterLimit", i52.class);
        m.put("strokeRect", q52.class);
        m.put("moveTo", u42.class);
        m.put("lineTo", t42.class);
        m.put("stroke", p52.class);
        m.put("fill", p42.class);
        m.put("beginPath", h42.class);
        m.put("rect", w42.class);
        m.put("clearRect", j42.class);
        m.put("closePath", l42.class);
        m.put("arc", g42.class);
        m.put("bezierCurveTo", i42.class);
        m.put("quadraticCurveTo", v42.class);
        m.put("scale", a52.class);
        m.put("rotate", y42.class);
        m.put("translate", u52.class);
        m.put("transform", t52.class);
        m.put("setTransform", n52.class);
        m.put("font", s42.class);
        m.put("setFontSize", c52.class);
        m.put("setTextAlign", l52.class);
        m.put("setTextBaseline", m52.class);
        m.put("fillText", r42.class);
        m.put("strokeText", s52.class);
        m.put("clip", k42.class);
        m.put("drawImage", o42.class);
        m.put("save", z42.class);
        m.put("restore", x42.class);
        m.put("setShadow", j52.class);
        m.put("setGlobalAlpha", d52.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w52(String str) {
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
                Class<? extends e42> cls = m.get(optString);
                if (cls != null) {
                    e42 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (ir1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<e42> h() {
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

    @Override // com.baidu.tieba.v52, com.baidu.tieba.o62, com.baidu.tieba.x03
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
