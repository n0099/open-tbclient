package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements DialogInterface.OnClickListener {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                TiebaApplication.a().a(0.0f);
                break;
            case 1:
                TiebaApplication.a().a(0.4f);
                if (CompatibleUtile.getInstance().isAutoBrightness(this.a)) {
                    this.a.k();
                    break;
                }
                break;
            case 2:
                TiebaApplication.a().a(0.05f);
                if (CompatibleUtile.getInstance().isAutoBrightness(this.a)) {
                    this.a.k();
                    break;
                }
                break;
        }
        this.a.q();
        com.baidu.tieba.c.ag.e(this.a);
    }
}
