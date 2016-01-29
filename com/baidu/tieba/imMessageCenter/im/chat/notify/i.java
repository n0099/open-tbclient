package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData cim;
    final /* synthetic */ h cin;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cin = hVar;
        this.cim = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.cim != null) {
            this.cim.setUnReadCount(0);
            if (this.cim.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.aaU().iv("apply_join_group");
            } else if (this.cim.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.aaU().iv("group_intro_change");
                com.baidu.tieba.im.db.d.aaU().iv("group_name_change");
                com.baidu.tieba.im.db.d.aaU().iv("group_notice_change");
                com.baidu.tieba.im.db.d.aaU().iv("group_level_up");
                com.baidu.tieba.im.db.d.aaU().iv("dismiss_group");
                com.baidu.tieba.im.db.d.aaU().iv("kick_out");
                com.baidu.tieba.im.db.d.aaU().iv("group_activitys_change");
            } else if (this.cim.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.aaU().iv("live_notify");
            }
        }
        return null;
    }
}
