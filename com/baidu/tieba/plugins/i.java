package com.baidu.tieba.plugins;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class i implements DialogInterface.OnKeyListener {
    final /* synthetic */ PluginDownloadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PluginDownloadActivity pluginDownloadActivity) {
        this.a = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        boolean z;
        m mVar;
        m mVar2;
        LinearLayout linearLayout;
        m mVar3;
        LinearLayout linearLayout2;
        m mVar4;
        LinearLayout linearLayout3;
        m mVar5;
        LinearLayout linearLayout4;
        m mVar6;
        LinearLayout linearLayout5;
        z = this.a.g;
        if (!z) {
            mVar = this.a.a;
            mVar.dismiss();
            return true;
        } else if (i == 4 && keyEvent.getAction() == 1) {
            mVar2 = this.a.a;
            linearLayout = mVar2.i;
            if (linearLayout.getVisibility() == 0) {
                mVar5 = this.a.a;
                linearLayout4 = mVar5.i;
                linearLayout4.setVisibility(8);
                mVar6 = this.a.a;
                linearLayout5 = mVar6.b;
                linearLayout5.setVisibility(0);
                return true;
            }
            mVar3 = this.a.a;
            linearLayout2 = mVar3.i;
            linearLayout2.setVisibility(0);
            mVar4 = this.a.a;
            linearLayout3 = mVar4.b;
            linearLayout3.setVisibility(8);
            return true;
        } else {
            return false;
        }
    }
}
