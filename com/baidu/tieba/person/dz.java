package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class dz implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof PersonFriendByUidLocalMessage)) {
            return null;
        }
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        String a = com.baidu.tbadk.core.a.a.a().b("tb.my_pages").a("personal_myfollow_" + str);
        ResponsePersonFriendByUidLocalMessage responsePersonFriendByUidLocalMessage = new ResponsePersonFriendByUidLocalMessage();
        if (a != null) {
            try {
                responsePersonFriendByUidLocalMessage.decodeInBackGround(2001186, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responsePersonFriendByUidLocalMessage;
    }
}
