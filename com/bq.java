package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
/* loaded from: classes.dex */
public class bq {
    private SocialOAuthActivity a;
    private String b;
    private IBaiduListener c;

    public bq(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.a = socialOAuthActivity;
        this.b = str;
        this.c = iBaiduListener;
    }

    public bp a(String str) {
        switch (br.a[MediaType.fromString(str).ordinal()]) {
            case 1:
                return new bn(this.a, this.b, this.c);
            case 2:
                return new bm(this.a, this.b, this.c);
            default:
                return new bp(this.a, this.b, str, this.c);
        }
    }
}
