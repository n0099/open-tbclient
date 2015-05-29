package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class f implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ e bsx;
    private final /* synthetic */ ImMessageCenterShowItemData bsy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bsx = eVar;
        this.bsy = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.bsy != null) {
            this.bsy.setUnReadCount(0);
            if (this.bsy.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.Rn().gY("apply_join_group");
            } else if (this.bsy.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.Rn().gY("group_intro_change");
                com.baidu.tieba.im.db.d.Rn().gY("group_name_change");
                com.baidu.tieba.im.db.d.Rn().gY("group_notice_change");
                com.baidu.tieba.im.db.d.Rn().gY("group_level_up");
                com.baidu.tieba.im.db.d.Rn().gY("dismiss_group");
                com.baidu.tieba.im.db.d.Rn().gY("kick_out");
                com.baidu.tieba.im.db.d.Rn().gY("group_activitys_change");
            } else if (this.bsy.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.Rn().gY("live_notify");
            }
        }
        return null;
    }
}
