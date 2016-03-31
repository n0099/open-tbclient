package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class by implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage != null && (customMessage instanceof RequestLocalPersonListMessage)) {
            RequestLocalPersonListMessage requestLocalPersonListMessage = (RequestLocalPersonListMessage) customMessage;
            boolean isFollow = requestLocalPersonListMessage.isFollow();
            String str = com.baidu.tbadk.core.b.a.um().cz("tb.my_pages").get(String.valueOf(isFollow ? "personal_followme" : "personal_myfollow") + "_" + requestLocalPersonListMessage.getUid());
            com.baidu.tieba.person.data.r rVar = new com.baidu.tieba.person.data.r();
            if (str != null) {
                rVar.parserJson(str);
            }
            ResponseLocalPersonListMessage responseLocalPersonListMessage = new ResponseLocalPersonListMessage();
            responseLocalPersonListMessage.setData(rVar);
            return responseLocalPersonListMessage;
        }
        return null;
    }
}
