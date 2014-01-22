package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class bv implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler a;

    public bv(CloudBatchShareHandler cloudBatchShareHandler) {
        this.a = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.a.mShareDialog != null) {
            this.a.mShareDialog = null;
        }
    }
}
