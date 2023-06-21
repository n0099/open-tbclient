package com.baidu.tieba.immessagecenter.im.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.R;
import com.baidu.tieba.bc8;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.ImBaseMessageCenterModel;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.k9;
import com.baidu.tieba.oa8;
import com.baidu.tieba.ra8;
import com.baidu.tieba.sa8;
import com.baidu.tieba.ug;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ImMessageCenterModel extends ImBaseMessageCenterModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_GROUP_MSG = 1;
    public static final int TYPE_GROUP_VALIDATE = 2;
    public static final int TYPE_NEW_GROUP_MSG = 9;
    public static final int TYPE_OFFICIAL_ACCOUNT_MESSAGE = 8;
    public static final int TYPE_OFFICIAL_MESSAGE_MERGE = 5;
    public static final int TYPE_PERSONAL_MSG = 4;
    public static final int TYPE_STRANGER_MESSAGE_MERGE = 7;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImMessageCenterModel() {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public final String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TbadkCoreApplication.getCurrentAccountNameShow();
        }
        return (String) invokeV.objValue;
    }

    public final boolean W(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() == -4) {
                return false;
            }
            if ((imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4) || imMessageCenterPojo.getCustomGroupType() == -8 || imMessageCenterPojo.getCustomGroupType() == -7) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    return false;
                }
                return true;
            } else if (imMessageCenterPojo.getCustomGroupType() != 9 || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean X(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() == -4) {
                return false;
            }
            if ((imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4) || imMessageCenterPojo.getCustomGroupType() == -8 || imMessageCenterPojo.getCustomGroupType() == -7) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2 && (imMessageCenterPojo.getIsFriend() == 1 || imMessageCenterPojo.getIsFriend() == 2 || imMessageCenterPojo.getShowOutOfStranger() == 1)) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    return false;
                }
                return true;
            } else if (imMessageCenterPojo.getCustomGroupType() != 9 || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || imMessageCenterPojo.getIs_hidden() == 1) {
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, imMessageCenterShowItemData)) == null) {
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
            if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(7))) {
                return -7;
            }
            if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(9))) {
                return 9;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void Y(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            if (imMessageCenterShowItemData == null) {
                imMessageCenterShowItemData = new ImMessageCenterShowItemData();
            }
            imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
            imMessageCenterShowItemData.setOwnerId(TbadkCoreApplication.getCurrentAccount());
            imMessageCenterShowItemData.setFriendName(imMessageCenterPojo.getGroup_name());
            imMessageCenterShowItemData.setFriendNameShow(imMessageCenterPojo.getGroup_name());
            imMessageCenterShowItemData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
            imMessageCenterShowItemData.setFriendBjhAvatar(imMessageCenterPojo.getGroup_head());
            imMessageCenterShowItemData.setOwnerName(String.valueOf(9));
            imMessageCenterShowItemData.setForumName(imMessageCenterPojo.getForumName());
            imMessageCenterShowItemData.setServerTime(imMessageCenterPojo.getLast_content_time());
            imMessageCenterShowItemData.setUnReadCount(imMessageCenterPojo.getUnread_count());
            imMessageCenterShowItemData.setGroupSetting(null);
            imMessageCenterShowItemData.setMarkTopIndex(oa8.b().a(Long.valueOf(ug.g(imMessageCenterPojo.getGid(), 0L))));
            imMessageCenterShowItemData.setNotify(oa8.b().d(Long.valueOf(ug.g(imMessageCenterPojo.getGid(), 0L))));
            imMessageCenterShowItemData.setGroupDelete(oa8.b().c(Long.valueOf(ug.g(imMessageCenterPojo.getGid(), 0L)), imMessageCenterPojo.getLast_content_time()));
            imMessageCenterShowItemData.setCacheGroupMsgContent(imMessageCenterPojo.getLast_content());
            if (TextUtils.isEmpty(imMessageCenterPojo.getLast_content())) {
                imMessageCenterPojo.setLast_content("");
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                imMessageCenterPojo.setLast_content(imMessageCenterPojo.getLast_user_name() + ": " + imMessageCenterPojo.getLast_content());
            }
            imMessageCenterShowItemData.setMsgContent(imMessageCenterPojo.getLast_content());
            imMessageCenterShowItemData.setGroupJumpUrl(imMessageCenterPojo.getGroupJumpUrl());
            imMessageCenterShowItemData.setAtInfoData(imMessageCenterPojo.getAtInfoData());
            insertShowData(imMessageCenterShowItemData, this.mList);
        }
    }

    public final void Z(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1790));
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return;
            }
            buildNormalItem.setOwnerName(String.valueOf(2));
            insertShowData(buildNormalItem, this.mList);
        }
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            int customGroupType = imMessageCenterPojo.getCustomGroupType();
            if (customGroupType != -8) {
                if (customGroupType != -7) {
                    if (customGroupType != -4) {
                        if (customGroupType != 2) {
                            if (customGroupType != 4) {
                                if (customGroupType == 9) {
                                    Y(imMessageCenterPojo, imMessageCenterShowItemData);
                                    return;
                                }
                                return;
                            } else if (imMessageCenterPojo.getUserType() == 4) {
                                a0(imMessageCenterPojo, imMessageCenterShowItemData);
                                return;
                            } else {
                                return;
                            }
                        }
                        c0(imMessageCenterPojo, imMessageCenterShowItemData);
                        return;
                    }
                    Z(imMessageCenterPojo, imMessageCenterShowItemData);
                    return;
                }
                d0(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            }
            b0(imMessageCenterPojo, imMessageCenterShowItemData);
        }
    }

    public final void a0(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, imMessageCenterPojo, imMessageCenterShowItemData) != null) || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            return;
        }
        buildNormalItem.setOwnerName(String.valueOf(8));
        if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(V()) && !StringUtils.isNull(buildNormalItem.getMsgContent())) {
            buildNormalItem.setMsgContent(buildNormalItem.getMsgContent());
        }
        OfficialSettingItemData a = ra8.j().a(U(), imMessageCenterPojo.getGid());
        if (a != null) {
            buildNormalItem.setGroupSetting(a);
        }
        insertShowData(buildNormalItem, this.mList);
    }

    public final void b0(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.subscribe_bar_title));
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return;
            }
            buildNormalItem.setOwnerName(String.valueOf(5));
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(V()) && !StringUtils.isNull(buildNormalItem.getMsgContent())) {
                buildNormalItem.setMsgContent(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{imMessageCenterPojo.getLast_user_name()}) + ":" + buildNormalItem.getMsgContent());
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    public final void c0(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) && imMessageCenterPojo != null) {
            if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || !TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                if (((imMessageCenterPojo.getIsFriend() == 0 || imMessageCenterPojo.getIsFriend() == 3) && imMessageCenterPojo.getShowOutOfStranger() == 0) || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
                    return;
                }
                buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
                buildNormalItem.setOwnerName(String.valueOf(4));
                PersonalSettingItemData a = sa8.j().a(U(), imMessageCenterPojo.getGid());
                if (a != null) {
                    buildNormalItem.setGroupSetting(a);
                }
                buildNormalItem.setMarkTopIndex(bc8.a(imMessageCenterPojo.getGid()));
                insertShowData(buildNormalItem, this.mList);
            }
        }
    }

    public final void d0(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f074a));
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return;
            }
            buildNormalItem.setOwnerName(String.valueOf(7));
            if (!StringUtils.isNull(buildNormalItem.getMsgContent())) {
                if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(V())) {
                    buildNormalItem.setMsgContent(imMessageCenterPojo.getLast_user_name() + " " + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1433));
                } else {
                    buildNormalItem.setMsgContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c44) + " " + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1433));
                }
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, imMessageCenterPojo)) == null) {
            return W(imMessageCenterPojo);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, imMessageCenterPojo)) == null) {
            return X(imMessageCenterPojo);
        }
        return invokeL.booleanValue;
    }
}
