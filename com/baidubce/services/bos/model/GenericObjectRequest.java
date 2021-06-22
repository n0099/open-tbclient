package com.baidubce.services.bos.model;

import com.baidubce.util.CheckUtils;
/* loaded from: classes6.dex */
public abstract class GenericObjectRequest extends GenericBucketRequest {
    public static final int MAX_OBJECT_KEY_LENGTH = 1024;
    public static final int MIN_OBJECT_KEY_LENGTH = 0;
    public String key;

    public GenericObjectRequest() {
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        CheckUtils.isNotNull(str, "key should not be null.");
        if (str.length() >= 0) {
            if (str.length() <= 1024) {
                this.key = str;
                return;
            }
            throw new IllegalArgumentException("Invalid objectKey:" + str + ". objectKey should not be greater than 1024.");
        }
        throw new IllegalArgumentException("Invalid objectKey:" + str + ". objectKey should not be less than 0.");
    }

    public abstract GenericObjectRequest withKey(String str);

    public GenericObjectRequest(String str, String str2) {
        super(str);
        setKey(str2);
    }
}
