package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes7.dex */
public interface qd2 extends JSRuntime, e52, TypedCallbackHandler {
    byte[] G(JsSerializeValue jsSerializeValue, boolean z);

    void X(String str, String str2);

    de2 a0();

    boolean dispatchEvent(JSEvent jSEvent);

    String getInitBasePath();

    int getInvokeSourceType();

    EventTarget m();

    boolean post(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void postOnJSThread(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);

    EventTarget v();

    zd2 w();

    JsSerializeValue z(byte[] bArr, boolean z);
}
