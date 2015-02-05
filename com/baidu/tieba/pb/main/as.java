package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import com.baidu.tieba.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!com.baidu.tbadk.core.util.s.bL()) {
            this.bAS.showToast(com.baidu.tbadk.core.util.s.ol());
        } else {
            FileDownloader.download(this.bAS.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.bAS.getPageContext().getString(com.baidu.tieba.z.download_baidu_video));
        }
    }
}
