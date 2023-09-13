package com.baidu.tieba.immessagecenter.im.chat.notify;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.me8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class MessageAggregationListAdapter extends ImMessageCenterListAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageAggregationListAdapter(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    public void b0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.g = tbPageContext;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.im.chat.notify.ImMessageCenterListAdapter, com.baidu.tieba.me8
    public void k(me8.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, imMessageCenterShowItemData) == null) {
            super.k(aVar, imMessageCenterShowItemData);
            aVar.b.setIsRound(true);
            if (!String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
                UtilHelper.showHeadImageViewBigVForStranger(aVar.b, imMessageCenterShowItemData);
            } else {
                aVar.b.setIsBigV(false);
            }
        }
    }
}
