package com.baidu.tieba.newfaceshop.message;

import android.text.TextUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.newfaceshop.b.a;
import com.baidu.tieba.newfaceshop.b.b;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class GetFaceGroupInfoResponseMessage extends JsonHttpResponsedMessage {
    private a mData;

    public GetFaceGroupInfoResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mData = parseData(jSONObject);
        }
    }

    public a parseData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.id = jSONObject.optString("id");
        if (TextUtils.isEmpty(aVar.id)) {
            return null;
        }
        aVar.name = jSONObject.optString("name");
        aVar.type = jSONObject.optInt("type");
        aVar.authorId = jSONObject.optString("owner");
        aVar.authorName = jSONObject.optString("author");
        aVar.createTime = jSONObject.optString("timestamp");
        aVar.cover = jSONObject.optString("cover");
        aVar.covername = jSONObject.optString("covername");
        aVar.url = jSONObject.optString("url");
        aVar.pics = parsePicsData(jSONObject.optJSONArray(SocialConstants.PARAM_IMAGE));
        return aVar;
    }

    public List<b> parsePicsData(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                b bVar = new b();
                bVar.id = jSONObject.optString("id");
                bVar.url = jSONObject.optString("url");
                bVar.thumbnail = jSONObject.optString("thumbnail");
                bVar.name = jSONObject.optString("name");
                bVar.lwZ = jSONObject.optString("thumbname");
                bVar.width = jSONObject.optInt("width");
                bVar.height = jSONObject.optInt("height");
                arrayList.add(bVar);
            } catch (JSONException e) {
                e.printStackTrace();
                return arrayList;
            }
        }
        return arrayList;
    }

    public a getData() {
        return this.mData;
    }
}
