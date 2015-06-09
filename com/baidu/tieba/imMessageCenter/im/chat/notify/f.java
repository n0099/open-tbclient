package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class f implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ e bsy;
    private final /* synthetic */ ImMessageCenterShowItemData bsz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bsy = eVar;
        this.bsz = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.bsz != null) {
            this.bsz.setUnReadCount(0);
            if (this.bsz.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.Ro().gY("apply_join_group");
            } else if (this.bsz.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.Ro().gY("group_intro_change");
                com.baidu.tieba.im.db.d.Ro().gY("group_name_change");
                com.baidu.tieba.im.db.d.Ro().gY("group_notice_change");
                com.baidu.tieba.im.db.d.Ro().gY("group_level_up");
                com.baidu.tieba.im.db.d.Ro().gY("dismiss_group");
                com.baidu.tieba.im.db.d.Ro().gY("kick_out");
                com.baidu.tieba.im.db.d.Ro().gY("group_activitys_change");
            } else if (this.bsz.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.Ro().gY("live_notify");
            }
        }
        return null;
    }
}
