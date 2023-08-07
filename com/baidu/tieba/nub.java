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
public class nub {
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
    public transient rwb j;
    public transient qwb k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public nub() {
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

    public static nub a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            nub nubVar = new nub();
            try {
                JSONObject jSONObject = new JSONObject(str);
                nubVar.a = jSONObject.optString("cacheDirectory");
                nubVar.b = jSONObject.optInt("avcCodec");
                nubVar.c = jSONObject.optInt("hevcCodec");
                nubVar.d = jSONObject.optInt("audioCodec");
                nubVar.e = jSONObject.optInt("videoSeekMode");
                nubVar.f = jSONObject.optBoolean("clearRender");
                nubVar.g = jSONObject.optBoolean("usingSurfaceView");
                nubVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                nubVar.i = jSONObject.optBoolean("forceNotCrop");
                nubVar.l = jSONObject.optInt("samplerFilter");
                nubVar.m = jSONObject.optBoolean("isSubProcess");
                nubVar.n = jSONObject.optInt("pcdnCatonTime");
                nubVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return nubVar;
        }
        return (nub) invokeL.objValue;
    }

    public static String b(nub nubVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, nubVar)) == null) {
            if (nubVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", nubVar.a);
                jSONObject.put("avcCodec", nubVar.b);
                jSONObject.put("hevcCodec", nubVar.c);
                jSONObject.put("audioCodec", nubVar.d);
                jSONObject.put("videoSeekMode", nubVar.e);
                jSONObject.put("clearRender", nubVar.f);
                jSONObject.put("usingSurfaceView", nubVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", nubVar.h);
                jSONObject.put("forceNotCrop", nubVar.i);
                jSONObject.put("samplerFilter", nubVar.l);
                jSONObject.put("isSubProcess", nubVar.m);
                jSONObject.put("pcdnCatonTime", nubVar.n);
                jSONObject.put("pcdnCatonCount", nubVar.o);
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
