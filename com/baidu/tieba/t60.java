package com.baidu.tieba;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public interface t60 extends Closeable {
    void disconnect();

    int getCode() throws IOException;

    Map<String, List<String>> getHeaders() throws IOException;

    InputStream getInputStream() throws IOException;

    String getMessage() throws IOException;

    InputStream q() throws IOException;

    void t(int i);

    int u();
}
