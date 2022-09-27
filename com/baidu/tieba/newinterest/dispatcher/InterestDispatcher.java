package com.baidu.tieba.newinterest.dispatcher;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tieba.zf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes5.dex */
public class InterestDispatcher implements zf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InterestDispatcher() {
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

    @Override // com.baidu.tieba.zf8
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) || jSONObject == null || context == null) {
            return;
        }
        InterestGuideActivityConfig interestGuideActivityConfig = new InterestGuideActivityConfig(context);
        try {
            boolean z = true;
            if (jSONObject.getInt("from") != 1) {
                z = false;
            }
            interestGuideActivityConfig.setIsBackToMainTab(z);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        interestGuideActivityConfig.start();
    }
}
