package com.baidu.yuyinala.privatemessage.model.response;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.yuyinala.privatemessage.session.b.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class NickNameListResponse extends JsonHttpResponsedMessage {
    public List<f> pcA;

    public NickNameListResponse() {
        super(1031060);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Iterator<String> keys;
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null && getError() == 0) {
            this.pcA = new ArrayList();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("list");
            if (optJSONObject2 != null && (keys = optJSONObject2.keys()) != null) {
                while (keys.hasNext()) {
                    f fVar = new f();
                    fVar.uk = keys.next();
                    if (optJSONObject2.opt(fVar.uk) != null) {
                        JSONObject jSONObject2 = (JSONObject) optJSONObject2.opt(fVar.uk);
                        if (jSONObject2 != null) {
                            fVar.pdE = jSONObject2.getInt(ImageViewerConfig.IS_BJH);
                            fVar.type = jSONObject2.optString("type");
                            fVar.user_nickname = jSONObject2.optString("user_nickname");
                            fVar.bd_portrait = jSONObject2.optString("bd_portrait");
                        }
                        this.pcA.add(fVar);
                    }
                }
            }
        }
    }
}
