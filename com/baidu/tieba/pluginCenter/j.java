package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes2.dex */
class j implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity fmT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginDownloadActivity pluginDownloadActivity) {
        this.fmT = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        boolean z;
        PluginDownloadActivity.a aVar;
        PluginDownloadActivity.a aVar2;
        LinearLayout linearLayout;
        PluginDownloadActivity.a aVar3;
        LinearLayout linearLayout2;
        PluginDownloadActivity.a aVar4;
        LinearLayout linearLayout3;
        PluginDownloadActivity.a aVar5;
        LinearLayout linearLayout4;
        PluginDownloadActivity.a aVar6;
        LinearLayout linearLayout5;
        z = this.fmT.fmS;
        if (!z) {
            aVar = this.fmT.fmR;
            com.baidu.adp.lib.g.j.b(aVar, this.fmT.getPageContext());
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            aVar2 = this.fmT.fmR;
            linearLayout = aVar2.aTi;
            if (linearLayout.getVisibility() == 0) {
                aVar5 = this.fmT.fmR;
                linearLayout4 = aVar5.aTi;
                linearLayout4.setVisibility(8);
                aVar6 = this.fmT.fmR;
                linearLayout5 = aVar6.fmU;
                linearLayout5.setVisibility(0);
                return true;
            }
            aVar3 = this.fmT.fmR;
            linearLayout2 = aVar3.aTi;
            linearLayout2.setVisibility(0);
            aVar4 = this.fmT.fmR;
            linearLayout3 = aVar4.fmU;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
