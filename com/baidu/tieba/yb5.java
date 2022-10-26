package com.baidu.tieba;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface yb5 extends rb5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
