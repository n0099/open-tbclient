package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes2.dex */
class j implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity eTI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginDownloadActivity pluginDownloadActivity) {
        this.eTI = pluginDownloadActivity;
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
        z = this.eTI.eTH;
        if (!z) {
            aVar = this.eTI.eTG;
            com.baidu.adp.lib.g.j.b(aVar, this.eTI.getPageContext());
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            aVar2 = this.eTI.eTG;
            linearLayout = aVar2.aUn;
            if (linearLayout.getVisibility() == 0) {
                aVar5 = this.eTI.eTG;
                linearLayout4 = aVar5.aUn;
                linearLayout4.setVisibility(8);
                aVar6 = this.eTI.eTG;
                linearLayout5 = aVar6.eTJ;
                linearLayout5.setVisibility(0);
                return true;
            }
            aVar3 = this.eTI.eTG;
            linearLayout2 = aVar3.aUn;
            linearLayout2.setVisibility(0);
            aVar4 = this.eTI.eTG;
            linearLayout3 = aVar4.eTJ;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
