package com.baidu.tieba;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
/* loaded from: classes7.dex */
public interface rd0<T> {
    void onNetResponse(NetResponse netResponse, T t);

    T onParseResponseInBackground(NetResponse netResponse);
}
