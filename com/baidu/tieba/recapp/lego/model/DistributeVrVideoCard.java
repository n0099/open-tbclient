package com.baidu.tieba.recapp.lego.model;

import android.text.TextUtils;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class DistributeVrVideoCard extends BaseLegoCardInfo {
    private final a videoInfo;

    /* loaded from: classes13.dex */
    public static class a {
        public String hYj;
        public boolean hYl;
        public int playCount;
        public int thumbHeight;
        public String thumbUrl;
        public int thumbWidth;
        public int videoDuration;
        public int videoHeight;
        public int videoLength;
        public String videoUrl;
        public int videoWidth;
    }

    public DistributeVrVideoCard(JSONObject jSONObject) {
        super(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("video_md5");
            String optString2 = optJSONObject.optString("video_url");
            int optInt = optJSONObject.optInt("video_duration");
            int optInt2 = optJSONObject.optInt("video_width");
            int optInt3 = optJSONObject.optInt("video_height");
            String optString3 = optJSONObject.optString(AsyncChatTask.THUMB_URL);
            int optInt4 = optJSONObject.optInt("thumb_width");
            int optInt5 = optJSONObject.optInt("thumb_height");
            int optInt6 = optJSONObject.optInt("video_length");
            int optInt7 = optJSONObject.optInt("play_count");
            boolean z = optJSONObject.optInt("show_progress", 1) == 1;
            if (optInt > 0 && !TextUtils.isEmpty(optString2)) {
                this.videoInfo = new a();
                this.videoInfo.hYj = optString;
                this.videoInfo.videoUrl = optString2;
                this.videoInfo.videoDuration = optInt;
                this.videoInfo.videoWidth = optInt2;
                this.videoInfo.videoHeight = optInt3;
                this.videoInfo.thumbUrl = optString3;
                this.videoInfo.thumbWidth = optInt4;
                this.videoInfo.thumbHeight = optInt5;
                this.videoInfo.videoLength = optInt6;
                this.videoInfo.playCount = optInt7;
                this.videoInfo.hYl = z;
                return;
            }
            this.videoInfo = null;
            return;
        }
        this.videoInfo = null;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        return false;
    }

    public a getVideoInfo() {
        return this.videoInfo;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return 1.78d;
    }
}
