package com.baidubce.services.vod.model;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MediaResource {
    public Attributes attributes;
    public String createTime;
    public String mediaId;
    public MediaMeta meta;
    public String publishTime;
    public String source;
    public String status;
    public String transcodingPresetGroupName;
    public List<PlayableUrl> playableUrlList = new ArrayList();
    public List<String> thumbnailList = new ArrayList();

    public Attributes getAttributes() {
        return this.attributes;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public MediaMeta getMeta() {
        return this.meta;
    }

    public List<PlayableUrl> getPlayableUrlList() {
        return this.playableUrlList;
    }

    public String getPublishTime() {
        return this.publishTime;
    }

    public String getSource() {
        return this.source;
    }

    public String getStatus() {
        return this.status;
    }

    public List<String> getThumbnailList() {
        return this.thumbnailList;
    }

    public String getTranscodingPresetGroupName() {
        return this.transcodingPresetGroupName;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setMeta(MediaMeta mediaMeta) {
        this.meta = mediaMeta;
    }

    public void setPlayableUrlList(List<PlayableUrl> list) {
        this.playableUrlList = list;
    }

    public void setPublishTime(String str) {
        this.publishTime = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setThumbnailList(List<String> list) {
        this.thumbnailList = list;
    }

    public void setTranscodingPresetGroupName(String str) {
        this.transcodingPresetGroupName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("  MediaResource { \n");
        sb.append("    mediaId = ");
        sb.append(this.mediaId);
        sb.append("\n");
        sb.append("    status = ");
        sb.append(this.status);
        sb.append("\n");
        sb.append("    attributes = ");
        sb.append(this.attributes);
        sb.append("\n");
        sb.append("    meta = ");
        sb.append(this.meta);
        sb.append("\n");
        sb.append("    createTime = ");
        sb.append(this.createTime);
        sb.append("\n");
        sb.append("    publishTime = ");
        sb.append(this.publishTime);
        sb.append("\n");
        sb.append("  transcodingPresetGroupName = ");
        sb.append(this.transcodingPresetGroupName);
        sb.append("\n");
        sb.append("  source = ");
        sb.append(this.source);
        sb.append("\n");
        sb.append("  playableUrlList = [");
        sb.append("\n");
        for (PlayableUrl playableUrl : this.playableUrlList) {
            sb.append(playableUrl.toString());
            sb.append("\n");
        }
        sb.append("] \n");
        sb.append("  thumbnailList = [");
        sb.append("\n");
        for (String str : this.thumbnailList) {
            sb.append("    thumbnail =");
            sb.append(str);
            sb.append("\n");
        }
        sb.append("  }\n");
        return sb.toString();
    }
}
