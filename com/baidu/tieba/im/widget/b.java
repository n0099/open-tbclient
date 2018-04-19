package com.baidu.tieba.im.widget;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.m;
/* loaded from: classes.dex */
public class b {
    public static void aHq() {
        MessageManager.getInstance().registerListener(2005016, new CustomMessageListener(0) { // from class: com.baidu.tieba.im.widget.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
                    final boolean isNull = StringUtils.isNull(((AccountData) customResponsedMessage.getData()).getAccount());
                    if (!isNull) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.zx().c(new e());
                        com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgChat(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgAtme(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.zx().dS(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgFans(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgGiftNum(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.zx().zP();
                        v.HR();
                        m.aDq().aCV();
                        l.aDo().aCV();
                    }
                    v.b(new u<Integer>() { // from class: com.baidu.tieba.im.widget.b.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.u
                        public Integer doInBackground() {
                            if (!isNull) {
                                com.baidu.tieba.im.db.b.aCW().aCX();
                            }
                            return 0;
                        }
                    }, new h<Integer>() { // from class: com.baidu.tieba.im.widget.b.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        /* renamed from: h */
                        public void onReturnDataInUI(Integer num) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005018, null));
                        }
                    });
                }
            }
        });
    }
}
