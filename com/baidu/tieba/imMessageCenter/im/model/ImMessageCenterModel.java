package com.baidu.tieba.imMessageCenter.im.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.ImBaseMessageCenterModel;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.od7;
import com.baidu.tieba.qd7;
import com.baidu.tieba.r9;
import com.baidu.tieba.rd7;
import com.baidu.tieba.ye7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ImMessageCenterModel extends ImBaseMessageCenterModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_GROUP_MSG = 1;
    public static final int TYPE_GROUP_VALIDATE = 2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TbadkCoreApplication.getCurrentAccountNameShow();
        }
        return (String) invokeV.objValue;
    }

    public final String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public final boolean B(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || !TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class)) {
                    return false;
                }
                return true;
            } else if (imMessageCenterPojo.getCustomGroupType() == -4) {
                return false;
            } else {
                if ((imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4) || imMessageCenterPojo.getCustomGroupType() == -8 || imMessageCenterPojo.getCustomGroupType() == -7) {
                    return true;
                }
                if (imMessageCenterPojo.getCustomGroupType() != 2) {
                    return false;
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean C(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                }
                return false;
            } else if (imMessageCenterPojo.getCustomGroupType() == -4) {
                return false;
            } else {
                if ((imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4) || imMessageCenterPojo.getCustomGroupType() == -8 || imMessageCenterPojo.getCustomGroupType() == -7) {
                    return true;
                }
                if (imMessageCenterPojo.getCustomGroupType() != 2 || (imMessageCenterPojo.getIsFriend() != 1 && imMessageCenterPojo.getIsFriend() != 2 && imMessageCenterPojo.getShowOutOfStranger() != 1)) {
                    return false;
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(1))) {
                return 1;
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
            if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(7))) {
                return -7;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void D(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, imMessageCenterPojo, imMessageCenterShowItemData) != null) || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            return;
        }
        buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
        buildNormalItem.setOwnerName(String.valueOf(1));
        GroupSettingItemData a = od7.k().a(z(), imMessageCenterPojo.getGid());
        if (a != null) {
            buildNormalItem.setGroupSetting(a);
        }
        if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(A())) {
            if (TextUtils.isEmpty(buildNormalItem.getMsgContent())) {
                buildNormalItem.setMsgContent("");
            } else {
                buildNormalItem.setMsgContent(imMessageCenterPojo.getLast_user_name() + ":" + buildNormalItem.getMsgContent());
            }
        }
        insertShowData(buildNormalItem, this.mList);
    }

    public final void G(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1272));
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return;
            }
            buildNormalItem.setOwnerName(String.valueOf(5));
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(A()) && !StringUtils.isNull(buildNormalItem.getMsgContent())) {
                buildNormalItem.setMsgContent(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03e1, new Object[]{imMessageCenterPojo.getLast_user_name()}) + ":" + buildNormalItem.getMsgContent());
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    public final void H(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) && imMessageCenterPojo != null) {
            if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || !TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                if (((imMessageCenterPojo.getIsFriend() == 0 || imMessageCenterPojo.getIsFriend() == 3) && imMessageCenterPojo.getShowOutOfStranger() == 0) || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
                    return;
                }
                buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
                buildNormalItem.setOwnerName(String.valueOf(4));
                PersonalSettingItemData a = rd7.j().a(z(), imMessageCenterPojo.getGid());
                if (a != null) {
                    buildNormalItem.setGroupSetting(a);
                }
                buildNormalItem.setMarkTopIndex(ye7.a(imMessageCenterPojo.getGid()));
                insertShowData(buildNormalItem, this.mList);
            }
        }
    }

    public final void E(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1554));
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
        if (interceptable == null || interceptable.invokeLL(1048590, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            int customGroupType = imMessageCenterPojo.getCustomGroupType();
            if (customGroupType != -8) {
                if (customGroupType != -7) {
                    if (customGroupType != -4) {
                        if (customGroupType != 4) {
                            if (customGroupType != 1) {
                                if (customGroupType == 2) {
                                    H(imMessageCenterPojo, imMessageCenterShowItemData);
                                    return;
                                }
                                return;
                            }
                            D(imMessageCenterPojo, imMessageCenterShowItemData);
                            return;
                        } else if (imMessageCenterPojo.getUserType() == 4) {
                            F(imMessageCenterPojo, imMessageCenterShowItemData);
                            return;
                        } else {
                            return;
                        }
                    }
                    E(imMessageCenterPojo, imMessageCenterShowItemData);
                    return;
                }
                I(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            }
            G(imMessageCenterPojo, imMessageCenterShowItemData);
        }
    }

    public final void F(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, imMessageCenterPojo, imMessageCenterShowItemData) != null) || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            return;
        }
        buildNormalItem.setOwnerName(String.valueOf(8));
        if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(A()) && !StringUtils.isNull(buildNormalItem.getMsgContent())) {
            buildNormalItem.setMsgContent(buildNormalItem.getMsgContent());
        }
        OfficialSettingItemData a = qd7.j().a(z(), imMessageCenterPojo.getGid());
        if (a != null) {
            buildNormalItem.setGroupSetting(a);
        }
        insertShowData(buildNormalItem, this.mList);
    }

    public final void I(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f065f));
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return;
            }
            buildNormalItem.setOwnerName(String.valueOf(7));
            if (!StringUtils.isNull(buildNormalItem.getMsgContent())) {
                if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(A())) {
                    buildNormalItem.setMsgContent(imMessageCenterPojo.getLast_user_name() + " " + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f125f));
                } else {
                    buildNormalItem.setMsgContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0adf) + " " + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f125f));
                }
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, imMessageCenterPojo)) == null) {
            return B(imMessageCenterPojo);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, imMessageCenterPojo)) == null) {
            return C(imMessageCenterPojo);
        }
        return invokeL.booleanValue;
    }
}
