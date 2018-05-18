package com.baidu.tieba.myAttentionAndFans;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tieba.myAttentionAndFans.message.RequestLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseLocalPersonListMessage;
/* loaded from: classes3.dex */
public class e implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage != null && (customMessage instanceof RequestLocalPersonListMessage)) {
            RequestLocalPersonListMessage requestLocalPersonListMessage = (RequestLocalPersonListMessage) customMessage;
            boolean isFollow = requestLocalPersonListMessage.isFollow();
            String str = com.baidu.tbadk.core.c.a.ty().cZ("tb.my_pages").get((isFollow ? "personal_followme" : "personal_myfollow") + "_" + requestLocalPersonListMessage.getUid());
            ar arVar = new ar();
            if (str != null) {
                arVar.parserJson(str);
            }
            ResponseLocalPersonListMessage responseLocalPersonListMessage = new ResponseLocalPersonListMessage();
            responseLocalPersonListMessage.setData(arVar);
            return responseLocalPersonListMessage;
        }
        return null;
    }
}
