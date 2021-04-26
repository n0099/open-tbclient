package com.baidubce.services.bos.model;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ListObjectsResponse extends BosResponse {
    public String bucketName;
    public List<String> commonPrefixes;
    public List<BosObjectSummary> contents = new ArrayList();
    public String delimiter;
    public boolean isTruncated;
    public String marker;
    public int maxKeys;
    public String nextMarker;
    public String prefix;

    public String getBucketName() {
        return this.bucketName;
    }

    public List<String> getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public List<BosObjectSummary> getContents() {
        return this.contents;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getMarker() {
        return this.marker;
    }

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCommonPrefixes(List<String> list) {
        this.commonPrefixes = list;
    }

    public void setContents(List<BosObjectSummary> list) {
        this.contents = list;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public void setMaxKeys(int i2) {
        this.maxKeys = i2;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }
}
