package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.al;
import com.baidu.tieba.im.message.LoadHistoryMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    final /* synthetic */ PersonalMsglistModel drm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonalMsglistModel personalMsglistModel, int i) {
        super(i);
        this.drm = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean processHistory;
        al callback;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() == 2013002) {
                this.drm.processServerMsg(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001147) {
                this.drm.processDraft(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001150) {
                processHistory = this.drm.processHistory(customResponsedMessage);
                if ((customResponsedMessage.getOrginalMessage() instanceof LoadHistoryMessage) && processHistory && (callback = ((LoadHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                    callback.apZ();
                }
            }
        }
    }
}
