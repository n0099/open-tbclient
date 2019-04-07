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
        public int cDh;
        public int eoa;
        public String gGP;
        public int gGQ;
        public int gGR;
        public boolean gGT;
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
                this.videoInfo.gGP = optString;
                this.videoInfo.videoUrl = optString2;
                this.videoInfo.videoDuration = optInt;
                this.videoInfo.videoWidth = optInt2;
                this.videoInfo.videoHeight = optInt3;
                this.videoInfo.thumbUrl = optString3;
                this.videoInfo.gGQ = optInt4;
                this.videoInfo.gGR = optInt5;
                this.videoInfo.eoa = optInt6;
                this.videoInfo.cDh = optInt7;
                this.videoInfo.gGT = z;
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
