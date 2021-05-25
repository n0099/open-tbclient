package com.baidu.tieba.newfaceshop.message;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.tencent.open.SocialConstants;
import d.a.n0.z1.f.a;
import d.a.n0.z1.f.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetFaceGroupInfoResponseMessage extends JsonHttpResponsedMessage {
    public a mData;

    public GetFaceGroupInfoResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mData = parseData(jSONObject);
        }
    }

    public a getData() {
        return this.mData;
    }

    public a parseData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        String optString = jSONObject.optString("id");
        aVar.f63637a = optString;
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        aVar.f63638b = jSONObject.optString("name");
        jSONObject.optInt("type");
        jSONObject.optString("owner");
        jSONObject.optString(NotificationCompat.CarExtender.KEY_AUTHOR);
        jSONObject.optString("timestamp");
        jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
        aVar.f63639c = jSONObject.optString("covername");
        aVar.f63640d = jSONObject.optString("url");
        aVar.f63641e = parsePicsData(jSONObject.optJSONArray(SocialConstants.PARAM_IMAGE));
        return aVar;
    }

    public List<b> parsePicsData(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                b bVar = new b();
                bVar.f63643f = jSONObject.optString("id");
                jSONObject.optString("url");
                jSONObject.optString("thumbnail");
                bVar.f63644g = jSONObject.optString("name");
                bVar.f63645h = jSONObject.optString("thumbname");
                bVar.j = jSONObject.optInt("width");
                bVar.f63646i = jSONObject.optInt("height");
                arrayList.add(bVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }
}
