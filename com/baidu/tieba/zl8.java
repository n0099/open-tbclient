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
public class zl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<rn> a(DataRes dataRes, String str) {
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
                        vl8 vl8Var = new vl8();
                        vl8Var.k(list.get(i));
                        vl8Var.l(true);
                        arrayList.add(vl8Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    vl8 vl8Var2 = new vl8();
                    vl8Var2.k(recommendForumInfo);
                    vl8Var2.l(false);
                    arrayList.add(vl8Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                wl8 wl8Var = new wl8();
                wl8Var.h(item);
                arrayList.add(wl8Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                xl8 xl8Var = new xl8();
                xl8Var.m(str);
                xl8Var.l(sugLiveInfo);
                arrayList.add(xl8Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                yl8 yl8Var = new yl8();
                yl8Var.f(str);
                yl8Var.e(sugRankingInfo);
                arrayList.add(yl8Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                ul8 ul8Var = new ul8();
                ul8Var.c(str);
                ul8Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, ul8Var);
                } else {
                    arrayList.add(ul8Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
