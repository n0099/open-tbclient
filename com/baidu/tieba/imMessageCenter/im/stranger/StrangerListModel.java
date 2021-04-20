package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.ImBaseMessageCenterModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import d.b.i0.e1.f.i.b;
import d.b.i0.e1.t.e;
import java.util.ArrayList;
import java.util.ListIterator;
/* loaded from: classes4.dex */
public class StrangerListModel extends ImBaseMessageCenterModel {
    public StrangerListModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return 2;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2) {
            return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 0) {
            return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        t(imMessageCenterPojo, imMessageCenterShowItemData);
    }

    public void s(b bVar) {
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

    public final void t(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem == null) {
            return;
        }
        buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
        buildNormalItem.setOwnerName(String.valueOf(7));
        PersonalSettingItemData a2 = e.j().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        if (a2 != null) {
            buildNormalItem.setGroupSetting(a2);
        }
        insertShowData(buildNormalItem, this.mList);
    }
}
