package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4 A[Catch: Exception -> 0x010b, TRY_LEAVE, TryCatch #0 {Exception -> 0x010b, blocks: (B:3:0x0006, B:5:0x000c, B:7:0x001d, B:9:0x0041, B:10:0x0049, B:12:0x0055, B:13:0x005c, B:15:0x0062, B:17:0x006b, B:33:0x00df, B:20:0x0075, B:22:0x00a3, B:24:0x00ac, B:26:0x00b5, B:28:0x00be, B:30:0x00c4, B:38:0x00f3, B:35:0x00e8), top: B:44:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f3 A[Catch: Exception -> 0x010b, TRY_LEAVE, TryCatch #0 {Exception -> 0x010b, blocks: (B:3:0x0006, B:5:0x000c, B:7:0x001d, B:9:0x0041, B:10:0x0049, B:12:0x0055, B:13:0x005c, B:15:0x0062, B:17:0x006b, B:33:0x00df, B:20:0x0075, B:22:0x00a3, B:24:0x00ac, B:26:0x00b5, B:28:0x00be, B:30:0x00c4, B:38:0x00f3, B:35:0x00e8), top: B:44:0x0006 }] */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        String str;
        int i = 2;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null) {
                String uri = intent.getData().toString();
                if (uri.contains("tbyunpushnotifybody=")) {
                    JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf("tbyunpushnotifybody=") + "tbyunpushnotifybody=".length()));
                    if (jSONObject.isNull("task_id")) {
                        str = "";
                    } else {
                        str = jSONObject.getString("task_id");
                    }
                    String str2 = "";
                    if (!jSONObject.isNull("jump_scheme")) {
                        str2 = jSONObject.getString("jump_scheme");
                    }
                    if (!StringUtils.isNull(str2)) {
                        if (str2.equals(UrlSchemaHelper.JUMP_TO_CHAT) || str2.equals(UrlSchemaHelper.HTTPS_JUMP_TO_CHAT)) {
                            i = 1;
                        } else if (!str2.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                            if (str2.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                                i = 3;
                            }
                        }
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).X("obj_type", 2).cx("task_id", str).cx(TiebaInitialize.Params.OBJ_TO, str2).X("obj_source", i));
                        if (!TextUtils.isEmpty(str2) && (str2.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str2.startsWith("https") || str2.startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list"))) {
                            if (!Li(str2)) {
                                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                mainTabActivityConfig.setTargetScheme(str2);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig));
                            } else {
                                ba.aGK().b(getPageContext(), new String[]{str2, "yun_push_tag"});
                            }
                        }
                    }
                    i = 0;
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).X("obj_type", 2).cx("task_id", str).cx(TiebaInitialize.Params.OBJ_TO, str2).X("obj_source", i));
                    if (!TextUtils.isEmpty(str2)) {
                        if (!Li(str2)) {
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        finish();
    }

    private boolean Li(String str) {
        return Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find() || str.startsWith("http://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("https://tieba.baidu.com/mo/q/newtopic/detail");
    }
}
