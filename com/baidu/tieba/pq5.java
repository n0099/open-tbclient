package com.baidu.tieba;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface pq5 extends iq5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
