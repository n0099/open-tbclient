package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class j implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity eEa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginDownloadActivity pluginDownloadActivity) {
        this.eEa = pluginDownloadActivity;
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
        z = this.eEa.eDZ;
        if (!z) {
            aVar = this.eEa.eDY;
            com.baidu.adp.lib.h.j.b(aVar, this.eEa.getPageContext());
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            aVar2 = this.eEa.eDY;
            linearLayout = aVar2.aHW;
            if (linearLayout.getVisibility() == 0) {
                aVar5 = this.eEa.eDY;
                linearLayout4 = aVar5.aHW;
                linearLayout4.setVisibility(8);
                aVar6 = this.eEa.eDY;
                linearLayout5 = aVar6.eEb;
                linearLayout5.setVisibility(0);
                return true;
            }
            aVar3 = this.eEa.eDY;
            linearLayout2 = aVar3.aHW;
            linearLayout2.setVisibility(0);
            aVar4 = this.eEa.eDY;
            linearLayout3 = aVar4.eEb;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
