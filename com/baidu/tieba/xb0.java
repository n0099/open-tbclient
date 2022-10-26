package com.baidu.tieba;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public interface xb0 {
    void onNetResponse(NetResponse netResponse, Object obj, Map map, List list);

    Object onParseResponseInBackground(NetResponse netResponse);
}
