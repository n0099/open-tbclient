package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.j37;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class uo6 implements j37.l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public uo6() {
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

    @Override // com.baidu.tieba.j37.s
    public void b(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof MultiLinkCardView)) {
            ((MultiLinkCardView) viewGroup).b();
        }
    }

    @Override // com.baidu.tieba.j37.l
    @NonNull
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new MultiLinkCardView(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j37.l
    public void i(@NonNull ViewGroup viewGroup, @NonNull r47 r47Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, r47Var) == null) && (viewGroup instanceof MultiLinkCardView)) {
            List<k77> d = r47Var.d();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (k77 k77Var : d) {
                if (k77Var.i() == 6) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.title = k77Var.h();
                    pbGoodsData.picUrl = k77Var.f();
                    pbGoodsData.price = k77Var.c();
                    pbGoodsData.linkUrl = k77Var.e();
                    pbGoodsData.sort = k77Var.g();
                    pbGoodsData.linkFrom = k77Var.d();
                    pbGoodsData.goodsUrlH5 = k77Var.a();
                    arrayList2.add(pbGoodsData);
                } else {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.title = k77Var.h();
                    pbLinkData.linkUrl = k77Var.e();
                    pbLinkData.picUrl = k77Var.f();
                    pbLinkData.linkFrom = k77Var.d();
                    pbLinkData.extTxt = k77Var.c();
                    pbLinkData.sort = k77Var.g();
                    pbLinkData.urlType = k77Var.i();
                    pbLinkData.content1 = k77Var.a();
                    pbLinkData.content2 = k77Var.b();
                    arrayList.add(pbLinkData);
                }
            }
            ((MultiLinkCardView) viewGroup).a(arrayList, arrayList2);
        }
    }
}
