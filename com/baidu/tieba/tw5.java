package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class tw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<ln6> b;

    /* loaded from: classes8.dex */
    public class a implements Comparator<ln6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(tw5 tw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ln6 ln6Var, ln6 ln6Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ln6Var, ln6Var2)) == null) {
                return ln6Var.sort() - ln6Var2.sort();
            }
            return invokeLL.intValue;
        }
    }

    public tw5() {
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
        this.b = new LinkedList();
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public List<ln6> a(List<PbLinkData> list, List<PbGoodsData> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, list2)) == null) {
            return b(list, list2, null);
        }
        return (List) invokeLL.objValue;
    }

    public List<ln6> b(List<PbLinkData> list, List<PbGoodsData> list2, List<CardLinkInfoData> list3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2, list3)) == null) {
            if (!ListUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    PbLinkData pbLinkData = list.get(i);
                    if (pbLinkData.urlType == 2 && !this.a) {
                        this.a = true;
                    }
                    this.b.add(pbLinkData);
                }
            }
            if (!ListUtils.isEmpty(list2)) {
                this.a = true;
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    this.b.add(list2.get(i2));
                }
            }
            if (!ListUtils.isEmpty(list3)) {
                this.a = false;
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    this.b.add(list3.get(i3));
                }
            }
            Collections.sort(this.b, new a(this));
            return this.b;
        }
        return (List) invokeLLL.objValue;
    }
}
