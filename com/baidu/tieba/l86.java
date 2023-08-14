package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l86 extends vc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l86(vb3 vb3Var) {
        super(vb3Var, "/swan/publishThread");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vb3Var};
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

    public static boolean j(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("path");
                if (StringUtils.isNull(optString)) {
                    String optString2 = jSONObject.optString("appid");
                    if (StringUtils.isNull(optString2)) {
                        return false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, TbAiappsLaunchUtil.getSmartLink(optString2, "", "", 0)));
                    return true;
                }
                String substring = optString.substring(39);
                if (StringUtils.isNull(substring)) {
                    return false;
                }
                JSONObject jSONObject2 = new JSONObject(bi.getUrlDecode(substring));
                String optString3 = jSONObject2.optString("third_app_id");
                String optString4 = jSONObject2.optString("third_app_name");
                String optString5 = jSONObject2.optString("third_app_pic");
                String optString6 = jSONObject2.optString("third_app_link");
                SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(context, 10086);
                selectForumActivityConfig.setAiAppsParams(optString3, optString4, optString5, null, null, optString6);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.vc3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, ya3Var)) == null) {
            j(context, unitedSchemeEntity.getParam("params"));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
