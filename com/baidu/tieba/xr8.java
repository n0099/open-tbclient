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
public class xr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<vn> a(DataRes dataRes, String str) {
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
                        tr8 tr8Var = new tr8();
                        tr8Var.k(list.get(i));
                        tr8Var.l(true);
                        arrayList.add(tr8Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    tr8 tr8Var2 = new tr8();
                    tr8Var2.k(recommendForumInfo);
                    tr8Var2.l(false);
                    arrayList.add(tr8Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                ur8 ur8Var = new ur8();
                ur8Var.h(item);
                arrayList.add(ur8Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                vr8 vr8Var = new vr8();
                vr8Var.m(str);
                vr8Var.l(sugLiveInfo);
                arrayList.add(vr8Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                wr8 wr8Var = new wr8();
                wr8Var.f(str);
                wr8Var.e(sugRankingInfo);
                arrayList.add(wr8Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                sr8 sr8Var = new sr8();
                sr8Var.c(str);
                sr8Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, sr8Var);
                } else {
                    arrayList.add(sr8Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
