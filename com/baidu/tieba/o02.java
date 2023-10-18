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
/* loaded from: classes7.dex */
public class o02 extends n02 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends wy1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<wy1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947978360, "Lcom/baidu/tieba/o02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947978360, "Lcom/baidu/tieba/o02;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", tz1.class);
        m.put("fillRect", iz1.class);
        m.put("setStrokeStyle", c02.class);
        m.put("strokeStyle", j02.class);
        m.put("setLineCap", wz1.class);
        m.put("setLineJoin", yz1.class);
        m.put("setLineWidth", zz1.class);
        m.put("setLineDash", xz1.class);
        m.put("setMiterLimit", a02.class);
        m.put("strokeRect", i02.class);
        m.put("moveTo", mz1.class);
        m.put("lineTo", lz1.class);
        m.put("stroke", h02.class);
        m.put("fill", hz1.class);
        m.put("beginPath", zy1.class);
        m.put("rect", oz1.class);
        m.put("clearRect", bz1.class);
        m.put("closePath", dz1.class);
        m.put("arc", yy1.class);
        m.put("bezierCurveTo", az1.class);
        m.put("quadraticCurveTo", nz1.class);
        m.put("scale", sz1.class);
        m.put("rotate", qz1.class);
        m.put("translate", m02.class);
        m.put("transform", l02.class);
        m.put("setTransform", f02.class);
        m.put("font", kz1.class);
        m.put("setFontSize", uz1.class);
        m.put("setTextAlign", d02.class);
        m.put("setTextBaseline", e02.class);
        m.put("fillText", jz1.class);
        m.put("strokeText", k02.class);
        m.put("clip", cz1.class);
        m.put("drawImage", gz1.class);
        m.put("save", rz1.class);
        m.put("restore", pz1.class);
        m.put("setShadow", b02.class);
        m.put("setGlobalAlpha", vz1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o02(String str) {
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
                Class<? extends wy1> cls = m.get(optString);
                if (cls != null) {
                    wy1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (am1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<wy1> h() {
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

    @Override // com.baidu.tieba.n02, com.baidu.tieba.g12, com.baidu.tieba.ov2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
