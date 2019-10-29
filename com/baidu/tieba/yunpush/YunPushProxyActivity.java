package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import org.apache.http.HttpHost;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
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
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).O("obj_type", 2).bS("task_id", str).bS(TiebaInitialize.Params.OBJ_TO, str2).O("obj_source", i));
                        if (!TextUtils.isEmpty(str2) && (str2.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str2.startsWith("https") || str2.startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list"))) {
                            ba.amQ().b(getPageContext(), new String[]{str2});
                        }
                    }
                    i = 0;
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).O("obj_type", 2).bS("task_id", str).bS(TiebaInitialize.Params.OBJ_TO, str2).O("obj_source", i));
                    if (!TextUtils.isEmpty(str2)) {
                        ba.amQ().b(getPageContext(), new String[]{str2});
                    }
                }
            }
        } catch (Exception e) {
        }
        finish();
    }
}
