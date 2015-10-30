package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class bx implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof PersonBarByUidLocalMessage)) {
            return null;
        }
        String str = com.baidu.tbadk.core.b.a.sL().cr("tb.my_pages").get(TbadkCoreApplication.getCurrentAccount());
        ResponsePersonBarByUidLocalMessage responsePersonBarByUidLocalMessage = new ResponsePersonBarByUidLocalMessage();
        if (str != null) {
            try {
                responsePersonBarByUidLocalMessage.decodeInBackGround(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return responsePersonBarByUidLocalMessage;
    }
}
