package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData bKH;
    final /* synthetic */ h bKI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bKI = hVar;
        this.bKH = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.bKH != null) {
            this.bKH.setUnReadCount(0);
            if (this.bKH.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.TX().hM("apply_join_group");
            } else if (this.bKH.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.TX().hM("group_intro_change");
                com.baidu.tieba.im.db.d.TX().hM("group_name_change");
                com.baidu.tieba.im.db.d.TX().hM("group_notice_change");
                com.baidu.tieba.im.db.d.TX().hM("group_level_up");
                com.baidu.tieba.im.db.d.TX().hM("dismiss_group");
                com.baidu.tieba.im.db.d.TX().hM("kick_out");
                com.baidu.tieba.im.db.d.TX().hM("group_activitys_change");
            } else if (this.bKH.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.TX().hM("live_notify");
            }
        }
        return null;
    }
}
