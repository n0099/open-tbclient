package com.baidu.tieba;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
/* loaded from: classes5.dex */
public interface p84<T> extends r84 {
    void a(T t);

    void c(T t);

    String d(T t);

    void e(T t, s94 s94Var);

    void f(T t);

    s94 h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException;

    void i(T t);

    void j(T t);

    Map<String, Object> k();
}
