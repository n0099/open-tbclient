package com.baidu.tieba.plugins;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity bHj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDownloadActivity pluginDownloadActivity) {
        this.bHj = pluginDownloadActivity;
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
        z = this.bHj.bHi;
        if (!z) {
            gVar = this.bHj.bHh;
            gVar.dismiss();
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            gVar2 = this.bHj.bHh;
            linearLayout = gVar2.adm;
            if (linearLayout.getVisibility() == 0) {
                gVar5 = this.bHj.bHh;
                linearLayout4 = gVar5.adm;
                linearLayout4.setVisibility(8);
                gVar6 = this.bHj.bHh;
                linearLayout5 = gVar6.bHk;
                linearLayout5.setVisibility(0);
                return true;
            }
            gVar3 = this.bHj.bHh;
            linearLayout2 = gVar3.adm;
            linearLayout2.setVisibility(0);
            gVar4 = this.bHj.bHh;
            linearLayout3 = gVar4.bHk;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
