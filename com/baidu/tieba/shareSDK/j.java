package com.baidu.tieba.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* loaded from: classes.dex */
class j implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteShareActivity writeShareActivity) {
        this.bJF = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        if (i == 4) {
            pVar = this.bJF.bJs;
            if (pVar != null) {
                pVar2 = this.bJF.bJs;
                if (pVar2.acp() != null) {
                    pVar3 = this.bJF.bJs;
                    if (pVar3.acp().isShowing()) {
                        pVar4 = this.bJF.bJs;
                        com.baidu.adp.lib.g.j.a(pVar4.acp(), this.bJF);
                        return true;
                    }
                }
            }
            this.bJF.acd();
            com.baidu.tbadk.core.b.b.a(this.bJF, Constants.MEDIA_INFO, false);
            this.bJF.finish();
            return true;
        }
        return false;
    }
}
