package com.baidu.tieba.pb.pb.main.emotion.message;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.face.data.EmotionImageData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class QueryMatchEmotionResponseMessage extends JsonHttpResponsedMessage {
    public List<EmotionImageData> mData;

    public QueryMatchEmotionResponseMessage(int i) {
        super(i);
    }

    private List<EmotionImageData> parseImageData(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int min = Math.min(jSONArray.length(), 10);
        for (int i = 0; i < min; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                EmotionImageData emotionImageData = new EmotionImageData();
                emotionImageData.setPicId(jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY));
                emotionImageData.setPicUrl(jSONObject.optString("pic_url"));
                emotionImageData.setThumbUrl(jSONObject.optString("thumbnail"));
                emotionImageData.setWidth(jSONObject.optInt("width"));
                emotionImageData.setHeight(jSONObject.optInt("height"));
                emotionImageData.setMemeContSign(jSONObject.optString("cont_sign"));
                arrayList.add(emotionImageData);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode != 200 || error != 0 || jSONObject == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        this.mData = parseImageData(optJSONObject.optJSONArray("memes"));
    }

    public List<EmotionImageData> getData() {
        return this.mData;
    }
}
