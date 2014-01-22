package com;

import android.content.Intent;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.SocialOAuthStatisticsManager;
import com.baidu.cloudsdk.social.share.uiwithlayout.SocialOAuthDialog;
import java.util.Random;
/* loaded from: classes.dex */
public class bp {
    protected SocialOAuthActivity a;
    protected String b;
    protected String c;
    protected IBaiduListener d;
    private SocialOAuthDialog e;

    public bp(SocialOAuthActivity socialOAuthActivity, String str, String str2, IBaiduListener iBaiduListener) {
        this.a = socialOAuthActivity;
        this.b = str;
        this.c = str2;
        this.d = iBaiduListener;
    }

    private String b() {
        return Utils.md5(String.valueOf(new Random(System.currentTimeMillis()).nextInt()));
    }

    public void a() {
        f();
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void e() {
        if (this.e != null && this.e.isShowing()) {
            this.e.dismiss();
        }
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        RequestParams requestParams = new RequestParams();
        requestParams.put(SocialConstants.PARAM_CLIENT_ID, this.b);
        requestParams.put(SocialConstants.PARAM_CLIENT_TYPE, SocialConstants.ANDROID_CLIENT_TYPE);
        requestParams.put(SocialConstants.PARAM_MEDIA_TYPE, this.c);
        requestParams.put(SocialConstants.PARAM_REDIRECT_URI, SocialConstants.OOB_REDIRECT_URI);
        requestParams.put(SocialConstants.PARAM_RESPONSE_TYPE, SocialConstants.TOKEN_RESPONSE_TYPE);
        requestParams.put(SocialConstants.PARAM_DISPLAY, SocialConstants.MOBILE_DISPLAY);
        requestParams.put(SocialConstants.PARAM_SECURE, SocialConstants.TRUE);
        String b = b();
        requestParams.put(SocialConstants.PARAM_STATE, b);
        SocialOAuthStatisticsManager.setCommonParams(this.a, requestParams);
        this.e = new SocialOAuthDialog(this.a, "https://openapi.baidu.com/social/oauth/2.0/authorize?" + requestParams.getQueryString(), b, this.d);
        this.e.show();
    }
}
