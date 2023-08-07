package com.baidu.tieba.write.write.dispatcher;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.tieba.s1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class WritePostDispatcher implements s1a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SEEK_HELP = "seek_help";
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

    @Override // com.baidu.tieba.s1a
    public void dispatch(JSONObject jSONObject, Context context) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            if ("game_rank".equals(jSONObject.optString("h5_from"))) {
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(context);
                newInstance.setTitle(jSONObject.optString("game_name") + context.getString(R.string.obfuscated_res_0x7f0f11c1));
                StringBuilder sb = new StringBuilder();
                sb.append("#");
                sb.append(jSONObject.optString("topic_name"));
                sb.append("#");
                String optString = jSONObject.optString("rank_name");
                String optString2 = jSONObject.optString("game_name");
                sb.append(String.format(context.getString(R.string.obfuscated_res_0x7f0f11c2), optString, optString2, jSONObject.optString("reward_name")));
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
            String optString4 = jSONObject.optString("topic_name");
            if (StringUtils.isNotNull(optString4)) {
                newInstance2.setContent("#" + optString4 + "#");
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
            String optString5 = jSONObject.optString("forum_id");
            if (!TextUtils.isEmpty(optString5)) {
                newInstance2.setForumId(optString5);
            } else {
                newInstance2.setForumId("0");
            }
            String optString6 = jSONObject.optString("forum_name");
            if (!TextUtils.isEmpty(optString6)) {
                newInstance2.setForumName(optString6);
            }
            String optString7 = jSONObject.optString("active");
            if (!TextUtils.isEmpty(optString7)) {
                newInstance2.setActiveName(optString7);
            }
            String optString8 = jSONObject.optString("taskname");
            if (!TextUtils.isEmpty(optString8)) {
                newInstance2.setTaskName(optString8);
            }
            if (1 == jSONObject.optInt("not_save_draft")) {
                newInstance2.setIsSaveDraft(false);
            }
            if (SEEK_HELP.equals(jSONObject.optString("write_post_type"))) {
                newInstance2.setType(14);
            } else {
                newInstance2.setType(9);
            }
            String optString9 = jSONObject.optString(WriteActivityConfig.SHOW_NOT_SAVE_POPUP);
            if (!TextUtils.isEmpty(optString9)) {
                newInstance2.setShowNotSavePopup(optString9);
            }
            if (1 == jSONObject.optInt(WriteActivityConfig.KEY_PUT_STORAGE_TID)) {
                newInstance2.setPutStorageTid(true);
            }
            if (1 == jSONObject.optInt(WriteActivityConfig.KEY_NOT_USE_DRAFT)) {
                newInstance2.setNotUseDraft(true);
            }
            String optString10 = jSONObject.optString(WriteActivityConfig.NO_SUCCESS_TOAST);
            if (!TextUtils.isEmpty(optString10)) {
                newInstance2.setNoSuccessToast(optString10);
            }
            newInstance2.send();
        }
    }
}
