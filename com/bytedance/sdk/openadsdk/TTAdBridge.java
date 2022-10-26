package com.bytedance.sdk.openadsdk;

import android.os.Bundle;
import java.util.Map;
/* loaded from: classes7.dex */
public interface TTAdBridge {
    String call(int i, Bundle bundle);

    Object callMethod(Class cls, int i, Map map);

    Object getObj(Class cls);

    Object getObj(Class cls, int i, Map map);

    void init(Bundle bundle);

    void removeObj(Object obj);

    void setObj(Object obj);

    void subscribe(TTAdEvent tTAdEvent);

    void unsubscribe(TTAdEvent tTAdEvent);
}
