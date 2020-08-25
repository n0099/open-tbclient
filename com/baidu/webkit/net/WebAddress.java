package com.baidu.webkit.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.webkit.internal.INoProGuard;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
/* loaded from: classes19.dex */
public class WebAddress implements INoProGuard {
    private static final String GOOD_IRI_CHAR = "a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef";
    static final int MATCH_GROUP_AUTHORITY = 2;
    static final int MATCH_GROUP_HOST = 3;
    static final int MATCH_GROUP_PATH = 5;
    static final int MATCH_GROUP_PORT = 4;
    static final int MATCH_GROUP_SCHEME = 1;
    static Pattern sAddressPattern = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef%_-][a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    private String mAuthInfo;
    private String mHost;
    private String mPath;
    private int mPort;
    private String mScheme;

    public WebAddress(String str) throws RuntimeException {
        if (str == null) {
            throw new NullPointerException();
        }
        this.mScheme = "";
        this.mHost = "";
        this.mPort = -1;
        this.mPath = "/";
        this.mAuthInfo = "";
        Matcher matcher = sAddressPattern.matcher(str);
        if (!matcher.matches()) {
            throw new RuntimeException("Bad address");
        }
        String group = matcher.group(1);
        if (group != null) {
            this.mScheme = group.toLowerCase(Locale.US);
        }
        String group2 = matcher.group(2);
        if (group2 != null) {
            this.mAuthInfo = group2;
        }
        String group3 = matcher.group(3);
        if (group3 != null) {
            this.mHost = group3;
        }
        String group4 = matcher.group(4);
        if (group4 != null && group4.length() > 0) {
            try {
                this.mPort = Integer.parseInt(group4);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Bad port");
            }
        }
        String group5 = matcher.group(5);
        if (group5 != null && group5.length() > 0) {
            if (group5.charAt(0) == '/') {
                this.mPath = group5;
            } else {
                this.mPath = "/" + group5;
            }
        }
        if (this.mPort == 443 && this.mScheme.equals("")) {
            this.mScheme = "https";
        } else if (this.mPort == -1) {
            if (this.mScheme.equals("https")) {
                this.mPort = Constants.SOCKET_PORT_SSL;
            } else {
                this.mPort = 80;
            }
        }
        if (this.mScheme.equals("")) {
            this.mScheme = HttpHost.DEFAULT_SCHEME_NAME;
        }
    }

    public String getAuthInfo() {
        return this.mAuthInfo;
    }

    public String getHost() {
        return this.mHost;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getPort() {
        return this.mPort;
    }

    public String getScheme() {
        return this.mScheme;
    }

    public void setAuthInfo(String str) {
        this.mAuthInfo = str;
    }

    public void setHost(String str) {
        this.mHost = str;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setPort(int i) {
        this.mPort = i;
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public String toString() {
        String str = "";
        if ((this.mPort != 443 && this.mScheme.equals("https")) || (this.mPort != 80 && this.mScheme.equals(HttpHost.DEFAULT_SCHEME_NAME))) {
            str = ":" + Integer.toString(this.mPort);
        }
        return this.mScheme + "://" + (this.mAuthInfo.length() > 0 ? this.mAuthInfo + UgcConstant.AT_RULE_TAG : "") + this.mHost + str + this.mPath;
    }
}
