package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class q68 extends s78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.r78
    public boolean a(int i, boolean z, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public q68() {
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

    @Override // com.baidu.tieba.s78
    public List<q78> j(@NonNull List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj instanceof BaseMsg) {
                    BaseMsg baseMsg = (BaseMsg) obj;
                    List<AbilityItem> quickOperate = baseMsg.getCommonMsgField().getQuickOperate();
                    if (ListUtils.isEmpty(quickOperate)) {
                        break;
                    }
                    for (int i2 = 0; i2 < ListUtils.getCount(quickOperate); i2++) {
                        AbilityItem abilityItem = (AbilityItem) ListUtils.getItem(quickOperate, i2);
                        if (abilityItem != null && abilityItem.getStyleConf().shouldShow()) {
                            u68 u68Var = new u68();
                            u68Var.d(abilityItem);
                            u68Var.e(baseMsg);
                            arrayList.add(u68Var);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
