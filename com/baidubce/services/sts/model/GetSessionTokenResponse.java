package com.baidubce.services.sts.model;

import com.baidubce.model.AbstractBceResponse;
import java.util.Date;
/* loaded from: classes6.dex */
public class GetSessionTokenResponse extends AbstractBceResponse {
    public String accessKeyId;
    public Date expiration;
    public String secretAccessKey;
    public String sessionToken;

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public Date getExpiration() {
        return this.expiration;
    }

    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setExpiration(Date date) {
        this.expiration = date;
    }

    public void setSecretAccessKey(String str) {
        this.secretAccessKey = str;
    }

    public void setSessionToken(String str) {
        this.sessionToken = str;
    }

    public String toString() {
        return "Credentials{accessKeyId='" + this.accessKeyId + "', secretAccessKey='" + this.secretAccessKey + "', sessionToken='" + this.sessionToken + "', expiration=" + this.expiration + '}';
    }
}
