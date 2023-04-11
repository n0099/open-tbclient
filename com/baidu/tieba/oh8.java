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
public class oh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<hn> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                kh8 kh8Var = new kh8();
                kh8Var.h(recommendForumInfo);
                arrayList.add(kh8Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                lh8 lh8Var = new lh8();
                lh8Var.h(item);
                arrayList.add(lh8Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                mh8 mh8Var = new mh8();
                mh8Var.m(str);
                mh8Var.l(sugLiveInfo);
                arrayList.add(mh8Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                nh8 nh8Var = new nh8();
                nh8Var.f(str);
                nh8Var.e(sugRankingInfo);
                arrayList.add(nh8Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                jh8 jh8Var = new jh8();
                jh8Var.c(str);
                jh8Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, jh8Var);
                } else {
                    arrayList.add(jh8Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
