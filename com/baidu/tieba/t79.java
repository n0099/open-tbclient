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
/* loaded from: classes8.dex */
public class t79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<bn> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<RecommendForumInfo> list = dataRes.forum_cards;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null) {
                        p79 p79Var = new p79();
                        p79Var.i(list.get(i));
                        p79Var.l(true);
                        arrayList.add(p79Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    p79 p79Var2 = new p79();
                    p79Var2.i(recommendForumInfo);
                    p79Var2.l(false);
                    arrayList.add(p79Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                q79 q79Var = new q79();
                q79Var.g(item);
                arrayList.add(q79Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                r79 r79Var = new r79();
                r79Var.m(str);
                r79Var.l(sugLiveInfo);
                arrayList.add(r79Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                s79 s79Var = new s79();
                s79Var.f(str);
                s79Var.e(sugRankingInfo);
                arrayList.add(s79Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                o79 o79Var = new o79();
                o79Var.c(str);
                o79Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, o79Var);
                } else {
                    arrayList.add(o79Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
