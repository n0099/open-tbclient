package com.baidu.tieba.lego.activity;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.lego.a.a;
import com.baidu.tieba.lego.a.c;
import com.baidu.tieba.lego.a.e;
import com.baidu.tieba.lego.card.d;
import com.baidu.tieba.lego.d.b;
import com.baidu.tieba.lego.l;
/* loaded from: classes9.dex */
public class LegoListActivityStatic {
    static {
        b.lcA.set(new l());
        TbConfig.setLegoLibVersion(SdkConfigOptions.HOST_VERSION);
        com.baidu.tieba.lego.card.b.ddm().a(d.ddp());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_LEGO_LIST, new CustomMessageTask.CustomRunnable<LegoListActivityConfig>() { // from class: com.baidu.tieba.lego.activity.LegoListActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<LegoListActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(LegoListActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_LEGO_REGISTER);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_REGISTER, true));
        com.baidu.tieba.lego.a.b.dde().a(new e());
        a.ddc().a(new c());
        a.ddc().a(new com.baidu.tieba.lego.a.d());
        com.baidu.tbadk.b.c.eJa.set(com.baidu.tieba.lego.a.b.dde());
        com.baidu.tbadk.b.b.eIX.set(a.ddc());
        bz.eTA.set(true);
    }
}
