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
public class sj7 {
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
                oj7 oj7Var = new oj7();
                oj7Var.j(recommendForumInfo);
                arrayList.add(oj7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                pj7 pj7Var = new pj7();
                pj7Var.j(item);
                arrayList.add(pj7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                qj7 qj7Var = new qj7();
                qj7Var.o(str);
                qj7Var.n(sugLiveInfo);
                arrayList.add(qj7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                rj7 rj7Var = new rj7();
                rj7Var.h(str);
                rj7Var.g(sugRankingInfo);
                arrayList.add(rj7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                nj7 nj7Var = new nj7();
                nj7Var.c(str);
                nj7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, nj7Var);
                } else {
                    arrayList.add(nj7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
