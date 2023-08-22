package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ig3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class t12 extends j12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ShowSMSPanelApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ t12 d;

        public a(t12 t12Var, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t12Var, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = t12Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (!bg3.h(gg3Var)) {
                    int b = gg3Var.b();
                    this.d.d(this.a, new d32(b, bg3.f(b)));
                    return;
                }
                this.d.z(this.b, this.c);
                this.d.d(this.a, new d32(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t12(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#openSystemSMSPanel", false);
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            d82.b("ShowSMSPanelApi", "params: ", jSONObject);
            String optString = jSONObject.optString("content");
            JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
            if (optJSONArray == null) {
                return new d32(202);
            }
            String y = y(optJSONArray);
            if (!TextUtils.isEmpty(y) && !TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new d32(202);
                }
                cb3.K().q().e0().g(getContext(), "scope_show_sms_panel", new a(this, optString2, y, optString));
                return d32.f();
            }
            return new d32(202);
        }
        return (d32) invokeL.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gi3 gi3Var = new gi3();
            gi3Var.b = "sms_panel";
            gi3Var.e = String.valueOf(this.f);
            gi3Var.a("appid", cb3.K().getAppId());
            wh3.x("1639", gi3Var);
        }
    }

    public final String y(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.f = jSONArray.length();
            for (int i = 0; i < this.f; i++) {
                String optString = jSONArray.optString(i);
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                sb.append(optString);
                if (i != this.f - 1) {
                    sb.append(ParamableElem.DIVIDE_PARAM);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void z(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            getContext().startActivity(intent);
            x();
        }
    }
}
