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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.b97;
import com.repackage.q77;
import com.repackage.s77;
import com.repackage.t77;
/* loaded from: classes3.dex */
public class ImMessageCenterModel extends ImBaseMessageCenterModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_GROUP_MSG = 1;
    public static final int TYPE_GROUP_UPDATES = 3;
    public static final int TYPE_GROUP_VALIDATE = 2;
    public static final int TYPE_OFFICIAL_ACCOUNT_MESSAGE = 8;
    public static final int TYPE_OFFICIAL_MESSAGE_MERGE = 5;
    public static final int TYPE_PERSONAL_MSG = 4;
    public static final int TYPE_STRANGER_MESSAGE_MERGE = 7;
    public transient /* synthetic */ FieldHolder $fh;

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
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean A(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterPojo)) == null) {
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
        return invokeL.booleanValue;
    }

    public final boolean B(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterPojo)) == null) {
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
                if (imMessageCenterPojo.getCustomGroupType() == 2 && (imMessageCenterPojo.getIsFriend() == 1 || imMessageCenterPojo.getIsFriend() == 2 || imMessageCenterPojo.getShowOutOfStranger() == 1)) {
                    return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void C(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            return;
        }
        buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
        buildNormalItem.setOwnerName(String.valueOf(1));
        GroupSettingItemData a = q77.k().a(y(), imMessageCenterPojo.getGid());
        if (a != null) {
            buildNormalItem.setGroupSetting(a);
        }
        if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(z())) {
            if (TextUtils.isEmpty(buildNormalItem.getMsgContent())) {
                buildNormalItem.setMsgContent("");
            } else {
                buildNormalItem.setMsgContent(imMessageCenterPojo.getLast_user_name() + ":" + buildNormalItem.getMsgContent());
            }
        }
        insertShowData(buildNormalItem, this.mList);
    }

    public final void D(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f14bf));
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return;
            }
            buildNormalItem.setOwnerName(String.valueOf(3));
            insertShowData(buildNormalItem, this.mList);
        }
    }

    public final void E(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f14e3));
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return;
            }
            buildNormalItem.setOwnerName(String.valueOf(2));
            insertShowData(buildNormalItem, this.mList);
        }
    }

    public final void F(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            return;
        }
        buildNormalItem.setOwnerName(String.valueOf(8));
        if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(z()) && !StringUtils.isNull(buildNormalItem.getMsgContent())) {
            buildNormalItem.setMsgContent(buildNormalItem.getMsgContent());
        }
        OfficialSettingItemData a = s77.j().a(y(), imMessageCenterPojo.getGid());
        if (a != null) {
            buildNormalItem.setGroupSetting(a);
        }
        insertShowData(buildNormalItem, this.mList);
    }

    public final void G(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1213));
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return;
            }
            buildNormalItem.setOwnerName(String.valueOf(5));
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(z()) && !StringUtils.isNull(buildNormalItem.getMsgContent())) {
                buildNormalItem.setMsgContent(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03cc, new Object[]{imMessageCenterPojo.getLast_user_name()}) + ":" + buildNormalItem.getMsgContent());
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    public final void H(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) || imMessageCenterPojo == null) {
            return;
        }
        if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
            return;
        }
        if (((imMessageCenterPojo.getIsFriend() == 0 || imMessageCenterPojo.getIsFriend() == 3) && imMessageCenterPojo.getShowOutOfStranger() == 0) || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            return;
        }
        buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
        buildNormalItem.setOwnerName(String.valueOf(4));
        PersonalSettingItemData a = t77.j().a(y(), imMessageCenterPojo.getGid());
        if (a != null) {
            buildNormalItem.setGroupSetting(a);
        }
        buildNormalItem.setMarkTopIndex(b97.a(imMessageCenterPojo.getGid()));
        insertShowData(buildNormalItem, this.mList);
    }

    public final void I(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            imMessageCenterPojo.setGroup_name(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f062f));
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem == null) {
                return;
            }
            buildNormalItem.setOwnerName(String.valueOf(7));
            if (!StringUtils.isNull(buildNormalItem.getMsgContent())) {
                if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(z())) {
                    buildNormalItem.setMsgContent(imMessageCenterPojo.getLast_user_name() + " " + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1201));
                } else {
                    buildNormalItem.setMsgContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0aa0) + " " + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1201));
                }
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, imMessageCenterShowItemData)) == null) {
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
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, imMessageCenterPojo)) == null) ? A(imMessageCenterPojo) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, imMessageCenterPojo)) == null) ? B(imMessageCenterPojo) : invokeL.booleanValue;
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

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) {
            int customGroupType = imMessageCenterPojo.getCustomGroupType();
            if (customGroupType == -8) {
                G(imMessageCenterPojo, imMessageCenterShowItemData);
            } else if (customGroupType == -7) {
                I(imMessageCenterPojo, imMessageCenterShowItemData);
            } else if (customGroupType == -4) {
                E(imMessageCenterPojo, imMessageCenterShowItemData);
            } else if (customGroupType == -3) {
                D(imMessageCenterPojo, imMessageCenterShowItemData);
            } else if (customGroupType == 1) {
                C(imMessageCenterPojo, imMessageCenterShowItemData);
            } else if (customGroupType != 2) {
                if (customGroupType == 4 && imMessageCenterPojo.getUserType() == 4) {
                    F(imMessageCenterPojo, imMessageCenterShowItemData);
                }
            } else {
                H(imMessageCenterPojo, imMessageCenterShowItemData);
            }
        }
    }

    public final String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TbadkCoreApplication.getCurrentAccount() : (String) invokeV.objValue;
    }

    public final String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TbadkCoreApplication.getCurrentAccountNameShow() : (String) invokeV.objValue;
    }
}
