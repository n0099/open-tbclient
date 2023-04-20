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
public class wh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<in> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                sh8 sh8Var = new sh8();
                sh8Var.h(recommendForumInfo);
                arrayList.add(sh8Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                th8 th8Var = new th8();
                th8Var.h(item);
                arrayList.add(th8Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                uh8 uh8Var = new uh8();
                uh8Var.m(str);
                uh8Var.l(sugLiveInfo);
                arrayList.add(uh8Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                vh8 vh8Var = new vh8();
                vh8Var.f(str);
                vh8Var.e(sugRankingInfo);
                arrayList.add(vh8Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                rh8 rh8Var = new rh8();
                rh8Var.c(str);
                rh8Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, rh8Var);
                } else {
                    arrayList.add(rh8Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
