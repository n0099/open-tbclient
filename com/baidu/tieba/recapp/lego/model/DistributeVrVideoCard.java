package com.baidu.tieba.recapp.lego.model;

import android.text.TextUtils;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DistributeVrVideoCard extends BaseLegoCardInfo {
    private final a videoInfo;

    /* loaded from: classes3.dex */
    public static class a {
        public int cML;
        public int eIH;
        public int heA;
        public int heB;
        public boolean heD;
        public String hez;
        public String thumbUrl;
        public int videoDuration;
        public int videoHeight;
        public String videoUrl;
        public int videoWidth;
    }

    public DistributeVrVideoCard(JSONObject jSONObject) {
        super(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("video_md5");
            String optString2 = optJSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
            int optInt = optJSONObject.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
            int optInt2 = optJSONObject.optInt("video_width");
            int optInt3 = optJSONObject.optInt("video_height");
            String optString3 = optJSONObject.optString("thumb_url");
            int optInt4 = optJSONObject.optInt("thumb_width");
            int optInt5 = optJSONObject.optInt("thumb_height");
            int optInt6 = optJSONObject.optInt("video_length");
            int optInt7 = optJSONObject.optInt("play_count");
            boolean z = optJSONObject.optInt("show_progress", 1) == 1;
            if (optInt > 0 && !TextUtils.isEmpty(optString2)) {
                this.videoInfo = new a();
                this.videoInfo.hez = optString;
                this.videoInfo.videoUrl = optString2;
                this.videoInfo.videoDuration = optInt;
                this.videoInfo.videoWidth = optInt2;
                this.videoInfo.videoHeight = optInt3;
                this.videoInfo.thumbUrl = optString3;
                this.videoInfo.heA = optInt4;
                this.videoInfo.heB = optInt5;
                this.videoInfo.eIH = optInt6;
                this.videoInfo.cML = optInt7;
                this.videoInfo.heD = z;
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
