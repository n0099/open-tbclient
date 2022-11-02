package com.baidu.tieba;

import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes5.dex */
public interface md {
    Set<String> getKeys();

    Object getObjectByType(String str, Type type);

    void set(String str, Object obj);
}
