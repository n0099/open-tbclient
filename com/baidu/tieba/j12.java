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
public class j12 extends i12 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends rz1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rz1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947830366, "Lcom/baidu/tieba/j12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947830366, "Lcom/baidu/tieba/j12;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", o02.class);
        m.put("fillRect", d02.class);
        m.put("setStrokeStyle", x02.class);
        m.put("strokeStyle", e12.class);
        m.put("setLineCap", r02.class);
        m.put("setLineJoin", t02.class);
        m.put("setLineWidth", u02.class);
        m.put("setLineDash", s02.class);
        m.put("setMiterLimit", v02.class);
        m.put("strokeRect", d12.class);
        m.put("moveTo", h02.class);
        m.put("lineTo", g02.class);
        m.put("stroke", c12.class);
        m.put("fill", c02.class);
        m.put("beginPath", uz1.class);
        m.put("rect", j02.class);
        m.put("clearRect", wz1.class);
        m.put("closePath", yz1.class);
        m.put("arc", tz1.class);
        m.put("bezierCurveTo", vz1.class);
        m.put("quadraticCurveTo", i02.class);
        m.put("scale", n02.class);
        m.put("rotate", l02.class);
        m.put("translate", h12.class);
        m.put("transform", g12.class);
        m.put("setTransform", a12.class);
        m.put("font", f02.class);
        m.put("setFontSize", p02.class);
        m.put("setTextAlign", y02.class);
        m.put("setTextBaseline", z02.class);
        m.put("fillText", e02.class);
        m.put("strokeText", f12.class);
        m.put("clip", xz1.class);
        m.put("drawImage", b02.class);
        m.put("save", m02.class);
        m.put("restore", k02.class);
        m.put("setShadow", w02.class);
        m.put("setGlobalAlpha", q02.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j12(String str) {
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
                Class<? extends rz1> cls = m.get(optString);
                if (cls != null) {
                    rz1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (vm1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<rz1> h() {
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

    @Override // com.baidu.tieba.i12, com.baidu.tieba.b22, com.baidu.tieba.jw2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
