package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes2.dex */
class j implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterShowItemData dej;
    final /* synthetic */ i dek;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dek = iVar;
        this.dej = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.dej != null) {
            this.dej.setUnReadCount(0);
            if (this.dej.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.anp().ks("apply_join_group");
            } else if (this.dej.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.anp().ks("group_intro_change");
                com.baidu.tieba.im.db.d.anp().ks("group_name_change");
                com.baidu.tieba.im.db.d.anp().ks("group_notice_change");
                com.baidu.tieba.im.db.d.anp().ks("group_level_up");
                com.baidu.tieba.im.db.d.anp().ks("dismiss_group");
                com.baidu.tieba.im.db.d.anp().ks("kick_out");
                com.baidu.tieba.im.db.d.anp().ks("group_activitys_change");
            } else if (this.dej.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.anp().ks("live_notify");
            }
        }
        return null;
    }
}
