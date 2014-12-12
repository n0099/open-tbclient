package com.baidu.tieba.plugins;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity bKD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDownloadActivity pluginDownloadActivity) {
        this.bKD = pluginDownloadActivity;
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
        z = this.bKD.bKC;
        if (!z) {
            gVar = this.bKD.bKB;
            gVar.dismiss();
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            gVar2 = this.bKD.bKB;
            linearLayout = gVar2.akY;
            if (linearLayout.getVisibility() == 0) {
                gVar5 = this.bKD.bKB;
                linearLayout4 = gVar5.akY;
                linearLayout4.setVisibility(8);
                gVar6 = this.bKD.bKB;
                linearLayout5 = gVar6.bKE;
                linearLayout5.setVisibility(0);
                return true;
            }
            gVar3 = this.bKD.bKB;
            linearLayout2 = gVar3.akY;
            linearLayout2.setVisibility(0);
            gVar4 = this.bKD.bKB;
            linearLayout3 = gVar4.bKE;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
