package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ps3 extends fh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;
    public String t;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends ug3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ps3 c;

        /* loaded from: classes7.dex */
        public class a implements oq3<Bundle> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.oq3
            /* renamed from: b */
            public void a(Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                    if (bundle == null) {
                        this.a.e(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                    if (TextUtils.isEmpty(string)) {
                        this.a.e(new OAuthException("empty stoken", 10001));
                        return;
                    }
                    this.a.c.t = string;
                    this.a.d();
                }
            }
        }

        public b(ps3 ps3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ps3Var;
        }

        public /* synthetic */ b(ps3 ps3Var, a aVar) {
            this(ps3Var);
        }

        @Override // com.baidu.tieba.ug3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.c.s) {
                    wr3.t(this.c.m, new a(this), BdZeusUtil.URL_KEY_MACHINE);
                    return false;
                }
                this.c.t = null;
                if (ps3.u) {
                    Log.w("MaOpenDataRequest", "user not login");
                    return true;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948072569, "Lcom/baidu/tieba/ps3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948072569, "Lcom/baidu/tieba/ps3;");
                return;
            }
        }
        u = fs1.a;
    }

    @Override // com.baidu.tieba.fh3
    public JSONObject P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject P = super.P();
            if (!TextUtils.isEmpty(this.t)) {
                try {
                    P.put("stoken", this.t);
                } catch (JSONException e) {
                    if (u) {
                        e.printStackTrace();
                    }
                }
            }
            return P;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sg3
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h(new b(this, null));
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ps3(Activity activity, String str, String str2, boolean z, boolean z2) {
        super(activity, str, str2, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Activity) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.s = z2;
        y();
    }
}
