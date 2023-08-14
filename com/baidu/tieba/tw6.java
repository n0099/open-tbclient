package com.baidu.tieba;

import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.easteregg.data.EasterEggAdData;
import com.baidu.tieba.easteregg.data.EasterEggAdDataHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Service
/* loaded from: classes8.dex */
public final class tw6 implements re5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final sw6 a;

    public tw6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        Intrinsics.checkNotNullExpressionValue(inst, "getInst()");
        this.a = new sw6(inst);
    }

    @Override // com.baidu.tieba.re5
    public void parseJson(JSONObject json) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JSONObject optJSONObject2 = json.optJSONObject("floating_icon");
                if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("easter_egg")) != null) {
                    EasterEggAdDataHolder.b.a().c(EasterEggAdData.Companion.b(optJSONObject));
                    sw6 sw6Var = this.a;
                    String jSONObject = optJSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "easterEggJsonObject.toString()");
                    sw6Var.c(jSONObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
