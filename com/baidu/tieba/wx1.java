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
public class wx1 extends vx1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends ew1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ew1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948285849, "Lcom/baidu/tieba/wx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948285849, "Lcom/baidu/tieba/wx1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", bx1.class);
        m.put("fillRect", qw1.class);
        m.put("setStrokeStyle", kx1.class);
        m.put("strokeStyle", rx1.class);
        m.put("setLineCap", ex1.class);
        m.put("setLineJoin", gx1.class);
        m.put("setLineWidth", hx1.class);
        m.put("setLineDash", fx1.class);
        m.put("setMiterLimit", ix1.class);
        m.put("strokeRect", qx1.class);
        m.put("moveTo", uw1.class);
        m.put("lineTo", tw1.class);
        m.put("stroke", px1.class);
        m.put("fill", pw1.class);
        m.put("beginPath", hw1.class);
        m.put("rect", ww1.class);
        m.put("clearRect", jw1.class);
        m.put("closePath", lw1.class);
        m.put("arc", gw1.class);
        m.put("bezierCurveTo", iw1.class);
        m.put("quadraticCurveTo", vw1.class);
        m.put("scale", ax1.class);
        m.put("rotate", yw1.class);
        m.put("translate", ux1.class);
        m.put("transform", tx1.class);
        m.put("setTransform", nx1.class);
        m.put("font", sw1.class);
        m.put("setFontSize", cx1.class);
        m.put("setTextAlign", lx1.class);
        m.put("setTextBaseline", mx1.class);
        m.put("fillText", rw1.class);
        m.put("strokeText", sx1.class);
        m.put("clip", kw1.class);
        m.put("drawImage", ow1.class);
        m.put("save", zw1.class);
        m.put("restore", xw1.class);
        m.put("setShadow", jx1.class);
        m.put("setGlobalAlpha", dx1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wx1(String str) {
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
                Class<? extends ew1> cls = m.get(optString);
                if (cls != null) {
                    ew1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (ij1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<ew1> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vx1, com.baidu.tieba.oy1, com.baidu.tieba.xs2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isValid() : invokeV.booleanValue;
    }
}
