package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ CommonImageLayout a;
    private final /* synthetic */ com.baidu.tbadk.core.data.j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(CommonImageLayout commonImageLayout, com.baidu.tbadk.core.data.j jVar) {
        this.a = commonImageLayout;
        this.b = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.o;
        com.baidu.tbadk.browser.a.a(context, this.b.d());
    }
}
