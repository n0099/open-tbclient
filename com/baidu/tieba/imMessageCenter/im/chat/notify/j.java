package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes2.dex */
class j implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData drA;
    final /* synthetic */ i drB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.drB = iVar;
        this.drA = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.drA != null) {
            this.drA.setUnReadCount(0);
            if (this.drA.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.asa().lA("apply_join_group");
            } else if (this.drA.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.asa().lA("group_intro_change");
                com.baidu.tieba.im.db.d.asa().lA("group_name_change");
                com.baidu.tieba.im.db.d.asa().lA("group_notice_change");
                com.baidu.tieba.im.db.d.asa().lA("group_level_up");
                com.baidu.tieba.im.db.d.asa().lA("dismiss_group");
                com.baidu.tieba.im.db.d.asa().lA("kick_out");
                com.baidu.tieba.im.db.d.asa().lA("group_activitys_change");
            } else if (this.drA.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.asa().lA("live_notify");
            }
        }
        return null;
    }
}
