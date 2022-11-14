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
public class yl7 {
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
                ul7 ul7Var = new ul7();
                ul7Var.j(recommendForumInfo);
                arrayList.add(ul7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                vl7 vl7Var = new vl7();
                vl7Var.j(item);
                arrayList.add(vl7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                wl7 wl7Var = new wl7();
                wl7Var.o(str);
                wl7Var.n(sugLiveInfo);
                arrayList.add(wl7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                xl7 xl7Var = new xl7();
                xl7Var.h(str);
                xl7Var.g(sugRankingInfo);
                arrayList.add(xl7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                tl7 tl7Var = new tl7();
                tl7Var.c(str);
                tl7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, tl7Var);
                } else {
                    arrayList.add(tl7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
