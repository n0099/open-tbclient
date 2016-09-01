package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData dnJ;
    final /* synthetic */ o dss;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dss = oVar;
        this.dnJ = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.dnJ != null) {
            this.dnJ.setUnReadCount(0);
            if (this.dnJ.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.asg().lp("apply_join_group");
            } else if (this.dnJ.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.asg().lp("group_intro_change");
                com.baidu.tieba.im.db.d.asg().lp("group_name_change");
                com.baidu.tieba.im.db.d.asg().lp("group_notice_change");
                com.baidu.tieba.im.db.d.asg().lp("group_level_up");
                com.baidu.tieba.im.db.d.asg().lp("dismiss_group");
                com.baidu.tieba.im.db.d.asg().lp("kick_out");
                com.baidu.tieba.im.db.d.asg().lp("group_activitys_change");
            } else if (this.dnJ.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.asg().lp("live_notify");
            }
        }
        return null;
    }
}
