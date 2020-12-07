package com.baidubce.services.vod.model;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidubce.model.AbstractBceResponse;
import com.coremedia.iso.boxes.MetaBox;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class GetMediaResourceResponse extends AbstractBceResponse {
    private Attributes attributes;
    private String createTime;
    private VodError error;
    private String mediaId;
    private MediaMeta meta;
    private String publishTime;
    private String source;
    private String status;
    private String transcodingPresetGroupName;
    private List<PlayableUrl> playableUrlList = new ArrayList();
    private List<String> thumbnailList = new ArrayList();

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public MediaMeta getMeta() {
        return this.meta;
    }

    public void setMeta(MediaMeta mediaMeta) {
        this.meta = mediaMeta;
    }

    public String getPublishTime() {
        return this.publishTime;
    }

    public void setPublishTime(String str) {
        this.publishTime = str;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public VodError getError() {
        return this.error;
    }

    public void setError(VodError vodError) {
        this.error = vodError;
    }

    public String getTranscodingPresetGroupName() {
        return this.transcodingPresetGroupName;
    }

    public void setTranscodingPresetGroupName(String str) {
        this.transcodingPresetGroupName = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public List<PlayableUrl> getPlayableUrlList() {
        return this.playableUrlList;
    }

    public void setPlayableUrlList(List<PlayableUrl> list) {
        this.playableUrlList = list;
    }

    public List<String> getThumbnailList() {
        return this.thumbnailList;
    }

    public void setThumbnailList(List<String> list) {
        this.thumbnailList = list;
    }

    public static void formatJsonToObject(JSONObject jSONObject, GetMediaResourceResponse getMediaResourceResponse) {
        try {
            getMediaResourceResponse.setMediaId(jSONObject.getString("mediaId"));
            getMediaResourceResponse.setStatus(jSONObject.getString("status"));
            getMediaResourceResponse.setAttributes(Attributes.formatFromJson(jSONObject.getJSONObject("attributes")));
            getMediaResourceResponse.setMeta(MediaMeta.formatFromJson(jSONObject.getJSONObject(MetaBox.TYPE)));
            if (getMediaResourceResponse.getStatus().equalsIgnoreCase("failed")) {
                getMediaResourceResponse.setError(VodError.formatFromJson(jSONObject.getJSONObject(BdStatsConstant.StatsType.ERROR)));
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
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    arrayList2.add(optJSONArray2.getString(i2));
                }
                getMediaResourceResponse.setThumbnailList(arrayList2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetMediaResourceResponse { \n");
        sb.append("  mediaId = ").append(this.mediaId).append("\n");
        sb.append("  status = ").append(this.status).append("\n");
        sb.append("  attributes = ").append(this.attributes).append("\n");
        sb.append("  meta = ").append(this.meta).append("\n");
        sb.append("  createTime = ").append(this.createTime).append("\n");
        sb.append("  publishTime = ").append(this.publishTime).append("\n");
        sb.append("  transcodingPresetGroupName = ").append(this.transcodingPresetGroupName).append("\n");
        sb.append("  source = ").append(this.source).append("\n");
        sb.append("  playableUrlList = [").append("\n");
        for (PlayableUrl playableUrl : this.playableUrlList) {
            sb.append(playableUrl.toString()).append("\n");
        }
        sb.append("] \n");
        sb.append("  thumbnailList = [").append("\n");
        for (String str : this.thumbnailList) {
            sb.append("    thumbnail =").append(str).append("\n");
        }
        if (this.error != null) {
            sb.append(this.error).append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
