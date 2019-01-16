package com.baidu.tieba.pushdialog;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.e;
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
        avC();
    }

    private static void avC() {
        com.baidu.tieba.tbadkCore.a.a.a(309614, PushDialogSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, com.baidu.tieba.tbadkCore.a.a.aV(TbConfig.GET_PUSH_DIALOG_DETAIL, 309614));
        tbHttpMessageTask.setResponsedClass(PushDialogHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.a(309618, PullTidSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, com.baidu.tieba.tbadkCore.a.a.aV(TbConfig.GET_PUSH_DIALOG_TID, 309618));
        tbHttpMessageTask2.setResponsedClass(PullTidHttpRespMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921359, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.pushdialog.PushDialogStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                PushDialogLoopManager.buL();
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921360, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.pushdialog.PushDialogStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                a.b bVar;
                int i = 0;
                if (customMessage != null && (customMessage.getData() instanceof TbPageContextSupport)) {
                    int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("lock_permission_guide_set", 0);
                    if (!(i2 >= 2) && TbSingleton.getInstance().canShowPermDialog()) {
                        final TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) customMessage.getData();
                        if (tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                            if (b.buR()) {
                                bVar = new a.b() { // from class: com.baidu.tieba.pushdialog.PushDialogStatic.2.1
                                    @Override // com.baidu.tbadk.core.dialog.a.b
                                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                        aVar.dismiss();
                                        Intent intent = new Intent();
                                        intent.setAction("miui.intent.action.APP_PERM_EDITOR_PRIVATE");
                                        intent.putExtra("extra_pkgname", tbPageContextSupport.getPageContext().getPageActivity().getPackageName());
                                        intent.setFlags(268435456);
                                        try {
                                            tbPageContextSupport.getPageContext().getPageActivity().startActivity(intent);
                                        } catch (Exception e) {
                                        }
                                    }
                                };
                                i = e.j.push_dialog_guide_content_miui;
                            } else if (b.buS()) {
                                bVar = new a.b() { // from class: com.baidu.tieba.pushdialog.PushDialogStatic.2.2
                                    @Override // com.baidu.tbadk.core.dialog.a.b
                                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                        aVar.dismiss();
                                        Intent intent = new Intent();
                                        intent.setAction("com.iqoo.secure.PERMISSION_MANAGER");
                                        intent.setFlags(268435456);
                                        try {
                                            tbPageContextSupport.getPageContext().getPageActivity().startActivity(intent);
                                        } catch (Exception e) {
                                        }
                                    }
                                };
                                i = e.j.push_dialog_guide_content_vivo;
                            } else {
                                bVar = null;
                            }
                            if (bVar != null) {
                                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContextSupport.getPageContext().getPageActivity());
                                aVar.da(e.j.push_dialog_guide_title);
                                aVar.db(i);
                                aVar.a(e.j.go_setting, bVar);
                                aVar.b(e.j.has_set, new a.b() { // from class: com.baidu.tieba.pushdialog.PushDialogStatic.2.3
                                    @Override // com.baidu.tbadk.core.dialog.a.b
                                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                        aVar2.dismiss();
                                    }
                                });
                                aVar.b(tbPageContextSupport.getPageContext());
                                aVar.BS();
                                TbSingleton.getInstance().setHasShowPermDlg(true);
                            }
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("lock_permission_guide_set", i2 + 1);
                        }
                    }
                }
                return null;
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
