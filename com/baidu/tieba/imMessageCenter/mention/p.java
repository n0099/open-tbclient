package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData cZe;
    final /* synthetic */ o ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.ddQ = oVar;
        this.cZe = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.cZe != null) {
            this.cZe.setUnReadCount(0);
            if (this.cZe.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.amH().kz("apply_join_group");
            } else if (this.cZe.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.amH().kz("group_intro_change");
                com.baidu.tieba.im.db.d.amH().kz("group_name_change");
                com.baidu.tieba.im.db.d.amH().kz("group_notice_change");
                com.baidu.tieba.im.db.d.amH().kz("group_level_up");
                com.baidu.tieba.im.db.d.amH().kz("dismiss_group");
                com.baidu.tieba.im.db.d.amH().kz("kick_out");
                com.baidu.tieba.im.db.d.amH().kz("group_activitys_change");
            } else if (this.cZe.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.amH().kz("live_notify");
            }
        }
        return null;
    }
}
