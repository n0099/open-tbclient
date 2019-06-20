package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class g implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof PersonFriendByUidLocalMessage)) {
            return null;
        }
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        String str2 = com.baidu.tbadk.core.c.a.afD().mA("tb.my_pages").get("personal_myfollow_" + str);
        ResponsePersonFriendByUidLocalMessage responsePersonFriendByUidLocalMessage = new ResponsePersonFriendByUidLocalMessage();
        if (str2 != null) {
            try {
                responsePersonFriendByUidLocalMessage.decodeInBackGround(2001182, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responsePersonFriendByUidLocalMessage;
    }
}
