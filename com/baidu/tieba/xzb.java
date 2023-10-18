package com.baidu.tieba;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xzb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public transient b2c j;
    public transient a2c k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public xzb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = 1;
        this.c = 1;
        this.d = 0;
        this.e = 1;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.k = null;
        this.l = 0;
        this.m = false;
        this.n = 1;
        this.o = 4000;
    }

    public static xzb a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            xzb xzbVar = new xzb();
            try {
                JSONObject jSONObject = new JSONObject(str);
                xzbVar.a = jSONObject.optString("cacheDirectory");
                xzbVar.b = jSONObject.optInt("avcCodec");
                xzbVar.c = jSONObject.optInt("hevcCodec");
                xzbVar.d = jSONObject.optInt("audioCodec");
                xzbVar.e = jSONObject.optInt("videoSeekMode");
                xzbVar.f = jSONObject.optBoolean("clearRender");
                xzbVar.g = jSONObject.optBoolean("usingSurfaceView");
                xzbVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                xzbVar.i = jSONObject.optBoolean("forceNotCrop");
                xzbVar.l = jSONObject.optInt("samplerFilter");
                xzbVar.m = jSONObject.optBoolean("isSubProcess");
                xzbVar.n = jSONObject.optInt("pcdnCatonTime");
                xzbVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return xzbVar;
        }
        return (xzb) invokeL.objValue;
    }

    public static String b(xzb xzbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, xzbVar)) == null) {
            if (xzbVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", xzbVar.a);
                jSONObject.put("avcCodec", xzbVar.b);
                jSONObject.put("hevcCodec", xzbVar.c);
                jSONObject.put("audioCodec", xzbVar.d);
                jSONObject.put("videoSeekMode", xzbVar.e);
                jSONObject.put("clearRender", xzbVar.f);
                jSONObject.put("usingSurfaceView", xzbVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", xzbVar.h);
                jSONObject.put("forceNotCrop", xzbVar.i);
                jSONObject.put("samplerFilter", xzbVar.l);
                jSONObject.put("isSubProcess", xzbVar.m);
                jSONObject.put("pcdnCatonTime", xzbVar.n);
                jSONObject.put("pcdnCatonCount", xzbVar.o);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PlayerOptions [cacheDirectory=" + this.a + ", avcCodec=" + this.b + ", hevcCodec=" + this.c + ", audioCodec=" + this.d + ", videoSeekMode=" + this.e + ", clearRender=" + this.f + ", usingSurfaceView=" + this.g + ", hardDecodeOutputToBuffer=" + this.h + ", forceNotCrop=" + this.i + ", samplerFilter=" + this.l + ", isSubProcess=" + this.m + ", pcdnCatonTime=" + this.n + ", pcdnCatonCount=" + this.o + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
