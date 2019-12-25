package com.baidubce.services.bos.model;

import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes.dex */
public abstract class GenericBucketRequest extends AbstractBceRequest {
    private static final int MAX_BUCKET_NAME_LENGTH = 63;
    private static final int MIN_BUCKET_NAME_LENGTH = 3;
    private String bucketName;

    public abstract GenericBucketRequest withBucketName(String str);

    public GenericBucketRequest() {
    }

    public GenericBucketRequest(String str) {
        setBucketName(str);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        if (str == null || str.isEmpty()) {
            this.bucketName = str;
            return;
        }
        String trim = str.trim();
        if (trim.length() < 3) {
            throw new IllegalArgumentException("Invalid bucketNamse:" + trim + ". bucketName should not be less than 3.");
        }
        if (trim.length() > 63) {
            throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should not be greater than 63.");
        }
        if (!isLowercaseOrDigit(trim.charAt(0))) {
            throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should start with a lowercase letter or digit.");
        }
        if (!isLowercaseOrDigit(trim.charAt(trim.length() - 1))) {
            throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should end with a lowercase letter or digit.");
        }
        for (int i = 1; i < trim.length() - 1; i++) {
            char charAt = trim.charAt(i);
            if (!isLowercaseOrDigit(charAt) && charAt != '-') {
                throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should contain only lowercase leters, digits and hyphens(-).");
            }
        }
        this.bucketName = trim;
    }

    private static boolean isLowercaseOrDigit(char c) {
        return Character.isDigit(c) || (c >= 'a' && c <= 'z');
    }
}
