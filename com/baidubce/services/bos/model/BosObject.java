package com.baidubce.services.bos.model;

import com.baidubce.services.bos.BosObjectInputStream;
import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes5.dex */
public class BosObject implements Closeable {
    public BosObjectInputStream objectContent;
    public String bucketName = null;
    public String key = null;
    public ObjectMetadata objectMetadata = new ObjectMetadata();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (getObjectContent() != null) {
            getObjectContent().close();
        }
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public BosObjectInputStream getObjectContent() {
        return this.objectContent;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setObjectContent(BosObjectInputStream bosObjectInputStream) {
        this.objectContent = bosObjectInputStream;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.objectMetadata = objectMetadata;
    }

    public String toString() {
        return "BosObject [bucketName=" + this.bucketName + ", key=" + this.key + ", metadata=" + this.objectMetadata + "]";
    }
}
