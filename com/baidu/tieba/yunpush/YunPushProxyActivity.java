package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
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
                        if (str2.equals("http://tieba.baidu.com/mo/q/chat") || str2.equals("https://tieba.baidu.com/mo/q/chat")) {
                            i = 1;
                        } else if (!str2.contains("jump_official_chat=1")) {
                            if (str2.contains("jump_chat=1")) {
                                i = 3;
                            }
                        }
                        TiebaStatic.log(new an("c11703").r("obj_type", 2).ae("task_id", str).ae("obj_to", str2).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
                        if (!TextUtils.isEmpty(str2) && (str2.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str2.startsWith("https"))) {
                            az.zI().c(getPageContext(), new String[]{str2});
                        }
                    }
                    i = 0;
                    TiebaStatic.log(new an("c11703").r("obj_type", 2).ae("task_id", str).ae("obj_to", str2).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
                    if (!TextUtils.isEmpty(str2)) {
                        az.zI().c(getPageContext(), new String[]{str2});
                    }
                }
            }
        } catch (Exception e) {
        }
        finish();
    }
}
