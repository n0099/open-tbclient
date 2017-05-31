package com.baidu.tieba.im.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
            boolean isNull = StringUtils.isNull(((AccountData) customResponsedMessage.getData()).getAccount());
            if (!isNull) {
                com.baidu.tbadk.coreExtra.messageCenter.a.yn().c(new com.baidu.tbadk.coreExtra.c.e());
                com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgChat(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgAtme(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgFans(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgGiftNum(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgLiveVip(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.yn().yF();
                w.Gz();
                m.aoD().aol();
                l.aoC().aol();
            }
            w.b(new e(this, isNull), new f(this));
        }
    }
}
