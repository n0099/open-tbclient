package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class j implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity eVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginDownloadActivity pluginDownloadActivity) {
        this.eVr = pluginDownloadActivity;
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
        z = this.eVr.eVq;
        if (!z) {
            aVar = this.eVr.eVp;
            com.baidu.adp.lib.g.j.b(aVar, this.eVr.getPageContext());
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            aVar2 = this.eVr.eVp;
            linearLayout = aVar2.aTQ;
            if (linearLayout.getVisibility() == 0) {
                aVar5 = this.eVr.eVp;
                linearLayout4 = aVar5.aTQ;
                linearLayout4.setVisibility(8);
                aVar6 = this.eVr.eVp;
                linearLayout5 = aVar6.eVs;
                linearLayout5.setVisibility(0);
                return true;
            }
            aVar3 = this.eVr.eVp;
            linearLayout2 = aVar3.aTQ;
            linearLayout2.setVisibility(0);
            aVar4 = this.eVr.eVp;
            linearLayout3 = aVar4.eVs;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
