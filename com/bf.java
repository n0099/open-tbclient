package com;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
/* loaded from: classes.dex */
public class bf extends h {
    public bf(Context context, IBaiduListener iBaiduListener, int i) {
        super(context, iBaiduListener, i, MediaType.EMAIL.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h
    public void doShare(Uri uri) {
        this.mConfig = SocialShareConfig.getInstance(this.mContext);
        boolean z = this.mConfig.getInt("default_mail_app_first") != 0;
        Intent emailIntent = getEmailIntent(uri);
        if (!z) {
            emailIntent.setPackage(null);
        }
        try {
            ((Activity) this.mContext).startActivityForResult(emailIntent, this.mRequestCode);
        } catch (ActivityNotFoundException e) {
            if (!z) {
                onStartLocalShareFailed("no_valid_mail_app", this.mListener);
                return;
            }
            emailIntent.setPackage(null);
            try {
                ((Activity) this.mContext).startActivityForResult(emailIntent, this.mRequestCode);
            } catch (ActivityNotFoundException e2) {
                onStartLocalShareFailed("no_valid_mail_app", this.mListener);
            }
        }
    }
}
