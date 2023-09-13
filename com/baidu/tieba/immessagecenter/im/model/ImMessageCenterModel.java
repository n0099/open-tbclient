package com.baidu.tieba.immessagecenter.im.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.ImBaseMessageCenterModel;
import com.baidu.tieba.im.settingcache.OfficialSettingCache;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.immessagecenter.service.ImAiBotDbService;
import com.baidu.tieba.li8;
import com.baidu.tieba.oi8;
import com.baidu.tieba.xj8;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public final String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TbadkCoreApplication.getCurrentAccountNameShow();
        }
        return (String) invokeV.objValue;
    }

    public final boolean O(ImMessageCenterPojo imMessageCenterPojo) {
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

    public final boolean P(ImMessageCenterPojo imMessageCenterPojo) {
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

    @Nullable
    public final ImMessageCenterShowItemData Q(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
                return null;
            }
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
            imMessageCenterShowItemData.setForumId(JavaTypesHelper.toLong(imMessageCenterPojo.getForumId(), 0L));
            imMessageCenterShowItemData.setRoomId(imMessageCenterPojo.getRoomId());
            imMessageCenterShowItemData.setServerTime(imMessageCenterPojo.getLast_content_time());
            imMessageCenterShowItemData.setUnReadCount(imMessageCenterPojo.getUnread_count());
            imMessageCenterShowItemData.setGroupSetting(null);
            imMessageCenterShowItemData.setMarkTopIndex(li8.b().a(Long.valueOf(JavaTypesHelper.toLong(imMessageCenterPojo.getGid(), 0L))));
            imMessageCenterShowItemData.setNotify(li8.b().d(Long.valueOf(JavaTypesHelper.toLong(imMessageCenterPojo.getGid(), 0L))));
            imMessageCenterShowItemData.setGroupDelete(li8.b().c(Long.valueOf(JavaTypesHelper.toLong(imMessageCenterPojo.getGid(), 0L)), imMessageCenterPojo.getLast_content_time()));
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
            imMessageCenterShowItemData.setSpecialMsgText(imMessageCenterPojo.getSpecialMsgText());
            imMessageCenterShowItemData.setAtInfoData(imMessageCenterPojo.getAtInfoData());
            return imMessageCenterShowItemData;
        }
        return (ImMessageCenterShowItemData) invokeLL.objValue;
    }

    @Nullable
    public final ImMessageCenterShowItemData R(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f17f3));
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return null;
            }
            buildNormalItem.setOwnerName(String.valueOf(2));
            return buildNormalItem;
        }
        return (ImMessageCenterShowItemData) invokeLL.objValue;
    }

    @Nullable
    public final ImMessageCenterShowItemData S(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return null;
            }
            buildNormalItem.setOwnerName(String.valueOf(8));
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(N()) && !StringUtils.isNull(buildNormalItem.getMsgContent())) {
                buildNormalItem.setMsgContent(buildNormalItem.getMsgContent());
            }
            OfficialSettingItemData setting = OfficialSettingCache.getInstance().getSetting(M(), imMessageCenterPojo.getGid());
            if (setting != null) {
                buildNormalItem.setGroupSetting(setting);
            }
            return buildNormalItem;
        }
        return (ImMessageCenterShowItemData) invokeLL.objValue;
    }

    @Nullable
    public final ImMessageCenterShowItemData T(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.subscribe_bar_title));
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return null;
            }
            buildNormalItem.setOwnerName(String.valueOf(5));
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(N()) && !StringUtils.isNull(buildNormalItem.getMsgContent())) {
                buildNormalItem.setMsgContent(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{imMessageCenterPojo.getLast_user_name()}) + ":" + buildNormalItem.getMsgContent());
            }
            return buildNormalItem;
        }
        return (ImMessageCenterShowItemData) invokeLL.objValue;
    }

    @Nullable
    public final ImMessageCenterShowItemData U(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeLL;
        ImMessageCenterShowItemData buildNormalItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterPojo == null || ((TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) || (((imMessageCenterPojo.getIsFriend() == 0 || imMessageCenterPojo.getIsFriend() == 3) && imMessageCenterPojo.getShowOutOfStranger() == 0) || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null))) {
                return null;
            }
            buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
            buildNormalItem.setOwnerName(String.valueOf(4));
            PersonalSettingItemData setting = oi8.a().getSetting(M(), imMessageCenterPojo.getGid());
            if (setting != null) {
                buildNormalItem.setGroupSetting(setting);
            }
            buildNormalItem.setMarkTopIndex(xj8.a(imMessageCenterPojo.getGid()));
            buildNormalItem.setAiBot(ImAiBotDbService.a.a().d(imMessageCenterPojo.getGid()));
            return buildNormalItem;
        }
        return (ImMessageCenterShowItemData) invokeLL.objValue;
    }

    @Nullable
    public final ImMessageCenterShowItemData V(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0762));
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return null;
            }
            buildNormalItem.setOwnerName(String.valueOf(7));
            if (!StringUtils.isNull(buildNormalItem.getMsgContent())) {
                if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(N())) {
                    buildNormalItem.setMsgContent(imMessageCenterPojo.getLast_user_name() + " " + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1491));
                } else {
                    buildNormalItem.setMsgContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c73) + " " + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1491));
                }
            }
            return buildNormalItem;
        }
        return (ImMessageCenterShowItemData) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, imMessageCenterPojo)) == null) {
            return O(imMessageCenterPojo);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, imMessageCenterPojo)) == null) {
            return P(imMessageCenterPojo);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData, @Nullable ImBaseMessageCenterModel.AsyncCallback asyncCallback) {
        ImMessageCenterShowItemData T2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, imMessageCenterPojo, imMessageCenterShowItemData, asyncCallback) == null) {
            int customGroupType = imMessageCenterPojo.getCustomGroupType();
            if (customGroupType != -8) {
                if (customGroupType != -7) {
                    if (customGroupType != -4) {
                        if (customGroupType != 2) {
                            if (customGroupType != 4) {
                                if (customGroupType == 9) {
                                    T2 = Q(imMessageCenterPojo, imMessageCenterShowItemData);
                                }
                                T2 = null;
                            } else {
                                if (imMessageCenterPojo.getUserType() == 4) {
                                    T2 = S(imMessageCenterPojo, imMessageCenterShowItemData);
                                }
                                T2 = null;
                            }
                        } else {
                            T2 = U(imMessageCenterPojo, imMessageCenterShowItemData);
                        }
                    } else {
                        T2 = R(imMessageCenterPojo, imMessageCenterShowItemData);
                    }
                } else {
                    T2 = V(imMessageCenterPojo, imMessageCenterShowItemData);
                }
            } else {
                T2 = T(imMessageCenterPojo, imMessageCenterShowItemData);
            }
            if (asyncCallback == null) {
                insertShowData(T2, this.mList);
            } else {
                asyncCallback.doInsert(T2);
            }
        }
    }
}
