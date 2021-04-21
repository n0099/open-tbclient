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
        public String f18298a;

        /* renamed from: b  reason: collision with root package name */
        public int f18299b;

        /* renamed from: c  reason: collision with root package name */
        public int f18300c;

        /* renamed from: d  reason: collision with root package name */
        public String f18301d;

        /* renamed from: e  reason: collision with root package name */
        public int f18302e;

        /* renamed from: f  reason: collision with root package name */
        public int f18303f;

        /* renamed from: g  reason: collision with root package name */
        public int f18304g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f18305h;
        public boolean i;
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
                aVar.f18298a = optString;
                aVar.f18299b = optInt2;
                aVar.f18300c = optInt3;
                aVar.f18301d = optString2;
                aVar.f18302e = optInt4;
                aVar.f18303f = optInt5;
                aVar.f18304g = optInt6;
                aVar.f18305h = z;
                aVar.i = z2;
                return;
            }
            this.videoInfo = null;
            return;
        }
        this.videoInfo = null;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        int i;
        a aVar = this.videoInfo;
        if (aVar != null && (i = aVar.f18299b) > 0) {
            return aVar.f18300c / i;
        }
        return super.getRatio();
    }

    public a getVideoInfo() {
        return this.videoInfo;
    }
}
