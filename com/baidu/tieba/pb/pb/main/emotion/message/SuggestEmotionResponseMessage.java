package com.baidu.tieba.pb.pb.main.emotion.message;

import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import d.a.o0.e2.k.e.b1.e.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SuggestEmotionResponseMessage extends JsonHttpResponsedMessage {
    public a mData;

    public SuggestEmotionResponseMessage(int i2) {
        super(i2);
    }

    private List<String> parseHotWordsData(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    arrayList.add(jSONArray.getJSONObject(i2).optString("keyword"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private List<EmotionImageData> parseImageData(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int min = Math.min(jSONArray.length(), 10);
        for (int i2 = 0; i2 < min; i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
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

    private SingleBarEmotionRecommendData parseSingleForumRecommend(JSONObject jSONObject) {
        if (jSONObject != null) {
            SingleBarEmotionRecommendData singleBarEmotionRecommendData = new SingleBarEmotionRecommendData();
            singleBarEmotionRecommendData.pkg_id = jSONObject.optString(IntentConfig.PKG_ID);
            singleBarEmotionRecommendData.cover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            return singleBarEmotionRecommendData;
        }
        return null;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode != 200 || error != 0 || jSONObject == null || jSONObject == null) {
            return;
        }
        a aVar = new a();
        this.mData = aVar;
        aVar.d(parseImageData(jSONObject.optJSONArray("memes")));
        this.mData.e(parseHotWordsData(jSONObject.optJSONArray("topwords")));
        this.mData.f(parseSingleForumRecommend(jSONObject.optJSONObject("forum_pkg")));
    }

    public a getData() {
        return this.mData;
    }
}
