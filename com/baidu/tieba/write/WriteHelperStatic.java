package com.baidu.tieba.write;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.UegWebViewActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.tieba.write.ueg.UegWebViewActivity;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes2.dex */
public class WriteHelperStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_START_NEW_VCODE_ACTIVITY) { // from class: com.baidu.tieba.write.WriteHelperStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl)) {
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setClass(TbadkCoreApplication.getInst().getContext(), NewVcodeActivity.class);
                    bl blVar = (bl) customResponsedMessage.getData();
                    intent.putExtra("model", blVar.aPs);
                    intent.putExtra("is_ad", false);
                    if (blVar.aPt != null) {
                        intent.putExtra("page_type", com.baidu.adp.lib.g.b.h(blVar.aPt.FI(), 0));
                    }
                    TbadkCoreApplication.getInst().getContext().startActivity(intent);
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_START_OLD_VCODE_ACTIVITY) { // from class: com.baidu.tieba.write.WriteHelperStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl)) {
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setClass(TbadkCoreApplication.getInst().getContext(), VcodeActivity.class);
                    intent.putExtra("model", ((bl) customResponsedMessage.getData()).aPs);
                    TbadkCoreApplication.getInst().getContext().startActivity(intent);
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_START_ACCOUNT_ACCESS_ACTIVITY) { // from class: com.baidu.tieba.write.WriteHelperStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl)) {
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setClass(TbadkCoreApplication.getInst().getContext(), AccountAccessActivity.class);
                    bl blVar = (bl) customResponsedMessage.getData();
                    intent.putExtra(AccountAccessActivityConfig.KEY_WRITE_DATA, blVar.aPs);
                    intent.putExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE, blVar.aPu);
                    TbadkCoreApplication.getInst().getContext().startActivity(intent);
                }
            }
        });
        aAt();
        TbadkCoreApplication.getInst().RegisterIntent(UegWebViewActivityConfig.class, UegWebViewActivity.class);
    }

    public static void aAt() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.write.WriteHelperStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.d.a> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER, customMessage.getData() != null ? new a(customMessage.getData(), null) : null);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
