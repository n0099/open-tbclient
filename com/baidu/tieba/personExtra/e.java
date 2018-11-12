package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class e implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof PersonBarByUidLocalMessage)) {
            return null;
        }
        String str = com.baidu.tbadk.core.c.a.Ax().eg("tb.my_pages").get(TbadkCoreApplication.getCurrentAccount());
        ResponsePersonBarByUidLocalMessage responsePersonBarByUidLocalMessage = new ResponsePersonBarByUidLocalMessage();
        if (str != null) {
            try {
                responsePersonBarByUidLocalMessage.decodeInBackGround(2001183, str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return responsePersonBarByUidLocalMessage;
    }
}
