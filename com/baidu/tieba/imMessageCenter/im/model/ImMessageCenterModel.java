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
import com.baidu.tieba.im.settingcache.b;
import com.baidu.tieba.im.settingcache.e;
/* loaded from: classes16.dex */
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

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    private String getCurrentAccount() {
        return TbadkCoreApplication.getCurrentAccount();
    }

    private String cJr() {
        return TbadkCoreApplication.getCurrentAccountNameShow();
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) != null) {
            buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
            buildNormalItem.setOwnerName(String.valueOf(1));
            GroupSettingItemData eS = b.cIh().eS(getCurrentAccount(), imMessageCenterPojo.getGid());
            if (eS != null) {
                buildNormalItem.setGroupSetting(eS);
            }
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(cJr())) {
                if (TextUtils.isEmpty(buildNormalItem.getMsgContent())) {
                    buildNormalItem.setMsgContent("");
                } else {
                    buildNormalItem.setMsgContent(imMessageCenterPojo.getLast_user_name() + ":" + buildNormalItem.getMsgContent());
                }
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        if (imMessageCenterPojo != null) {
            if ((!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || !TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) && imMessageCenterPojo.getIsFriend() != 0 && (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) != null) {
                buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
                buildNormalItem.setOwnerName(String.valueOf(4));
                PersonalSettingItemData eS = e.cIk().eS(getCurrentAccount(), imMessageCenterPojo.getGid());
                if (eS != null) {
                    buildNormalItem.setGroupSetting(eS);
                }
                insertShowData(buildNormalItem, this.mList);
            }
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setOwnerName(String.valueOf(8));
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(cJr()) && !StringUtils.isNull(buildNormalItem.getMsgContent())) {
                buildNormalItem.setMsgContent(buildNormalItem.getMsgContent());
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.subscribe_bar_title));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setOwnerName(String.valueOf(5));
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(cJr()) && !StringUtils.isNull(buildNormalItem.getMsgContent())) {
                buildNormalItem.setMsgContent(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{imMessageCenterPojo.getLast_user_name()}) + ":" + buildNormalItem.getMsgContent());
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.stranger_message_activity_title));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setOwnerName(String.valueOf(7));
            if (!StringUtils.isNull(buildNormalItem.getMsgContent())) {
                if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(cJr())) {
                    buildNormalItem.setMsgContent(imMessageCenterPojo.getLast_user_name() + ":" + buildNormalItem.getMsgContent());
                } else {
                    buildNormalItem.setMsgContent(TbadkCoreApplication.getInst().getApp().getString(R.string.me) + ":" + buildNormalItem.getMsgContent());
                }
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.updates_activity_title));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setOwnerName(String.valueOf(3));
            insertShowData(buildNormalItem, this.mList);
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.validate));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setOwnerName(String.valueOf(2));
            insertShowData(buildNormalItem, this.mList);
        }
    }

    private boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        }
        if (imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -4) {
            if ((imMessageCenterPojo.getCustomGroupType() != 4 || imMessageCenterPojo.getUserType() != 4) && imMessageCenterPojo.getCustomGroupType() != -8 && imMessageCenterPojo.getCustomGroupType() != -7) {
                if (imMessageCenterPojo.getCustomGroupType() == 2) {
                    return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name());
        }
        if (imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -4) {
            if ((imMessageCenterPojo.getCustomGroupType() != 4 || imMessageCenterPojo.getUserType() != 4) && imMessageCenterPojo.getCustomGroupType() != -8 && imMessageCenterPojo.getCustomGroupType() != -7) {
                if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
                    return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        switch (imMessageCenterPojo.getCustomGroupType()) {
            case -8:
                d(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case -7:
                e(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case -6:
            case -5:
            case -2:
            case -1:
            case 0:
            case 3:
            default:
                return;
            case -4:
                g(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case -3:
                f(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case 1:
                a(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case 2:
                b(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case 4:
                if (imMessageCenterPojo.getUserType() == 4) {
                    c(imMessageCenterPojo, imMessageCenterShowItemData);
                    return;
                }
                return;
        }
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
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
        if (!imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(7))) {
            return 0;
        }
        return -7;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        return q(imMessageCenterPojo);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        return r(imMessageCenterPojo);
    }
}
