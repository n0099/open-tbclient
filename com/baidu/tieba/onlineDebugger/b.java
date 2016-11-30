package com.baidu.tieba.onlineDebugger;

import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import com.baidu.tieba.onlineDebugger.OnlineDebuggerStatic;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class b extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 202006 && (socketResponsedMessage instanceof PushNotifyMessage)) {
            PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
            if (pushNotifyMessage.getType() == 6) {
                try {
                    JSONObject jSONObject = new JSONObject(pushNotifyMessage.getContent());
                    String optString = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                    String optString2 = jSONObject.optString("fromCuid");
                    String optString3 = jSONObject.optString("toCuid");
                    com.baidu.tieba.onlineDebugger.d.a aVar = new com.baidu.tieba.onlineDebugger.d.a();
                    aVar.oU(optString2);
                    aVar.setToUid(optString3);
                    aVar.setMsgContent(optString);
                    new OnlineDebuggerStatic.a().execute(aVar);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
        }
    }
}
