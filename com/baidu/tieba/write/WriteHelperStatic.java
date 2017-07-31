package com.baidu.tieba.write;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
public class WriteHelperStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_START_NEW_VCODE_ACTIVITY) { // from class: com.baidu.tieba.write.WriteHelperStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof br)) {
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setClass(TbadkCoreApplication.getInst().getContext(), NewVcodeActivity.class);
                    br brVar = (br) customResponsedMessage.getData();
                    intent.putExtra("model", brVar.abm);
                    intent.putExtra("is_ad", false);
                    if (brVar.abn != null) {
                        intent.putExtra("page_type", com.baidu.adp.lib.g.b.g(brVar.abn.yx(), 0));
                    }
                    TbadkCoreApplication.getInst().getContext().startActivity(intent);
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_START_OLD_VCODE_ACTIVITY) { // from class: com.baidu.tieba.write.WriteHelperStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof br)) {
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setClass(TbadkCoreApplication.getInst().getContext(), VcodeActivity.class);
                    intent.putExtra("model", ((br) customResponsedMessage.getData()).abm);
                    TbadkCoreApplication.getInst().getContext().startActivity(intent);
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_START_ACCOUNT_ACCESS_ACTIVITY) { // from class: com.baidu.tieba.write.WriteHelperStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof br)) {
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setClass(TbadkCoreApplication.getInst().getContext(), AccountAccessActivity.class);
                    br brVar = (br) customResponsedMessage.getData();
                    intent.putExtra(AccountAccessActivityConfig.KEY_WRITE_DATA, brVar.abm);
                    intent.putExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE, brVar.abo);
                    TbadkCoreApplication.getInst().getContext().startActivity(intent);
                }
            }
        });
    }
}
