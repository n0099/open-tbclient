package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.hi9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PbFloorDispatcher implements hi9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PbFloorDispatcher() {
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

    @Override // com.baidu.tieba.hi9
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            String optString = jSONObject.optString("tid");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            String optString2 = jSONObject.optString("floorId");
            String optString3 = jSONObject.optString("postId");
            String optString4 = jSONObject.optString("content");
            if (TextUtils.isEmpty(optString2) && TextUtils.isEmpty(optString3)) {
                return;
            }
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(context).createSubPbActivityConfig(optString, optString3, optString2);
            createSubPbActivityConfig.setKeyPageStartFrom(25);
            createSubPbActivityConfig.setHighLightPostId(optString2);
            if (TextUtils.isEmpty(optString4)) {
                createSubPbActivityConfig.showOpenEditorTips(optString4);
            }
            createSubPbActivityConfig.start();
        }
    }
}
