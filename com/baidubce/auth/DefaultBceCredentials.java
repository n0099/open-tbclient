package com.baidubce.auth;

import android.annotation.SuppressLint;
import com.baidubce.util.CheckUtils;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class DefaultBceCredentials implements BceCredentials {
    public final String accessKeyId;
    public final String secretKey;

    public DefaultBceCredentials(String str, String str2) {
        CheckUtils.isNotNull(str, "accessKeyId should not be null.");
        CheckUtils.checkArgument(!str.isEmpty(), "accessKeyId should not be empty.");
        CheckUtils.isNotNull(str2, "secretKey should not be null.");
        CheckUtils.checkArgument(!str2.isEmpty(), "secretKey should not be empty.");
        this.accessKeyId = str;
        this.secretKey = str2;
    }

    @Override // com.baidubce.auth.BceCredentials
    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    @Override // com.baidubce.auth.BceCredentials
    public String getSecretKey() {
        return this.secretKey;
    }
}
