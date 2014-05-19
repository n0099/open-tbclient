package com.baidu.tieba.plugins;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PluginDownloadActivity pluginDownloadActivity) {
        this.a = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        boolean z;
        o oVar;
        o oVar2;
        LinearLayout linearLayout;
        o oVar3;
        LinearLayout linearLayout2;
        o oVar4;
        LinearLayout linearLayout3;
        o oVar5;
        LinearLayout linearLayout4;
        o oVar6;
        LinearLayout linearLayout5;
        z = this.a.g;
        if (!z) {
            oVar = this.a.a;
            oVar.dismiss();
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            oVar2 = this.a.a;
            linearLayout = oVar2.i;
            if (linearLayout.getVisibility() == 0) {
                oVar5 = this.a.a;
                linearLayout4 = oVar5.i;
                linearLayout4.setVisibility(8);
                oVar6 = this.a.a;
                linearLayout5 = oVar6.b;
                linearLayout5.setVisibility(0);
                return true;
            }
            oVar3 = this.a.a;
            linearLayout2 = oVar3.i;
            linearLayout2.setVisibility(0);
            oVar4 = this.a.a;
            linearLayout3 = oVar4.b;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
