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
public class nl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<wn> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                jl7 jl7Var = new jl7();
                jl7Var.j(recommendForumInfo);
                arrayList.add(jl7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                kl7 kl7Var = new kl7();
                kl7Var.j(item);
                arrayList.add(kl7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                ll7 ll7Var = new ll7();
                ll7Var.o(str);
                ll7Var.n(sugLiveInfo);
                arrayList.add(ll7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                ml7 ml7Var = new ml7();
                ml7Var.h(str);
                ml7Var.g(sugRankingInfo);
                arrayList.add(ml7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                il7 il7Var = new il7();
                il7Var.c(str);
                il7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, il7Var);
                } else {
                    arrayList.add(il7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
