package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes6.dex */
public interface ta0 {
    void K();

    void M(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void b(int i);

    void e();

    void g0(List<? extends LiveRoomEntity> list);

    void j(ua0 ua0Var);

    void k0();

    void l(List<String> list);

    void n(SearchResultBean searchResultBean);

    void showToast(String str);

    void x0(List<String> list);
}
