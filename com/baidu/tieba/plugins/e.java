package com.baidu.tieba.plugins;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDownloadActivity pluginDownloadActivity) {
        this.a = pluginDownloadActivity;
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
        z = this.a.d;
        if (!z) {
            gVar = this.a.a;
            gVar.dismiss();
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            gVar2 = this.a.a;
            linearLayout = gVar2.i;
            if (linearLayout.getVisibility() == 0) {
                gVar5 = this.a.a;
                linearLayout4 = gVar5.i;
                linearLayout4.setVisibility(8);
                gVar6 = this.a.a;
                linearLayout5 = gVar6.b;
                linearLayout5.setVisibility(0);
                return true;
            }
            gVar3 = this.a.a;
            linearLayout2 = gVar3.i;
            linearLayout2.setVisibility(0);
            gVar4 = this.a.a;
            linearLayout3 = gVar4.b;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
