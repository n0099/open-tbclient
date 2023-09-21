package com.baidu.tieba.tblauncher.dispatcher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.y9a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class CategoryListDispatcher implements y9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CategoryListDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.y9a
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            String optString = jSONObject.optString(BdUniDispatchSchemeController.PARAM_ITEM_ID_CAMEL);
            String optString2 = jSONObject.optString(BdUniDispatchSchemeController.PARAM_TAB_ID_CAMEL);
            String optString3 = jSONObject.optString(BdUniDispatchSchemeController.PARAM_SORT_TYPE_CAMEL);
            String optString4 = jSONObject.optString(BdUniDispatchSchemeController.PARAM_RANK_TYPE_CAMEL);
            String optString5 = jSONObject.optString(BdUniDispatchSchemeController.PARAM_RANK_CODE_CAMEL);
            String optString6 = jSONObject.optString(BdUniDispatchSchemeController.PARAM_HOME_TAB_NAME_CAMEL);
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", optString);
            hashMap.put("tab_id", optString2);
            hashMap.put("sort_type", optString3);
            hashMap.put("rank_type", optString4);
            hashMap.put("rank_code", optString5);
            hashMap.put("home_tab_name", optString6);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(context, "ItemRecommendList", hashMap)));
        }
    }
}
