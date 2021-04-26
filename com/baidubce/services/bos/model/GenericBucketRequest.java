package com.baidubce.services.bos.model;

import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes5.dex */
public abstract class GenericBucketRequest extends AbstractBceRequest {
    public static final int MAX_BUCKET_NAME_LENGTH = 63;
    public static final int MIN_BUCKET_NAME_LENGTH = 3;
    public String bucketName;

    public GenericBucketRequest() {
    }

    public static boolean isLowercaseOrDigit(char c2) {
        return Character.isDigit(c2) || (c2 >= 'a' && c2 <= 'z');
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        if (str != null && !str.isEmpty()) {
            String trim = str.trim();
            if (trim.length() >= 3) {
                if (trim.length() <= 63) {
                    if (isLowercaseOrDigit(trim.charAt(0))) {
                        if (isLowercaseOrDigit(trim.charAt(trim.length() - 1))) {
                            for (int i2 = 1; i2 < trim.length() - 1; i2++) {
                                char charAt = trim.charAt(i2);
                                if (!isLowercaseOrDigit(charAt) && charAt != '-') {
                                    throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should contain only lowercase leters, digits and hyphens(-).");
                                }
                            }
                            this.bucketName = trim;
                            return;
                        }
                        throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should end with a lowercase letter or digit.");
                    }
                    throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should start with a lowercase letter or digit.");
                }
                throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should not be greater than 63.");
            }
            throw new IllegalArgumentException("Invalid bucketNamse:" + trim + ". bucketName should not be less than 3.");
        }
        this.bucketName = str;
    }

    public abstract GenericBucketRequest withBucketName(String str);

    public GenericBucketRequest(String str) {
        setBucketName(str);
    }
}
