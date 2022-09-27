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
/* loaded from: classes4.dex */
public class jy1 extends iy1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends rw1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rw1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947899527, "Lcom/baidu/tieba/jy1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947899527, "Lcom/baidu/tieba/jy1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", ox1.class);
        m.put("fillRect", dx1.class);
        m.put("setStrokeStyle", xx1.class);
        m.put("strokeStyle", ey1.class);
        m.put("setLineCap", rx1.class);
        m.put("setLineJoin", tx1.class);
        m.put("setLineWidth", ux1.class);
        m.put("setLineDash", sx1.class);
        m.put("setMiterLimit", vx1.class);
        m.put("strokeRect", dy1.class);
        m.put("moveTo", hx1.class);
        m.put("lineTo", gx1.class);
        m.put("stroke", cy1.class);
        m.put("fill", cx1.class);
        m.put("beginPath", uw1.class);
        m.put("rect", jx1.class);
        m.put("clearRect", ww1.class);
        m.put("closePath", yw1.class);
        m.put("arc", tw1.class);
        m.put("bezierCurveTo", vw1.class);
        m.put("quadraticCurveTo", ix1.class);
        m.put("scale", nx1.class);
        m.put("rotate", lx1.class);
        m.put("translate", hy1.class);
        m.put("transform", gy1.class);
        m.put("setTransform", ay1.class);
        m.put("font", fx1.class);
        m.put("setFontSize", px1.class);
        m.put("setTextAlign", yx1.class);
        m.put("setTextBaseline", zx1.class);
        m.put("fillText", ex1.class);
        m.put("strokeText", fy1.class);
        m.put("clip", xw1.class);
        m.put("drawImage", bx1.class);
        m.put("save", mx1.class);
        m.put("restore", kx1.class);
        m.put("setShadow", wx1.class);
        m.put("setGlobalAlpha", qx1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jy1(String str) {
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
                Class<? extends rw1> cls = m.get(optString);
                if (cls != null) {
                    rw1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (vj1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<rw1> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iy1, com.baidu.tieba.bz1, com.baidu.tieba.kt2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isValid() : invokeV.booleanValue;
    }
}
