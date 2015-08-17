package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData bGp;
    final /* synthetic */ h bGq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bGq = hVar;
        this.bGp = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.bGp != null) {
            this.bGp.setUnReadCount(0);
            if (this.bGp.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.SW().hx("apply_join_group");
            } else if (this.bGp.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.SW().hx("group_intro_change");
                com.baidu.tieba.im.db.d.SW().hx("group_name_change");
                com.baidu.tieba.im.db.d.SW().hx("group_notice_change");
                com.baidu.tieba.im.db.d.SW().hx("group_level_up");
                com.baidu.tieba.im.db.d.SW().hx("dismiss_group");
                com.baidu.tieba.im.db.d.SW().hx("kick_out");
                com.baidu.tieba.im.db.d.SW().hx("group_activitys_change");
            } else if (this.bGp.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.SW().hx("live_notify");
            }
        }
        return null;
    }
}
