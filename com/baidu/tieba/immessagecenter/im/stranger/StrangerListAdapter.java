package com.baidu.tieba.immessagecenter.im.stranger;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.eo7;
import com.baidu.tieba.k85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class StrangerListAdapter extends eo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.eo7
    public boolean f(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterShowItemData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.eo7
    public boolean g(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterShowItemData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrangerListAdapter(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext().getContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strangerListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = true;
    }

    @Override // com.baidu.tieba.eo7
    public void j(eo7.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.b.setIsRound(true);
            UtilHelper.showHeadImageViewBigVForStranger(aVar.b, imMessageCenterShowItemData);
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            if (!TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.b.M(friendBjhAvatar, 12, false);
            }
        }
    }

    @Override // com.baidu.tieba.eo7
    public void l(eo7.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, imMessageCenterShowItemData) == null) {
            if (imMessageCenterShowItemData != null) {
                imMessageCenterShowItemData.setMsgContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f12fc));
            }
            super.l(aVar, imMessageCenterShowItemData);
        }
    }

    @Override // com.baidu.tieba.eo7
    public void u(eo7.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.n.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.eo7
    public BasicNameValuePair x(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, imMessageCenterShowItemData, i, str)) == null) {
            String str2 = "";
            int i2 = 0;
            if (!k85.d().v()) {
                str = "";
                i = 0;
            }
            if (imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
                i2 = i;
                str2 = str;
            }
            return new BasicNameValuePair(String.valueOf(i2), str2);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }
}
