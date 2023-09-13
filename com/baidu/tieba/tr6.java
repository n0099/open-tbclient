package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.c67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class tr6 implements c67.l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tr6() {
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

    @Override // com.baidu.tieba.c67.s
    public void a(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof MultiLinkCardView)) {
            ((MultiLinkCardView) viewGroup).b();
        }
    }

    @Override // com.baidu.tieba.c67.l
    @NonNull
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new MultiLinkCardView(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.c67.l
    public void update(@NonNull ViewGroup viewGroup, @NonNull g77 g77Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, g77Var) == null) && (viewGroup instanceof MultiLinkCardView)) {
            List<j97> d = g77Var.d();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (j97 j97Var : d) {
                if (j97Var.i() == 6) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.title = j97Var.h();
                    pbGoodsData.picUrl = j97Var.f();
                    pbGoodsData.price = j97Var.c();
                    pbGoodsData.linkUrl = j97Var.e();
                    pbGoodsData.sort = j97Var.g();
                    pbGoodsData.linkFrom = j97Var.d();
                    pbGoodsData.goodsUrlH5 = j97Var.a();
                    arrayList2.add(pbGoodsData);
                } else {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.title = j97Var.h();
                    pbLinkData.linkUrl = j97Var.e();
                    pbLinkData.picUrl = j97Var.f();
                    pbLinkData.linkFrom = j97Var.d();
                    pbLinkData.extTxt = j97Var.c();
                    pbLinkData.sort = j97Var.g();
                    pbLinkData.urlType = j97Var.i();
                    pbLinkData.content1 = j97Var.a();
                    pbLinkData.content2 = j97Var.b();
                    arrayList.add(pbLinkData);
                }
            }
            ((MultiLinkCardView) viewGroup).a(arrayList, arrayList2);
        }
    }
}
