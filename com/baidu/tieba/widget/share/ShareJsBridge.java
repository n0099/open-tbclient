package com.baidu.tieba.widget.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.tieba.util.bc;
/* loaded from: classes.dex */
public class ShareJsBridge {
    private Context mContext;

    public ShareJsBridge(Context context) {
        this.mContext = context;
    }

    public void showShareDialog(String str, String str2, String str3, String str4, boolean z) {
        ShareContent shareContent = new ShareContent();
        shareContent.setTitle(str);
        shareContent.setContent(str2);
        shareContent.setLinkUrl(str4);
        if (!bc.c(str3)) {
            shareContent.setImageUri(Uri.parse(str3));
        }
        b bVar = new b(this.mContext);
        bVar.a(shareContent, z);
        bVar.a();
    }
}
