package com.baidubce.services.bos.model;

import com.baidubce.util.CheckUtils;
/* loaded from: classes24.dex */
public abstract class GenericObjectRequest extends GenericBucketRequest {
    private static final int MAX_OBJECT_KEY_LENGTH = 1024;
    private static final int MIN_OBJECT_KEY_LENGTH = 0;
    private String key;

    public abstract GenericObjectRequest withKey(String str);

    public GenericObjectRequest() {
    }

    public GenericObjectRequest(String str, String str2) {
        super(str);
        setKey(str2);
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        CheckUtils.isNotNull(str, "key should not be null.");
        if (str.length() < 0) {
            throw new IllegalArgumentException("Invalid objectKey:" + str + ". objectKey should not be less than 0.");
        }
        if (str.length() > 1024) {
            throw new IllegalArgumentException("Invalid objectKey:" + str + ". objectKey should not be greater than 1024.");
        }
        this.key = str;
    }
}
