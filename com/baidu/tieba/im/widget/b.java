package com.baidu.tieba.im.widget;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.m;
/* loaded from: classes.dex */
public class b {
    public static void cpL() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, new CustomMessageListener(0) { // from class: com.baidu.tieba.im.widget.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
                    final boolean isNull = StringUtils.isNull(((AccountData) customResponsedMessage.getData()).getAccount());
                    if (!isNull) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZl().c(new e());
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgChat(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgAtme(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZl().mE(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgFans(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgGiftNum(0);
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZD();
                        ad.clearQueue();
                        m.clU().cly();
                        l.clS().cly();
                    }
                    ad.b(new ac<Integer>() { // from class: com.baidu.tieba.im.widget.b.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ac
                        public Integer doInBackground() {
                            if (!isNull) {
                                com.baidu.tieba.im.db.b.clz().clA();
                            }
                            return 0;
                        }
                    }, new com.baidu.tbadk.util.l<Integer>() { // from class: com.baidu.tieba.im.widget.b.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.l
                        /* renamed from: m */
                        public void onReturnDataInUI(Integer num) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_FOR_IM, null));
                        }
                    });
                }
            }
        });
    }
}
