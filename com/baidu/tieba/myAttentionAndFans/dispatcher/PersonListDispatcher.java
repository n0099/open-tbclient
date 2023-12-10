package com.baidu.tieba.myAttentionAndFans.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.myAttentionAndFans.PersonListActivity;
import com.baidu.tieba.pma;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PersonListDispatcher implements pma {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PersonListDispatcher() {
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

    @Override // com.baidu.tieba.pma
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            boolean optBoolean = jSONObject.optBoolean("follow");
            boolean optBoolean2 = jSONObject.optBoolean("isBjhUser");
            String optString = jSONObject.optString("userId");
            String optString2 = jSONObject.optString("portrait");
            int optInt = jSONObject.optInt("userSex");
            int optInt2 = jSONObject.optInt("totalFollowNum");
            Intent intent = new Intent();
            intent.putExtra("follow", optBoolean);
            intent.putExtra("user_id", optString);
            intent.putExtra(IntentConfig.USER_SEX, optInt);
            intent.putExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, optInt2);
            intent.putExtra("portrait", optString2);
            intent.putExtra(IntentConfig.IS_BJH_USER, optBoolean2);
            intent.setClass(context, PersonListActivity.class);
            context.startActivity(intent);
        }
    }
}
