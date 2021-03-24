package com.baidubce.auth;

import java.util.Date;
import java.util.Set;
/* loaded from: classes5.dex */
public class SignOptions {
    public static final SignOptions DEFAULT = new SignOptions();
    public static final int DEFAULT_EXPIRATION_IN_SECONDS = 1800;
    public Set<String> headersToSign = null;
    public Date timestamp = null;
    public int expirationInSeconds = 1800;

    public int getExpirationInSeconds() {
        return this.expirationInSeconds;
    }

    public Set<String> getHeadersToSign() {
        return this.headersToSign;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setExpirationInSeconds(int i) {
        this.expirationInSeconds = i;
    }

    public void setHeadersToSign(Set<String> set) {
        this.headersToSign = set;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public String toString() {
        return "SignOptions [\n  headersToSign=" + this.headersToSign + ",\n  timestamp=" + this.timestamp + ",\n  expirationInSeconds=" + this.expirationInSeconds + "]";
    }
}
