package com.baidu.tieba.im.widget;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.m;
/* loaded from: classes.dex */
public class b {
    public static void cMk() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, new CustomMessageListener(0) { // from class: com.baidu.tieba.im.widget.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
                    final boolean isNull = StringUtils.isNull(((AccountData) customResponsedMessage.getData()).getAccount());
                    if (!isNull) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.boP().c(new f());
                        com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgChat(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgAtme(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.boP().pP(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgFans(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgGiftNum(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.boP().bph();
                        ae.clearQueue();
                        m.cHX().cHA();
                        l.cHU().cHA();
                    }
                    ae.b(new ad<Integer>() { // from class: com.baidu.tieba.im.widget.b.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ad
                        public Integer doInBackground() {
                            if (!isNull) {
                                com.baidu.tieba.im.db.b.cHB().cHC();
                            }
                            return 0;
                        }
                    }, new com.baidu.tbadk.util.m<Integer>() { // from class: com.baidu.tieba.im.widget.b.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.m
                        /* renamed from: n */
                        public void onReturnDataInUI(Integer num) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_FOR_IM, null));
                        }
                    });
                }
            }
        });
    }
}
