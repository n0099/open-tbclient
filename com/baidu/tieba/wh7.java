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
public class wh7 {
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
                sh7 sh7Var = new sh7();
                sh7Var.j(recommendForumInfo);
                arrayList.add(sh7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                th7 th7Var = new th7();
                th7Var.j(item);
                arrayList.add(th7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                uh7 uh7Var = new uh7();
                uh7Var.o(str);
                uh7Var.n(sugLiveInfo);
                arrayList.add(uh7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                vh7 vh7Var = new vh7();
                vh7Var.h(str);
                vh7Var.g(sugRankingInfo);
                arrayList.add(vh7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                rh7 rh7Var = new rh7();
                rh7Var.c(str);
                rh7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, rh7Var);
                } else {
                    arrayList.add(rh7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
