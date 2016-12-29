package com.baidu.tieba.onlineDebugger;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.onlineDebugger.OnlineDebuggerStatic;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        BdLog.i("CMD_OFFLINE_DEBUG:onMessage");
        if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
            String cmd = p.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                BdLog.i("CMD_OFFLINE_DEBUG:pushCmd = " + cmd);
                if (cmd.equals("offline_debug")) {
                    String content = p.getContent();
                    if (!TextUtils.isEmpty(content)) {
                        BdLog.i("CMD_OFFLINE_DEBUG:content = " + content);
                        try {
                            JSONObject jSONObject = new JSONObject(new JSONObject(content).optString("userMsg"));
                            String optString = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                            String optString2 = jSONObject.optString("fromCuid");
                            String optString3 = jSONObject.optString("toCuid");
                            String uniqueIdentifier = TbadkCoreApplication.getUniqueIdentifier();
                            if (!optString3.equals(uniqueIdentifier)) {
                                BdLog.e("cuid error! expect:" + uniqueIdentifier + "; not:" + optString3);
                            } else {
                                com.baidu.tieba.onlineDebugger.d.a aVar = new com.baidu.tieba.onlineDebugger.d.a();
                                aVar.nv(optString2);
                                aVar.setToUid(optString3);
                                aVar.setMsgContent(optString);
                                new OnlineDebuggerStatic.a().execute(aVar);
                            }
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                    }
                }
            }
        }
    }
}
