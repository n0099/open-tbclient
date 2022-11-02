package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes5.dex */
public interface ob2 extends JSRuntime, c32, TypedCallbackHandler {
    JsSerializeValue B(byte[] bArr, boolean z);

    byte[] J(JsSerializeValue jsSerializeValue, boolean z);

    void Z(String str, String str2);

    bc2 d0();

    boolean dispatchEvent(JSEvent jSEvent);

    String getInitBasePath();

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    int getInvokeSourceType();

    EventTarget n();

    boolean post(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void postOnJSThread(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);

    EventTarget x();

    xb2 y();
}
