package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class j implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity eTM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginDownloadActivity pluginDownloadActivity) {
        this.eTM = pluginDownloadActivity;
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
        z = this.eTM.eTL;
        if (!z) {
            aVar = this.eTM.eTK;
            com.baidu.adp.lib.g.j.b(aVar, this.eTM.getPageContext());
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            aVar2 = this.eTM.eTK;
            linearLayout = aVar2.aNO;
            if (linearLayout.getVisibility() == 0) {
                aVar5 = this.eTM.eTK;
                linearLayout4 = aVar5.aNO;
                linearLayout4.setVisibility(8);
                aVar6 = this.eTM.eTK;
                linearLayout5 = aVar6.eTN;
                linearLayout5.setVisibility(0);
                return true;
            }
            aVar3 = this.eTM.eTK;
            linearLayout2 = aVar3.aNO;
            linearLayout2.setVisibility(0);
            aVar4 = this.eTM.eTK;
            linearLayout3 = aVar4.eTN;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
