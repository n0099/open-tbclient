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
public class yv1 extends xv1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends gu1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<gu1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948343509, "Lcom/baidu/tieba/yv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948343509, "Lcom/baidu/tieba/yv1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", dv1.class);
        m.put("fillRect", su1.class);
        m.put("setStrokeStyle", mv1.class);
        m.put("strokeStyle", tv1.class);
        m.put("setLineCap", gv1.class);
        m.put("setLineJoin", iv1.class);
        m.put("setLineWidth", jv1.class);
        m.put("setLineDash", hv1.class);
        m.put("setMiterLimit", kv1.class);
        m.put("strokeRect", sv1.class);
        m.put("moveTo", wu1.class);
        m.put("lineTo", vu1.class);
        m.put("stroke", rv1.class);
        m.put("fill", ru1.class);
        m.put("beginPath", ju1.class);
        m.put("rect", yu1.class);
        m.put("clearRect", lu1.class);
        m.put("closePath", nu1.class);
        m.put("arc", iu1.class);
        m.put("bezierCurveTo", ku1.class);
        m.put("quadraticCurveTo", xu1.class);
        m.put("scale", cv1.class);
        m.put("rotate", av1.class);
        m.put("translate", wv1.class);
        m.put("transform", vv1.class);
        m.put("setTransform", pv1.class);
        m.put("font", uu1.class);
        m.put("setFontSize", ev1.class);
        m.put("setTextAlign", nv1.class);
        m.put("setTextBaseline", ov1.class);
        m.put("fillText", tu1.class);
        m.put("strokeText", uv1.class);
        m.put("clip", mu1.class);
        m.put("drawImage", qu1.class);
        m.put("save", bv1.class);
        m.put("restore", zu1.class);
        m.put("setShadow", lv1.class);
        m.put("setGlobalAlpha", fv1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yv1(String str) {
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
                Class<? extends gu1> cls = m.get(optString);
                if (cls != null) {
                    gu1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (kh1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<gu1> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xv1, com.baidu.tieba.qw1, com.baidu.tieba.zq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isValid() : invokeV.booleanValue;
    }
}
