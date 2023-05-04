package com.baidu.tieba.personPolymeric.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.ReportThemeActivityConfig;
import com.baidu.tieba.eg9;
import com.baidu.tieba.personPolymeric.jvbao.ReportThemeActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ReportThemeDispatcher implements eg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ReportThemeDispatcher() {
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

    @Override // com.baidu.tieba.eg9
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("threadArray");
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra(ReportThemeActivityConfig.REPORT_TID_LIST, arrayList);
            intent.putExtra("portrait", jSONObject.optString("portrait"));
            intent.setClass(context, ReportThemeActivity.class);
            context.startActivity(intent);
        }
    }
}
