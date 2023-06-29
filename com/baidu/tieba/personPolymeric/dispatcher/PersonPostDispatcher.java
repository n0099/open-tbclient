package com.baidu.tieba.personPolymeric.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tieba.post.PersonPostActivity;
import com.baidu.tieba.xu9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PersonPostDispatcher implements xu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PersonPostDispatcher() {
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

    @Override // com.baidu.tieba.xu9
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            String optString = jSONObject.optString("uid");
            String optString2 = jSONObject.optString("portrait");
            Intent intent = new Intent();
            intent.putExtra("key_uid", optString);
            intent.putExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL, optString2);
            intent.setClass(context, PersonPostActivity.class);
            context.startActivity(intent);
        }
    }
}
