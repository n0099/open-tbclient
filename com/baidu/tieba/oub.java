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
public class oub {
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
    public transient swb j;
    public transient rwb k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public oub() {
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

    public static oub a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            oub oubVar = new oub();
            try {
                JSONObject jSONObject = new JSONObject(str);
                oubVar.a = jSONObject.optString("cacheDirectory");
                oubVar.b = jSONObject.optInt("avcCodec");
                oubVar.c = jSONObject.optInt("hevcCodec");
                oubVar.d = jSONObject.optInt("audioCodec");
                oubVar.e = jSONObject.optInt("videoSeekMode");
                oubVar.f = jSONObject.optBoolean("clearRender");
                oubVar.g = jSONObject.optBoolean("usingSurfaceView");
                oubVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                oubVar.i = jSONObject.optBoolean("forceNotCrop");
                oubVar.l = jSONObject.optInt("samplerFilter");
                oubVar.m = jSONObject.optBoolean("isSubProcess");
                oubVar.n = jSONObject.optInt("pcdnCatonTime");
                oubVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return oubVar;
        }
        return (oub) invokeL.objValue;
    }

    public static String b(oub oubVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, oubVar)) == null) {
            if (oubVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", oubVar.a);
                jSONObject.put("avcCodec", oubVar.b);
                jSONObject.put("hevcCodec", oubVar.c);
                jSONObject.put("audioCodec", oubVar.d);
                jSONObject.put("videoSeekMode", oubVar.e);
                jSONObject.put("clearRender", oubVar.f);
                jSONObject.put("usingSurfaceView", oubVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", oubVar.h);
                jSONObject.put("forceNotCrop", oubVar.i);
                jSONObject.put("samplerFilter", oubVar.l);
                jSONObject.put("isSubProcess", oubVar.m);
                jSONObject.put("pcdnCatonTime", oubVar.n);
                jSONObject.put("pcdnCatonCount", oubVar.o);
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
