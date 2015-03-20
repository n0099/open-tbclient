package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class f implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ e bpC;
    private final /* synthetic */ ImMessageCenterShowItemData bpD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bpC = eVar;
        this.bpD = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.bpD != null) {
            this.bpD.setUnReadCount(0);
            if (this.bpD.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.PL().gs("apply_join_group");
            } else if (this.bpD.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.PL().gs("group_intro_change");
                com.baidu.tieba.im.db.d.PL().gs("group_name_change");
                com.baidu.tieba.im.db.d.PL().gs("group_notice_change");
                com.baidu.tieba.im.db.d.PL().gs("group_level_up");
                com.baidu.tieba.im.db.d.PL().gs("dismiss_group");
                com.baidu.tieba.im.db.d.PL().gs("kick_out");
                com.baidu.tieba.im.db.d.PL().gs("group_activitys_change");
            } else if (this.bpD.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.PL().gs("live_notify");
            }
        }
        return null;
    }
}
