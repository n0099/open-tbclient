package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ImmersiveVideoCardEx extends BaseCardInfo {
    public final a videoInfo;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17956a;

        /* renamed from: b  reason: collision with root package name */
        public int f17957b;

        /* renamed from: c  reason: collision with root package name */
        public int f17958c;

        /* renamed from: d  reason: collision with root package name */
        public String f17959d;

        /* renamed from: e  reason: collision with root package name */
        public int f17960e;

        /* renamed from: f  reason: collision with root package name */
        public int f17961f;

        /* renamed from: g  reason: collision with root package name */
        public int f17962g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f17963h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f17964i;
    }

    public ImmersiveVideoCardEx(JSONObject jSONObject) {
        super(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject != null) {
            optJSONObject.optString(VideoFinishResult.KEY_VIDEO_MD5);
            String optString = optJSONObject.optString("video_url");
            int optInt = optJSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
            int optInt2 = optJSONObject.optInt("video_width");
            int optInt3 = optJSONObject.optInt("video_height");
            String optString2 = optJSONObject.optString("thumb_url");
            int optInt4 = optJSONObject.optInt("thumb_width");
            int optInt5 = optJSONObject.optInt("thumb_height");
            optJSONObject.optInt("video_length");
            int optInt6 = optJSONObject.optInt("play_count");
            boolean z = optJSONObject.optInt("full_screen", 0) == 1;
            boolean z2 = optJSONObject.optInt("show_progress", 1) == 1;
            if (optInt > 0 && !TextUtils.isEmpty(optString)) {
                a aVar = new a();
                this.videoInfo = aVar;
                aVar.f17956a = optString;
                aVar.f17957b = optInt2;
                aVar.f17958c = optInt3;
                aVar.f17959d = optString2;
                aVar.f17960e = optInt4;
                aVar.f17961f = optInt5;
                aVar.f17962g = optInt6;
                aVar.f17963h = z;
                aVar.f17964i = z2;
                return;
            }
            this.videoInfo = null;
            return;
        }
        this.videoInfo = null;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        int i2;
        a aVar = this.videoInfo;
        if (aVar != null && (i2 = aVar.f17957b) > 0) {
            return aVar.f17958c / i2;
        }
        return super.getRatio();
    }

    public a getVideoInfo() {
        return this.videoInfo;
    }
}
