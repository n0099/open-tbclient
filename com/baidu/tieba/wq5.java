package com.baidu.tieba;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface wq5 extends pq5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
