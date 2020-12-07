package com.baidu.webkit.sdk.jschecker;

import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes12.dex */
public final class BdJsCallInfo implements INoProGuard {
    private String mJsInterfaceName;
    private String mJsMethodName;
    private String mMethodDeclaration;
    private boolean mPermissionChecked;
    private String mUrl;
    private String mWebViewFrameName;

    public final void finishPermissionCheck() {
        this.mPermissionChecked = true;
    }

    public final String getJsInterfaceName() {
        return this.mJsInterfaceName;
    }

    public final String getJsMethodDeclaration() {
        return this.mMethodDeclaration;
    }

    public final String getJsMethodName() {
        return this.mJsMethodName;
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public final String getWebViewFrameName() {
        return this.mWebViewFrameName;
    }

    public final boolean hasFinishedPermissionCheck() {
        return this.mPermissionChecked;
    }

    public final void setJsInterfaceName(String str) {
        this.mJsInterfaceName = str;
    }

    public final void setJsMethodDeclaration(String str) {
        this.mMethodDeclaration = str;
    }

    public final void setJsMethodName(String str) {
        this.mJsMethodName = str;
    }

    public final void setUrl(String str) {
        this.mUrl = str;
    }

    public final void setWebViewFrameName(String str) {
        this.mWebViewFrameName = str;
    }

    public final String toString() {
        return "BdJsCallInfo{mJsInterfaceName='" + this.mJsInterfaceName + "', mMethodDeclaration='" + this.mMethodDeclaration + "', mPermissionChecked=" + this.mPermissionChecked + ", mUrl='" + this.mUrl + "', mWebViewFrameName='" + this.mWebViewFrameName + "'}";
    }
}
