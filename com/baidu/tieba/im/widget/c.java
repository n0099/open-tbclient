package com.baidu.tieba.im.widget;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.db.l;
/* loaded from: classes.dex */
public class c {
    public static void azv() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, new CustomMessageListener(0) { // from class: com.baidu.tieba.im.widget.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
                    final boolean isNull = StringUtils.isNull(((AccountData) customResponsedMessage.getData()).getAccount());
                    if (!isNull) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yv().c(new e());
                        com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgChat(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgAtme(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgFans(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgGiftNum(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgLiveVip(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yv().yN();
                        t.GQ();
                        l.avk().auT();
                        k.avj().auT();
                    }
                    t.b(new s<Integer>() { // from class: com.baidu.tieba.im.widget.c.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.s
                        public Integer doInBackground() {
                            if (!isNull) {
                                com.baidu.tieba.im.db.b.auU().auV();
                            }
                            return 0;
                        }
                    }, new g<Integer>() { // from class: com.baidu.tieba.im.widget.c.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.g
                        /* renamed from: g */
                        public void onReturnDataInUI(Integer num) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_FOR_IM, null));
                        }
                    });
                }
            }
        });
    }
}
