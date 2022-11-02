package com.baidu.tieba;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
/* loaded from: classes6.dex */
public interface vb4<T> extends xb4 {
    void a(T t);

    void c(T t);

    String d(T t);

    void e(T t, yc4 yc4Var);

    void f(T t);

    yc4 h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException;

    void i(T t);

    void j(T t);

    Map<String, Object> k();
}
