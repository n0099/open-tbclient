package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nl2 extends gh2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public int c;

    @Override // com.baidu.tieba.gh2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setZeusVideoExt" : (String) invokeV.objValue;
    }

    public nl2() {
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
        this.b = 1;
        this.c = 3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gh2
    /* renamed from: e */
    public void a(ZeusPlugin.Command command, xl2 xl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, xl2Var) == null) {
            Object obj = command.obj;
            boolean z = false;
            if (!(obj instanceof String)) {
                if (gh2.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("setZeusVideoExt with a illegal obj ");
                    if (obj == null) {
                        z = true;
                    }
                    sb.append(z);
                    throw new RuntimeException(sb.toString());
                }
                return;
            }
            String str = command.what;
            d(xl2Var, str, "setZeusVideoExt:" + obj, false);
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                if (jSONObject.has("instance-error")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("instance-error", jSONObject.optString("instance-error"));
                    xl2Var.T(hashMap);
                }
                String optString = jSONObject.optString("firstPlayStatus");
                if (!TextUtils.isEmpty(optString)) {
                    xl2Var.b0(optString);
                }
                this.b = jSONObject.optInt("min-cache", this.b);
                int optInt = jSONObject.optInt("max-cache", this.c);
                this.c = optInt;
                if (this.b <= optInt) {
                    if (jSONObject.has("min-cache")) {
                        xl2Var.G(this.b);
                    }
                    if (jSONObject.has("max-cache")) {
                        xl2Var.g0(this.c);
                    }
                } else if (gh2.a) {
                    Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.b + " > maxCache " + this.c);
                }
            } catch (Exception e) {
                if (!gh2.a) {
                    return;
                }
                throw new RuntimeException("setZeusVideoExt with a illegal str", e);
            }
        }
    }
}
