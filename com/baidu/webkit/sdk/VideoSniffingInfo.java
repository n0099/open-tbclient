package com.baidu.webkit.sdk;
/* loaded from: classes9.dex */
public class VideoSniffingInfo {
    public String mCookie;
    public String mPageTitle;
    public String mPageUrl;
    public String mPosterImageUrl;
    public String mReferrer;
    public String mSourceUrl;
    public String mUserAgent;

    public VideoSniffingInfo() {
    }

    public VideoSniffingInfo(String str, String str2, String str3, String str4) {
        this.mSourceUrl = str;
        this.mReferrer = str2;
        this.mUserAgent = str3;
        this.mPosterImageUrl = str4;
    }

    public String GetCookie() {
        return this.mCookie;
    }

    public String GetPageTitle() {
        return this.mPageTitle;
    }

    public String GetPageUrl() {
        return this.mPageUrl;
    }

    public String GetPosterImageUrl() {
        return this.mPosterImageUrl;
    }

    public String GetReferrer() {
        return this.mReferrer;
    }

    public String GetSourceUrl() {
        return this.mSourceUrl;
    }

    public String GetUserAgent() {
        return this.mUserAgent;
    }

    public void SetCookie(String str) {
        this.mCookie = str;
    }

    public void SetPageTitle(String str) {
        this.mPageTitle = str;
    }

    public void SetPageUrl(String str) {
        this.mPageUrl = str;
    }

    public void SetPosterImageUrl(String str) {
        this.mPosterImageUrl = str;
    }

    public void SetReferrer(String str) {
        this.mReferrer = str;
    }

    public void SetSourceUrl(String str) {
        this.mSourceUrl = str;
    }

    public void SetUserAgent(String str) {
        this.mUserAgent = str;
    }
}
