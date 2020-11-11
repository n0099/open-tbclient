package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.ImBaseMessageCenterModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.e;
import java.util.ArrayList;
import java.util.ListIterator;
/* loaded from: classes22.dex */
public class StrangerListModel extends ImBaseMessageCenterModel {
    /* JADX INFO: Access modifiers changed from: protected */
    public StrangerListModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.tieba.im.chat.a.b bVar) {
        ListIterator<ImMessageCenterShowItemData> listIterator = this.mList.listIterator();
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasNext()) {
            ImMessageCenterShowItemData next = listIterator.next();
            if (next != null) {
                arrayList.add(next);
            }
        }
        asyncDeleteMsgList(arrayList, 2, bVar);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        h(imMessageCenterPojo, imMessageCenterShowItemData);
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
            buildNormalItem.setOwnerName(String.valueOf(7));
            PersonalSettingItemData fs = e.cVh().fs(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (fs != null) {
                buildNormalItem.setGroupSetting(fs);
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
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2) {
            return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 0) {
            return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
        }
        return false;
    }
}
