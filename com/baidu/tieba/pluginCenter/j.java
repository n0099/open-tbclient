package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes2.dex */
class j implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity fcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginDownloadActivity pluginDownloadActivity) {
        this.fcD = pluginDownloadActivity;
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
        z = this.fcD.fcC;
        if (!z) {
            aVar = this.fcD.fcB;
            com.baidu.adp.lib.g.j.b(aVar, this.fcD.getPageContext());
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            aVar2 = this.fcD.fcB;
            linearLayout = aVar2.aRP;
            if (linearLayout.getVisibility() == 0) {
                aVar5 = this.fcD.fcB;
                linearLayout4 = aVar5.aRP;
                linearLayout4.setVisibility(8);
                aVar6 = this.fcD.fcB;
                linearLayout5 = aVar6.fcE;
                linearLayout5.setVisibility(0);
                return true;
            }
            aVar3 = this.fcD.fcB;
            linearLayout2 = aVar3.aRP;
            linearLayout2.setVisibility(0);
            aVar4 = this.fcD.fcB;
            linearLayout3 = aVar4.fcE;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
