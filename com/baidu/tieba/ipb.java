package com.baidu.tieba;

import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public interface ipb {
    String a(Object obj);

    <T> T b(String str, Class<T> cls);

    <T> T c(String str, Type type);
}
