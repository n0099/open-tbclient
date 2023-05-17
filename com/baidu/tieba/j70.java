package com.baidu.tieba;

import java.util.Map;
/* loaded from: classes6.dex */
public interface j70 {
    String getContentType();

    Map<String, String> getHeaders();

    String getHost();

    String getMethod();

    byte[] getRequestParameter();
}
