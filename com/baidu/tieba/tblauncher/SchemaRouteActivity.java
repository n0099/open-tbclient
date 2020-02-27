package com.baidu.tieba.tblauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class SchemaRouteActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        az(getIntent());
        finish();
    }

    private void az(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString) && (dataString.contains("invoke_frs") || dataString.contains("tbfrs") || dataString.contains("unidispatch/frs"))) {
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(getActivity());
                frsActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig));
            } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbpb") || dataString.contains("unidispatch/pb"))) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(getActivity());
                pbActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            } else if (!TextUtils.isEmpty(dataString) && dataString.contains("tbwebview")) {
                Uri data = intent.getData();
                if (f.n(data)) {
                    f.axN().d(data, new f.a() { // from class: com.baidu.tieba.tblauncher.SchemaRouteActivity.1
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void n(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(f.PARAM_URL) instanceof String)) {
                                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(SchemaRouteActivity.this.getActivity(), null, (String) hashMap.get(f.PARAM_URL), true);
                                tbWebViewActivityConfig.setIsFromSchema(true);
                                SchemaRouteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            }
                        }
                    });
                    return;
                }
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getActivity());
                tbWebViewActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
            } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbtopicdetail") || dataString.contains("unidispatch/topicdetail"))) {
                TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(getActivity());
                topicDetailActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, topicDetailActivityConfig));
            } else if (TextUtils.isEmpty(dataString)) {
            } else {
                if (dataString.contains("tbusercenter") || dataString.contains("unidispatch/usercenter") || dataString.contains("usercenter")) {
                    PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
                    personPolymericActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig));
                }
            }
        }
    }
}
