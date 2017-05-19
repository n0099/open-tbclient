package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryClearStrangerItemsMessage;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import com.baidu.tieba.im.model.ImBaseMessageCenterModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.j;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class StrangerListModel extends ImBaseMessageCenterModel {
    /* JADX INFO: Access modifiers changed from: protected */
    public StrangerListModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void asW() {
        LinkedList linkedList = new LinkedList();
        Iterator<ImMessageCenterShowItemData> it = this.mList.iterator();
        while (it.hasNext()) {
            String friendId = it.next().getFriendId();
            if (!TextUtils.isEmpty(friendId)) {
                linkedList.add(new MemoryModifyVisibilityMessage.a(friendId, 2, false));
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearStrangerItemsMessage(new MemoryClearStrangerItemsMessage.a(linkedList), true));
        this.mList.clear();
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        i(imMessageCenterPojo, imMessageCenterShowItemData);
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
            buildNormalItem.setOwnerName(String.valueOf(7));
            PersonalSettingItemData bf = j.aru().bf(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (bf != null) {
                buildNormalItem.setGroupSetting(bf);
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
        return (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 2 || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) ? false : true;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        return imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 0 && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name());
    }
}
