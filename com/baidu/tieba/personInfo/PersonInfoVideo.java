package com.baidu.tieba.personInfo;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class PersonInfoVideo implements Serializable {
    private static final long serialVersionUID = -1538103146882985197L;
    private String thumbnailUrl;

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void parserProtobuf(VideoInfo videoInfo) {
        if (videoInfo != null) {
            this.thumbnailUrl = videoInfo.thumbnail_url;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.thumbnailUrl = jSONObject.optString("thumbnail_url");
        }
    }
}
