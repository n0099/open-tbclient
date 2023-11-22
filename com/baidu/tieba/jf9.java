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
public class jf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<oi> a(DataRes dataRes, String str) {
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
                        ff9 ff9Var = new ff9();
                        ff9Var.i(list.get(i));
                        ff9Var.l(true);
                        arrayList.add(ff9Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    ff9 ff9Var2 = new ff9();
                    ff9Var2.i(recommendForumInfo);
                    ff9Var2.l(false);
                    arrayList.add(ff9Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                gf9 gf9Var = new gf9();
                gf9Var.g(item);
                arrayList.add(gf9Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                hf9 hf9Var = new hf9();
                hf9Var.n(str);
                hf9Var.l(sugLiveInfo);
                arrayList.add(hf9Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                if9 if9Var = new if9();
                if9Var.f(str);
                if9Var.e(sugRankingInfo);
                arrayList.add(if9Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                ef9 ef9Var = new ef9();
                ef9Var.c(str);
                ef9Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, ef9Var);
                } else {
                    arrayList.add(ef9Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
