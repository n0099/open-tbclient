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
public class yh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<pn> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                uh7 uh7Var = new uh7();
                uh7Var.j(recommendForumInfo);
                arrayList.add(uh7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                vh7 vh7Var = new vh7();
                vh7Var.j(item);
                arrayList.add(vh7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                wh7 wh7Var = new wh7();
                wh7Var.o(str);
                wh7Var.n(sugLiveInfo);
                arrayList.add(wh7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                xh7 xh7Var = new xh7();
                xh7Var.h(str);
                xh7Var.g(sugRankingInfo);
                arrayList.add(xh7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                th7 th7Var = new th7();
                th7Var.c(str);
                th7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, th7Var);
                } else {
                    arrayList.add(th7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
