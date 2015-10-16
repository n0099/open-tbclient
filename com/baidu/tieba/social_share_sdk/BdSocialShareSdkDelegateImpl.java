package com.baidu.tieba.social_share_sdk;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.plugins.BdSocialShareSdkDelegate;
/* loaded from: classes.dex */
public class BdSocialShareSdkDelegateImpl implements BdSocialShareSdkDelegate {
    private boolean forbidden;

    public boolean isForbidden() {
        return this.forbidden;
    }

    public void setForbidden(boolean z) {
        this.forbidden = z;
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate
    public void shareToWexinTimeline(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, BdSocialShareSdkDelegate.ShareCallback shareCallback) {
        doShare(str, str2, str3, uri, location, context, MediaType.WEIXIN_TIMELINE.toString(), z, shareCallback);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate
    public void shareToWeixinFriend(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, BdSocialShareSdkDelegate.ShareCallback shareCallback) {
        doShare(str, str2, str3, uri, location, context, MediaType.WEIXIN_FRIEND.toString(), z, shareCallback);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate
    public void shareToQZone(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, BdSocialShareSdkDelegate.ShareCallback shareCallback) {
        doShare(str, str2, str3, uri, location, context, MediaType.QZONE.toString(), z, shareCallback);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate
    public void shareToQQWeibo(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, BdSocialShareSdkDelegate.ShareCallback shareCallback) {
        doShare(str, str2, str3, uri, location, context, MediaType.QQWEIBO.toString(), z, shareCallback);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate
    public void shareToSinaWeibo(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, BdSocialShareSdkDelegate.ShareCallback shareCallback) {
        doShare(str, str2, str3, uri, location, context, MediaType.SINAWEIBO.toString(), z, shareCallback);
    }

    @Override // com.baidu.tbadk.plugins.BdSocialShareSdkDelegate
    public void shareToRenren(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, BdSocialShareSdkDelegate.ShareCallback shareCallback) {
        doShare(str, str2, str3, uri, location, context, MediaType.RENREN.toString(), z, shareCallback);
    }

    private void doShare(String str, String str2, String str3, Uri uri, Location location, Context context, String str4, boolean z, BdSocialShareSdkDelegate.ShareCallback shareCallback) {
        shareCallback.shareCallback(false);
        IntentConfig intentConfig = new IntentConfig(context);
        ShareInfoData shareInfoData = new ShareInfoData();
        shareInfoData.setTitle(str);
        shareInfoData.setContent(str2);
        shareInfoData.setImageUri(uri);
        shareInfoData.setLinkUrl(str3);
        shareInfoData.setLocation(location);
        shareInfoData.setShareTo(str4);
        Bundle bundle = new Bundle();
        bundle.putParcelable("shareInfo", shareInfoData);
        intentConfig.getIntent().putExtras(bundle);
        intentConfig.startActivity(ShareHelperActivity.class);
    }
}
