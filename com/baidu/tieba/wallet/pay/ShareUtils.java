package com.baidu.tieba.wallet.pay;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import d.b.c.e.p.a;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class ShareUtils {
    public static void share(final Activity activity, String str, String str2, String str3, String str4, String str5) {
        final ShareItem shareItem = new ShareItem();
        shareItem.r = str2;
        shareItem.s = str3;
        shareItem.t = str4;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) activity, shareItem, true, (SparseArray<String>) new SparseArray());
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.wallet.pay.ShareUtils.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.a(ShareItem.this.t);
                l.L(activity, view.getResources().getString(R.string.copy_pb_url_success));
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
