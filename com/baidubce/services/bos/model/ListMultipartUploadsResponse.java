package com.baidubce.services.bos.model;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ListMultipartUploadsResponse extends BosResponse {
    private String bucketName;
    private List<String> commonPrefixes;
    private String delimiter;
    private boolean isTruncated;
    private String keyMarker;
    private int maxUploads;
    private List<MultipartUploadSummary> multipartUploads;
    private String nextKeyMarker;
    private String prefix;

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public void setKeyMarker(String str) {
        this.keyMarker = str;
    }

    public String getNextKeyMarker() {
        return this.nextKeyMarker;
    }

    public void setNextKeyMarker(String str) {
        this.nextKeyMarker = str;
    }

    public int getMaxUploads() {
        return this.maxUploads;
    }

    public void setMaxUploads(int i) {
        this.maxUploads = i;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public List<MultipartUploadSummary> getMultipartUploads() {
        if (this.multipartUploads == null) {
            this.multipartUploads = new ArrayList();
        }
        return this.multipartUploads;
    }

    public void setMultipartUploads(List<MultipartUploadSummary> list) {
        this.multipartUploads = list;
    }

    public List<String> getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public void setCommonPrefixes(List<String> list) {
        this.commonPrefixes = list;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }
}
