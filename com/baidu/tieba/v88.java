package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.n88;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class v88 extends z98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v88() {
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

    @Override // com.baidu.tieba.w98
    public boolean a(int i, boolean z, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
            i(i);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.z98
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

    @Override // com.baidu.tieba.z98
    public List<v98> j(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof AbilityItem) {
                        arrayList.add(new w88((AbilityItem) obj));
                    } else {
                        boolean z = obj instanceof n88.b;
                        if (z) {
                            Object obj2 = ((n88.b) obj).a;
                            if (obj2 instanceof AbilityItem) {
                                arrayList.add(new w88((AbilityItem) obj2));
                            }
                        }
                        if (z) {
                            Object obj3 = ((n88.b) obj).a;
                            if (obj3 instanceof w88) {
                                arrayList.add((w88) obj3);
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
