package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData cdM;
    final /* synthetic */ o cit;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cit = oVar;
        this.cdM = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.cdM != null) {
            this.cdM.setUnReadCount(0);
            if (this.cdM.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.Yj().iu("apply_join_group");
            } else if (this.cdM.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.Yj().iu("group_intro_change");
                com.baidu.tieba.im.db.d.Yj().iu("group_name_change");
                com.baidu.tieba.im.db.d.Yj().iu("group_notice_change");
                com.baidu.tieba.im.db.d.Yj().iu("group_level_up");
                com.baidu.tieba.im.db.d.Yj().iu("dismiss_group");
                com.baidu.tieba.im.db.d.Yj().iu("kick_out");
                com.baidu.tieba.im.db.d.Yj().iu("group_activitys_change");
            } else if (this.cdM.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.Yj().iu("live_notify");
            }
        }
        return null;
    }
}
