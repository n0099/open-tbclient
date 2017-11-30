package com.baidu.tieba.im.widget;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.db.l;
/* loaded from: classes.dex */
public class c {
    public static void aDu() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, new CustomMessageListener(0) { // from class: com.baidu.tieba.im.widget.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
                    final boolean isNull = StringUtils.isNull(((AccountData) customResponsedMessage.getData()).getAccount());
                    if (!isNull) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yM().c(new e());
                        com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgChat(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgAtme(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgFans(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgGiftNum(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgLiveVip(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yM().ze();
                        v.Hu();
                        l.azx().azf();
                        k.azw().azf();
                    }
                    v.b(new u<Integer>() { // from class: com.baidu.tieba.im.widget.c.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.u
                        public Integer doInBackground() {
                            if (!isNull) {
                                com.baidu.tieba.im.db.b.azg().azh();
                            }
                            return 0;
                        }
                    }, new h<Integer>() { // from class: com.baidu.tieba.im.widget.c.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
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
