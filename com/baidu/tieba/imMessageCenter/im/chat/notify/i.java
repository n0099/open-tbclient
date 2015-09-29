package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData bKb;
    final /* synthetic */ h bKc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bKc = hVar;
        this.bKb = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.bKb != null) {
            this.bKb.setUnReadCount(0);
            if (this.bKb.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.TG().hK("apply_join_group");
            } else if (this.bKb.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.TG().hK("group_intro_change");
                com.baidu.tieba.im.db.d.TG().hK("group_name_change");
                com.baidu.tieba.im.db.d.TG().hK("group_notice_change");
                com.baidu.tieba.im.db.d.TG().hK("group_level_up");
                com.baidu.tieba.im.db.d.TG().hK("dismiss_group");
                com.baidu.tieba.im.db.d.TG().hK("kick_out");
                com.baidu.tieba.im.db.d.TG().hK("group_activitys_change");
            } else if (this.bKb.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.TG().hK("live_notify");
            }
        }
        return null;
    }
}
