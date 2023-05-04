package com.baidu.tieba;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
/* loaded from: classes5.dex */
public interface of4<T> extends qf4 {
    void a(T t);

    void c(T t);

    String d(T t);

    void e(T t, rg4 rg4Var);

    void f(T t);

    rg4 h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException;

    void i(T t);

    void j(T t);

    Map<String, Object> k();
}
