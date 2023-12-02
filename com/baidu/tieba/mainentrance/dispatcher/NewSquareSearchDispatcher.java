package com.baidu.tieba.mainentrance.dispatcher;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tieba.oma;
import com.baidu.tieba.ra8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class NewSquareSearchDispatcher implements oma {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NewSquareSearchDispatcher() {
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

    @Override // com.baidu.tieba.oma
    public void dispatch(JSONObject jSONObject, Context context) {
        String optString;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            if (!TextUtils.isEmpty(jSONObject.optString("queryContent"))) {
                str = "keyword=" + ra8.a(optString);
            } else {
                str = "";
            }
            String str2 = ra8.a;
            if (!TextUtils.isEmpty(str)) {
                str2 = BdUtilHelper.urlAddParam(BdUtilHelper.urlAddParam(str2, str), "pageType=result");
            }
            BrowserHelper.startWebActivity(context, str2);
        }
    }
}
