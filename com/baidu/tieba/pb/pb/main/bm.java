package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements a.b {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (!com.baidu.tbadk.core.util.m.bG()) {
            this.dPF.showToast(com.baidu.tbadk.core.util.m.sV());
        } else {
            FileDownloader.download(this.dPF.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.dPF.getPageContext().getString(u.j.download_baidu_video));
        }
    }
}
