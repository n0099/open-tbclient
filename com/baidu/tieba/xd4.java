package com.baidu.tieba;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
/* loaded from: classes9.dex */
public interface xd4<T> extends zd4 {
    void a(T t);

    void c(T t);

    String d(T t);

    void e(T t, af4 af4Var);

    void f(T t);

    af4 h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException;

    void i(T t);

    void j(T t);

    Map<String, Object> k();
}
