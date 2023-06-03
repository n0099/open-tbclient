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
public class yfb {
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
    public transient cib j;
    public transient bib k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public yfb() {
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

    public static yfb a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            yfb yfbVar = new yfb();
            try {
                JSONObject jSONObject = new JSONObject(str);
                yfbVar.a = jSONObject.optString("cacheDirectory");
                yfbVar.b = jSONObject.optInt("avcCodec");
                yfbVar.c = jSONObject.optInt("hevcCodec");
                yfbVar.d = jSONObject.optInt("audioCodec");
                yfbVar.e = jSONObject.optInt("videoSeekMode");
                yfbVar.f = jSONObject.optBoolean("clearRender");
                yfbVar.g = jSONObject.optBoolean("usingSurfaceView");
                yfbVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                yfbVar.i = jSONObject.optBoolean("forceNotCrop");
                yfbVar.l = jSONObject.optInt("samplerFilter");
                yfbVar.m = jSONObject.optBoolean("isSubProcess");
                yfbVar.n = jSONObject.optInt("pcdnCatonTime");
                yfbVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return yfbVar;
        }
        return (yfb) invokeL.objValue;
    }

    public static String b(yfb yfbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, yfbVar)) == null) {
            if (yfbVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", yfbVar.a);
                jSONObject.put("avcCodec", yfbVar.b);
                jSONObject.put("hevcCodec", yfbVar.c);
                jSONObject.put("audioCodec", yfbVar.d);
                jSONObject.put("videoSeekMode", yfbVar.e);
                jSONObject.put("clearRender", yfbVar.f);
                jSONObject.put("usingSurfaceView", yfbVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", yfbVar.h);
                jSONObject.put("forceNotCrop", yfbVar.i);
                jSONObject.put("samplerFilter", yfbVar.l);
                jSONObject.put("isSubProcess", yfbVar.m);
                jSONObject.put("pcdnCatonTime", yfbVar.n);
                jSONObject.put("pcdnCatonCount", yfbVar.o);
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
