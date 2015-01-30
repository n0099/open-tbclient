package com.baidu.tieba.plugins;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity bMo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDownloadActivity pluginDownloadActivity) {
        this.bMo = pluginDownloadActivity;
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
        z = this.bMo.bMn;
        if (!z) {
            gVar = this.bMo.bMm;
            gVar.dismiss();
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            gVar2 = this.bMo.bMm;
            linearLayout = gVar2.alS;
            if (linearLayout.getVisibility() == 0) {
                gVar5 = this.bMo.bMm;
                linearLayout4 = gVar5.alS;
                linearLayout4.setVisibility(8);
                gVar6 = this.bMo.bMm;
                linearLayout5 = gVar6.bMp;
                linearLayout5.setVisibility(0);
                return true;
            }
            gVar3 = this.bMo.bMm;
            linearLayout2 = gVar3.alS;
            linearLayout2.setVisibility(0);
            gVar4 = this.bMo.bMm;
            linearLayout3 = gVar4.bMp;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
