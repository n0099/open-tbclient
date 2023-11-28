package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes8.dex */
public interface w60 {
    void O(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void R0(List<String> list);

    void h(int i);

    void hideLoading();

    void i();

    void i0(List<? extends LiveRoomEntity> list);

    void l(x60 x60Var);

    void m0();

    void p(List<String> list);

    void q(SearchResultBean searchResultBean);

    void showToast(String str);
}
