package com.baidu.tieba;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kvb {
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
    public transient oxb j;
    public transient nxb k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public kvb() {
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

    public static kvb a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            kvb kvbVar = new kvb();
            try {
                JSONObject jSONObject = new JSONObject(str);
                kvbVar.a = jSONObject.optString("cacheDirectory");
                kvbVar.b = jSONObject.optInt("avcCodec");
                kvbVar.c = jSONObject.optInt("hevcCodec");
                kvbVar.d = jSONObject.optInt("audioCodec");
                kvbVar.e = jSONObject.optInt("videoSeekMode");
                kvbVar.f = jSONObject.optBoolean("clearRender");
                kvbVar.g = jSONObject.optBoolean("usingSurfaceView");
                kvbVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                kvbVar.i = jSONObject.optBoolean("forceNotCrop");
                kvbVar.l = jSONObject.optInt("samplerFilter");
                kvbVar.m = jSONObject.optBoolean("isSubProcess");
                kvbVar.n = jSONObject.optInt("pcdnCatonTime");
                kvbVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return kvbVar;
        }
        return (kvb) invokeL.objValue;
    }

    public static String b(kvb kvbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, kvbVar)) == null) {
            if (kvbVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", kvbVar.a);
                jSONObject.put("avcCodec", kvbVar.b);
                jSONObject.put("hevcCodec", kvbVar.c);
                jSONObject.put("audioCodec", kvbVar.d);
                jSONObject.put("videoSeekMode", kvbVar.e);
                jSONObject.put("clearRender", kvbVar.f);
                jSONObject.put("usingSurfaceView", kvbVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", kvbVar.h);
                jSONObject.put("forceNotCrop", kvbVar.i);
                jSONObject.put("samplerFilter", kvbVar.l);
                jSONObject.put("isSubProcess", kvbVar.m);
                jSONObject.put("pcdnCatonTime", kvbVar.n);
                jSONObject.put("pcdnCatonCount", kvbVar.o);
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
