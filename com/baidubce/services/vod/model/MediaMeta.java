package com.baidubce.services.vod.model;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class MediaMeta {
    public Long durationInSeconds;
    public Long sizeInBytes;
    public Long sourceSizeInBytes;

    public static MediaMeta formatFromJson(JSONObject jSONObject) throws JSONException {
        MediaMeta mediaMeta = new MediaMeta();
        mediaMeta.setSourceSizeInBytes(Long.valueOf(jSONObject.optLong("sourceSizeInBytes")));
        mediaMeta.setSizeInBytes(Long.valueOf(jSONObject.optLong("sizeInBytes")));
        mediaMeta.setDurationInSeconds(Long.valueOf(jSONObject.optLong("durationInSeconds")));
        return mediaMeta;
    }

    public Long getDurationInSeconds() {
        return this.durationInSeconds;
    }

    public Long getSizeInBytes() {
        return this.sizeInBytes;
    }

    public Long getSourceSizeInBytes() {
        return this.sourceSizeInBytes;
    }

    public void setDurationInSeconds(Long l) {
        this.durationInSeconds = l;
    }

    public void setSizeInBytes(Long l) {
        this.sizeInBytes = l;
    }

    public void setSourceSizeInBytes(Long l) {
        this.sourceSizeInBytes = l;
    }

    public String toString() {
        return "MediaMeta { \n      sizeInBytes = " + this.sizeInBytes + "\n      durationInSeconds = " + this.durationInSeconds + "\n    }";
    }
}
