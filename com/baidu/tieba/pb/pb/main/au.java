package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements a.b {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        try {
            this.djE.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.m11getInst().getPackageName())));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        aVar.dismiss();
    }
}
