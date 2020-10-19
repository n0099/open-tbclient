package com.baidubce.services.sts.model;

import com.baidubce.model.AbstractBceResponse;
import java.util.Date;
/* loaded from: classes25.dex */
public class GetSessionTokenResponse extends AbstractBceResponse {
    private String accessKeyId;
    private Date expiration;
    private String secretAccessKey;
    private String sessionToken;

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public void setSecretAccessKey(String str) {
        this.secretAccessKey = str;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }

    public void setSessionToken(String str) {
        this.sessionToken = str;
    }

    public Date getExpiration() {
        return this.expiration;
    }

    public void setExpiration(Date date) {
        this.expiration = date;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Credentials{");
        sb.append("accessKeyId='").append(this.accessKeyId).append('\'');
        sb.append(", secretAccessKey='").append(this.secretAccessKey).append('\'');
        sb.append(", sessionToken='").append(this.sessionToken).append('\'');
        sb.append(", expiration=").append(this.expiration);
        sb.append('}');
        return sb.toString();
    }
}
