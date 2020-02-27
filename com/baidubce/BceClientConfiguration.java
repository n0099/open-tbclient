package com.baidubce;

import com.baidubce.auth.BceCredentials;
import com.baidubce.http.RetryPolicy;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.JoinerUtils;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class BceClientConfiguration {
    public static final int DEFAULT_CONNECTION_TIMEOUT_IN_MILLIS = 30000;
    public static final int DEFAULT_MAX_CONNECTIONS = 5;
    public static final int DEFAULT_SOCKET_TIMEOUT_IN_MILLIS = 30000;
    public static final String DEFAULT_USER_AGENT;
    private String acceptEncoding;
    private int connectionTimeoutInMillis;
    private BceCredentials credentials;
    private String endpoint;
    private long keepAliveDuration;
    private InetAddress localAddress;
    private int maxConnections;
    private Protocol protocol;
    private String proxyDomain;
    private String proxyHost;
    private String proxyPassword;
    private int proxyPort;
    private boolean proxyPreemptiveAuthenticationEnabled;
    private String proxyUsername;
    private String proxyWorkstation;
    private Region region;
    private RetryPolicy retryPolicy;
    private int socketBufferSizeInBytes;
    private int socketTimeoutInMillis;
    private String token;
    private long uploadSegmentPart;
    private String userAgent;
    public static Region DEFAULT_REGION = Region.CN_N1;
    public static String DEFAULT_ACCPET_ENCODING = "identity";
    public static Protocol DEFAULT_PROTOCOL = Protocol.HTTP;
    public static long DEFAULT_KEEPALIVE_DURATION = 30;

    static {
        String property = System.getProperty("user.language");
        if (property == null) {
            property = "";
        }
        String property2 = System.getProperty("user.region");
        if (property2 == null) {
            property2 = "";
        }
        DEFAULT_USER_AGENT = JoinerUtils.on("/", "bce-sdk-android", "1.0.7", System.getProperty("os.name"), System.getProperty("os.version"), System.getProperty("java.vm.name"), System.getProperty("java.vm.version"), System.getProperty("java.version"), property, property2).replace(' ', '_');
    }

    public BceClientConfiguration() {
        this.userAgent = DEFAULT_USER_AGENT;
        this.retryPolicy = RetryPolicy.DEFAULT_RETRY_POLICY;
        this.localAddress = null;
        this.protocol = Protocol.HTTP;
        this.proxyHost = null;
        this.proxyPort = -1;
        this.proxyUsername = null;
        this.proxyPassword = null;
        this.proxyDomain = null;
        this.proxyWorkstation = null;
        this.maxConnections = 5;
        this.socketTimeoutInMillis = 30000;
        this.connectionTimeoutInMillis = 30000;
        this.socketBufferSizeInBytes = 0;
        this.endpoint = null;
        this.region = DEFAULT_REGION;
        this.acceptEncoding = DEFAULT_ACCPET_ENCODING;
        this.keepAliveDuration = DEFAULT_KEEPALIVE_DURATION;
        this.token = null;
        this.credentials = null;
        this.uploadSegmentPart = 2048L;
    }

    public BceClientConfiguration(BceClientConfiguration bceClientConfiguration) {
        this.userAgent = DEFAULT_USER_AGENT;
        this.retryPolicy = RetryPolicy.DEFAULT_RETRY_POLICY;
        this.localAddress = null;
        this.protocol = Protocol.HTTP;
        this.proxyHost = null;
        this.proxyPort = -1;
        this.proxyUsername = null;
        this.proxyPassword = null;
        this.proxyDomain = null;
        this.proxyWorkstation = null;
        this.maxConnections = 5;
        this.socketTimeoutInMillis = 30000;
        this.connectionTimeoutInMillis = 30000;
        this.socketBufferSizeInBytes = 0;
        this.endpoint = null;
        this.region = DEFAULT_REGION;
        this.acceptEncoding = DEFAULT_ACCPET_ENCODING;
        this.keepAliveDuration = DEFAULT_KEEPALIVE_DURATION;
        this.token = null;
        this.credentials = null;
        this.uploadSegmentPart = 2048L;
        this.connectionTimeoutInMillis = bceClientConfiguration.connectionTimeoutInMillis;
        this.maxConnections = bceClientConfiguration.maxConnections;
        this.retryPolicy = bceClientConfiguration.retryPolicy;
        this.localAddress = bceClientConfiguration.localAddress;
        this.protocol = bceClientConfiguration.protocol;
        this.proxyDomain = bceClientConfiguration.proxyDomain;
        this.proxyHost = bceClientConfiguration.proxyHost;
        this.proxyPassword = bceClientConfiguration.proxyPassword;
        this.proxyPort = bceClientConfiguration.proxyPort;
        this.proxyUsername = bceClientConfiguration.proxyUsername;
        this.proxyWorkstation = bceClientConfiguration.proxyWorkstation;
        this.proxyPreemptiveAuthenticationEnabled = bceClientConfiguration.proxyPreemptiveAuthenticationEnabled;
        this.socketTimeoutInMillis = bceClientConfiguration.socketTimeoutInMillis;
        this.userAgent = bceClientConfiguration.userAgent;
        this.socketBufferSizeInBytes = bceClientConfiguration.socketBufferSizeInBytes;
        this.endpoint = bceClientConfiguration.endpoint;
        this.region = bceClientConfiguration.region;
        this.credentials = bceClientConfiguration.credentials;
        this.token = bceClientConfiguration.token;
        this.uploadSegmentPart = bceClientConfiguration.uploadSegmentPart;
        this.acceptEncoding = bceClientConfiguration.acceptEncoding;
        this.keepAliveDuration = bceClientConfiguration.keepAliveDuration;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public void setProtocol(Protocol protocol) {
        if (protocol == null) {
            protocol = DEFAULT_PROTOCOL;
        }
        this.protocol = protocol;
    }

    public BceClientConfiguration withProtocol(Protocol protocol) {
        setProtocol(protocol);
        return this;
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public void setMaxConnections(int i) {
        CheckUtils.checkArgument(i >= 0, "maxConnections should not be negative.");
        this.maxConnections = i;
    }

    public BceClientConfiguration withMaxConnections(int i) {
        setMaxConnections(i);
        return this;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String str) {
        if (str == null) {
            this.userAgent = DEFAULT_USER_AGENT;
        } else if (str.endsWith(DEFAULT_USER_AGENT)) {
            this.userAgent = str;
        } else {
            this.userAgent = str + ", " + DEFAULT_USER_AGENT;
        }
    }

    public BceClientConfiguration withUserAgent(String str) {
        setUserAgent(str);
        return this;
    }

    public InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public void setLocalAddress(InetAddress inetAddress) {
        this.localAddress = inetAddress;
    }

    public BceClientConfiguration withLocalAddress(InetAddress inetAddress) {
        setLocalAddress(inetAddress);
        return this;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public void setProxyHost(String str) {
        this.proxyHost = str;
    }

    public BceClientConfiguration withProxyHost(String str) {
        setProxyHost(str);
        return this;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public void setProxyPort(int i) {
        this.proxyPort = i;
    }

    public BceClientConfiguration withProxyPort(int i) {
        setProxyPort(i);
        return this;
    }

    public String getProxyUsername() {
        return this.proxyUsername;
    }

    public void setProxyUsername(String str) {
        this.proxyUsername = str;
    }

    public BceClientConfiguration withProxyUsername(String str) {
        setProxyUsername(str);
        return this;
    }

    public String getProxyPassword() {
        return this.proxyPassword;
    }

    public void setProxyPassword(String str) {
        this.proxyPassword = str;
    }

    public BceClientConfiguration withProxyPassword(String str) {
        setProxyPassword(str);
        return this;
    }

    public String getProxyDomain() {
        return this.proxyDomain;
    }

    public void setProxyDomain(String str) {
        this.proxyDomain = str;
    }

    public BceClientConfiguration withProxyDomain(String str) {
        setProxyDomain(str);
        return this;
    }

    public String getProxyWorkstation() {
        return this.proxyWorkstation;
    }

    public void setProxyWorkstation(String str) {
        this.proxyWorkstation = str;
    }

    public BceClientConfiguration withProxyWorkstation(String str) {
        setProxyWorkstation(str);
        return this;
    }

    public boolean isProxyPreemptiveAuthenticationEnabled() {
        return this.proxyPreemptiveAuthenticationEnabled;
    }

    public void setProxyPreemptiveAuthenticationEnabled(boolean z) {
        this.proxyPreemptiveAuthenticationEnabled = z;
    }

    public BceClientConfiguration withProxyPreemptiveAuthenticationEnabled(boolean z) {
        setProxyPreemptiveAuthenticationEnabled(z);
        return this;
    }

    public RetryPolicy getRetryPolicy() {
        return this.retryPolicy;
    }

    public void setRetryPolicy(RetryPolicy retryPolicy) {
        if (retryPolicy == null) {
            retryPolicy = RetryPolicy.DEFAULT_RETRY_POLICY;
        }
        this.retryPolicy = retryPolicy;
    }

    public BceClientConfiguration withRetryPolicy(RetryPolicy retryPolicy) {
        setRetryPolicy(retryPolicy);
        return this;
    }

    public int getSocketTimeoutInMillis() {
        return this.socketTimeoutInMillis;
    }

    public void setSocketTimeoutInMillis(int i) {
        CheckUtils.checkArgument(i >= 0, "socketTimeoutInMillis should not be negative.");
        this.socketTimeoutInMillis = i;
    }

    public BceClientConfiguration withSocketTimeoutInMillis(int i) {
        setSocketTimeoutInMillis(i);
        return this;
    }

    public int getConnectionTimeoutInMillis() {
        return this.connectionTimeoutInMillis;
    }

    public void setConnectionTimeoutInMillis(int i) {
        CheckUtils.checkArgument(i >= 0, "connectionTimeoutInMillis should not be negative.");
        this.connectionTimeoutInMillis = i;
    }

    public BceClientConfiguration withConnectionTimeoutInMillis(int i) {
        setConnectionTimeoutInMillis(i);
        return this;
    }

    public int getSocketBufferSizeInBytes() {
        return this.socketBufferSizeInBytes;
    }

    public void setSocketBufferSizeInBytes(int i) {
        this.socketBufferSizeInBytes = i;
    }

    public BceClientConfiguration withSocketBufferSizeInBytes(int i) {
        setSocketBufferSizeInBytes(i);
        return this;
    }

    public String getEndpoint() {
        String str = this.endpoint;
        if (this.endpoint != null && this.endpoint.length() > 0 && this.endpoint.indexOf("://") < 0) {
            return this.protocol.toString().toLowerCase() + "://" + this.endpoint;
        }
        return str;
    }

    public void setEndpoint(String str) {
        CheckUtils.isNotNull(str, "endpoint should not be null.");
        this.endpoint = str;
    }

    public BceClientConfiguration withEndpoint(String str) {
        setEndpoint(str);
        return this;
    }

    public Region getRegion() {
        return this.region;
    }

    public void setRegion(Region region) {
        if (region == null) {
            region = DEFAULT_REGION;
        }
        this.region = region;
    }

    public BceClientConfiguration withRegion(Region region) {
        setRegion(region);
        return this;
    }

    public BceCredentials getCredentials() {
        return this.credentials;
    }

    public void setCredentials(BceCredentials bceCredentials) {
        CheckUtils.isNotNull(bceCredentials, "credentials should not be null.");
        this.credentials = bceCredentials;
    }

    public BceClientConfiguration withCredentials(BceCredentials bceCredentials) {
        setCredentials(bceCredentials);
        return this;
    }

    public long getUploadSegmentPart() {
        return this.uploadSegmentPart;
    }

    public void setUploadSegmentPart(long j) {
        this.uploadSegmentPart = (j < 1 || j > 8192) ? 2048L : 2048L;
    }

    public BceClientConfiguration withUploadSegmentPart(Long l) {
        setUploadSegmentPart(l.longValue());
        return this;
    }

    public String getAcceptEncoding() {
        return this.acceptEncoding;
    }

    public void setAcceptEncoding(String str) {
        this.acceptEncoding = str;
    }

    public long getKeepAliveDuration() {
        return this.keepAliveDuration;
    }

    public void setKeepAliveDuration(long j) {
        this.keepAliveDuration = j;
    }

    public String toString() {
        return "BceClientConfiguration [ \n  userAgent=" + this.userAgent + ", \n  retryPolicy=" + this.retryPolicy + ", \n  localAddress=" + this.localAddress + ", \n  protocol=" + this.protocol + ", \n  proxyHost=" + this.proxyHost + ", \n  proxyPort=" + this.proxyPort + ", \n  proxyUsername=" + this.proxyUsername + ", \n  proxyPassword=" + this.proxyPassword + ", \n  proxyDomain=" + this.proxyDomain + ", \n  proxyWorkstation=" + this.proxyWorkstation + ", \n  proxyPreemptiveAuthenticationEnabled=" + this.proxyPreemptiveAuthenticationEnabled + ", \n  maxConnections=" + this.maxConnections + ", \n  socketTimeoutInMillis=" + this.socketTimeoutInMillis + ", \n  connectionTimeoutInMillis=" + this.connectionTimeoutInMillis + ", \n  socketBufferSizeInBytes=" + this.socketBufferSizeInBytes + ", \n  endpoint=" + this.endpoint + ", \n  region=" + this.region + ", \n  credentials=" + this.credentials + ", \n  uploadSegmentPart=" + this.uploadSegmentPart + ", \n  acceptEncoding=" + this.acceptEncoding + ", \n  keepAliveDuration=" + this.keepAliveDuration + "]\n";
    }
}
