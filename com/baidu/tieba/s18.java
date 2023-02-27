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
public class s18 {
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
                o18 o18Var = new o18();
                o18Var.i(recommendForumInfo);
                arrayList.add(o18Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                p18 p18Var = new p18();
                p18Var.i(item);
                arrayList.add(p18Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                q18 q18Var = new q18();
                q18Var.n(str);
                q18Var.m(sugLiveInfo);
                arrayList.add(q18Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                r18 r18Var = new r18();
                r18Var.h(str);
                r18Var.g(sugRankingInfo);
                arrayList.add(r18Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                n18 n18Var = new n18();
                n18Var.c(str);
                n18Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, n18Var);
                } else {
                    arrayList.add(n18Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
