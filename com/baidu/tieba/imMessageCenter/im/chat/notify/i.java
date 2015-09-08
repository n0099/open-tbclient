package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData bGW;
    final /* synthetic */ h bGX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bGX = hVar;
        this.bGW = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.bGW != null) {
            this.bGW.setUnReadCount(0);
            if (this.bGW.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.SY().hG("apply_join_group");
            } else if (this.bGW.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.SY().hG("group_intro_change");
                com.baidu.tieba.im.db.d.SY().hG("group_name_change");
                com.baidu.tieba.im.db.d.SY().hG("group_notice_change");
                com.baidu.tieba.im.db.d.SY().hG("group_level_up");
                com.baidu.tieba.im.db.d.SY().hG("dismiss_group");
                com.baidu.tieba.im.db.d.SY().hG("kick_out");
                com.baidu.tieba.im.db.d.SY().hG("group_activitys_change");
            } else if (this.bGW.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.SY().hG("live_notify");
            }
        }
        return null;
    }
}
