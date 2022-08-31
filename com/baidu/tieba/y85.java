package com.baidu.tieba;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface y85 extends r85 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
