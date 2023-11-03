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
public class ycc {
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
    public transient cfc j;
    public transient bfc k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public ycc() {
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

    public static ycc a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            ycc yccVar = new ycc();
            try {
                JSONObject jSONObject = new JSONObject(str);
                yccVar.a = jSONObject.optString("cacheDirectory");
                yccVar.b = jSONObject.optInt("avcCodec");
                yccVar.c = jSONObject.optInt("hevcCodec");
                yccVar.d = jSONObject.optInt("audioCodec");
                yccVar.e = jSONObject.optInt("videoSeekMode");
                yccVar.f = jSONObject.optBoolean("clearRender");
                yccVar.g = jSONObject.optBoolean("usingSurfaceView");
                yccVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                yccVar.i = jSONObject.optBoolean("forceNotCrop");
                yccVar.l = jSONObject.optInt("samplerFilter");
                yccVar.m = jSONObject.optBoolean("isSubProcess");
                yccVar.n = jSONObject.optInt("pcdnCatonTime");
                yccVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return yccVar;
        }
        return (ycc) invokeL.objValue;
    }

    public static String b(ycc yccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, yccVar)) == null) {
            if (yccVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", yccVar.a);
                jSONObject.put("avcCodec", yccVar.b);
                jSONObject.put("hevcCodec", yccVar.c);
                jSONObject.put("audioCodec", yccVar.d);
                jSONObject.put("videoSeekMode", yccVar.e);
                jSONObject.put("clearRender", yccVar.f);
                jSONObject.put("usingSurfaceView", yccVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", yccVar.h);
                jSONObject.put("forceNotCrop", yccVar.i);
                jSONObject.put("samplerFilter", yccVar.l);
                jSONObject.put("isSubProcess", yccVar.m);
                jSONObject.put("pcdnCatonTime", yccVar.n);
                jSONObject.put("pcdnCatonCount", yccVar.o);
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
