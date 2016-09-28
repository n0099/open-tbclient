package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class j implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData dph;
    final /* synthetic */ i dpj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dpj = iVar;
        this.dph = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.dph != null) {
            this.dph.setUnReadCount(0);
            if (this.dph.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.asF().lC("apply_join_group");
            } else if (this.dph.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.asF().lC("group_intro_change");
                com.baidu.tieba.im.db.d.asF().lC("group_name_change");
                com.baidu.tieba.im.db.d.asF().lC("group_notice_change");
                com.baidu.tieba.im.db.d.asF().lC("group_level_up");
                com.baidu.tieba.im.db.d.asF().lC("dismiss_group");
                com.baidu.tieba.im.db.d.asF().lC("kick_out");
                com.baidu.tieba.im.db.d.asF().lC("group_activitys_change");
            } else if (this.dph.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.asF().lC("live_notify");
            }
        }
        return null;
    }
}
