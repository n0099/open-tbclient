package com.baidu.tieba.newfaceshop.message;

import android.text.TextUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.newfaceshop.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class GetCloudFaceGroupMessage extends JsonHttpResponsedMessage {
    private List<CollectEmotionData> mCollectEmotionList;
    private long mCollectUpdateTime;
    private List<String> mFaceGroupData;
    private long mFaceGroupUpdateTime;

    public GetCloudFaceGroupMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            parseData(jSONObject.optJSONObject("data"));
        }
    }

    public void parseData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mCollectUpdateTime = jSONObject.optLong("pic_update_time");
            if (d.getCollectUpdateTime() < this.mCollectUpdateTime) {
                parseCollectData(jSONObject.optJSONArray("pic_ids"));
            }
            this.mFaceGroupUpdateTime = jSONObject.optLong("pkg_update_time");
            if (d.getFaceGroupUpdateTime() < this.mFaceGroupUpdateTime) {
                parseFaceGroupData(jSONObject.optString("package_ids"));
            }
        }
    }

    public void parseCollectData(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.mCollectEmotionList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        CollectEmotionData collectEmotionData = new CollectEmotionData();
                        collectEmotionData.pid = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
                        collectEmotionData.picUrl = jSONObject.optString("pic_url");
                        collectEmotionData.width = jSONObject.optInt("width");
                        collectEmotionData.height = jSONObject.optInt("height");
                        collectEmotionData.thumbnail = jSONObject.optString("thumbnail");
                        collectEmotionData.uid = TbadkApplication.getCurrentAccount();
                        collectEmotionData.pkgId = jSONObject.optString("pck_id");
                        StringBuilder sb = new StringBuilder(com.baidu.tbadk.imageManager.d.SHARP_TEXT_PREFIX_SHORT);
                        if (TextUtils.isEmpty(collectEmotionData.pkgId)) {
                            sb.append(collectEmotionData.pkgId).append(",");
                        } else {
                            sb.append(collectEmotionData.pkgId).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(collectEmotionData.pid).append(",");
                        }
                        sb.append(collectEmotionData.width).append(",");
                        sb.append(collectEmotionData.height).append(",");
                        collectEmotionData.sharpText = "#(" + sb.toString() + s.toMd5(sb.toString().replace("collect_", "") + "7S6wbXjEKL9N").toLowerCase() + ")";
                        this.mCollectEmotionList.add(collectEmotionData);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void parseFaceGroupData(String str) {
        this.mFaceGroupData = Arrays.asList(str.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS));
    }

    public long getCollectUpdateTime() {
        return this.mCollectUpdateTime;
    }

    public long getFaceGroupUpdateTime() {
        return this.mFaceGroupUpdateTime;
    }

    public void setCollectEmotionList(List<CollectEmotionData> list) {
        this.mCollectEmotionList = list;
    }

    public void setFaceGroupData(List<String> list) {
        this.mFaceGroupData = list;
    }

    public List<String> getFaceGroupData() {
        return this.mFaceGroupData;
    }

    public List<CollectEmotionData> getCollectEmotionList() {
        return this.mCollectEmotionList;
    }
}
