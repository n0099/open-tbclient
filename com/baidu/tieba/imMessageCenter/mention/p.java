package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData csR;
    final /* synthetic */ o cxv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cxv = oVar;
        this.csR = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.csR != null) {
            this.csR.setUnReadCount(0);
            if (this.csR.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.aeq().je("apply_join_group");
            } else if (this.csR.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.aeq().je("group_intro_change");
                com.baidu.tieba.im.db.d.aeq().je("group_name_change");
                com.baidu.tieba.im.db.d.aeq().je("group_notice_change");
                com.baidu.tieba.im.db.d.aeq().je("group_level_up");
                com.baidu.tieba.im.db.d.aeq().je("dismiss_group");
                com.baidu.tieba.im.db.d.aeq().je("kick_out");
                com.baidu.tieba.im.db.d.aeq().je("group_activitys_change");
            } else if (this.csR.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.aeq().je("live_notify");
            }
        }
        return null;
    }
}
