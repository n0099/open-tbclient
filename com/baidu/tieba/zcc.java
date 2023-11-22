package com.baidu.tieba;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zcc {
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
    public transient dfc j;
    public transient cfc k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public zcc() {
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

    public static zcc a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            zcc zccVar = new zcc();
            try {
                JSONObject jSONObject = new JSONObject(str);
                zccVar.a = jSONObject.optString("cacheDirectory");
                zccVar.b = jSONObject.optInt("avcCodec");
                zccVar.c = jSONObject.optInt("hevcCodec");
                zccVar.d = jSONObject.optInt("audioCodec");
                zccVar.e = jSONObject.optInt("videoSeekMode");
                zccVar.f = jSONObject.optBoolean("clearRender");
                zccVar.g = jSONObject.optBoolean("usingSurfaceView");
                zccVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                zccVar.i = jSONObject.optBoolean("forceNotCrop");
                zccVar.l = jSONObject.optInt("samplerFilter");
                zccVar.m = jSONObject.optBoolean("isSubProcess");
                zccVar.n = jSONObject.optInt("pcdnCatonTime");
                zccVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return zccVar;
        }
        return (zcc) invokeL.objValue;
    }

    public static String b(zcc zccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zccVar)) == null) {
            if (zccVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", zccVar.a);
                jSONObject.put("avcCodec", zccVar.b);
                jSONObject.put("hevcCodec", zccVar.c);
                jSONObject.put("audioCodec", zccVar.d);
                jSONObject.put("videoSeekMode", zccVar.e);
                jSONObject.put("clearRender", zccVar.f);
                jSONObject.put("usingSurfaceView", zccVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", zccVar.h);
                jSONObject.put("forceNotCrop", zccVar.i);
                jSONObject.put("samplerFilter", zccVar.l);
                jSONObject.put("isSubProcess", zccVar.m);
                jSONObject.put("pcdnCatonTime", zccVar.n);
                jSONObject.put("pcdnCatonCount", zccVar.o);
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
