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
public class whb {
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
    public transient akb j;
    public transient zjb k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public whb() {
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

    public static whb a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            whb whbVar = new whb();
            try {
                JSONObject jSONObject = new JSONObject(str);
                whbVar.a = jSONObject.optString("cacheDirectory");
                whbVar.b = jSONObject.optInt("avcCodec");
                whbVar.c = jSONObject.optInt("hevcCodec");
                whbVar.d = jSONObject.optInt("audioCodec");
                whbVar.e = jSONObject.optInt("videoSeekMode");
                whbVar.f = jSONObject.optBoolean("clearRender");
                whbVar.g = jSONObject.optBoolean("usingSurfaceView");
                whbVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                whbVar.i = jSONObject.optBoolean("forceNotCrop");
                whbVar.l = jSONObject.optInt("samplerFilter");
                whbVar.m = jSONObject.optBoolean("isSubProcess");
                whbVar.n = jSONObject.optInt("pcdnCatonTime");
                whbVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return whbVar;
        }
        return (whb) invokeL.objValue;
    }

    public static String b(whb whbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, whbVar)) == null) {
            if (whbVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", whbVar.a);
                jSONObject.put("avcCodec", whbVar.b);
                jSONObject.put("hevcCodec", whbVar.c);
                jSONObject.put("audioCodec", whbVar.d);
                jSONObject.put("videoSeekMode", whbVar.e);
                jSONObject.put("clearRender", whbVar.f);
                jSONObject.put("usingSurfaceView", whbVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", whbVar.h);
                jSONObject.put("forceNotCrop", whbVar.i);
                jSONObject.put("samplerFilter", whbVar.l);
                jSONObject.put("isSubProcess", whbVar.m);
                jSONObject.put("pcdnCatonTime", whbVar.n);
                jSONObject.put("pcdnCatonCount", whbVar.o);
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
