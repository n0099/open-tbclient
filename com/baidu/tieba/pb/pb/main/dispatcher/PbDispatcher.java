package com.baidu.tieba.pb.pb.main.dispatcher;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.y9a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PbDispatcher implements y9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PbDispatcher() {
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

    @Override // com.baidu.tieba.y9a
    public void dispatch(JSONObject jSONObject, Context context) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            String optString = jSONObject.optString("tid");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            String optString2 = jSONObject.optString("query");
            String optString3 = jSONObject.optString("channelId");
            if ("1".equals(jSONObject.optString("preSource"))) {
                i = 2;
            } else {
                i = 0;
            }
            String optString4 = jSONObject.optString("hightlightAnchorPid");
            boolean equals = "1".equals(jSONObject.optString("showComment"));
            if (!TextUtils.isEmpty(optString4)) {
                equals = true;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(optString, optString4, 1, "allthread");
            createNormalCfg.setSimilarFrom(i);
            createNormalCfg.setQueryKeywordFromSearch(optString2);
            createNormalCfg.setChannelId(optString3);
            createNormalCfg.setStartFrom(JavaTypesHelper.toInt(jSONObject.optString("from"), 12));
            createNormalCfg.setHighLightPostId(optString4);
            createNormalCfg.setJumpToCommentArea(equals);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }
}
