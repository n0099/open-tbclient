package com.baidu.tieba;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface kk5 extends dk5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
