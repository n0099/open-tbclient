package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.FriendBotPostConfigData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Service
/* loaded from: classes7.dex */
public final class rk5 implements if5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    public rk5() {
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
        this.a = "wl_config";
    }

    @Override // com.baidu.tieba.if5
    public void parseJson(JSONObject json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JSONObject optJSONObject = json.optJSONObject(this.a);
                if (optJSONObject != null) {
                    String botConfigStr = optJSONObject.optString("friend_bot_post_config");
                    if (!TextUtils.isEmpty(botConfigStr)) {
                        Intrinsics.checkNotNullExpressionValue(botConfigStr, "botConfigStr");
                        TbSingleton.getInstance().setFriendBotPostConfigData((FriendBotPostConfigData) DataExt.toEntity(botConfigStr, FriendBotPostConfigData.class));
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
