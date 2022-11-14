package com.baidu.tieba.write.write.dispatcher;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.ei8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class WritePostDispatcher implements ei8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WritePostDispatcher() {
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

    @Override // com.baidu.tieba.ei8
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            boolean z = false;
            if ("game_rank".equals(jSONObject.optString("h5_from"))) {
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(context);
                newInstance.setTitle(jSONObject.optString("game_name") + context.getString(R.string.obfuscated_res_0x7f0f0fce));
                StringBuilder sb = new StringBuilder();
                sb.append("#");
                sb.append(jSONObject.optString(IntentConfig.TOPIC_NAME));
                sb.append("#");
                String optString = jSONObject.optString("rank_name");
                String optString2 = jSONObject.optString("game_name");
                sb.append(String.format(context.getString(R.string.obfuscated_res_0x7f0f0fcf), optString, optString2, jSONObject.optString("reward_name")));
                newInstance.setContent(sb.toString());
                newInstance.setXiuxiuOriginalContent(sb.toString());
                newInstance.setGameRankImgUrl(jSONObject.optString(BigdayActivityConfig.IMG_URL));
                newInstance.setForumName(jSONObject.optString("forum_name"));
                newInstance.setXiuxiuOriginalFname(jSONObject.optString("forum_name"));
                newInstance.setForumId(jSONObject.optString("forum_id"));
                newInstance.setGameId(jSONObject.optString("game_id"));
                newInstance.setGameName(optString2);
                newInstance.setRewardsType(jSONObject.optString("rewardsType"));
                newInstance.setFromGameRank(true);
                newInstance.setIsSaveDraft(false);
                newInstance.send();
                return;
            }
            WriteActivityConfig newInstance2 = WriteActivityConfig.newInstance(context);
            String optString3 = jSONObject.optString("title");
            if (!TextUtils.isEmpty(optString3)) {
                newInstance2.setTitle(optString3);
            }
            if (1 == jSONObject.optInt("notification_h5")) {
                z = true;
            }
            newInstance2.setNotificationH5(z);
            if (1 == jSONObject.optInt("use_home_style")) {
                newInstance2.setCallFrom("2");
                newInstance2.setFrom("main_tab");
                newInstance2.setNotShowVideoWorkListPage(true);
                newInstance2.setStatisticFrom(1);
            }
            if (1 == jSONObject.optInt("not_fake_post")) {
                newInstance2.setNotFakePost(true);
            }
            newInstance2.setType(9);
            newInstance2.send();
        }
    }
}
