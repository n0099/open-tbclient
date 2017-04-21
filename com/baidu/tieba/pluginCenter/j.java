package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class j implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity eXI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginDownloadActivity pluginDownloadActivity) {
        this.eXI = pluginDownloadActivity;
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
        z = this.eXI.eXH;
        if (!z) {
            aVar = this.eXI.eXG;
            com.baidu.adp.lib.g.j.b(aVar, this.eXI.getPageContext());
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            aVar2 = this.eXI.eXG;
            linearLayout = aVar2.aTS;
            if (linearLayout.getVisibility() == 0) {
                aVar5 = this.eXI.eXG;
                linearLayout4 = aVar5.aTS;
                linearLayout4.setVisibility(8);
                aVar6 = this.eXI.eXG;
                linearLayout5 = aVar6.eXJ;
                linearLayout5.setVisibility(0);
                return true;
            }
            aVar3 = this.eXI.eXG;
            linearLayout2 = aVar3.aTS;
            linearLayout2.setVisibility(0);
            aVar4 = this.eXI.eXG;
            linearLayout3 = aVar4.eXJ;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
