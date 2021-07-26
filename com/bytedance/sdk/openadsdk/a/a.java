package com.bytedance.sdk.openadsdk.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f29165a;

    /* renamed from: b  reason: collision with root package name */
    public String f29166b;

    /* renamed from: c  reason: collision with root package name */
    public String f29167c;

    /* renamed from: d  reason: collision with root package name */
    public long f29168d;

    /* renamed from: e  reason: collision with root package name */
    public long f29169e;

    public a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29165a = jSONObject.optLong(IAdRequestParam.CELL_ID);
        this.f29166b = jSONObject.optString("url");
        this.f29167c = jSONObject.optString("file_hash");
        this.f29168d = jSONObject.optLong("effective_time");
        this.f29169e = jSONObject.optLong(GameGuideConfigInfo.KEY_EXPIRATION_TIME);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29166b : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29167c : (String) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29168d : invokeV.longValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? System.currentTimeMillis() >= this.f29169e : invokeV.booleanValue;
    }

    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(IAdRequestParam.CELL_ID, this.f29165a);
                jSONObject.put("url", this.f29166b);
                jSONObject.put("file_hash", this.f29167c);
                jSONObject.put("effective_time", this.f29168d);
                jSONObject.put(GameGuideConfigInfo.KEY_EXPIRATION_TIME, this.f29169e);
            } catch (Exception e2) {
                k.d("BrandVideo", e2.getMessage());
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            File file = new File(str, this.f29167c);
            if (file.exists()) {
                return file.lastModified();
            }
            return System.currentTimeMillis();
        }
        return invokeL.longValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            File file = new File(str, this.f29167c);
            if (file.exists()) {
                try {
                    return file.delete();
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
