package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class j implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity ePJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginDownloadActivity pluginDownloadActivity) {
        this.ePJ = pluginDownloadActivity;
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
        z = this.ePJ.ePI;
        if (!z) {
            aVar = this.ePJ.ePH;
            com.baidu.adp.lib.h.j.b(aVar, this.ePJ.getPageContext());
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            aVar2 = this.ePJ.ePH;
            linearLayout = aVar2.aIN;
            if (linearLayout.getVisibility() == 0) {
                aVar5 = this.ePJ.ePH;
                linearLayout4 = aVar5.aIN;
                linearLayout4.setVisibility(8);
                aVar6 = this.ePJ.ePH;
                linearLayout5 = aVar6.ePK;
                linearLayout5.setVisibility(0);
                return true;
            }
            aVar3 = this.ePJ.ePH;
            linearLayout2 = aVar3.aIN;
            linearLayout2.setVisibility(0);
            aVar4 = this.ePJ.ePH;
            linearLayout3 = aVar4.ePK;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
