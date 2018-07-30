package com.baidu.tieba.pushdialog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pushdialog.data.PullTidHttpRespMessage;
import com.baidu.tieba.pushdialog.data.PullTidSocketResponseMessage;
import com.baidu.tieba.pushdialog.data.PushDialogHttpResMsg;
import com.baidu.tieba.pushdialog.data.PushDialogSocketResMsg;
import com.squareup.wire.Wire;
/* loaded from: classes3.dex */
public class PushDialogStatic {
    public static Wire WIRE = new Wire(new Class[0]);

    static {
        TbadkApplication.getInst().RegisterIntent(PushDialogActivityConfig.class, PushDialogActivity.class);
        anR();
    }

    private static void anR() {
        com.baidu.tieba.tbadkCore.a.a.a(309614, PushDialogSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, com.baidu.tieba.tbadkCore.a.a.aK(TbConfig.GET_PUSH_DIALOG_DETAIL, 309614));
        tbHttpMessageTask.setResponsedClass(PushDialogHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.a(309618, PullTidSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, com.baidu.tieba.tbadkCore.a.a.aK(TbConfig.GET_PUSH_DIALOG_TID, 309618));
        tbHttpMessageTask2.setResponsedClass(PullTidHttpRespMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921359, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.pushdialog.PushDialogStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                a.bmk();
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
