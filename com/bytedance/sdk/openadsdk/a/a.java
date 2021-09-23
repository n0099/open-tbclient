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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f65729a;

    /* renamed from: b  reason: collision with root package name */
    public String f65730b;

    /* renamed from: c  reason: collision with root package name */
    public String f65731c;

    /* renamed from: d  reason: collision with root package name */
    public long f65732d;

    /* renamed from: e  reason: collision with root package name */
    public long f65733e;

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
        this.f65729a = jSONObject.optLong(IAdRequestParam.CELL_ID);
        this.f65730b = jSONObject.optString("url");
        this.f65731c = jSONObject.optString("file_hash");
        this.f65732d = jSONObject.optLong("effective_time");
        this.f65733e = jSONObject.optLong(GameGuideConfigInfo.KEY_EXPIRATION_TIME);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65730b : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65731c : (String) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f65732d : invokeV.longValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? System.currentTimeMillis() >= this.f65733e : invokeV.booleanValue;
    }

    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(IAdRequestParam.CELL_ID, this.f65729a);
                jSONObject.put("url", this.f65730b);
                jSONObject.put("file_hash", this.f65731c);
                jSONObject.put("effective_time", this.f65732d);
                jSONObject.put(GameGuideConfigInfo.KEY_EXPIRATION_TIME, this.f65733e);
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
            File file = new File(str, this.f65731c);
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
            File file = new File(str, this.f65731c);
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
