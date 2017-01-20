package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class v implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData dgZ;
    final /* synthetic */ u djL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.djL = uVar;
        this.dgZ = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.dgZ != null) {
            this.dgZ.setUnReadCount(0);
            if (this.dgZ.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.aqi().kG("apply_join_group");
            } else if (this.dgZ.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.aqi().kG("group_intro_change");
                com.baidu.tieba.im.db.d.aqi().kG("group_name_change");
                com.baidu.tieba.im.db.d.aqi().kG("group_notice_change");
                com.baidu.tieba.im.db.d.aqi().kG("group_level_up");
                com.baidu.tieba.im.db.d.aqi().kG("dismiss_group");
                com.baidu.tieba.im.db.d.aqi().kG("kick_out");
                com.baidu.tieba.im.db.d.aqi().kG("group_activitys_change");
            } else if (this.dgZ.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.aqi().kG("live_notify");
            }
        }
        return null;
    }
}
