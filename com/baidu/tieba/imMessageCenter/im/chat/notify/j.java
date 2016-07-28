package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class j implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData dcb;
    final /* synthetic */ i dcc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dcc = iVar;
        this.dcb = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.dcb != null) {
            this.dcb.setUnReadCount(0);
            if (this.dcb.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.anr().kG("apply_join_group");
            } else if (this.dcb.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.anr().kG("group_intro_change");
                com.baidu.tieba.im.db.d.anr().kG("group_name_change");
                com.baidu.tieba.im.db.d.anr().kG("group_notice_change");
                com.baidu.tieba.im.db.d.anr().kG("group_level_up");
                com.baidu.tieba.im.db.d.anr().kG("dismiss_group");
                com.baidu.tieba.im.db.d.anr().kG("kick_out");
                com.baidu.tieba.im.db.d.anr().kG("group_activitys_change");
            } else if (this.dcb.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.anr().kG("live_notify");
            }
        }
        return null;
    }
}
