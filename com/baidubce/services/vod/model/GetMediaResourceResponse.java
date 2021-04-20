package com.baidubce.services.vod.model;

import com.alipay.sdk.util.e;
import com.baidubce.model.AbstractBceResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetMediaResourceResponse extends AbstractBceResponse {
    public Attributes attributes;
    public String createTime;
    public VodError error;
    public String mediaId;
    public MediaMeta meta;
    public String publishTime;
    public String source;
    public String status;
    public String transcodingPresetGroupName;
    public List<PlayableUrl> playableUrlList = new ArrayList();
    public List<String> thumbnailList = new ArrayList();

    public static void formatJsonToObject(JSONObject jSONObject, GetMediaResourceResponse getMediaResourceResponse) {
        try {
            getMediaResourceResponse.setMediaId(jSONObject.getString("mediaId"));
            getMediaResourceResponse.setStatus(jSONObject.getString("status"));
            getMediaResourceResponse.setAttributes(Attributes.formatFromJson(jSONObject.getJSONObject("attributes")));
            getMediaResourceResponse.setMeta(MediaMeta.formatFromJson(jSONObject.getJSONObject("meta")));
            if (getMediaResourceResponse.getStatus().equalsIgnoreCase(e.f1994a)) {
                getMediaResourceResponse.setError(VodError.formatFromJson(jSONObject.getJSONObject("error")));
            }
            getMediaResourceResponse.setPublishTime(jSONObject.optString("publishTime"));
            getMediaResourceResponse.setCreateTime(jSONObject.getString("createTime"));
            getMediaResourceResponse.setTranscodingPresetGroupName(jSONObject.getString("transcodingPresetGroupName"));
            JSONArray optJSONArray = jSONObject.optJSONArray("playableUrlList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(PlayableUrl.formatFromJson(optJSONArray.getJSONObject(i)));
                }
                getMediaResourceResponse.setPlayableUrlList(arrayList);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("thumbnailList");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                arrayList2.add(optJSONArray2.getString(i2));
            }
            getMediaResourceResponse.setThumbnailList(arrayList2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public VodError getError() {
        return this.error;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public MediaMeta getMeta() {
        return this.meta;
    }

    public List<PlayableUrl> getPlayableUrlList() {
        return this.playableUrlList;
    }

    public String getPublishTime() {
        return this.publishTime;
    }

    public String getSource() {
        return this.source;
    }

    public String getStatus() {
        return this.status;
    }

    public List<String> getThumbnailList() {
        return this.thumbnailList;
    }

    public String getTranscodingPresetGroupName() {
        return this.transcodingPresetGroupName;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setError(VodError vodError) {
        this.error = vodError;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setMeta(MediaMeta mediaMeta) {
        this.meta = mediaMeta;
    }

    public void setPlayableUrlList(List<PlayableUrl> list) {
        this.playableUrlList = list;
    }

    public void setPublishTime(String str) {
        this.publishTime = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setThumbnailList(List<String> list) {
        this.thumbnailList = list;
    }

    public void setTranscodingPresetGroupName(String str) {
        this.transcodingPresetGroupName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetMediaResourceResponse { \n");
        sb.append("  mediaId = ");
        sb.append(this.mediaId);
        sb.append("\n");
        sb.append("  status = ");
        sb.append(this.status);
        sb.append("\n");
        sb.append("  attributes = ");
        sb.append(this.attributes);
        sb.append("\n");
        sb.append("  meta = ");
        sb.append(this.meta);
        sb.append("\n");
        sb.append("  createTime = ");
        sb.append(this.createTime);
        sb.append("\n");
        sb.append("  publishTime = ");
        sb.append(this.publishTime);
        sb.append("\n");
        sb.append("  transcodingPresetGroupName = ");
        sb.append(this.transcodingPresetGroupName);
        sb.append("\n");
        sb.append("  source = ");
        sb.append(this.source);
        sb.append("\n");
        sb.append("  playableUrlList = [");
        sb.append("\n");
        for (PlayableUrl playableUrl : this.playableUrlList) {
            sb.append(playableUrl.toString());
            sb.append("\n");
        }
        sb.append("] \n");
        sb.append("  thumbnailList = [");
        sb.append("\n");
        for (String str : this.thumbnailList) {
            sb.append("    thumbnail =");
            sb.append(str);
            sb.append("\n");
        }
        VodError vodError = this.error;
        if (vodError != null) {
            sb.append(vodError);
            sb.append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
