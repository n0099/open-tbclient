package com;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.SocialOAuthStatisticsManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class bs extends bp {
    protected bu e;
    private AsyncHttpClient f;

    public bs(SocialOAuthActivity socialOAuthActivity, String str, String str2, IBaiduListener iBaiduListener) {
        super(socialOAuthActivity, str, str2, iBaiduListener);
        this.f = new AsyncHttpClient();
        this.e = new bu(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, String str2, String str3) {
        RequestParams requestParams = new RequestParams();
        requestParams.put(SocialConstants.PARAM_GRANT_TYPE, "media_token");
        requestParams.put("media_token", str);
        requestParams.put(SocialConstants.PARAM_MEDIA_UID, str2);
        requestParams.put(SocialConstants.PARAM_MEDIA_TYPE, str3);
        requestParams.put(SocialConstants.PARAM_CLIENT_ID, this.b);
        requestParams.put(SocialConstants.PARAM_CLIENT_TYPE, SocialConstants.ANDROID_CLIENT_TYPE);
        SocialOAuthStatisticsManager.setCommonParams(this.a, requestParams);
        this.f.post(this.a, "https://openapi.baidu.com/social/oauth/2.0/token", requestParams, this.e);
    }

    protected boolean a(Intent intent, String str) {
        PackageManager packageManager = this.a.getPackageManager();
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures;
            for (Signature signature : signatureArr) {
                if (str.equals(Utils.md5(signature.toCharsString()))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    protected abstract Intent b();

    protected abstract String c();

    protected abstract int d();

    @Override // com.bp
    public void e() {
        this.f.cancelRequests(this.a, true);
        super.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        Intent b = b();
        if (a(b, c())) {
            try {
                this.a.startActivityForResult(b, d());
                this.a.a();
                return true;
            } catch (ActivityNotFoundException e) {
                return false;
            }
        }
        return false;
    }
}
