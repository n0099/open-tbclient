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
public class us8 {
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
            List<RecommendForumInfo> list = dataRes.forum_cards;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null) {
                        qs8 qs8Var = new qs8();
                        qs8Var.k(list.get(i));
                        qs8Var.l(true);
                        arrayList.add(qs8Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    qs8 qs8Var2 = new qs8();
                    qs8Var2.k(recommendForumInfo);
                    qs8Var2.l(false);
                    arrayList.add(qs8Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                rs8 rs8Var = new rs8();
                rs8Var.h(item);
                arrayList.add(rs8Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                ss8 ss8Var = new ss8();
                ss8Var.m(str);
                ss8Var.l(sugLiveInfo);
                arrayList.add(ss8Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                ts8 ts8Var = new ts8();
                ts8Var.f(str);
                ts8Var.e(sugRankingInfo);
                arrayList.add(ts8Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                ps8 ps8Var = new ps8();
                ps8Var.c(str);
                ps8Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, ps8Var);
                } else {
                    arrayList.add(ps8Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
