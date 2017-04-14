package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class v implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData dhQ;
    final /* synthetic */ u dkE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dkE = uVar;
        this.dhQ = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.dhQ != null) {
            this.dhQ.setUnReadCount(0);
            if (this.dhQ.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.apv().kn("apply_join_group");
            } else if (this.dhQ.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.apv().kn("group_intro_change");
                com.baidu.tieba.im.db.d.apv().kn("group_name_change");
                com.baidu.tieba.im.db.d.apv().kn("group_notice_change");
                com.baidu.tieba.im.db.d.apv().kn("group_level_up");
                com.baidu.tieba.im.db.d.apv().kn("dismiss_group");
                com.baidu.tieba.im.db.d.apv().kn("kick_out");
                com.baidu.tieba.im.db.d.apv().kn("group_activitys_change");
            } else if (this.dhQ.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.apv().kn("live_notify");
            }
        }
        return null;
    }
}
