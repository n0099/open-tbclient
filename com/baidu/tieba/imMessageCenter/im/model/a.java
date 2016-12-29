package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.al;
import com.baidu.tieba.im.message.LoadHistoryMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    final /* synthetic */ PersonalMsglistModel dbm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonalMsglistModel personalMsglistModel, int i) {
        super(i);
        this.dbm = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean processHistory;
        al callback;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() == 2012121) {
                this.dbm.processServerMsg(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001143) {
                this.dbm.processDraft(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001146) {
                processHistory = this.dbm.processHistory(customResponsedMessage);
                if ((customResponsedMessage.getOrginalMessage() instanceof LoadHistoryMessage) && processHistory && (callback = ((LoadHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                    callback.amW();
                }
            }
        }
    }
}
