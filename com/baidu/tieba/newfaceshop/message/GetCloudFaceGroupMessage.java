package com.baidu.tieba.newfaceshop.message;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.faceshop.CollectEmotionData;
import d.a.c.e.p.q;
import d.a.m0.a0.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetCloudFaceGroupMessage extends JsonHttpResponsedMessage {
    public List<CollectEmotionData> mCollectEmotionList;
    public long mCollectUpdateTime;
    public List<String> mFaceGroupData;
    public long mFaceGroupUpdateTime;

    public GetCloudFaceGroupMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            parseData(jSONObject.optJSONObject("data"));
        }
    }

    public List<CollectEmotionData> getCollectEmotionList() {
        return this.mCollectEmotionList;
    }

    public long getCollectUpdateTime() {
        return this.mCollectUpdateTime;
    }

    public List<String> getFaceGroupData() {
        return this.mFaceGroupData;
    }

    public long getFaceGroupUpdateTime() {
        return this.mFaceGroupUpdateTime;
    }

    public void parseCollectData(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.mCollectEmotionList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject != null) {
                    CollectEmotionData collectEmotionData = new CollectEmotionData();
                    collectEmotionData.pid = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
                    collectEmotionData.picUrl = jSONObject.optString("pic_url");
                    collectEmotionData.width = jSONObject.optInt("width");
                    collectEmotionData.height = jSONObject.optInt("height");
                    collectEmotionData.thumbnail = jSONObject.optString("thumbnail");
                    collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
                    collectEmotionData.pkgId = jSONObject.optString("pck_id");
                    StringBuilder sb = new StringBuilder(d.f52492f);
                    if (TextUtils.isEmpty(collectEmotionData.pkgId)) {
                        sb.append(collectEmotionData.pkgId);
                        sb.append(",");
                    } else {
                        sb.append(collectEmotionData.pkgId);
                        sb.append("_");
                        sb.append(collectEmotionData.pid);
                        sb.append(",");
                    }
                    sb.append(collectEmotionData.width);
                    sb.append(",");
                    sb.append(collectEmotionData.height);
                    sb.append(",");
                    String lowerCase = q.c(sb.toString().replace("collect_", "") + "7S6wbXjEKL9N").toLowerCase();
                    collectEmotionData.sharpText = SmallTailInfo.EMOTION_PREFIX + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX;
                    this.mCollectEmotionList.add(collectEmotionData);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void parseData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mCollectUpdateTime = jSONObject.optLong("pic_update_time");
        if (d.a.n0.z1.d.k() < this.mCollectUpdateTime) {
            parseCollectData(jSONObject.optJSONArray("pic_ids"));
        }
        this.mFaceGroupUpdateTime = jSONObject.optLong("pkg_update_time");
        if (d.a.n0.z1.d.l() < this.mFaceGroupUpdateTime) {
            parseFaceGroupData(jSONObject.optString("package_ids"));
        }
    }

    public void parseFaceGroupData(String str) {
        this.mFaceGroupData = Arrays.asList(str.split("_"));
    }

    public void setCollectEmotionList(List<CollectEmotionData> list) {
        this.mCollectEmotionList = list;
    }

    public void setFaceGroupData(List<String> list) {
        this.mFaceGroupData = list;
    }
}
