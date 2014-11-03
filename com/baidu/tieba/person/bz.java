package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class bz implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof PersonBarByUidLocalMessage)) {
            return null;
        }
        String str = com.baidu.tbadk.core.a.a.kS().bd("tb.my_pages").get(TbadkApplication.getCurrentAccount());
        ResponsePersonBarByUidLocalMessage responsePersonBarByUidLocalMessage = new ResponsePersonBarByUidLocalMessage();
        if (str != null) {
            try {
                responsePersonBarByUidLocalMessage.decodeInBackGround(2001187, str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return responsePersonBarByUidLocalMessage;
    }
}
