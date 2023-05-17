package com.baidu.tieba;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface nm5 extends gm5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
