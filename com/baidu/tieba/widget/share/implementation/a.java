package com.baidu.tieba.widget.share.implementation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.tieba.widget.share.f;
/* loaded from: classes.dex */
public final class a implements com.baidu.tieba.widget.share.b {
    private Context a;
    private SocialShare b;
    private String c;
    private d d;

    public a(Context context, com.baidu.tieba.widget.share.a aVar) {
        this.a = null;
        this.a = context;
        this.b = SocialShare.getInstance(this.a);
        this.c = SocialConfig.getInstance(this.a).getClientId(MediaType.BAIDU);
        this.d = new d(aVar);
    }

    @Override // com.baidu.tieba.widget.share.b
    public final void a(f fVar, int i, boolean z) {
        MediaType mediaType;
        switch (i) {
            case 2:
                mediaType = MediaType.WEIXIN_TIMELINE;
                break;
            case 3:
                mediaType = MediaType.WEIXIN_FRIEND;
                break;
            case 4:
                mediaType = MediaType.QZONE;
                break;
            case 5:
                mediaType = MediaType.QQWEIBO;
                break;
            case 6:
                mediaType = MediaType.SINAWEIBO;
                break;
            case 7:
                mediaType = MediaType.RENREN;
                break;
            default:
                Log.e("ShareTool", "Invalid type recevied");
                return;
        }
        ShareContent shareContent = new ShareContent();
        shareContent.setTitle(fVar.a);
        shareContent.setContent(fVar.b);
        shareContent.setLinkUrl(fVar.c);
        shareContent.setImageUri(fVar.d);
        shareContent.setLocation(fVar.e);
        String mediaType2 = mediaType.toString();
        SessionManager.Session session = SessionManager.getInstance(this.a).get(mediaType2);
        if (z && (session == null || session.isExpired())) {
            Bundle bundle = new Bundle();
            bundle.putString(SocialConstants.PARAM_CLIENT_ID, this.c);
            bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, mediaType2);
            Intent intent = new Intent(this.a, SocialOAuthActivity.class);
            intent.putExtras(bundle);
            this.d.a(true);
            this.d.a(new b(this, fVar, i));
            SocialOAuthActivity.setListener(this.d);
            this.a.startActivity(intent);
            return;
        }
        this.d.a(false);
        this.b.share(shareContent, mediaType2, (IBaiduListener) this.d, true);
    }
}
