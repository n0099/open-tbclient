package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class g implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity bXt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PluginDownloadActivity pluginDownloadActivity) {
        this.bXt = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        boolean z;
        i iVar;
        i iVar2;
        LinearLayout linearLayout;
        i iVar3;
        LinearLayout linearLayout2;
        i iVar4;
        LinearLayout linearLayout3;
        i iVar5;
        LinearLayout linearLayout4;
        i iVar6;
        LinearLayout linearLayout5;
        z = this.bXt.bXs;
        if (!z) {
            iVar = this.bXt.bXr;
            iVar.dismiss();
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            iVar2 = this.bXt.bXr;
            linearLayout = iVar2.avE;
            if (linearLayout.getVisibility() == 0) {
                iVar5 = this.bXt.bXr;
                linearLayout4 = iVar5.avE;
                linearLayout4.setVisibility(8);
                iVar6 = this.bXt.bXr;
                linearLayout5 = iVar6.bXu;
                linearLayout5.setVisibility(0);
                return true;
            }
            iVar3 = this.bXt.bXr;
            linearLayout2 = iVar3.avE;
            linearLayout2.setVisibility(0);
            iVar4 = this.bXt.bXr;
            linearLayout3 = iVar4.bXu;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
