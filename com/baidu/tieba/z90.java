package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes7.dex */
public interface z90 {
    void E0();

    void Z0(List<String> list);

    void h0();

    void i0(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void k(int i);

    void m();

    void q(aa0 aa0Var);

    void showToast(String str);

    void t(List<String> list);

    void u(SearchResultBean searchResultBean);

    void z0(List<? extends LiveRoomEntity> list);
}
