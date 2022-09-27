package com.baidu.tieba;

import java.util.List;
/* loaded from: classes6.dex */
public interface uc5 {
    String getCurrentPageKey();

    List<String> getCurrentPageSourceKeyList();

    List<String> getNextPageSourceKeyList();

    vc5 getPageStayFilter();
}
