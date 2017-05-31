package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null) {
                String uri = intent.getData().toString();
                if (uri.contains("tbyunpushnotifybody=")) {
                    JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf("tbyunpushnotifybody=") + "tbyunpushnotifybody=".length()));
                    String str = "";
                    if (!jSONObject.isNull(InterviewLiveActivityConfig.KEY_TASK_ID)) {
                        str = jSONObject.getString(InterviewLiveActivityConfig.KEY_TASK_ID);
                    }
                    TiebaStatic.log(new as("c11703").r("obj_type", 2).Z(InterviewLiveActivityConfig.KEY_TASK_ID, str));
                    String str2 = "";
                    if (!jSONObject.isNull("jump_scheme")) {
                        str2 = jSONObject.getString("jump_scheme");
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.startsWith("http") || str2.startsWith("https")) {
                            bb.vy().c(getPageContext(), new String[]{str2});
                        } else {
                            Intent parseUri = Intent.parseUri(str2, 1);
                            parseUri.setFlags(276824064);
                            getPageContext().getPageActivity().startActivity(parseUri);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        finish();
    }
}
