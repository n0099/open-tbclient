package com.baidu.tieba;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
/* loaded from: classes5.dex */
public interface ob0<T> {
    void onNetResponse(NetResponse netResponse, T t);

    T onParseResponseInBackground(NetResponse netResponse);
}
