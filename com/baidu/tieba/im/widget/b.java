package com.baidu.tieba.im.widget;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.m;
/* loaded from: classes.dex */
public class b {
    public static void bEe() {
        MessageManager.getInstance().registerListener(2005016, new CustomMessageListener(0) { // from class: com.baidu.tieba.im.widget.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
                    final boolean isNull = StringUtils.isNull(((AccountData) customResponsedMessage.getData()).getAccount());
                    if (!isNull) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().c(new e());
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgChat(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgAtme(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().jp(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgFans(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgGiftNum(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().amQ();
                        aa.avr();
                        m.bAl().bzQ();
                        l.bAj().bzQ();
                    }
                    aa.b(new z<Integer>() { // from class: com.baidu.tieba.im.widget.b.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.z
                        public Integer doInBackground() {
                            if (!isNull) {
                                com.baidu.tieba.im.db.b.bzR().bzS();
                            }
                            return 0;
                        }
                    }, new k<Integer>() { // from class: com.baidu.tieba.im.widget.b.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.k
                        /* renamed from: i */
                        public void onReturnDataInUI(Integer num) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005018, null));
                        }
                    });
                }
            }
        });
    }
}
