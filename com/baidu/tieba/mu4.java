package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class mu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public String e;
    public final Map<String, String> f;
    public final List<ru4> g;

    public mu4(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new LinkedHashMap();
        this.g = new ArrayList();
        this.a = str;
        this.b = str2;
        this.c = str3;
        if (!StringUtils.isNull(str2) && !StringUtils.isNull(str3)) {
            a();
            b();
            c();
            return;
        }
        this.d = false;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g.add(new xu4());
            this.g.add(new vu4());
            this.g.add(new tu4());
            this.g.add(new yu4());
            this.g.add(new wu4());
            this.g.add(new zu4());
            this.g.add(new uu4());
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || StringUtils.isNull(this.b)) {
            return;
        }
        String valueOf = String.valueOf(this.b.charAt(0));
        String[] split = this.b.split("@");
        for (ru4 ru4Var : this.g) {
            if (valueOf.equals(ru4Var.b())) {
                String a = ru4Var.a(split, this.f);
                this.e = a;
                if (!StringUtils.isNull(a)) {
                    this.d = true;
                    return;
                }
                return;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.put("@d", BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            this.f.put("@n", BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE);
            this.f.put("@v", BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            this.f.put("@rid", HttpClientWrap.f);
            this.f.put("@sid", TiebaStatic.Params.WISE_SAMPLE_ID);
            this.f.put("@c", TiebaStatic.Params.QD);
            this.f.put("@p", "obj_source");
            this.f.put("@eq", TiebaStatic.Params.EQID);
            this.f.put("@1p", "obj_param1");
            this.f.put("@2p", TiebaStatic.Params.OBJ_PARAM2);
            this.f.put("@m", "obj_name");
            this.f.put("@re", "refer");
            this.f.put("@lo", "obj_locate");
        }
    }
}
