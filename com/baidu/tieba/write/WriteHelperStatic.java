package com.baidu.tieba.write;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes2.dex */
public class WriteHelperStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921048) { // from class: com.baidu.tieba.write.WriteHelperStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk)) {
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setClass(TbadkCoreApplication.getInst().getContext(), NewVcodeActivity.class);
                    bk bkVar = (bk) customResponsedMessage.getData();
                    intent.putExtra("model", bkVar.aQR);
                    intent.putExtra("is_ad", false);
                    if (bkVar.aQS != null) {
                        intent.putExtra("page_type", com.baidu.adp.lib.g.b.h(bkVar.aQS.FX(), 0));
                    }
                    TbadkCoreApplication.getInst().getContext().startActivity(intent);
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921049) { // from class: com.baidu.tieba.write.WriteHelperStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk)) {
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setClass(TbadkCoreApplication.getInst().getContext(), VcodeActivity.class);
                    intent.putExtra("model", ((bk) customResponsedMessage.getData()).aQR);
                    TbadkCoreApplication.getInst().getContext().startActivity(intent);
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921050) { // from class: com.baidu.tieba.write.WriteHelperStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk)) {
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setClass(TbadkCoreApplication.getInst().getContext(), AccountAccessActivity.class);
                    bk bkVar = (bk) customResponsedMessage.getData();
                    intent.putExtra(AccountAccessActivityConfig.KEY_WRITE_DATA, bkVar.aQR);
                    intent.putExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE, bkVar.aQT);
                    TbadkCoreApplication.getInst().getContext().startActivity(intent);
                }
            }
        });
        aBU();
    }

    public static void aBU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001449, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.write.WriteHelperStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.d.a> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2001449, new a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
