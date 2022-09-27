package com.baidu.tieba.write.write;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.gp8;
import com.baidu.tieba.zf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class EditThreadDispatcher implements zf8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ORIGINAL_THREAD = "1";
    public transient /* synthetic */ FieldHolder $fh;

    public EditThreadDispatcher() {
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
        String optString = jSONObject.optString("pos");
        String optString2 = jSONObject.optString("fid");
        String optString3 = jSONObject.optString("fname");
        String optString4 = jSONObject.optString("content");
        Intent intent = new Intent();
        if ("1".equals(optString)) {
            intent.setClass(context, WriteActivity.class);
            ForumWriteData forumWriteData = new ForumWriteData(optString2, optString3, null, null);
            intent.putExtra("type", 9);
            if (optString2 == null) {
                optString2 = "0";
            }
            intent.putExtra("forum_id", optString2);
            intent.putExtra("forum_name", optString3);
            AntiData antiData = forumWriteData.antiData;
            if (antiData != null) {
                intent.putExtra(WriteActivityConfig.ENABLE_AUDIO, antiData.isIfvoice());
                intent.putExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE, forumWriteData.antiData.getVoice_message());
                intent.putExtra(WriteActivityConfig.CAN_GOODS, forumWriteData.antiData.getCanGoods());
            }
            PostPrefixData postPrefixData = forumWriteData.prefixData;
            if (postPrefixData != null) {
                intent.putExtra("prefix_data", postPrefixData);
            }
            intent.putExtra(BaseWriteConfig.PRIVATE_THREAD, false);
            String str = forumWriteData.firstDir;
            if (str == null) {
                str = "";
            }
            intent.putExtra(IntentConfig.FORUM_FIRST_DIR, str);
            String str2 = forumWriteData.secondDir;
            intent.putExtra(IntentConfig.FORUM_SECOND_DIR, str2 != null ? str2 : "");
            intent.putExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, forumWriteData.defaultZone);
            intent.putExtra("tab_list", forumWriteData.frsTabInfo);
            intent.putExtra("from", forumWriteData.mFrom);
            intent.putExtra(BaseWriteConfig.KEY_CALL_FROM, forumWriteData.writeCallFrom);
            intent.putExtra(WriteActivityConfig.KEY_STATISTIS_FROM, forumWriteData.statisticFrom);
            intent.putExtra(BaseWriteConfig.IS_SAVE_DRAFTE, false);
            intent.putExtra(BaseWriteConfig.CONTENT, optString4);
            intent.putExtra("from", "frs");
            intent.putExtra(BaseWriteConfig.KEY_CALL_FROM, "2");
            intent.setClass(context, WriteActivity.class);
            gp8.h = intent;
            context.startActivity(intent);
        }
    }
}
