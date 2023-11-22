package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AdMixFloor;
import tbclient.BannerList;
import tbclient.Error;
import tbclient.LayoutFactory;
import tbclient.ThreadList.DataRes;
import tbclient.ThreadList.PageData;
import tbclient.ThreadList.ThreadListResIdl;
/* loaded from: classes9.dex */
public final class yh7 extends sh7<lh7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yh7() {
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

    @Override // com.baidu.tieba.nh7
    public boolean a(Object originData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            if (originData instanceof DataRes) {
                List<LayoutFactory> list = ((DataRes) originData).page_data.feed_list;
                Intrinsics.checkNotNullExpressionValue(list, "originData.page_data.feed_list");
                return !list.isEmpty();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.sh7
    public List<LayoutFactory> f(Object originData) {
        InterceptResult invokeL;
        List<LayoutFactory> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            if (originData instanceof DataRes) {
                PageData pageData = ((DataRes) originData).page_data;
                if (pageData != null) {
                    list = pageData.feed_list;
                } else {
                    list = null;
                }
                if (list == null) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                return list;
            }
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sh7
    public rh7 e(Object originData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            rh7 rh7Var = new rh7();
            if (originData instanceof DataRes) {
                DataRes dataRes = (DataRes) originData;
                BannerList bannerList = dataRes.banner_list;
                int i = 0;
                if (bannerList == null) {
                    bannerList = new BannerList.Builder().build(false);
                    Intrinsics.checkNotNullExpressionValue(bannerList, "Builder().build(false)");
                }
                rh7Var.f(bannerList);
                Integer num = dataRes.ad_show_select;
                if (num != null) {
                    i = num.intValue();
                }
                rh7Var.e(i);
                List<AdMixFloor> list = dataRes.ad_mix_list;
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                rh7Var.d(list);
            }
            return rh7Var;
        }
        return (rh7) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nh7
    /* renamed from: k */
    public lh7 b(byte[] bArr) {
        InterceptResult invokeL;
        Integer num;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            lh7 lh7Var = new lh7();
            ThreadListResIdl threadListResIdl = (ThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadListResIdl.class);
            if (threadListResIdl == null) {
                threadListResIdl = new ThreadListResIdl.Builder().build(false);
            }
            Error error = threadListResIdl.error;
            String str = null;
            if (error != null) {
                num = error.errorno;
            } else {
                num = null;
            }
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            lh7Var.c(intValue);
            Error error2 = threadListResIdl.error;
            if (error2 != null) {
                str = error2.usermsg;
            }
            if (str == null) {
                str = "";
            }
            lh7Var.d(str);
            DataRes dataRes = threadListResIdl.data;
            if (dataRes == null) {
                dataRes = new DataRes.Builder().build(false);
                Intrinsics.checkNotNullExpressionValue(dataRes, "Builder().build(false)");
            }
            lh7Var.e(dataRes);
            lh7Var.f(this);
            return lh7Var;
        }
        return (lh7) invokeL.objValue;
    }
}
