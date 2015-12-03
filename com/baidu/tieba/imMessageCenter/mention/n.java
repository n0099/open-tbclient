package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class n implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData bZL;
    final /* synthetic */ m cer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cer = mVar;
        this.bZL = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.bZL != null) {
            this.bZL.setUnReadCount(0);
            if (this.bZL.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.Xd().ih("apply_join_group");
            } else if (this.bZL.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.Xd().ih("group_intro_change");
                com.baidu.tieba.im.db.d.Xd().ih("group_name_change");
                com.baidu.tieba.im.db.d.Xd().ih("group_notice_change");
                com.baidu.tieba.im.db.d.Xd().ih("group_level_up");
                com.baidu.tieba.im.db.d.Xd().ih("dismiss_group");
                com.baidu.tieba.im.db.d.Xd().ih("kick_out");
                com.baidu.tieba.im.db.d.Xd().ih("group_activitys_change");
            } else if (this.bZL.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.Xd().ih("live_notify");
            }
        }
        return null;
    }
}
