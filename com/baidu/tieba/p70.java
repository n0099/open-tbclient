package com.baidu.tieba;

import java.util.Map;
/* loaded from: classes7.dex */
public interface p70 {
    String getContentType();

    Map<String, String> getHeaders();

    String getHost();

    String getMethod();

    byte[] getRequestParameter();
}
