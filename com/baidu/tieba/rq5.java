package com.baidu.tieba;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface rq5 extends kq5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
