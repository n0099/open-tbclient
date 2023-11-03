package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes8.dex */
public interface v60 {
    void O(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void R0(List<String> list);

    void h(int i);

    void hideLoading();

    void i();

    void j0(List<? extends LiveRoomEntity> list);

    void n(w60 w60Var);

    void p(List<String> list);

    void q(SearchResultBean searchResultBean);

    void r0();

    void showToast(String str);
}
