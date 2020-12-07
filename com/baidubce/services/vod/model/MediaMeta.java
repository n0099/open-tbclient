package com.baidubce.services.vod.model;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class MediaMeta {
    private Long durationInSeconds;
    private Long sizeInBytes;
    private Long sourceSizeInBytes;

    public Long getSourceSizeInBytes() {
        return this.sourceSizeInBytes;
    }

    public void setSourceSizeInBytes(Long l) {
        this.sourceSizeInBytes = l;
    }

    public Long getSizeInBytes() {
        return this.sizeInBytes;
    }

    public void setSizeInBytes(Long l) {
        this.sizeInBytes = l;
    }

    public Long getDurationInSeconds() {
        return this.durationInSeconds;
    }

    public void setDurationInSeconds(Long l) {
        this.durationInSeconds = l;
    }

    public static MediaMeta formatFromJson(JSONObject jSONObject) throws JSONException {
        MediaMeta mediaMeta = new MediaMeta();
        mediaMeta.setSourceSizeInBytes(Long.valueOf(jSONObject.optLong("sourceSizeInBytes")));
        mediaMeta.setSizeInBytes(Long.valueOf(jSONObject.optLong("sizeInBytes")));
        mediaMeta.setDurationInSeconds(Long.valueOf(jSONObject.optLong("durationInSeconds")));
        return mediaMeta;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MediaMeta { \n");
        sb.append("      sizeInBytes = ").append(this.sizeInBytes).append("\n");
        sb.append("      durationInSeconds = ").append(this.durationInSeconds).append("\n");
        sb.append("    }");
        return sb.toString();
    }
}
