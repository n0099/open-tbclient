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
/* loaded from: classes7.dex */
public class yo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<xn> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                uo7 uo7Var = new uo7();
                uo7Var.i(recommendForumInfo);
                arrayList.add(uo7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                vo7 vo7Var = new vo7();
                vo7Var.i(item);
                arrayList.add(vo7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                wo7 wo7Var = new wo7();
                wo7Var.o(str);
                wo7Var.m(sugLiveInfo);
                arrayList.add(wo7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                xo7 xo7Var = new xo7();
                xo7Var.h(str);
                xo7Var.g(sugRankingInfo);
                arrayList.add(xo7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                to7 to7Var = new to7();
                to7Var.c(str);
                to7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, to7Var);
                } else {
                    arrayList.add(to7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
