package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rc3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rc3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/openApp4Ad");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static ResolveInfo j(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return null;
            }
            return queryIntentActivities.iterator().next();
        }
        return (ResolveInfo) invokeLL.objValue;
    }

    public static void k(Context context, ResolveInfo resolveInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, context, resolveInfo) == null) && context != null && resolveInfo != null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            try {
                ou2.a().b(context, intent, gb3.K().q().O(), null, resolveInfo.activityInfo.packageName);
            } catch (Exception e) {
                if (ed3.b) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            JSONObject a = ed3.a(unitedSchemeEntity, "params");
            if (a == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
                h82.i("OpenAdAppAction", "params parse error");
                return false;
            } else if (!ou2.a().d()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1003, "Host denied");
                h82.i("OpenAdAppAction", "Host denied");
                return false;
            } else {
                String optString = a.optString("name");
                String optString2 = a.optString("url");
                if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty params: Must contain 'url' or 'name' parameter");
                    h82.i("OpenAdAppAction", "empty params: Must contain 'url' or 'name' parameter");
                    return false;
                }
                if (!TextUtils.isEmpty(optString2)) {
                    if (bp3.W(context, optString2)) {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "deeplink launch failed");
                    h82.i("OpenAdAppAction", "deeplink launch failed");
                }
                if (!TextUtils.isEmpty(optString)) {
                    ResolveInfo j = j(context, optString);
                    if (j != null) {
                        k(context, j);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "app not installed");
                    h82.i("OpenAdAppAction", "app not installed");
                }
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "launch failed");
                    h82.i("OpenAdAppAction", "launch failed");
                }
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
