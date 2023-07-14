package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class sc3 extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, sd3> a;

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "swanAPI" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return null;
        }
        return (Class) invokeL.objValue;
    }

    public sc3() {
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
        this.a = new HashMap();
        a();
    }

    public void a() {
        List<sd3> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new md3(this));
            b(new f33(this));
            b(new vd3(this));
            b(new yc3(this));
            b(new y23(this));
            b(new hd3(this));
            b(new rj3(this));
            b(new sj3(this));
            b(new lj3(this));
            b(new mj3(this));
            b(new tj3(this));
            b(new uj3(this));
            b(new oj3(this));
            b(new pj3(this));
            b(new gj3(this));
            b(new hj3(this));
            b(new mg3(this));
            b(new lg3(this));
            b(new jg3(this));
            b(new hg3(this));
            b(new gg3(this));
            b(new fg3(this));
            b(new ig3(this));
            b(new pg3(this));
            b(new bd3(this));
            b(new qd3(this));
            b(new ri2(this));
            b(new ud3(this));
            b(new jd3(this));
            b(new id3(this));
            b(new vl3(this));
            b(new wl3(this));
            b(new il3(this));
            b(new jl3(this));
            b(new i03(this));
            b(new ld3(this));
            b(new q03(this));
            b(new k33(this));
            b(new cd3(this));
            b(new se3(this));
            b(new pe3(this));
            b(new a42(this));
            b(new pd3(this));
            b(new SwanAppDownloadAction(this));
            b(new td3(this));
            b(new qe3(this));
            b(new ne3(this));
            b(new me3(this));
            b(new em3(this));
            b(new fm3(this));
            b(new rl3(this));
            b(new pl3(this));
            b(new kl3(this));
            b(new hm3(this));
            b(new ll3(this));
            b(new ml3(this));
            b(new gm3(this));
            b(new mz1(this));
            b(new ng3(this));
            b(new os2(this));
            b(new nz1(this));
            b(new e93(this));
            b(new c93(this));
            b(new f93(this));
            b(new d93(this));
            at1 d = dv2.d();
            if (d != null && (c = d.c(this)) != null && !c.isEmpty()) {
                for (sd3 sd3Var : c) {
                    b(sd3Var);
                }
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void b(sd3 sd3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sd3Var) == null) {
            this.a.put(sd3Var.a, sd3Var);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            Uri uri = unitedSchemeEntity.getUri();
            if (uri == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty url");
                return false;
            } else if (uri.getPathSegments() != null && !uri.getPathSegments().isEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("swanAPI");
                arrayList.addAll(uri.getPathSegments());
                String str = "/swanAPI" + uri.getPath();
                if (!TextUtils.isEmpty(str) && str.startsWith("/")) {
                    for (int size = arrayList.size(); size > 0; size--) {
                        String str2 = "/" + ((String) arrayList.get(size - 1));
                        if (!str.isEmpty() && str.length() >= str2.length()) {
                            sd3 sd3Var = this.a.get(str);
                            if (sd3Var != null) {
                                if (unitedSchemeEntity.isOnlyVerify()) {
                                    return true;
                                }
                                return sd3Var.h(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
                            }
                            str = str.substring(0, str.length() - str2.length());
                        } else {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str + " @ " + str2);
                            return false;
                        }
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "not support such action ：" + uri.getPath());
                    return false;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str);
                return false;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty Segment");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
