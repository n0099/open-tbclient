package com.baidu.tieba.write.write.dispatcher;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.tieba.g39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class WritePostDispatcher implements g39 {
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

    private ArrayList<AtSelectData> getAtListByJson(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("atList")) == null) {
                return null;
            }
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    arrayList.add(new AtSelectData(jSONObject2.optString("portrait"), jSONObject2.optString("uname")));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g39
    public void dispatch(JSONObject jSONObject, Context context) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            if ("game_rank".equals(jSONObject.optString("h5_from"))) {
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(context);
                newInstance.setTitle(jSONObject.optString("game_name") + context.getString(R.string.obfuscated_res_0x7f0f1061));
                StringBuilder sb = new StringBuilder();
                sb.append("#");
                sb.append(jSONObject.optString(IntentConfig.TOPIC_NAME));
                sb.append("#");
                String optString = jSONObject.optString("rank_name");
                String optString2 = jSONObject.optString("game_name");
                sb.append(String.format(context.getString(R.string.obfuscated_res_0x7f0f1062), optString, optString2, jSONObject.optString("reward_name")));
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
            } else {
                z = false;
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
            newInstance2.setHintText(jSONObject.optString("hintText"));
            try {
                newInstance2.setAtList(getAtListByJson(jSONObject));
            } catch (JSONException e) {
                BdLog.e(e);
            }
            String optString4 = jSONObject.optString("forum_id");
            if (!TextUtils.isEmpty(optString4)) {
                newInstance2.setForumId(optString4);
            }
            String optString5 = jSONObject.optString("forum_name");
            if (!TextUtils.isEmpty(optString5)) {
                newInstance2.setForumName(optString5);
            }
            String optString6 = jSONObject.optString("active");
            if (!TextUtils.isEmpty(optString6)) {
                newInstance2.setActiveName(optString6);
            }
            String optString7 = jSONObject.optString("taskname");
            if (!TextUtils.isEmpty(optString7)) {
                newInstance2.setTaskName(optString7);
            }
            if (1 == jSONObject.optInt("not_save_draft")) {
                newInstance2.setIsSaveDraft(false);
            }
            newInstance2.setType(9);
            newInstance2.send();
        }
    }
}
