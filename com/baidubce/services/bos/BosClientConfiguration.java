package com.baidubce.services.bos;

import com.baidubce.BceClientConfiguration;
import com.baidubce.Protocol;
import com.baidubce.Region;
import com.baidubce.auth.BceCredentials;
import com.baidubce.http.RetryPolicy;
import com.baidubce.util.CheckUtils;
import java.net.InetAddress;
/* loaded from: classes6.dex */
public class BosClientConfiguration extends BceClientConfiguration {
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 5242880;
    private Boolean cnameEnabled;
    private int streamBufferSize = DEFAULT_STREAM_BUFFER_SIZE;

    public int getStreamBufferSize() {
        return this.streamBufferSize;
    }

    public void setStreamBufferSize(int i) {
        CheckUtils.checkArgument(i > 0, "streamBufferSize should be positive.");
        this.streamBufferSize = i;
    }

    public BosClientConfiguration withStreamBufferSize(int i) {
        setStreamBufferSize(i);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProtocol(Protocol protocol) {
        setProtocol(protocol);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withMaxConnections(int i) {
        setMaxConnections(i);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withUserAgent(String str) {
        setUserAgent(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withLocalAddress(InetAddress inetAddress) {
        setLocalAddress(inetAddress);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProxyHost(String str) {
        setProxyHost(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProxyPort(int i) {
        setProxyPort(i);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProxyUsername(String str) {
        setProxyUsername(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProxyPassword(String str) {
        setProxyPassword(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProxyDomain(String str) {
        setProxyDomain(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProxyWorkstation(String str) {
        setProxyWorkstation(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withRetryPolicy(RetryPolicy retryPolicy) {
        setRetryPolicy(retryPolicy);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withSocketTimeoutInMillis(int i) {
        setSocketTimeoutInMillis(i);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withConnectionTimeoutInMillis(int i) {
        setConnectionTimeoutInMillis(i);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withSocketBufferSizeInBytes(int i) {
        setSocketBufferSizeInBytes(i);
        return this;
    }

    @Override // com.baidubce.BceClientConfiguration
    public BceClientConfiguration withProxyPreemptiveAuthenticationEnabled(boolean z) {
        setProxyPreemptiveAuthenticationEnabled(z);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withEndpoint(String str) {
        setEndpoint(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withRegion(Region region) {
        setRegion(region);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withCredentials(BceCredentials bceCredentials) {
        setCredentials(bceCredentials);
        return this;
    }

    public Boolean isCnameEnabled() {
        return this.cnameEnabled;
    }

    public void setCnameEnabled(Boolean bool) {
        this.cnameEnabled = bool;
    }

    public BosClientConfiguration withCnameEnabled(Boolean bool) {
        setCnameEnabled(bool);
        return this;
    }
}
