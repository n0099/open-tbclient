package com.baidu.tieba;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nmb {
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
    public transient rob j;
    public transient qob k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public nmb() {
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

    public static nmb a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            nmb nmbVar = new nmb();
            try {
                JSONObject jSONObject = new JSONObject(str);
                nmbVar.a = jSONObject.optString("cacheDirectory");
                nmbVar.b = jSONObject.optInt("avcCodec");
                nmbVar.c = jSONObject.optInt("hevcCodec");
                nmbVar.d = jSONObject.optInt("audioCodec");
                nmbVar.e = jSONObject.optInt("videoSeekMode");
                nmbVar.f = jSONObject.optBoolean("clearRender");
                nmbVar.g = jSONObject.optBoolean("usingSurfaceView");
                nmbVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                nmbVar.i = jSONObject.optBoolean("forceNotCrop");
                nmbVar.l = jSONObject.optInt("samplerFilter");
                nmbVar.m = jSONObject.optBoolean("isSubProcess");
                nmbVar.n = jSONObject.optInt("pcdnCatonTime");
                nmbVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return nmbVar;
        }
        return (nmb) invokeL.objValue;
    }

    public static String b(nmb nmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, nmbVar)) == null) {
            if (nmbVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", nmbVar.a);
                jSONObject.put("avcCodec", nmbVar.b);
                jSONObject.put("hevcCodec", nmbVar.c);
                jSONObject.put("audioCodec", nmbVar.d);
                jSONObject.put("videoSeekMode", nmbVar.e);
                jSONObject.put("clearRender", nmbVar.f);
                jSONObject.put("usingSurfaceView", nmbVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", nmbVar.h);
                jSONObject.put("forceNotCrop", nmbVar.i);
                jSONObject.put("samplerFilter", nmbVar.l);
                jSONObject.put("isSubProcess", nmbVar.m);
                jSONObject.put("pcdnCatonTime", nmbVar.n);
                jSONObject.put("pcdnCatonCount", nmbVar.o);
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
