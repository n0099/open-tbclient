package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class y implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData cZK;
    final /* synthetic */ x dcA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dcA = xVar;
        this.cZK = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.cZK != null) {
            this.cZK.setUnReadCount(0);
            if (this.cZK.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.apb().ks("apply_join_group");
            } else if (this.cZK.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.apb().ks("group_intro_change");
                com.baidu.tieba.im.db.d.apb().ks("group_name_change");
                com.baidu.tieba.im.db.d.apb().ks("group_notice_change");
                com.baidu.tieba.im.db.d.apb().ks("group_level_up");
                com.baidu.tieba.im.db.d.apb().ks("dismiss_group");
                com.baidu.tieba.im.db.d.apb().ks("kick_out");
                com.baidu.tieba.im.db.d.apb().ks("group_activitys_change");
            } else if (this.cZK.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.apb().ks("live_notify");
            }
        }
        return null;
    }
}
