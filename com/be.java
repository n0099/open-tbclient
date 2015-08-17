package com;

import android.content.Context;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.handler.ISocialShareHandler;
/* loaded from: classes.dex */
public class be implements ISocialShareHandler {
    private Context a;

    public be(Context context) {
        this.a = context;
    }

    @Override // com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        ((ClipboardManager) this.a.getSystemService("clipboard")).setText(shareContent.getLinkUrl());
        Toast.makeText(this.a, SocialShareConfig.getInstance(this.a).getString("copy_link_success"), 1).show();
    }
}
