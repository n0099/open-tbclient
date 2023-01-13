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
public class ot7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<yn> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                kt7 kt7Var = new kt7();
                kt7Var.i(recommendForumInfo);
                arrayList.add(kt7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                lt7 lt7Var = new lt7();
                lt7Var.i(item);
                arrayList.add(lt7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                mt7 mt7Var = new mt7();
                mt7Var.o(str);
                mt7Var.m(sugLiveInfo);
                arrayList.add(mt7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                nt7 nt7Var = new nt7();
                nt7Var.h(str);
                nt7Var.g(sugRankingInfo);
                arrayList.add(nt7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                jt7 jt7Var = new jt7();
                jt7Var.c(str);
                jt7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, jt7Var);
                } else {
                    arrayList.add(jt7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
