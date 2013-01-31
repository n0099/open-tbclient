package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class w implements DialogInterface.OnClickListener {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.a = vVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        BrowseSettingActivity browseSettingActivity;
        switch (i) {
            case 0:
                TiebaApplication.b().a((Boolean) true);
                break;
            case 1:
                TiebaApplication.b().a((Boolean) false);
                break;
        }
        browseSettingActivity = this.a.a;
        browseSettingActivity.l();
    }
}
