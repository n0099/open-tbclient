package com.baidu.tieba.pluginCenter;

import android.view.View;
/* loaded from: classes2.dex */
class g implements View.OnClickListener {
    final /* synthetic */ PluginDetailActivity fcA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PluginDetailActivity pluginDetailActivity) {
        this.fcA = pluginDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fcA.closeActivity();
    }
}
