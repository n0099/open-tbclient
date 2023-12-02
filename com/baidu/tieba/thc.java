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
public class thc {
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
    public transient xjc j;
    public transient wjc k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public thc() {
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

    public static thc a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            thc thcVar = new thc();
            try {
                JSONObject jSONObject = new JSONObject(str);
                thcVar.a = jSONObject.optString("cacheDirectory");
                thcVar.b = jSONObject.optInt("avcCodec");
                thcVar.c = jSONObject.optInt("hevcCodec");
                thcVar.d = jSONObject.optInt("audioCodec");
                thcVar.e = jSONObject.optInt("videoSeekMode");
                thcVar.f = jSONObject.optBoolean("clearRender");
                thcVar.g = jSONObject.optBoolean("usingSurfaceView");
                thcVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                thcVar.i = jSONObject.optBoolean("forceNotCrop");
                thcVar.l = jSONObject.optInt("samplerFilter");
                thcVar.m = jSONObject.optBoolean("isSubProcess");
                thcVar.n = jSONObject.optInt("pcdnCatonTime");
                thcVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return thcVar;
        }
        return (thc) invokeL.objValue;
    }

    public static String b(thc thcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, thcVar)) == null) {
            if (thcVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", thcVar.a);
                jSONObject.put("avcCodec", thcVar.b);
                jSONObject.put("hevcCodec", thcVar.c);
                jSONObject.put("audioCodec", thcVar.d);
                jSONObject.put("videoSeekMode", thcVar.e);
                jSONObject.put("clearRender", thcVar.f);
                jSONObject.put("usingSurfaceView", thcVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", thcVar.h);
                jSONObject.put("forceNotCrop", thcVar.i);
                jSONObject.put("samplerFilter", thcVar.l);
                jSONObject.put("isSubProcess", thcVar.m);
                jSONObject.put("pcdnCatonTime", thcVar.n);
                jSONObject.put("pcdnCatonCount", thcVar.o);
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
