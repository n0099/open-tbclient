package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes2.dex */
class v implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData djE;
    final /* synthetic */ u dmv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dmv = uVar;
        this.djE = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.djE != null) {
            this.djE.setUnReadCount(0);
            if (this.djE.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.aop().kC("apply_join_group");
            } else if (this.djE.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.aop().kC("group_intro_change");
                com.baidu.tieba.im.db.d.aop().kC("group_name_change");
                com.baidu.tieba.im.db.d.aop().kC("group_notice_change");
                com.baidu.tieba.im.db.d.aop().kC("group_level_up");
                com.baidu.tieba.im.db.d.aop().kC("dismiss_group");
                com.baidu.tieba.im.db.d.aop().kC("kick_out");
                com.baidu.tieba.im.db.d.aop().kC("group_activitys_change");
            } else if (this.djE.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.aop().kC("live_notify");
            }
        }
        return null;
    }
}
