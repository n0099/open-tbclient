package com.baidu.tieba.imMessageCenter.im.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.ImBaseMessageCenterModel;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import d.b.i0.d1.t.b;
import d.b.i0.d1.t.e;
/* loaded from: classes4.dex */
public class ImMessageCenterModel extends ImBaseMessageCenterModel {
    public static final int TYPE_GROUP_MSG = 1;
    public static final int TYPE_GROUP_UPDATES = 3;
    public static final int TYPE_GROUP_VALIDATE = 2;
    public static final int TYPE_OFFICIAL_ACCOUNT_MESSAGE = 8;
    public static final int TYPE_OFFICIAL_MESSAGE_MERGE = 5;
    public static final int TYPE_PERSONAL_MSG = 4;
    public static final int TYPE_STRANGER_MESSAGE_MERGE = 7;

    public ImMessageCenterModel() {
        super(null);
    }

    public final void A(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.subscribe_bar_title));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem == null) {
            return;
        }
        buildNormalItem.setOwnerName(String.valueOf(5));
        if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(t()) && !StringUtils.isNull(buildNormalItem.getMsgContent())) {
            buildNormalItem.setMsgContent(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{imMessageCenterPojo.getLast_user_name()}) + ":" + buildNormalItem.getMsgContent());
        }
        insertShowData(buildNormalItem, this.mList);
    }

    public final void B(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        if (imMessageCenterPojo != null) {
            if ((TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) || imMessageCenterPojo.getIsFriend() == 0 || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
                return;
            }
            buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
            buildNormalItem.setOwnerName(String.valueOf(4));
            PersonalSettingItemData a2 = e.j().a(s(), imMessageCenterPojo.getGid());
            if (a2 != null) {
                buildNormalItem.setGroupSetting(a2);
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    public final void C(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.stranger_message_activity_title));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem == null) {
            return;
        }
        buildNormalItem.setOwnerName(String.valueOf(7));
        if (!StringUtils.isNull(buildNormalItem.getMsgContent())) {
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(t())) {
                buildNormalItem.setMsgContent(imMessageCenterPojo.getLast_user_name() + ":" + buildNormalItem.getMsgContent());
            } else {
                buildNormalItem.setMsgContent(TbadkCoreApplication.getInst().getApp().getString(R.string.me) + ":" + buildNormalItem.getMsgContent());
            }
        }
        insertShowData(buildNormalItem, this.mList);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(1))) {
            return 1;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(3))) {
            return -3;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(2))) {
            return -4;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(8))) {
            return 4;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(5))) {
            return -8;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(4))) {
            return 2;
        }
        return imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(7)) ? -7 : 0;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        return u(imMessageCenterPojo);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        return v(imMessageCenterPojo);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int customGroupType = imMessageCenterPojo.getCustomGroupType();
        if (customGroupType == -8) {
            A(imMessageCenterPojo, imMessageCenterShowItemData);
        } else if (customGroupType == -7) {
            C(imMessageCenterPojo, imMessageCenterShowItemData);
        } else if (customGroupType == -4) {
            y(imMessageCenterPojo, imMessageCenterShowItemData);
        } else if (customGroupType == -3) {
            x(imMessageCenterPojo, imMessageCenterShowItemData);
        } else if (customGroupType == 1) {
            w(imMessageCenterPojo, imMessageCenterShowItemData);
        } else if (customGroupType != 2) {
            if (customGroupType == 4 && imMessageCenterPojo.getUserType() == 4) {
                z(imMessageCenterPojo, imMessageCenterShowItemData);
            }
        } else {
            B(imMessageCenterPojo, imMessageCenterShowItemData);
        }
    }

    public final String s() {
        return TbadkCoreApplication.getCurrentAccount();
    }

    public final String t() {
        return TbadkCoreApplication.getCurrentAccountNameShow();
    }

    public final boolean u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        } else if (imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4) {
            return false;
        } else {
            if ((imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4) || imMessageCenterPojo.getCustomGroupType() == -8 || imMessageCenterPojo.getCustomGroupType() == -7) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
            }
            return false;
        }
    }

    public final boolean v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
            }
            return false;
        } else if (imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4) {
            return false;
        } else {
            if ((imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4) || imMessageCenterPojo.getCustomGroupType() == -8 || imMessageCenterPojo.getCustomGroupType() == -7) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
                return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
            }
            return false;
        }
    }

    public final void w(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        if (imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            return;
        }
        buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
        buildNormalItem.setOwnerName(String.valueOf(1));
        GroupSettingItemData a2 = b.k().a(s(), imMessageCenterPojo.getGid());
        if (a2 != null) {
            buildNormalItem.setGroupSetting(a2);
        }
        if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(t())) {
            if (TextUtils.isEmpty(buildNormalItem.getMsgContent())) {
                buildNormalItem.setMsgContent("");
            } else {
                buildNormalItem.setMsgContent(imMessageCenterPojo.getLast_user_name() + ":" + buildNormalItem.getMsgContent());
            }
        }
        insertShowData(buildNormalItem, this.mList);
    }

    public final void x(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.updates_activity_title));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem == null) {
            return;
        }
        buildNormalItem.setOwnerName(String.valueOf(3));
        insertShowData(buildNormalItem, this.mList);
    }

    public final void y(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.validate));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem == null) {
            return;
        }
        buildNormalItem.setOwnerName(String.valueOf(2));
        insertShowData(buildNormalItem, this.mList);
    }

    public final void z(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem == null) {
            return;
        }
        buildNormalItem.setOwnerName(String.valueOf(8));
        if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(t()) && !StringUtils.isNull(buildNormalItem.getMsgContent())) {
            buildNormalItem.setMsgContent(buildNormalItem.getMsgContent());
        }
        insertShowData(buildNormalItem, this.mList);
    }
}
