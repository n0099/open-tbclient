package com.baidu.tieba.tbadkCore.l;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ a daG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.daG = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && !TextUtils.isEmpty(p.getCmd())) {
            String content = p.getContent();
            if (!TextUtils.isEmpty(content)) {
                try {
                    JSONObject jSONObject = new JSONObject(content);
                    BdUploadStatMsgData bdUploadStatMsgData = new BdUploadStatMsgData();
                    bdUploadStatMsgData.parentType = jSONObject.optString("type");
                    bdUploadStatMsgData.childType = jSONObject.optString("sub_type");
                    bdUploadStatMsgData.isWifi = jSONObject.optInt("is_wifi") == 1;
                    if (jSONObject.optLong("continue_time") > 0) {
                        bdUploadStatMsgData.deadLineTime = System.currentTimeMillis() + (jSONObject.optLong("continue_time") * 1000);
                    }
                    com.baidu.adp.lib.stats.a.hi().a(bdUploadStatMsgData.parentType, bdUploadStatMsgData.childType, bdUploadStatMsgData);
                } catch (Exception e) {
                }
            }
        }
    }
}
