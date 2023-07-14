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
public class t62 extends s62 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends b52>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b52> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948133081, "Lcom/baidu/tieba/t62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948133081, "Lcom/baidu/tieba/t62;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", y52.class);
        m.put("fillRect", n52.class);
        m.put("setStrokeStyle", h62.class);
        m.put("strokeStyle", o62.class);
        m.put("setLineCap", b62.class);
        m.put("setLineJoin", d62.class);
        m.put("setLineWidth", e62.class);
        m.put("setLineDash", c62.class);
        m.put("setMiterLimit", f62.class);
        m.put("strokeRect", n62.class);
        m.put("moveTo", r52.class);
        m.put("lineTo", q52.class);
        m.put("stroke", m62.class);
        m.put("fill", m52.class);
        m.put("beginPath", e52.class);
        m.put("rect", t52.class);
        m.put("clearRect", g52.class);
        m.put("closePath", i52.class);
        m.put("arc", d52.class);
        m.put("bezierCurveTo", f52.class);
        m.put("quadraticCurveTo", s52.class);
        m.put("scale", x52.class);
        m.put("rotate", v52.class);
        m.put("translate", r62.class);
        m.put("transform", q62.class);
        m.put("setTransform", k62.class);
        m.put("font", p52.class);
        m.put("setFontSize", z52.class);
        m.put("setTextAlign", i62.class);
        m.put("setTextBaseline", j62.class);
        m.put("fillText", o52.class);
        m.put("strokeText", p62.class);
        m.put("clip", h52.class);
        m.put("drawImage", l52.class);
        m.put("save", w52.class);
        m.put("restore", u52.class);
        m.put("setShadow", g62.class);
        m.put("setGlobalAlpha", a62.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t62(String str) {
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
                Class<? extends b52> cls = m.get(optString);
                if (cls != null) {
                    b52 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (fs1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<b52> h() {
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

    @Override // com.baidu.tieba.s62, com.baidu.tieba.l72, com.baidu.tieba.u13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
