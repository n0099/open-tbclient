package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.ye5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class r17 extends ye5 {
    public static /* synthetic */ Interceptable $ic;
    public static r17 b;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<bf5> a;

    @Override // com.baidu.tieba.ye5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ye5
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public r17() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList<>();
    }

    public static r17 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (r17.class) {
                    if (b == null) {
                        b = new r17();
                    }
                }
            }
            return b;
        }
        return (r17) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ye5
    public void b(ye5.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && FileHelper.checkSD()) {
            List<MyEmotionGroupData> h = e17.c().h(TbadkCoreApplication.getCurrentAccount());
            this.a.clear();
            for (MyEmotionGroupData myEmotionGroupData : h) {
                EmotionGroupData n = m17.o().n(myEmotionGroupData.getGroupId());
                if (n != null) {
                    g17 g17Var = new g17(n);
                    if (g17Var.d() != null) {
                        this.a.add(g17Var);
                        if (aVar != null) {
                            aVar.a(g17Var);
                        }
                    }
                }
            }
        }
    }
}
