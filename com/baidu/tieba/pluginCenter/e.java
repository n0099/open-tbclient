package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity bUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDownloadActivity pluginDownloadActivity) {
        this.bUy = pluginDownloadActivity;
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
        z = this.bUy.bUx;
        if (!z) {
            gVar = this.bUy.bUw;
            gVar.dismiss();
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            gVar2 = this.bUy.bUw;
            linearLayout = gVar2.atV;
            if (linearLayout.getVisibility() == 0) {
                gVar5 = this.bUy.bUw;
                linearLayout4 = gVar5.atV;
                linearLayout4.setVisibility(8);
                gVar6 = this.bUy.bUw;
                linearLayout5 = gVar6.bUz;
                linearLayout5.setVisibility(0);
                return true;
            }
            gVar3 = this.bUy.bUw;
            linearLayout2 = gVar3.atV;
            linearLayout2.setVisibility(0);
            gVar4 = this.bUy.bUw;
            linearLayout3 = gVar4.bUz;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
