package com.baidu.tieba.recapp.lego.model;

import android.text.TextUtils;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DistributeVrVideoCard extends BaseLegoCardInfo {
    private final a videoInfo;

    /* loaded from: classes3.dex */
    public static class a {
        public int cXa;
        public int eTc;
        public String hfq;
        public int hfr;
        public int hfs;
        public boolean hfu;
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
                this.videoInfo.hfq = optString;
                this.videoInfo.videoUrl = optString2;
                this.videoInfo.videoDuration = optInt;
                this.videoInfo.videoWidth = optInt2;
                this.videoInfo.videoHeight = optInt3;
                this.videoInfo.thumbUrl = optString3;
                this.videoInfo.hfr = optInt4;
                this.videoInfo.hfs = optInt5;
                this.videoInfo.eTc = optInt6;
                this.videoInfo.cXa = optInt7;
                this.videoInfo.hfu = z;
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
