package com.baidu.tieba.plugins;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity bGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDownloadActivity pluginDownloadActivity) {
        this.bGV = pluginDownloadActivity;
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
        z = this.bGV.bGU;
        if (!z) {
            gVar = this.bGV.bGT;
            gVar.dismiss();
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            gVar2 = this.bGV.bGT;
            linearLayout = gVar2.adh;
            if (linearLayout.getVisibility() == 0) {
                gVar5 = this.bGV.bGT;
                linearLayout4 = gVar5.adh;
                linearLayout4.setVisibility(8);
                gVar6 = this.bGV.bGT;
                linearLayout5 = gVar6.bGW;
                linearLayout5.setVisibility(0);
                return true;
            }
            gVar3 = this.bGV.bGT;
            linearLayout2 = gVar3.adh;
            linearLayout2.setVisibility(0);
            gVar4 = this.bGV.bGT;
            linearLayout3 = gVar4.bGW;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
