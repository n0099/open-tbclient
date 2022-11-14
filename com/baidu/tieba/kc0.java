package com.baidu.tieba;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
/* loaded from: classes4.dex */
public interface kc0<T> {
    void onNetResponse(NetResponse netResponse, T t);

    T onParseResponseInBackground(NetResponse netResponse);
}
