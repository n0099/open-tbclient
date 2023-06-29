package com.baidu.tieba;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
/* loaded from: classes8.dex */
public interface vd0<T> {
    void onNetResponse(NetResponse netResponse, T t);

    T onParseResponseInBackground(NetResponse netResponse);
}
