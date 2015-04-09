package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity bUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDownloadActivity pluginDownloadActivity) {
        this.bUO = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        boolean z;
        g gVar;
        g gVar2;
        LinearLayout linearLayout;
        g gVar3;
        LinearLayout linearLayout2;
        g gVar4;
        LinearLayout linearLayout3;
        g gVar5;
        LinearLayout linearLayout4;
        g gVar6;
        LinearLayout linearLayout5;
        z = this.bUO.bUN;
        if (!z) {
            gVar = this.bUO.bUM;
            gVar.dismiss();
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            gVar2 = this.bUO.bUM;
            linearLayout = gVar2.aud;
            if (linearLayout.getVisibility() == 0) {
                gVar5 = this.bUO.bUM;
                linearLayout4 = gVar5.aud;
                linearLayout4.setVisibility(8);
                gVar6 = this.bUO.bUM;
                linearLayout5 = gVar6.bUP;
                linearLayout5.setVisibility(0);
                return true;
            }
            gVar3 = this.bUO.bUM;
            linearLayout2 = gVar3.aud;
            linearLayout2.setVisibility(0);
            gVar4 = this.bUO.bUM;
            linearLayout3 = gVar4.bUP;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
