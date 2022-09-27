package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.q83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class wt1 extends rt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wt1 c;

        public a(wt1 wt1Var, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wt1Var, context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wt1Var;
            this.a = context;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (j83.h(o83Var)) {
                    this.c.d(this.b, new lv1(0, this.c.z(this.a)));
                    return;
                }
                int b = o83Var.b();
                j83.f(b);
                this.c.d(this.b, new lv1(b, j83.f(b)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wt1(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "DeviceInfoApi" : (String) invokeV.objValue;
    }

    public lv1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getDeviceInfo", false);
            l33 b0 = l33.b0();
            if (b0 == null) {
                return new lv1(1001, "swan app is null");
            }
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new lv1(202, "cb is empty");
                }
                Context context = getContext();
                b0.e0().g(context, "scope_get_device_info", new a(this, context, optString));
                return lv1.f();
            }
            return lv1Var;
        }
        return (lv1) invokeL.objValue;
    }

    public final JSONObject z(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("oaid", qo3.b.b(context));
                jSONObject.put("androidId", qo3.b.a(context));
            } catch (JSONException e) {
                p("#getDeviceInfo json put data fail", e, false);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
