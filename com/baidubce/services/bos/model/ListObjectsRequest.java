package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
/* loaded from: classes6.dex */
public class ListObjectsRequest extends GenericBucketRequest {
    public String delimiter;
    public String marker;
    public int maxKeys;
    public String prefix;

    public ListObjectsRequest(String str) {
        this(str, null);
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

    public String getPrefix() {
        return this.prefix;
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

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public ListObjectsRequest withDelimiter(String str) {
        setDelimiter(str);
        return this;
    }

    public ListObjectsRequest withMarker(String str) {
        setMarker(str);
        return this;
    }

    public ListObjectsRequest withMaxKeys(int i2) {
        setMaxKeys(i2);
        return this;
    }

    public ListObjectsRequest withPrefix(String str) {
        setPrefix(str);
        return this;
    }

    public ListObjectsRequest(String str, String str2) {
        super(str);
        this.maxKeys = -1;
        this.prefix = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public ListObjectsRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public ListObjectsRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }
}
