package com.baidu.tieba.im.widget;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.m;
/* loaded from: classes.dex */
public class b {
    public static void das() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, new CustomMessageListener(0) { // from class: com.baidu.tieba.im.widget.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
                    final boolean isNull = StringUtils.isNull(((AccountData) customResponsedMessage.getData()).getAccount());
                    if (!isNull) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.byI().c(new f());
                        com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgChat(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgAtme(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.byI().rH(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgFans(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgGiftNum(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.byI().bza();
                        ad.clearQueue();
                        m.cWi().cVL();
                        l.cWf().cVL();
                    }
                    ad.b(new ac<Integer>() { // from class: com.baidu.tieba.im.widget.b.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ac
                        public Integer doInBackground() {
                            if (!isNull) {
                                com.baidu.tieba.im.db.b.cVM().cVN();
                            }
                            return 0;
                        }
                    }, new com.baidu.tbadk.util.m<Integer>() { // from class: com.baidu.tieba.im.widget.b.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.m
                        /* renamed from: p */
                        public void onReturnDataInUI(Integer num) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_FOR_IM, null));
                        }
                    });
                }
            }
        });
    }
}
