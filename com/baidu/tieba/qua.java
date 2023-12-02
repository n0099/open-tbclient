package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AICapacityApplyHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Service
/* loaded from: classes7.dex */
public final class qua implements wa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qua() {
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

    @Override // com.baidu.tieba.wa5
    public void parseJson(JSONObject json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JSONObject optJSONObject = json.optJSONObject("wl_config");
                if (optJSONObject != null) {
                    AICapacityApplyHelper a = AICapacityApplyHelper.e.a();
                    boolean z = true;
                    if (optJSONObject.optInt("ai_available_status") != 1) {
                        z = false;
                    }
                    a.g(z);
                }
                JSONObject optJSONObject2 = json.optJSONObject("common_scheme");
                if (optJSONObject2 != null) {
                    String aiWriteScheme = optJSONObject2.optString("ai_write_scheme");
                    if (!TextUtils.isEmpty(aiWriteScheme)) {
                        AICapacityApplyHelper a2 = AICapacityApplyHelper.e.a();
                        Intrinsics.checkNotNullExpressionValue(aiWriteScheme, "aiWriteScheme");
                        a2.h(aiWriteScheme);
                    }
                }
            } catch (Exception e) {
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    e.printStackTrace();
                    return;
                }
                throw e;
            }
        }
    }
}
