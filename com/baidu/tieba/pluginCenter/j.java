package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class j implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity eZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginDownloadActivity pluginDownloadActivity) {
        this.eZB = pluginDownloadActivity;
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
        z = this.eZB.eZA;
        if (!z) {
            aVar = this.eZB.eZz;
            com.baidu.adp.lib.h.j.b(aVar, this.eZB.getPageContext());
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            aVar2 = this.eZB.eZz;
            linearLayout = aVar2.aNo;
            if (linearLayout.getVisibility() == 0) {
                aVar5 = this.eZB.eZz;
                linearLayout4 = aVar5.aNo;
                linearLayout4.setVisibility(8);
                aVar6 = this.eZB.eZz;
                linearLayout5 = aVar6.eZC;
                linearLayout5.setVisibility(0);
                return true;
            }
            aVar3 = this.eZB.eZz;
            linearLayout2 = aVar3.aNo;
            linearLayout2.setVisibility(0);
            aVar4 = this.eZB.eZz;
            linearLayout3 = aVar4.eZC;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
