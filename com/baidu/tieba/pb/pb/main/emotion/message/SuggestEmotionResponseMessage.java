package com.baidu.tieba.pb.pb.main.emotion.message;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import com.baidu.tieba.pb.pb.main.emotion.a.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class SuggestEmotionResponseMessage extends JsonHttpResponsedMessage {
    private a mData;

    public SuggestEmotionResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null && jSONObject != null) {
            this.mData = new a();
            this.mData.cP(parseImageData(jSONObject.optJSONArray("memes")));
            this.mData.fg(parseHotWordsData(jSONObject.optJSONArray("topwords")));
            this.mData.a(parseSingleForumRecommend(jSONObject.optJSONObject("forum_pkg")));
        }
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
            } catch (JSONException e) {
                e.printStackTrace();
                return arrayList;
            }
        }
        return arrayList;
    }

    private List<String> parseHotWordsData(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(jSONArray.getJSONObject(i).optString("keyword"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private SingleBarEmotionRecommendData parseSingleForumRecommend(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SingleBarEmotionRecommendData singleBarEmotionRecommendData = new SingleBarEmotionRecommendData();
        singleBarEmotionRecommendData.pkg_id = jSONObject.optString("pkg_id");
        singleBarEmotionRecommendData.cover = jSONObject.optString("cover");
        return singleBarEmotionRecommendData;
    }

    public a getData() {
        return this.mData;
    }
}
