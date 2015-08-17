package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class i implements DialogInterface.OnKeyListener {

    /* renamed from: com  reason: collision with root package name */
    final /* synthetic */ PluginDownloadActivity f128com;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PluginDownloadActivity pluginDownloadActivity) {
        this.f128com = pluginDownloadActivity;
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
        z = this.f128com.col;
        if (!z) {
            aVar = this.f128com.cok;
            com.baidu.adp.lib.g.j.b(aVar, this.f128com.getPageContext());
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            aVar2 = this.f128com.cok;
            linearLayout = aVar2.aCW;
            if (linearLayout.getVisibility() == 0) {
                aVar5 = this.f128com.cok;
                linearLayout4 = aVar5.aCW;
                linearLayout4.setVisibility(8);
                aVar6 = this.f128com.cok;
                linearLayout5 = aVar6.con;
                linearLayout5.setVisibility(0);
                return true;
            }
            aVar3 = this.f128com.cok;
            linearLayout2 = aVar3.aCW;
            linearLayout2.setVisibility(0);
            aVar4 = this.f128com.cok;
            linearLayout3 = aVar4.con;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
