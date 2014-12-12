package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.atomData.LiveGroupLikeListActivityConfig;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.AnchorInfo;
/* loaded from: classes.dex */
public class PersonInfoPostAnchor implements Serializable {
    private static final long serialVersionUID = -5225061027879353696L;
    private int author_id;
    private String author_name;
    private int group_id;
    private String intro;
    private int likers;
    private int listeners;
    private String name;
    private String portrait;
    private int publisherId;
    private String publisherName;
    private String publisherPortrait;
    private int start_time;
    private int status;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.portrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
            this.name = jSONObject.optString("name");
            this.start_time = jSONObject.optInt("start_time");
            this.status = jSONObject.optInt("status");
            this.author_id = jSONObject.optInt("author_id");
            this.author_name = jSONObject.optString("author_name");
            this.listeners = jSONObject.optInt("listeners");
            this.likers = jSONObject.optInt(LiveGroupLikeListActivityConfig.LIKERS);
            this.group_id = jSONObject.optInt("group_id");
            this.intro = jSONObject.optString("intro");
            this.publisherPortrait = jSONObject.optString("publisherPortrait");
            this.publisherName = jSONObject.optString("publisherName");
            this.publisherId = jSONObject.optInt("publisherId");
        }
    }

    public void parseProto(AnchorInfo anchorInfo) {
        if (anchorInfo != null) {
            this.portrait = anchorInfo.portrait;
            this.name = anchorInfo.name;
            this.start_time = anchorInfo.start_time.intValue();
            this.status = anchorInfo.status.intValue();
            this.author_id = anchorInfo.author_id.intValue();
            this.author_name = anchorInfo.author_name;
            this.listeners = anchorInfo.listeners.intValue();
            this.likers = anchorInfo.likers.intValue();
            this.group_id = anchorInfo.group_id.intValue();
            this.intro = anchorInfo.intro;
            this.publisherPortrait = anchorInfo.publisherPortrait;
            this.publisherName = anchorInfo.publisherName;
            this.publisherId = anchorInfo.publisherId.intValue();
        }
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getName() {
        return this.name;
    }

    public int getStart_time() {
        return this.start_time;
    }

    public int getStatus() {
        return this.status;
    }

    public int getAuthor_id() {
        return this.author_id;
    }

    public String getAuthor_name() {
        return this.author_name;
    }

    public int getListeners() {
        return this.listeners;
    }

    public int getLikers() {
        return this.likers;
    }

    public int getGroup_id() {
        return this.group_id;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getPublisherPortrait() {
        return this.publisherPortrait;
    }

    public String getPublisherName() {
        return this.publisherName;
    }

    public int getPublisherId() {
        return this.publisherId;
    }
}
