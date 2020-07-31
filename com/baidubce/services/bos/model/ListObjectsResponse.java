package com.baidubce.services.bos.model;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes19.dex */
public class ListObjectsResponse extends BosResponse {
    private String bucketName;
    private List<String> commonPrefixes;
    private List<BosObjectSummary> contents = new ArrayList();
    private String delimiter;
    private boolean isTruncated;
    private String marker;
    private int maxKeys;
    private String nextMarker;
    private String prefix;

    public List<BosObjectSummary> getContents() {
        return this.contents;
    }

    public void setContents(List<BosObjectSummary> list) {
        this.contents = list;
    }

    public List<String> getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public void setCommonPrefixes(List<String> list) {
        this.commonPrefixes = list;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public void setMaxKeys(int i) {
        this.maxKeys = i;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }
}
