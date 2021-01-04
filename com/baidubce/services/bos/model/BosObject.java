package com.baidubce.services.bos.model;

import com.baidubce.services.bos.BosObjectInputStream;
import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes6.dex */
public class BosObject implements Closeable {
    private BosObjectInputStream objectContent;
    private String bucketName = null;
    private String key = null;
    private ObjectMetadata objectMetadata = new ObjectMetadata();

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.objectMetadata = objectMetadata;
    }

    public BosObjectInputStream getObjectContent() {
        return this.objectContent;
    }

    public void setObjectContent(BosObjectInputStream bosObjectInputStream) {
        this.objectContent = bosObjectInputStream;
    }

    public String toString() {
        return "BosObject [bucketName=" + this.bucketName + ", key=" + this.key + ", metadata=" + this.objectMetadata + "]";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (getObjectContent() != null) {
            getObjectContent().close();
        }
    }
}
