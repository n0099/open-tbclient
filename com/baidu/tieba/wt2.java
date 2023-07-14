package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wt2 extends pp2<gu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public int c;

    @Override // com.baidu.tieba.pp2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setZeusVideoExt" : (String) invokeV.objValue;
    }

    public wt2() {
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
    @Override // com.baidu.tieba.pp2
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull gu2 gu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, gu2Var) == null) {
            Object obj = command.obj;
            boolean z = false;
            if (!(obj instanceof String)) {
                if (pp2.a) {
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
            d(gu2Var, str, "setZeusVideoExt:" + obj, false);
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                if (jSONObject.has("instance-error")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("instance-error", jSONObject.optString("instance-error"));
                    gu2Var.S(hashMap);
                }
                String optString = jSONObject.optString("firstPlayStatus");
                if (!TextUtils.isEmpty(optString)) {
                    gu2Var.a0(optString);
                }
                this.b = jSONObject.optInt("min-cache", this.b);
                int optInt = jSONObject.optInt("max-cache", this.c);
                this.c = optInt;
                if (this.b <= optInt) {
                    if (jSONObject.has("min-cache")) {
                        gu2Var.G(this.b);
                    }
                    if (jSONObject.has("max-cache")) {
                        gu2Var.f0(this.c);
                    }
                } else if (pp2.a) {
                    Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.b + " > maxCache " + this.c);
                }
            } catch (Exception e) {
                if (!pp2.a) {
                    return;
                }
                throw new RuntimeException("setZeusVideoExt with a illegal str", e);
            }
        }
    }
}
