package com.baidu.tieba.immessagecenter.im.stranger;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.ImBaseMessageCenterModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.l9;
import com.baidu.tieba.uc8;
import com.baidu.tieba.uf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes6.dex */
public class StrangerListModel extends ImBaseMessageCenterModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterShowItemData)) == null) {
            return 2;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrangerListModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void deleteSelectedDatas(uc8 uc8Var) {
        List<ImMessageCenterShowItemData> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uc8Var) != null) || (list = this.mList) == null) {
            return;
        }
        ListIterator<ImMessageCenterShowItemData> listIterator = list.listIterator();
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasNext()) {
            ImMessageCenterShowItemData next = listIterator.next();
            if (next != null && next.isSelected()) {
                arrayList.add(next);
            }
        }
        asyncDeleteMsgList(arrayList, 2, uc8Var);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 2) {
                return false;
            }
            if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void V(uc8 uc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uc8Var) == null) {
            ListIterator<ImMessageCenterShowItemData> listIterator = this.mList.listIterator();
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasNext()) {
                ImMessageCenterShowItemData next = listIterator.next();
                if (next != null) {
                    arrayList.add(next);
                }
            }
            asyncDeleteMsgList(arrayList, 2, uc8Var);
        }
    }

    public void updateEditStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            for (int i = 0; i != this.mList.size(); i++) {
                this.mList.get(i).setSelected(z);
            }
        }
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 2 || ((imMessageCenterPojo.getIsFriend() != 0 && imMessageCenterPojo.getIsFriend() != 3) || imMessageCenterPojo.getShowOutOfStranger() == 1)) {
                return false;
            }
            if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData, @Nullable ImBaseMessageCenterModel.AsyncCallback asyncCallback) {
        ImMessageCenterShowItemData buildNormalItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048581, this, imMessageCenterPojo, imMessageCenterShowItemData, asyncCallback) != null) || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            return;
        }
        buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
        buildNormalItem.setOwnerName(String.valueOf(7));
        PersonalSettingItemData a = uf8.j().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        if (a != null) {
            buildNormalItem.setGroupSetting(a);
        }
        if (asyncCallback == null) {
            insertShowData(buildNormalItem, this.mList);
        } else {
            asyncCallback.doInsert(buildNormalItem);
        }
    }
}
