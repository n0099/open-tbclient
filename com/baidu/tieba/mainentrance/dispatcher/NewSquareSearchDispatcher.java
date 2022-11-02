package com.baidu.tieba.mainentrance.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.mainentrance.NewSquareSearchActivity;
import com.baidu.tieba.th8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class NewSquareSearchDispatcher implements th8 {
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

    @Override // com.baidu.tieba.th8
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            jSONObject.optBoolean("isFromEnterForum");
            String optString = jSONObject.optString("queryContent");
            Intent intent = new Intent();
            intent.putExtra(IntentConfig.SEARCH_PAGE_QUERY_CONTENT_KEY, optString);
            intent.setClass(context, NewSquareSearchActivity.class);
            context.startActivity(intent);
        }
    }
}
