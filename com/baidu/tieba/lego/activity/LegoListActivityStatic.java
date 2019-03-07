package com.baidu.tieba.lego.activity;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.lego.a.a;
import com.baidu.tieba.lego.a.c;
import com.baidu.tieba.lego.a.e;
import com.baidu.tieba.lego.card.d;
import com.baidu.tieba.lego.d.b;
import com.baidu.tieba.lego.l;
/* loaded from: classes2.dex */
public class LegoListActivityStatic {
    static {
        b.gLp.set(new l());
        TbConfig.setLegoLibVersion(SdkConfigOptions.HOST_VERSION);
        TbConfig.setCriusLibVersion("1.0");
        com.baidu.tieba.lego.card.b.bzH().a(d.bzK());
        CustomMessageTask customMessageTask = new CustomMessageTask(2016447, new CustomMessageTask.CustomRunnable<LegoListActivityConfig>() { // from class: com.baidu.tieba.lego.activity.LegoListActivityStatic.1
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
        MessageManager.getInstance().registerStickyMode(2016470);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016470, true));
        com.baidu.tieba.lego.a.b.bzz().a(new e());
        a.bzx().a(new c());
        a.bzx().a(new com.baidu.tieba.lego.a.d());
        com.baidu.tbadk.b.c.bsE.set(com.baidu.tieba.lego.a.b.bzz());
        com.baidu.tbadk.b.b.bsB.set(a.bzx());
        bg.bBn.set(true);
    }
}
