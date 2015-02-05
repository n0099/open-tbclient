package com.baidu.tieba.plugins;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity bMn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDownloadActivity pluginDownloadActivity) {
        this.bMn = pluginDownloadActivity;
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
        z = this.bMn.bMm;
        if (!z) {
            gVar = this.bMn.bMl;
            gVar.dismiss();
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            gVar2 = this.bMn.bMl;
            linearLayout = gVar2.alP;
            if (linearLayout.getVisibility() == 0) {
                gVar5 = this.bMn.bMl;
                linearLayout4 = gVar5.alP;
                linearLayout4.setVisibility(8);
                gVar6 = this.bMn.bMl;
                linearLayout5 = gVar6.bMo;
                linearLayout5.setVisibility(0);
                return true;
            }
            gVar3 = this.bMn.bMl;
            linearLayout2 = gVar3.alP;
            linearLayout2.setVisibility(0);
            gVar4 = this.bMn.bMl;
            linearLayout3 = gVar4.bMo;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
