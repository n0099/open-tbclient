package com.baidu.tieba.lego.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.b.g;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c implements g {
    @Override // com.baidu.tbadk.b.g
    public void a(HashMap<String, String> hashMap, h hVar) {
        if (hVar != null && hashMap != null && !hashMap.isEmpty()) {
            UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
            aVar.Jy = hVar.result;
            aVar.errorString = hVar.errorString;
            aVar.isAttention = true;
            aVar.toUid = hashMap.get("touid") == null ? "" : hashMap.get("touid");
            MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
        }
    }

    @Override // com.baidu.tbadk.b.g
    public String key() {
        return TbConfig.FOLLOW_ADDRESS;
    }
}
