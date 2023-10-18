package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.s07;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class im6 implements s07.l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public im6() {
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

    @Override // com.baidu.tieba.s07.s
    public void b(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof MultiLinkCardView)) {
            ((MultiLinkCardView) viewGroup).b();
        }
    }

    @Override // com.baidu.tieba.s07.l
    @NonNull
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new MultiLinkCardView(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s07.l
    public void i(@NonNull ViewGroup viewGroup, @NonNull w17 w17Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, w17Var) == null) && (viewGroup instanceof MultiLinkCardView)) {
            List<z37> d = w17Var.d();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (z37 z37Var : d) {
                if (z37Var.i() == 6) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.title = z37Var.h();
                    pbGoodsData.picUrl = z37Var.f();
                    pbGoodsData.price = z37Var.c();
                    pbGoodsData.linkUrl = z37Var.e();
                    pbGoodsData.sort = z37Var.g();
                    pbGoodsData.linkFrom = z37Var.d();
                    pbGoodsData.goodsUrlH5 = z37Var.a();
                    arrayList2.add(pbGoodsData);
                } else {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.title = z37Var.h();
                    pbLinkData.linkUrl = z37Var.e();
                    pbLinkData.picUrl = z37Var.f();
                    pbLinkData.linkFrom = z37Var.d();
                    pbLinkData.extTxt = z37Var.c();
                    pbLinkData.sort = z37Var.g();
                    pbLinkData.urlType = z37Var.i();
                    pbLinkData.content1 = z37Var.a();
                    pbLinkData.content2 = z37Var.b();
                    arrayList.add(pbLinkData);
                }
            }
            ((MultiLinkCardView) viewGroup).a(arrayList, arrayList2);
        }
    }
}
