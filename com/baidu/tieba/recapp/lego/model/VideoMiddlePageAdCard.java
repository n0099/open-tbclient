package com.baidu.tieba.recapp.lego.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.c;
import com.baidu.afd.d;
import com.baidu.afd.h;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.lego.model.AdCard;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class VideoMiddlePageAdCard extends BaseLegoCardInfo implements h, b, i {
    private d adFacadeData;
    public boolean autoPlay;
    public AdCard.c operateData;
    public b.a parallelChargeInfo;
    public String tagName;
    public AdCard.f tailFrame;
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
        this.tagName = jSONObject.optString("tag_name", "广告");
        if (TextUtils.isEmpty(this.tagName)) {
            this.tagName = "广告";
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO);
        if (optJSONObject != null && optJSONObject.length() > 0) {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_md5 = optJSONObject.optString("video_md5", "");
            builder.video_url = optJSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL, "");
            builder.video_duration = Integer.valueOf(optJSONObject.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
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
        JSONObject optJSONObject2 = jSONObject.optJSONObject(WebVideoActivityConfig.KEY_TAIL_FRAME);
        this.tailFrame = new AdCard.f();
        this.tailFrame.parseFromJson(optJSONObject2);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("operate");
        this.operateData = new AdCard.c();
        this.operateData.parseFromJson(optJSONObject3);
        this.parallelChargeInfo = new b.a();
        this.parallelChargeInfo.parseFromJson(jSONObject);
        if (TextUtils.isEmpty(this.operateData.iIc)) {
            this.operateData.iIc = this.userName;
        }
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        return false;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    public boolean getAutoPlay() {
        return this.autoPlay;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        this.waitConfirm = z;
    }

    public boolean getWaitConfirm() {
        return this.waitConfirm;
    }

    public d getAdFacadeData() {
        return this.adFacadeData;
    }

    @Override // com.baidu.afd.h
    public void setAdFacadeData(d dVar) {
        this.adFacadeData = dVar;
    }

    public String adCollect() {
        byte[] bytes = toJson().toString().getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 47);
        }
        return new String(c.encodeBytesToBytes(bytes));
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
                jSONObject2.put(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.video.video_duration);
                jSONObject2.put("video_width", this.video.video_width);
                jSONObject2.put("video_height", this.video.video_height);
                jSONObject2.put(WebVideoActivityConfig.KEY_VIDEO_URL, this.video.video_url);
            }
            jSONObject.put(WriteVideoActivityConfig.VIDEO_INFO, jSONObject2);
            jSONObject.put(WebVideoActivityConfig.KEY_TAIL_FRAME, this.tailFrame.toJson());
            jSONObject.put("operate", this.operateData.bQf());
            if (this.adFacadeData != null && this.adFacadeData.pi() != null) {
                jSONObject.put("extraparams", this.adFacadeData.pi().ext);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        return this.parallelChargeInfo;
    }
}
