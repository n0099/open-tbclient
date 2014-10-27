package com.baidu.tieba.im.stranger;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryClearStrangerItemsMessage;
import com.baidu.tieba.im.message.g;
import com.baidu.tieba.im.model.ImBaseMessageCenterModel;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class StrangerListModel extends ImBaseMessageCenterModel {
    /* JADX INFO: Access modifiers changed from: protected */
    public StrangerListModel(Context context) {
        super(context);
    }

    public void RD() {
        LinkedList linkedList = new LinkedList();
        Iterator<ImMessageCenterShowItemData> it = this.mList.iterator();
        while (it.hasNext()) {
            String friendId = it.next().getFriendId();
            if (!TextUtils.isEmpty(friendId)) {
                linkedList.add(new g(friendId, 2, false));
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearStrangerItemsMessage(new com.baidu.tieba.im.message.e(linkedList), true));
        this.mList.clear();
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        a(imMessageCenterPojo, imMessageCenterShowItemData);
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
            PersonalSettingItemData am = com.baidu.tieba.im.chat.personaltalk.c.KF().am(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (am != null) {
                buildNormalItem.setGroupSetting(am);
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return 2;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 2 || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) ? false : true;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 2 || imMessageCenterPojo.getIsFriend() != 0 || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) ? false : true;
    }
}
