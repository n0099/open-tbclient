package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class v implements DialogInterface.OnClickListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.a = uVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        BrowseSettingActivity browseSettingActivity;
        switch (i) {
            case 0:
                TiebaApplication.a().a((Boolean) true);
                break;
            case 1:
                TiebaApplication.a().a((Boolean) false);
                break;
        }
        browseSettingActivity = this.a.a;
        browseSettingActivity.j();
    }
}
