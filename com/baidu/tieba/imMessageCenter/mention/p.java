package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData duP;
    final /* synthetic */ o dzu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dzu = oVar;
        this.duP = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.duP != null) {
            this.duP.setUnReadCount(0);
            if (this.duP.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.auC().lP("apply_join_group");
            } else if (this.duP.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.auC().lP("group_intro_change");
                com.baidu.tieba.im.db.d.auC().lP("group_name_change");
                com.baidu.tieba.im.db.d.auC().lP("group_notice_change");
                com.baidu.tieba.im.db.d.auC().lP("group_level_up");
                com.baidu.tieba.im.db.d.auC().lP("dismiss_group");
                com.baidu.tieba.im.db.d.auC().lP("kick_out");
                com.baidu.tieba.im.db.d.auC().lP("group_activitys_change");
            } else if (this.duP.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.auC().lP("live_notify");
            }
        }
        return null;
    }
}
