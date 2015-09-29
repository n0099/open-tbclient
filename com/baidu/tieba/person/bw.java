package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class bw implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage != null && (customMessage instanceof RequestLocalPersonListMessage)) {
            RequestLocalPersonListMessage requestLocalPersonListMessage = (RequestLocalPersonListMessage) customMessage;
            boolean isFollow = requestLocalPersonListMessage.isFollow();
            String str = com.baidu.tbadk.core.b.a.sO().cq("tb.my_pages").get(String.valueOf(isFollow ? "personal_followme" : "personal_myfollow") + "_" + requestLocalPersonListMessage.getUid());
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            if (str != null) {
                aVar.parserJson(str);
            }
            ResponseLocalPersonListMessage responseLocalPersonListMessage = new ResponseLocalPersonListMessage();
            responseLocalPersonListMessage.setData(aVar);
            return responseLocalPersonListMessage;
        }
        return null;
    }
}
