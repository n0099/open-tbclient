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
public class x68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<gn> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                t68 t68Var = new t68();
                t68Var.i(recommendForumInfo);
                arrayList.add(t68Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                u68 u68Var = new u68();
                u68Var.i(item);
                arrayList.add(u68Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                v68 v68Var = new v68();
                v68Var.n(str);
                v68Var.m(sugLiveInfo);
                arrayList.add(v68Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                w68 w68Var = new w68();
                w68Var.h(str);
                w68Var.g(sugRankingInfo);
                arrayList.add(w68Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                s68 s68Var = new s68();
                s68Var.c(str);
                s68Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, s68Var);
                } else {
                    arrayList.add(s68Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
