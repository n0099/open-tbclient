package com.baidu.tieba.pluginCenter;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ PluginDetailActivity bUv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PluginDetailActivity pluginDetailActivity) {
        this.bUv = pluginDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bUv.closeActivity();
    }
}
