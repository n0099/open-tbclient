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
public class zl7 {
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
                vl7 vl7Var = new vl7();
                vl7Var.j(recommendForumInfo);
                arrayList.add(vl7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                wl7 wl7Var = new wl7();
                wl7Var.j(item);
                arrayList.add(wl7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                xl7 xl7Var = new xl7();
                xl7Var.o(str);
                xl7Var.n(sugLiveInfo);
                arrayList.add(xl7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                yl7 yl7Var = new yl7();
                yl7Var.h(str);
                yl7Var.g(sugRankingInfo);
                arrayList.add(yl7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                ul7 ul7Var = new ul7();
                ul7Var.c(str);
                ul7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, ul7Var);
                } else {
                    arrayList.add(ul7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
