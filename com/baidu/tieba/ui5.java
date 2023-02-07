package com.baidu.tieba;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface ui5 extends ni5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
