package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes7.dex */
public interface ri2 extends JSRuntime, fa2, TypedCallbackHandler {
    JsSerializeValue A(byte[] bArr, boolean z);

    byte[] K(JsSerializeValue jsSerializeValue, boolean z);

    void V(String str, String str2);

    ej2 b0();

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

    aj2 w();
}
