package com.baidu.tieba.pbextra;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tieba.pbextra.a.a;
import com.baidu.tieba.pbextra.emotion.EmotionEditActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.d;
/* loaded from: classes4.dex */
public class PbExtraStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(EmotionEditActivityConfig.class, EmotionEditActivity.class);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pbextra.PbExtraStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof d)) {
                    ((d) customResponsedMessage.getData()).cdT().add(new a(null, PostData.iGe));
                }
            }
        });
        PostData.iGi = true;
    }
}
