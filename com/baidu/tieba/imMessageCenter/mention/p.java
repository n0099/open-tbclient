package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData ctP;
    final /* synthetic */ o cyt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cyt = oVar;
        this.ctP = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.ctP != null) {
            this.ctP.setUnReadCount(0);
            if (this.ctP.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.aeq().jg("apply_join_group");
            } else if (this.ctP.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.aeq().jg("group_intro_change");
                com.baidu.tieba.im.db.d.aeq().jg("group_name_change");
                com.baidu.tieba.im.db.d.aeq().jg("group_notice_change");
                com.baidu.tieba.im.db.d.aeq().jg("group_level_up");
                com.baidu.tieba.im.db.d.aeq().jg("dismiss_group");
                com.baidu.tieba.im.db.d.aeq().jg("kick_out");
                com.baidu.tieba.im.db.d.aeq().jg("group_activitys_change");
            } else if (this.ctP.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.aeq().jg("live_notify");
            }
        }
        return null;
    }
}
