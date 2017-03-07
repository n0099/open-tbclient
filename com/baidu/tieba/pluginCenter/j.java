package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class j implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity eXs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginDownloadActivity pluginDownloadActivity) {
        this.eXs = pluginDownloadActivity;
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
        z = this.eXs.eXr;
        if (!z) {
            aVar = this.eXs.eXq;
            com.baidu.adp.lib.g.j.b(aVar, this.eXs.getPageContext());
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            aVar2 = this.eXs.eXq;
            linearLayout = aVar2.aTB;
            if (linearLayout.getVisibility() == 0) {
                aVar5 = this.eXs.eXq;
                linearLayout4 = aVar5.aTB;
                linearLayout4.setVisibility(8);
                aVar6 = this.eXs.eXq;
                linearLayout5 = aVar6.eXt;
                linearLayout5.setVisibility(0);
                return true;
            }
            aVar3 = this.eXs.eXq;
            linearLayout2 = aVar3.aTB;
            linearLayout2.setVisibility(0);
            aVar4 = this.eXs.eXq;
            linearLayout3 = aVar4.eXt;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
