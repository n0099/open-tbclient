package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ImmersiveVideoCardEx extends BaseCardInfo {
    private final a videoInfo;

    /* loaded from: classes9.dex */
    public static class a {
        public int cEb;
        public int kuP;
        public String lcc;
        public int lcd;
        public int lce;
        public boolean lcf;
        public boolean lcg;
        public String thumbUrl;
        public int videoDuration;
        public int videoHeight;
        public String videoUrl;
        public int videoWidth;
    }

    public ImmersiveVideoCardEx(JSONObject jSONObject) {
        super(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("video_md5");
            String optString2 = optJSONObject.optString("video_url");
            int optInt = optJSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
            int optInt2 = optJSONObject.optInt("video_width");
            int optInt3 = optJSONObject.optInt("video_height");
            String optString3 = optJSONObject.optString("thumb_url");
            int optInt4 = optJSONObject.optInt("thumb_width");
            int optInt5 = optJSONObject.optInt("thumb_height");
            int optInt6 = optJSONObject.optInt("video_length");
            int optInt7 = optJSONObject.optInt("play_count");
            boolean z = optJSONObject.optInt("full_screen", 0) == 1;
            boolean z2 = optJSONObject.optInt("show_progress", 1) == 1;
            if (optInt > 0 && !TextUtils.isEmpty(optString2)) {
                this.videoInfo = new a();
                this.videoInfo.lcc = optString;
                this.videoInfo.videoUrl = optString2;
                this.videoInfo.videoDuration = optInt;
                this.videoInfo.videoWidth = optInt2;
                this.videoInfo.videoHeight = optInt3;
                this.videoInfo.thumbUrl = optString3;
                this.videoInfo.lcd = optInt4;
                this.videoInfo.lce = optInt5;
                this.videoInfo.kuP = optInt6;
                this.videoInfo.cEb = optInt7;
                this.videoInfo.lcf = z;
                this.videoInfo.lcg = z2;
                return;
            }
            this.videoInfo = null;
            return;
        }
        this.videoInfo = null;
    }

    public a getVideoInfo() {
        return this.videoInfo;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return (this.videoInfo == null || this.videoInfo.videoWidth <= 0) ? super.getRatio() : this.videoInfo.videoHeight / this.videoInfo.videoWidth;
    }
}
