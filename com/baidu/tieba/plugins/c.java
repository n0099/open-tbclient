package com.baidu.tieba.plugins;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ PluginDetailActivity bMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginDetailActivity pluginDetailActivity) {
        this.bMl = pluginDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bMl.closeActivity();
    }
}
