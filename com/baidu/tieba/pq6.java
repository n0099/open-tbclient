package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.y47;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class pq6 implements y47.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pq6() {
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

    @Override // com.baidu.tieba.y47.r
    public void a(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof MultiLinkCardView)) {
            ((MultiLinkCardView) viewGroup).b();
        }
    }

    @Override // com.baidu.tieba.y47.k
    @NonNull
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new MultiLinkCardView(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y47.k
    public void update(@NonNull ViewGroup viewGroup, @NonNull c67 c67Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, c67Var) == null) && (viewGroup instanceof MultiLinkCardView)) {
            List<e87> d = c67Var.d();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (e87 e87Var : d) {
                if (e87Var.i() == 6) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.title = e87Var.h();
                    pbGoodsData.picUrl = e87Var.f();
                    pbGoodsData.price = e87Var.c();
                    pbGoodsData.linkUrl = e87Var.e();
                    pbGoodsData.sort = e87Var.g();
                    pbGoodsData.linkFrom = e87Var.d();
                    pbGoodsData.goodsUrlH5 = e87Var.a();
                    arrayList2.add(pbGoodsData);
                } else {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.title = e87Var.h();
                    pbLinkData.linkUrl = e87Var.e();
                    pbLinkData.picUrl = e87Var.f();
                    pbLinkData.linkFrom = e87Var.d();
                    pbLinkData.extTxt = e87Var.c();
                    pbLinkData.sort = e87Var.g();
                    pbLinkData.urlType = e87Var.i();
                    pbLinkData.content1 = e87Var.a();
                    pbLinkData.content2 = e87Var.b();
                    arrayList.add(pbLinkData);
                }
            }
            ((MultiLinkCardView) viewGroup).a(arrayList, arrayList2);
        }
    }
}
