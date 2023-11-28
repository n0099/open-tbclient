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
public class uhc {
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
    public transient yjc j;
    public transient xjc k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public uhc() {
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

    public static uhc a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            uhc uhcVar = new uhc();
            try {
                JSONObject jSONObject = new JSONObject(str);
                uhcVar.a = jSONObject.optString("cacheDirectory");
                uhcVar.b = jSONObject.optInt("avcCodec");
                uhcVar.c = jSONObject.optInt("hevcCodec");
                uhcVar.d = jSONObject.optInt("audioCodec");
                uhcVar.e = jSONObject.optInt("videoSeekMode");
                uhcVar.f = jSONObject.optBoolean("clearRender");
                uhcVar.g = jSONObject.optBoolean("usingSurfaceView");
                uhcVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                uhcVar.i = jSONObject.optBoolean("forceNotCrop");
                uhcVar.l = jSONObject.optInt("samplerFilter");
                uhcVar.m = jSONObject.optBoolean("isSubProcess");
                uhcVar.n = jSONObject.optInt("pcdnCatonTime");
                uhcVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return uhcVar;
        }
        return (uhc) invokeL.objValue;
    }

    public static String b(uhc uhcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uhcVar)) == null) {
            if (uhcVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", uhcVar.a);
                jSONObject.put("avcCodec", uhcVar.b);
                jSONObject.put("hevcCodec", uhcVar.c);
                jSONObject.put("audioCodec", uhcVar.d);
                jSONObject.put("videoSeekMode", uhcVar.e);
                jSONObject.put("clearRender", uhcVar.f);
                jSONObject.put("usingSurfaceView", uhcVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", uhcVar.h);
                jSONObject.put("forceNotCrop", uhcVar.i);
                jSONObject.put("samplerFilter", uhcVar.l);
                jSONObject.put("isSubProcess", uhcVar.m);
                jSONObject.put("pcdnCatonTime", uhcVar.n);
                jSONObject.put("pcdnCatonCount", uhcVar.o);
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
