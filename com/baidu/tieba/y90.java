package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes7.dex */
public interface y90 {
    void D0();

    void b1(List<String> list);

    void g0();

    void h0(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void l(int i);

    void n();

    void q(z90 z90Var);

    void showToast(String str);

    void t(List<String> list);

    void u(SearchResultBean searchResultBean);

    void y0(List<? extends LiveRoomEntity> list);
}
