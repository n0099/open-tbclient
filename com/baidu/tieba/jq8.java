package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bq8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class jq8 extends js8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jq8() {
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

    @Override // com.baidu.tieba.is8
    public boolean a(int i, boolean z, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
            i(i);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.js8
    public void h(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            if (this.a.isEmpty()) {
                g(list);
            } else {
                super.h(list);
            }
        }
    }

    @Override // com.baidu.tieba.js8
    public List<hs8> j(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof AbilityItem) {
                        arrayList.add(new kq8((AbilityItem) obj));
                    } else {
                        boolean z = obj instanceof bq8.b;
                        if (z) {
                            Object obj2 = ((bq8.b) obj).a;
                            if (obj2 instanceof AbilityItem) {
                                arrayList.add(new kq8((AbilityItem) obj2));
                            }
                        }
                        if (z) {
                            Object obj3 = ((bq8.b) obj).a;
                            if (obj3 instanceof kq8) {
                                arrayList.add((kq8) obj3);
                            }
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }
}
