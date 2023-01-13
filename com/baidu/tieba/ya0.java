package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes7.dex */
public interface ya0 {
    void K();

    void M(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void b(int i);

    void e();

    void h0(List<? extends LiveRoomEntity> list);

    void j(za0 za0Var);

    void l(List<String> list);

    void l0();

    void n(SearchResultBean searchResultBean);

    void showToast(String str);

    void z0(List<String> list);
}
