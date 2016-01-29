package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class j implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity dxg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginDownloadActivity pluginDownloadActivity) {
        this.dxg = pluginDownloadActivity;
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
        z = this.dxg.dxf;
        if (!z) {
            aVar = this.dxg.dxe;
            com.baidu.adp.lib.h.j.b(aVar, this.dxg.getPageContext());
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            aVar2 = this.dxg.dxe;
            linearLayout = aVar2.aIn;
            if (linearLayout.getVisibility() == 0) {
                aVar5 = this.dxg.dxe;
                linearLayout4 = aVar5.aIn;
                linearLayout4.setVisibility(8);
                aVar6 = this.dxg.dxe;
                linearLayout5 = aVar6.dxh;
                linearLayout5.setVisibility(0);
                return true;
            }
            aVar3 = this.dxg.dxe;
            linearLayout2 = aVar3.aIn;
            linearLayout2.setVisibility(0);
            aVar4 = this.dxg.dxe;
            linearLayout3 = aVar4.dxh;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
