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
public class ky1 extends jy1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map m;
    public transient /* synthetic */ FieldHolder $fh;
    public List k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947929318, "Lcom/baidu/tieba/ky1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947929318, "Lcom/baidu/tieba/ky1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", px1.class);
        m.put("fillRect", ex1.class);
        m.put("setStrokeStyle", yx1.class);
        m.put("strokeStyle", fy1.class);
        m.put("setLineCap", sx1.class);
        m.put("setLineJoin", ux1.class);
        m.put("setLineWidth", vx1.class);
        m.put("setLineDash", tx1.class);
        m.put("setMiterLimit", wx1.class);
        m.put("strokeRect", ey1.class);
        m.put("moveTo", ix1.class);
        m.put("lineTo", hx1.class);
        m.put("stroke", dy1.class);
        m.put("fill", dx1.class);
        m.put("beginPath", vw1.class);
        m.put("rect", kx1.class);
        m.put("clearRect", xw1.class);
        m.put("closePath", zw1.class);
        m.put("arc", uw1.class);
        m.put("bezierCurveTo", ww1.class);
        m.put("quadraticCurveTo", jx1.class);
        m.put("scale", ox1.class);
        m.put("rotate", mx1.class);
        m.put("translate", iy1.class);
        m.put("transform", hy1.class);
        m.put("setTransform", by1.class);
        m.put("font", gx1.class);
        m.put("setFontSize", qx1.class);
        m.put("setTextAlign", zx1.class);
        m.put("setTextBaseline", ay1.class);
        m.put("fillText", fx1.class);
        m.put("strokeText", gy1.class);
        m.put("clip", yw1.class);
        m.put("drawImage", cx1.class);
        m.put("save", nx1.class);
        m.put("restore", lx1.class);
        m.put("setShadow", xx1.class);
        m.put("setGlobalAlpha", rx1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ky1(String str) {
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
                Class cls = (Class) m.get(optString);
                if (cls != null) {
                    sw1 sw1Var = (sw1) cls.newInstance();
                    sw1Var.b(optJSONArray);
                    this.k.add(sw1Var);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (wj1.a) {
                e.printStackTrace();
            }
        }
    }

    public List h() {
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

    @Override // com.baidu.tieba.jy1, com.baidu.tieba.cz1, com.baidu.tieba.lt2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
