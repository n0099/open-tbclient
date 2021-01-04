package com.baidubce.services.vod.model;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MediaResource {
    private Attributes attributes;
    private String createTime;
    private String mediaId;
    private MediaMeta meta;
    private String publishTime;
    private String source;
    private String status;
    private String transcodingPresetGroupName;
    private List<PlayableUrl> playableUrlList = new ArrayList();
    private List<String> thumbnailList = new ArrayList();

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public MediaMeta getMeta() {
        return this.meta;
    }

    public void setMeta(MediaMeta mediaMeta) {
        this.meta = mediaMeta;
    }

    public String getPublishTime() {
        return this.publishTime;
    }

    public void setPublishTime(String str) {
        this.publishTime = str;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getTranscodingPresetGroupName() {
        return this.transcodingPresetGroupName;
    }

    public void setTranscodingPresetGroupName(String str) {
        this.transcodingPresetGroupName = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public List<PlayableUrl> getPlayableUrlList() {
        return this.playableUrlList;
    }

    public void setPlayableUrlList(List<PlayableUrl> list) {
        this.playableUrlList = list;
    }

    public List<String> getThumbnailList() {
        return this.thumbnailList;
    }

    public void setThumbnailList(List<String> list) {
        this.thumbnailList = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("  MediaResource { \n");
        sb.append("    mediaId = ").append(this.mediaId).append("\n");
        sb.append("    status = ").append(this.status).append("\n");
        sb.append("    attributes = ").append(this.attributes).append("\n");
        sb.append("    meta = ").append(this.meta).append("\n");
        sb.append("    createTime = ").append(this.createTime).append("\n");
        sb.append("    publishTime = ").append(this.publishTime).append("\n");
        sb.append("  transcodingPresetGroupName = ").append(this.transcodingPresetGroupName).append("\n");
        sb.append("  source = ").append(this.source).append("\n");
        sb.append("  playableUrlList = [").append("\n");
        for (PlayableUrl playableUrl : this.playableUrlList) {
            sb.append(playableUrl.toString()).append("\n");
        }
        sb.append("] \n");
        sb.append("  thumbnailList = [").append("\n");
        for (String str : this.thumbnailList) {
            sb.append("    thumbnail =").append(str).append("\n");
        }
        sb.append("  }\n");
        return sb.toString();
    }
}
