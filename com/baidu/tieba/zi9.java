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
/* loaded from: classes9.dex */
public class zi9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<pi> a(DataRes dataRes, String str) {
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
                        vi9 vi9Var = new vi9();
                        vi9Var.k(list.get(i));
                        vi9Var.l(true);
                        arrayList.add(vi9Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    vi9 vi9Var2 = new vi9();
                    vi9Var2.k(recommendForumInfo);
                    vi9Var2.l(false);
                    arrayList.add(vi9Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                wi9 wi9Var = new wi9();
                wi9Var.g(item);
                arrayList.add(wi9Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                xi9 xi9Var = new xi9();
                xi9Var.n(str);
                xi9Var.l(sugLiveInfo);
                arrayList.add(xi9Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                yi9 yi9Var = new yi9();
                yi9Var.f(str);
                yi9Var.e(sugRankingInfo);
                arrayList.add(yi9Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                ui9 ui9Var = new ui9();
                ui9Var.c(str);
                ui9Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, ui9Var);
                } else {
                    arrayList.add(ui9Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
