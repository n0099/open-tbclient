package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ CommonImageLayout a;
    private final /* synthetic */ com.baidu.tieba.data.ah b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(CommonImageLayout commonImageLayout, com.baidu.tieba.data.ah ahVar) {
        this.a = commonImageLayout;
        this.b = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.o;
        UtilHelper.c(context, this.b.c());
    }
}
