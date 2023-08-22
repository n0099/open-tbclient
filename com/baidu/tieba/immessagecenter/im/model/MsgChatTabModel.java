package com.baidu.tieba.immessagecenter.im.model;

import android.text.TextUtils;
import com.baidu.tieba.ie5;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class MsgChatTabModel extends ImMessageCenterModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MsgChatTabModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private boolean Q(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() == -4) {
                return false;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4 && !ie5.P(imMessageCenterPojo.getGid())) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == -8) {
                return false;
            }
            if (imMessageCenterPojo.getCustomGroupType() == -7) {
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

    @Override // com.baidu.tieba.immessagecenter.im.model.ImMessageCenterModel, com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterPojo)) == null) {
            return Q(imMessageCenterPojo);
        }
        return invokeL.booleanValue;
    }
}
