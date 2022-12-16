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
/* loaded from: classes6.dex */
public class xo7 {
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
                to7 to7Var = new to7();
                to7Var.i(recommendForumInfo);
                arrayList.add(to7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                uo7 uo7Var = new uo7();
                uo7Var.i(item);
                arrayList.add(uo7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                vo7 vo7Var = new vo7();
                vo7Var.o(str);
                vo7Var.m(sugLiveInfo);
                arrayList.add(vo7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                wo7 wo7Var = new wo7();
                wo7Var.h(str);
                wo7Var.g(sugRankingInfo);
                arrayList.add(wo7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                so7 so7Var = new so7();
                so7Var.c(str);
                so7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, so7Var);
                } else {
                    arrayList.add(so7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
