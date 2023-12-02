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
import tbclient.Anti;
import tbclient.BannerList;
import tbclient.BlockPopInfo;
import tbclient.Error;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.PageData;
import tbclient.LayoutFactory;
/* loaded from: classes6.dex */
public final class jj7 extends ej7<ui7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jj7() {
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

    @Override // com.baidu.tieba.xi7
    public boolean a(Object originData) {
        InterceptResult invokeL;
        PageData pageData;
        List<LayoutFactory> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            if (!(originData instanceof DataRes) || (pageData = ((DataRes) originData).page_data) == null || (list = pageData.feed_list) == null) {
                return false;
            }
            return !list.isEmpty();
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ej7
    public List<LayoutFactory> g(Object originData) {
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

    @Override // com.baidu.tieba.ej7
    public dj7 f(Object originData) {
        InterceptResult invokeL;
        BannerList bannerList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            dj7 dj7Var = new dj7();
            if (originData instanceof DataRes) {
                DataRes dataRes = (DataRes) originData;
                ForumInfo forumInfo = dataRes.forum;
                if (forumInfo != null) {
                    bannerList = forumInfo.banner_list;
                } else {
                    bannerList = null;
                }
                int i = 0;
                if (bannerList == null) {
                    bannerList = new BannerList.Builder().build(false);
                    Intrinsics.checkNotNullExpressionValue(bannerList, "Builder().build(false)");
                }
                dj7Var.f(bannerList);
                Integer num = dataRes.ad_show_select;
                if (num != null) {
                    i = num.intValue();
                }
                dj7Var.e(i);
                List<AdMixFloor> list = dataRes.ad_mix_list;
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                dj7Var.d(list);
            }
            return dj7Var;
        }
        return (dj7) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xi7
    /* renamed from: l */
    public ui7 b(byte[] bArr) {
        InterceptResult invokeL;
        Integer num;
        int intValue;
        String str;
        Anti anti;
        BlockPopInfo blockPopInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            ui7 ui7Var = new ui7();
            if (bArr == null) {
                return ui7Var;
            }
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl == null) {
                frsPageResIdl = new FrsPageResIdl.Builder().build(false);
            }
            Error error = frsPageResIdl.error;
            List<Long> list = null;
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
            ui7Var.c(intValue);
            Error error2 = frsPageResIdl.error;
            if (error2 != null) {
                str = error2.usermsg;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            ui7Var.d(str);
            DataRes dataRes = frsPageResIdl.data;
            if (dataRes == null) {
                dataRes = new DataRes.Builder().build(false);
                Intrinsics.checkNotNullExpressionValue(dataRes, "Builder().build(false)");
            }
            ui7Var.e(dataRes);
            DataRes dataRes2 = frsPageResIdl.data;
            Intrinsics.checkNotNullExpressionValue(dataRes2, "result.data");
            ui7Var.l(ij7.d(dataRes2));
            DataRes dataRes3 = frsPageResIdl.data;
            Intrinsics.checkNotNullExpressionValue(dataRes3, "result.data");
            ui7Var.k(ij7.c(dataRes3));
            DataRes dataRes4 = frsPageResIdl.data;
            Intrinsics.checkNotNullExpressionValue(dataRes4, "result.data");
            ui7Var.n(ij7.j(dataRes4));
            ui7Var.f(this);
            DataRes dataRes5 = frsPageResIdl.data;
            if (dataRes5 != null) {
                list = dataRes5.thread_id_list;
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            ui7Var.m(list);
            DataRes dataRes6 = frsPageResIdl.data;
            if (dataRes6 != null && (anti = dataRes6.anti) != null && (blockPopInfo = anti.block_pop_info) != null) {
                t4b.g(blockPopInfo);
            }
            return ui7Var;
        }
        return (ui7) invokeL.objValue;
    }
}
