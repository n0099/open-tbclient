package com.baidu.tieba.im.widget;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.m;
/* loaded from: classes.dex */
public class b {
    public static void aUE() {
        MessageManager.getInstance().registerListener(2005016, new CustomMessageListener(0) { // from class: com.baidu.tieba.im.widget.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
                    final boolean isNull = StringUtils.isNull(((AccountData) customResponsedMessage.getData()).getAccount());
                    if (!isNull) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.HP().c(new e());
                        com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgChat(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgAtme(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.HP().eV(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgFans(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgGiftNum(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.HP().Ih();
                        x.Qh();
                        m.aQH().aQm();
                        l.aQF().aQm();
                    }
                    x.b(new w<Integer>() { // from class: com.baidu.tieba.im.widget.b.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.w
                        public Integer doInBackground() {
                            if (!isNull) {
                                com.baidu.tieba.im.db.b.aQn().aQo();
                            }
                            return 0;
                        }
                    }, new h<Integer>() { // from class: com.baidu.tieba.im.widget.b.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        /* renamed from: n */
                        public void onReturnDataInUI(Integer num) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005018, null));
                        }
                    });
                }
            }
        });
    }
}
