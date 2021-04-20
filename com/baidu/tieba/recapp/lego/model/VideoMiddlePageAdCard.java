package com.baidu.tieba.recapp.lego.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.b.c.e.p.c;
import d.b.d.d;
import d.b.i0.j1.o.h.b;
import d.b.i0.j1.o.l.i;
import d.b.i0.s2.c0.b.e;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class VideoMiddlePageAdCard extends BaseLegoCardInfo implements i, d.b.d.i, b {
    public d adFacadeData;
    public boolean autoPlay;
    public AdCard.c operateData;
    public b.a parallelChargeInfo;
    public String tagName;
    public e tailFrame;
    public String threadTitle;
    public String userName;
    public String userPortrait;
    public VideoInfo video;
    public boolean waitConfirm;

    public VideoMiddlePageAdCard(JSONObject jSONObject) {
        super(jSONObject);
        this.autoPlay = false;
        this.waitConfirm = false;
        this.userName = jSONObject.optString("user_name");
        this.userPortrait = jSONObject.optString("user_portrait");
        this.threadTitle = jSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
        String optString = jSONObject.optString("tag_name", "广告");
        this.tagName = optString;
        if (TextUtils.isEmpty(optString)) {
            this.tagName = "广告";
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
        if (optJSONObject != null && optJSONObject.length() > 0) {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_md5 = optJSONObject.optString(VideoFinishResult.KEY_VIDEO_MD5, "");
            builder.video_url = optJSONObject.optString("video_url", "");
            builder.video_duration = Integer.valueOf(optJSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
            builder.video_width = Integer.valueOf(optJSONObject.optInt("video_width", 0));
            builder.video_height = Integer.valueOf(optJSONObject.optInt("video_height", 0));
            builder.thumbnail_url = optJSONObject.optString("thumbnail_url", "");
            builder.thumbnail_width = Integer.valueOf(optJSONObject.optInt("thumbnail_width", 0));
            builder.thumbnail_height = Integer.valueOf(optJSONObject.optInt("thumbnail_height", 0));
            builder.video_length = Integer.valueOf(optJSONObject.optInt("video_length", 0));
            builder.play_count = Integer.valueOf(optJSONObject.optInt("play_count", -1));
            builder.media_subtitle = optJSONObject.optString("media_subtitle", "");
            this.video = builder.build(true);
        } else {
            this.video = null;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME);
        e eVar = new e();
        this.tailFrame = eVar;
        eVar.b(optJSONObject2);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("operate");
        AdCard.c cVar = new AdCard.c();
        this.operateData = cVar;
        cVar.a(optJSONObject3);
        b.a aVar = new b.a();
        this.parallelChargeInfo = aVar;
        aVar.a(jSONObject);
        if (TextUtils.isEmpty(this.operateData.f20396b)) {
            this.operateData.f20396b = this.userName;
        }
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("card_type", this.cardType);
            jSONObject.put("user_portrait", this.userPortrait);
            jSONObject.put("user_name", this.userPortrait);
            jSONObject.put(MissonDetailsActivityConfig.THREAD_TITLE, this.userPortrait);
            jSONObject.put("scheme", this.userPortrait);
            jSONObject.put("tag_name", this.userPortrait);
            JSONObject jSONObject2 = new JSONObject();
            if (this.video != null) {
                jSONObject2.put("thumbnail_url", this.video.thumbnail_url);
                jSONObject2.put("thumbnail_width", this.video.thumbnail_width);
                jSONObject2.put("thumbnail_height", this.video.video_height);
                jSONObject2.put("thumbnail_width", this.video.thumbnail_width);
                jSONObject2.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.video.video_duration);
                jSONObject2.put("video_width", this.video.video_width);
                jSONObject2.put("video_height", this.video.video_height);
                jSONObject2.put("video_url", this.video.video_url);
            }
            jSONObject.put(WriteActivityConfig.VIDEO_INFO, jSONObject2);
            jSONObject.put(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.tailFrame.d());
            jSONObject.put("operate", this.operateData.b());
            if (this.adFacadeData != null && this.adFacadeData.j() != null) {
                jSONObject.put("extraparams", this.adFacadeData.j().f43083b);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String adCollect() {
        byte[] bytes = toJson().toString().getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 47);
        }
        return new String(c.m(bytes));
    }

    public d getAdFacadeData() {
        return this.adFacadeData;
    }

    public boolean getAutoPlay() {
        return this.autoPlay;
    }

    @Override // d.b.i0.j1.o.h.b
    public b.a getParallelCharge() {
        return this.parallelChargeInfo;
    }

    public boolean getWaitConfirm() {
        return this.waitConfirm;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        return false;
    }

    @Override // d.b.d.i
    public void setAdFacadeData(d dVar) {
        this.adFacadeData = dVar;
    }

    @Override // d.b.i0.j1.o.l.i
    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    @Override // d.b.i0.j1.o.l.i
    public void setWaitConfirm(boolean z) {
        this.waitConfirm = z;
    }
}
