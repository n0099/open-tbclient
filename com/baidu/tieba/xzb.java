package com.baidu.tieba;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes8.dex */
public interface xzb {
    xzb a();

    boolean b(String str);

    void c(Framedata framedata);

    String d();

    boolean e(String str);

    void f(Framedata framedata) throws InvalidDataException;

    String g();

    void h(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
