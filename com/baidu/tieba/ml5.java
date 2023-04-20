package com.baidu.tieba;

import java.util.List;
/* loaded from: classes5.dex */
public interface ml5 {
    String getCurrentPageKey();

    List<String> getCurrentPageSourceKeyList();

    List<String> getNextPageSourceKeyList();

    nl5 getPageStayFilter();
}
