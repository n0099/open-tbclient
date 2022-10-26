package com.baidu.tieba;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
/* loaded from: classes4.dex */
public interface kc0 {
    void onNetResponse(NetResponse netResponse, Object obj);

    Object onParseResponseInBackground(NetResponse netResponse);
}
