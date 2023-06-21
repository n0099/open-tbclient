package com.baidu.tieba;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public interface v70 extends Closeable {
    void disconnect();

    int getCode() throws IOException;

    Map<String, List<String>> getHeaders() throws IOException;

    InputStream getInputStream() throws IOException;

    String getMessage() throws IOException;

    InputStream t() throws IOException;

    void u(int i);

    int v();
}
