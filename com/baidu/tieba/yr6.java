package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.b67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class yr6 implements b67.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yr6() {
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

    @Override // com.baidu.tieba.b67.r
    public void a(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof MultiLinkCardView)) {
            ((MultiLinkCardView) viewGroup).b();
        }
    }

    @Override // com.baidu.tieba.b67.k
    @NonNull
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new MultiLinkCardView(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b67.k
    public void update(@NonNull ViewGroup viewGroup, @NonNull f77 f77Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, f77Var) == null) && (viewGroup instanceof MultiLinkCardView)) {
            List<h97> d = f77Var.d();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (h97 h97Var : d) {
                if (h97Var.i() == 6) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.title = h97Var.h();
                    pbGoodsData.picUrl = h97Var.f();
                    pbGoodsData.price = h97Var.c();
                    pbGoodsData.linkUrl = h97Var.e();
                    pbGoodsData.sort = h97Var.g();
                    pbGoodsData.linkFrom = h97Var.d();
                    pbGoodsData.goodsUrlH5 = h97Var.a();
                    arrayList2.add(pbGoodsData);
                } else {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.title = h97Var.h();
                    pbLinkData.linkUrl = h97Var.e();
                    pbLinkData.picUrl = h97Var.f();
                    pbLinkData.linkFrom = h97Var.d();
                    pbLinkData.extTxt = h97Var.c();
                    pbLinkData.sort = h97Var.g();
                    pbLinkData.urlType = h97Var.i();
                    pbLinkData.content1 = h97Var.a();
                    pbLinkData.content2 = h97Var.b();
                    arrayList.add(pbLinkData);
                }
            }
            ((MultiLinkCardView) viewGroup).a(arrayList, arrayList2);
        }
    }
}
