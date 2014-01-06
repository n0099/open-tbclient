package com.baidu.tieba.widget.share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.tieba.util.bm;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d {
    private SocialShare a;
    private Context b;
    private String c;
    private g d;

    public d(Context context, a aVar) {
        this.b = context;
        this.a = SocialShare.getInstance(context);
        this.c = SocialConfig.getInstance(context).getClientId(MediaType.BAIDU);
        this.d = new g(aVar);
    }

    public void a(ShareContent shareContent) {
        a(a(shareContent, "weixin"), MediaType.WEIXIN_FRIEND.toString(), false);
    }

    public void b(ShareContent shareContent) {
        shareContent.setTitle(shareContent.getContent());
        a(a(shareContent, "weixin_timeline"), MediaType.WEIXIN_TIMELINE.toString(), false);
    }

    public void c(ShareContent shareContent) {
        shareContent.setContent(a(shareContent.getContent(), 80, 32));
        a(a(shareContent, "qzone"), MediaType.QZONE.toString(), true);
    }

    public void d(ShareContent shareContent) {
        shareContent.setContent(a(shareContent.getContent(), 140, 20));
        a(a(shareContent, "tencent_weibo"), MediaType.QQWEIBO.toString(), true);
    }

    public void e(ShareContent shareContent) {
        shareContent.setContent(a(shareContent.getContent(), 140, 20));
        a(a(shareContent, "sina_weibo"), MediaType.SINAWEIBO.toString(), true);
    }

    public void f(ShareContent shareContent) {
        shareContent.setContent(a(shareContent.getContent(), 140, 20));
        a(a(shareContent, "renren"), MediaType.RENREN.toString(), true);
    }

    public void a(ShareContent shareContent, String str, boolean z) {
        SessionManager.Session session = SessionManager.getInstance(this.b).get(str);
        if (z && (session == null || session.isExpired())) {
            Bundle bundle = new Bundle();
            bundle.putString(SocialConstants.PARAM_CLIENT_ID, this.c);
            bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, str);
            Intent intent = new Intent(this.b, SocialOAuthActivity.class);
            intent.putExtras(bundle);
            this.d.a(true);
            this.d.a(new e(this, shareContent, str));
            SocialOAuthActivity.setListener(this.d);
            this.b.startActivity(intent);
            return;
        }
        this.d.a(false);
        this.a.share(shareContent, str, (IBaiduListener) this.d, true);
    }

    private String a(String str, int i, int i2) {
        String string = this.b.getString(R.string.share_tail);
        int min = Math.min((i - string.length()) - i2, str.length());
        if (min < str.length()) {
            return str.substring(0, min - 1) + ("..." + string);
        }
        return str + string;
    }

    private ShareContent a(ShareContent shareContent, String str) {
        if (shareContent.getImageUri() == null && shareContent.getImageData() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-11/6e28217cc80f804e61251d35ba4c5fbd.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            shareContent.setImageUri(Uri.parse(str2));
        }
        if (shareContent.getImageUri() != null) {
            shareContent.setImageUri(Uri.parse(a(shareContent.getImageUri().toString(), "sfc=" + str)));
        }
        shareContent.setLinkUrl(a(bm.c(shareContent.getLinkUrl()) ? "http://tieba.baidu.com" : shareContent.getLinkUrl(), "sfc=" + str));
        return shareContent;
    }

    private String a(String str, String str2) {
        if (bm.c(Uri.parse(str).getQuery())) {
            str = str + "?";
        }
        return str + "&" + str2;
    }
}
