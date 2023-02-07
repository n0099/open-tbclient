package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Item;
import tbclient.RecommendForumInfo;
import tbclient.SearchSug.DataRes;
import tbclient.SugLiveInfo;
import tbclient.SugRankingInfo;
/* loaded from: classes5.dex */
public class jy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<Cdo> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                fy7 fy7Var = new fy7();
                fy7Var.i(recommendForumInfo);
                arrayList.add(fy7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                gy7 gy7Var = new gy7();
                gy7Var.i(item);
                arrayList.add(gy7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                hy7 hy7Var = new hy7();
                hy7Var.o(str);
                hy7Var.m(sugLiveInfo);
                arrayList.add(hy7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                iy7 iy7Var = new iy7();
                iy7Var.h(str);
                iy7Var.g(sugRankingInfo);
                arrayList.add(iy7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                ey7 ey7Var = new ey7();
                ey7Var.c(str);
                ey7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, ey7Var);
                } else {
                    arrayList.add(ey7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
