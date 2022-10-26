package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imageutils.JfifUtil;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vs2 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap a;
    public static final HashMap b;
    public static final HashMap c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948251284, "Lcom/baidu/tieba/vs2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948251284, "Lcom/baidu/tieba/vs2;");
                return;
            }
        }
        HashMap hashMap = new HashMap(16);
        a = hashMap;
        hashMap.put("VRModeProjectionSphere", 201);
        a.put("VRModeProjectionDome180", 202);
        a.put("VRModeProjectionDome230", 203);
        a.put("VRModeProjectionDome180Upper", 204);
        a.put("VRModeProjectionDome230Upper", 205);
        a.put("VRModeProjectionPlaneFit", 207);
        a.put("VRModeProjectionPlaneCrop", 208);
        a.put("VRModeProjectionPlaneFull", 209);
        a.put("VRModeProjectionMultiFishEyeHorizontal", 210);
        a.put("VRModeProjectionMultiFishEyeVertical", 211);
        a.put("VRModeProjectionStereoSphereHorizontal", 212);
        a.put("VRModeProjectionStereoSphereVertical", 213);
        a.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        a.put("VRModeProjectionStereoPlaneFitVertical", 215);
        a.put("VRModeProjectionPlaneFullHorizontal", Integer.valueOf((int) JfifUtil.MARKER_SOI));
        a.put("VRModeProjectionPlaneFullVertical", 217);
        HashMap hashMap2 = new HashMap(2);
        b = hashMap2;
        hashMap2.put("VRModeDisplayNormal", 101);
        b.put("VRModeDisplayGlass", 102);
        HashMap hashMap3 = new HashMap(5);
        c = hashMap3;
        hashMap3.put("VRModeInteractiveMotion", 1);
        c.put("VRModeInteractiveTouch", 2);
        c.put("VRModeInteractiveMotionWithTouch", 3);
        c.put("VRModeInteractiveGVRMotion", 4);
        c.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public vs2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public vs2 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            vs2 vs2Var = new vs2();
            if (jSONObject == null) {
                return vs2Var;
            }
            String optString = jSONObject.optString("projectionMode");
            if (!TextUtils.isEmpty(optString) && a.containsKey(optString)) {
                ((Integer) a.get(optString)).intValue();
            }
            String optString2 = jSONObject.optString("displayMode");
            if (!TextUtils.isEmpty(optString2) && b.containsKey(optString2)) {
                ((Integer) b.get(optString2)).intValue();
            }
            String optString3 = jSONObject.optString("interactiveMode");
            if (!TextUtils.isEmpty(optString3) && c.containsKey(optString3)) {
                ((Integer) c.get(optString3)).intValue();
            }
            jSONObject.optInt("fov", -1);
            jSONObject.optInt("minFov", -1);
            jSONObject.optInt("maxFov", -1);
            jSONObject.optBoolean("pinchEnable", true);
            return vs2Var;
        }
        return (vs2) invokeL.objValue;
    }
}
