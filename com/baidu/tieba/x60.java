package com.baidu.tieba;

import java.util.Map;
/* loaded from: classes6.dex */
public interface x60 {
    String getContentType();

    Map<String, String> getHeaders();

    String getHost();

    String getMethod();

    byte[] getRequestParameter();
}
